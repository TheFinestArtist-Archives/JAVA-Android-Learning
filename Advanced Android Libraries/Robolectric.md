#Robolectric

##Kinds of Tests
This part is copied from [StackOverflow Answer](http://stackoverflow.com/a/4904533/1797648)

###Unit Tests

Tests the smallest unit of functionality, typically a method/function (e.g. given a class with a particular state, calling x method on the class should cause y to happen).  Unit tests should be focussed on one particular feature (e.g., calling the pop method when the stack is empty should throw an `InvalidOperationException`).  Everything it touches should be done in memory; this means that the test code **and** the code under test shouldn't:

 - Call out into (non-trivial) collaborators
 - Access the network  
 - Hit a database
 - Use the file system
 - Spin up a thread
 - etc.

Any kind of dependency that is slow / hard to understand / initialise / manipulate should be stubbed/mocked/whatevered using the appropriate techniques so you can focus on what the unit of code is doing, not what its dependencies do.

In short, unit tests are as simple as possible, easy to debug, reliable (due to reduced external factors), fast to execute and help to prove that the smallest building blocks of your program function as intended before they're put together.  The caveat is that, although you can prove they work perfectly in isolation, the units of code may blow up when combined which brings us to ...

###Integration Tests

Integration tests build on unit tests by combining the units of code and testing that the resulting combination functions correctly.  This can be either the innards of one system, or combining multiple systems together to do something useful.  Also, another thing that differentiates integration tests from unit tests is the environment.  Integration tests can and will use threads, access the database or do whatever is required to ensure that all of the code **and** the different environment changes will work correctly.  

If you've built some serialization code and unit tested its innards without touching the disk, how do you know that it'll work when you are loading and saving to disk?  Maybe you forgot to flush and dispose filestreams.  Maybe your file permissions are incorrect and you've tested the innards using in memory streams.  The only way to find out for sure is to test it 'for real' using an environment that is closest to production.

The main advantage is that they will find bugs that unit tests can't such as wiring bugs (e.g. an instance of class A unexpectedly receives a null instance of B) and environment bugs (it runs fine on my single-CPU machine, but my colleague's 4 core machine can't pass the tests).  The main disadvantage is that integration tests touch more code, are less reliable, failures are harder to diagnose and the tests are harder to maintain.

Also, integration tests don't necessarily prove that a complete feature works.  The user may not care about the internal details of my programs, but I do!

###Functional Tests

Functional tests check a particular feature for correctness by comparing the results for a given input against the specification.  Functional tests don't concern themselves with intermediate results or side-effects, just the result (they don't care that after doing x, object y has state z). They are written to test part of the specification such as, "calling function Square(x) with the argument of 2 returns 4".

###Acceptance Tests

Acceptance testing seems to be split into two types:

Standard acceptance testing involves performing tests on the full system (e.g. using your web page via a web browser) to see whether the application's functionality satisfies the specification. E.g. "clicking a zoom icon should enlarge the document view by 25%." There is no real continuum of results, just a pass or fail outcome.

The advantage is that the tests are described in plain English and ensures the software, as a whole, is feature complete.  The disadvantage is that you've moved another level up the testing pyramid. Acceptance tests touch mountains of code, so tracking down a failure can be tricky.  

Also, in agile software development, user acceptance testing involves creating tests to mirror the user stories created by/for the software's customer during development.  If the tests pass, it means the software should meet the customer's requirements and the stories can be considered complete. An acceptance test suite is basically an executable specification written in a domain specific language that describes the tests in the language used by the users of the system.

###Conclusion

They're all complementary.  Sometimes it's advantageous to focus on one type or to eschew them entirely.  The main difference for me is that some of the tests look at things from a programmer's perspective, whereas others use a customer/end user focus.

