# Consider static factory methods instead of constructors

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Advantages
1. Meaningful name for each constructor
   <pre class="prettyprint">
   BigInteger.probablePrime()
   </pre>
2. No need to create object every time if it's unnecessary
   * Choose to use cached object or create a new one
3. Possible to return subclass object
4. Easy to create parameterized type object
   <pre class="prettyprint">
   public static &lt;K, V&gt; HashMap&lt;K, V&gt; newInstance() {
      return new HashMap&lt;K, V&gt;();
   }

   Map&lt;String, List&lt;String&gt;&gt; m = HashMap.newInstance();
   </pre>

## Disadvantages
1. Impossible to make subclass if a class is consist of static factory method without any public or protected constructor
2. Hard to distinguish between static factory method and static method

## Naming Convention
<pre class="prettyprint">
valueOf()
of()
getInstance()
newInstance()
getType()
newType()
</pre>

Consider to make static factory method for each class because it has lots of advantages.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
