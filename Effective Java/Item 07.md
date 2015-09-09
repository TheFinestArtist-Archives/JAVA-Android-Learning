# Avoid finalizers

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Finalizer or Finalize Methods
* http://en.wikipedia.org/wiki/Finalizer
* http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#finalize%28%29

## Why?
* No guarantee that finalizers will get executed promptly
   * never do anything time-critical in a finalizer
* No guarantee that they’ll get executed at all
* Severe performance penalty for using finalizers
   * Object creation and deletion slowed down
* Finalizer thread was running at a lower priority than another application thread

## Termination Method
* private validation method to check whether current object has been terminated, <code id="inline">throw IllegalStateException</code> if it has been.
* other method runs the validation method at first
* examples
   * close() method on OutputStream, InputStream, java.sql.Connection
   * cancel() method on Timer
   * Graphics.dispost(), Window.dispose()

## Use case of Termination Method
* invoke termination method in finalizer just in case
* leave a log if current object never has not yet called termination method before finalizer calls it

<pre class="prettyprint">
FileInputStream fileInputStream = new FileInputStream();
try {
   ...
} catch(Exception e) {
   e.printStactTrace();
} finally {
   fileInputStream.close();
}
</pre>

## How to override Finalizer
<pre class="prettyprint">
// Manual finalizer chaining
@Override protected void finalize() throws Throwable {
   try {
      ... // Finalize subclass state
   } finally {
      super.finalize();
   }
}
</pre>

## [Finalizer Guardian Example](http://stackoverflow.com/questions/6872857/how-does-a-finalizer-guardian-work-in-java)
* If a subclass implementor overrides a superclass finalizer but forgets to invoke the superclass finalizer

<pre class="prettyprint">
public class Parent {

   public static void main(final String[] args) throws Exception {
      doIt();
      System.gc();
      Thread.sleep(5000); //  5 sec sleep
   }

   @SuppressWarnings("unused")
   private final Object guardian = new Object() {
      @Override protected void finalize() {
         doFinalize();
      }
   };

   private void doFinalize() {
      System.out.println("Finalize of class Parent");
   }

   public static void doIt() {
      Child c = new Child();
      System.out.println(c);
   }
}

class Child extends Parent {

   // Note, Child class does not call super.finalize()
   @Override protected void finalize() {
      System.out.println("Finalize of class Child");
   }

}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