##Dummy vs. Stub vs. Spy vs. Fake vs. Mock
This part is copied from [Niraj Bhatt's blog](https://nirajrules.wordpress.com/2011/08/27/dummy-vs-stub-vs-spy-vs-fake-vs-mock/)

One of the fundamental requirements of making Unit testing work is isolation. Isolation is hard in real world as there are always dependencies (collaborators) across the system. That’s where concept of something generically called ‘Test Double’ comes into picture. A ‘Double’ allow us to break the original dependency, helping isolate the unit (or System Under Test (SUT) – as commonly referred). As this Double is used to pass a unit test it’s generally referred to as ‘Test Double’. There are variations in types of Test Doubles depending on their intent (reminds me of GOF’s Proxy pattern).

Test doubles are not only useful in state verification but also in behavior verification; help us enhance the code coverage of our unit tests. While demarcating various test doubles may not provide exceptional value add, knowing about them can definitely organize our thinking process around unit testing.  Interestingly Mock Frameworks available today, allow us to seamlessly create all the variations of test doubles. I would be using moq for this blog post. The variations of Test Doubles described below are taken from xUnit Patterns.com. Below are the various test doubles along with examples:

###Dummy
Dummy is simple of all. It’s a placeholder required to pass the unit test. Unit in the context (SUT) doesn’t exercise this placeholder. Dummy can be something as simple as passing ‘null’ or a void implementation with exceptions to ensure it’s never leveraged.

```java
public void PlayerRollDieWithMaxFaceValue()
{
   var dummyBoard = new Mock<IBoard>();
   var player = new Player(dummyBoard.Object, new Die() ); //null too would have been just fine
   player.RollDie();
   Assert.AreEqual(6, player.UnitsToMove);
}
```

While the above test would work just fine, it won’t throw any exceptions if RollDie implementation is invoking Board Object. To ensure that Board object isn’t exercised at  all you can leverage strict mock. Strict Mock with throw an exception if no expectation is set for member.

```java
public void PlayerRollDieWithMaxFaceValueStrictTest()
{
   var dummyBoard = new Mock<IBoard>(MockBehavior.Strict); //Ensure Board class is never invoked
   var player = new Player( dummyBoard.Object, new Die() );
   player.RollDie();
   Assert.AreEqual( 6, player.UnitsToMove );
}
```

###Fake
Fake is used to simplify a dependency so that unit test can pass easily. There is very thin line between Fake and Stub which is best described here as – “a Test Stub acts as a control point to inject indirect inputs into the SUT the Fake Object does not. It merely provides a way for the interactions to occur in a self-consistent manner. These interactions (between the SUT and the Fake Object) will typically be many and the values passed in as arguments of earlier method calls will often be returned as results of later method calls“. A common place where you would use fake is database access. Below sample shows the same by creating a FakeProductRepository instead of using live database.

```java
public interface IProductRepository
{
   void AddProduct(IProduct product);
   IProduct GetProduct(int productId);
}

public class FakeProductRepository : IProductRepository
{
   List<IProduct> _products = new List<IProduct>();

   public void AddProduct(IProduct product)
   {
   //...
   }
   public IProduct GetProduct(int productId)
   {
   //...
   }
}
```

```java
public void BillingManagerCalcuateTax()
{
var fakeProductRepository = new FakeProductRepository();
BillingManager billingManager = new BillingManager(fakeProductRepository);
//...
}
```

Fakes can be also be implemented by moq using callbacks.

###Stub
Stub is used to provide indirect inputs to the SUT coming from its collaborators / dependencies. These inputs could be in form of objects, exceptions or primitive values. Unlike Fake, stubs are exercised by SUT. Going back to the Die example, we can use a Stub to return a fixed face value. This could simply our tests by taking out the randomness associated with rolling a Die.

```java
public void PlayerRollDieWithMaxFaceValue()
{
   var stubDie = new Mock<IDie>();
   stubDie.Setup(d => d.GetFaceValue()).Returns(6).Verifiable();
   IDie die = stubDie.Object;
   Assert.AreEqual(6, die.GetFaceValue()); //Excercise the return value
}
```

###Mock
Mock – Like Indirect Inputs that flow back to SUT from its collaborators, there are also Indirect Outputs. Indirect outputs are tricky to test as they don’t return to SUT and are encapsulated by collaborator. Hence it becomes quite difficult to assert on them from a SUT standpoint. This is where behavior verification kicks in. Using behavior verification we can set expectations for SUT to exhibit the right behavior during its interactions with collaborators. Classic example of this is logging. When a SUT invokes logger it might quite difficult for us to assert on the actual log store (file, database, etc.). But what we can do is assert that logger is invoked by SUT. Below is an example that shows a typical mock in action

```java
public void ModuleThrowExceptionInvokesLogger()
{
   var mock = new Mock<ILogger>();
   Module module = new Module();
   ILogger logger = mock.Object;
   module.SetLogger(logger);
   module.ThrowException("Catch me if you can");
   mock.Verify( m => m.Log( "Catch me if you can" ) );
}
```

###Spy
Spy – Spy is a variation of behavior verification. Instead of setting up behavior expectations, Spy records calls made to the collaborator. SUT then can later assert the recordings of Spy. Below is variation of Logger shown for Mock. Focus on this test is to count the number of times Log is invoked on Logger. It’s doesn’t care about the inputs passed to Log, it just records the Log calls and asserts them. Complex Spy objects can also leverage callback features of moq framework.

```java
public void ModuleThrowExceptionInvokesLoggerOnlyOnce()
{
   var spyLogger = new Mock<ILogger>();
   Module module = new Module();
   ILogger logger = spyLogger.Object;
   module.SetLogger( logger );
   module.ThrowException( "Catch me if you can" );
   module.ThrowException( "Catch me if you can" );
   spyLogger.Verify( m => m.Log( It.IsAny<string>()), Times.Exactly(2) );
}
```

##Robolectric

Robolectric is a JUnit4-based testing framework that allows to run unit tests on desktop JVM while using Android API.

* Based on JUnit 4 framework
* Runs unit tests on desktop without any device or emulator
* Be able to use Android APIs includes `android-support-v4, android-multidex, google-play-services, google-maps, apache-httpclient`
* Be able to use and tests Android Resources
* Be able to use 3rd party libraries
* Is not an integration tests

Some other aspects
* Support up to **SDK version 21**



###Shadow Objects
The Robolectric testing framework provides "shadow objects" that override certain aspects of the Android SDK. These objects allow the code being tested to execute outside of the Android environment. At times, it's useful to manipulate these shadow objects to achieve some expected result.

###Set ups
**build.gradle**
```java
dependencies {
    // ...other dependencies
    testCompile 'junit:junit:4.12'
    testCompile 'org.robolectric:robolectric:3.0-rc2'
}
```

## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```

<!-- espresso
robotium
junit
mockito
powermock

Jenkins
Burst

Object mock
Http mock
TDD & BDD
Testing -->

<!-- https://github.com/google/auto -->
