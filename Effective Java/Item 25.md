# Prefer lists to arrays

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Arrays v/s Generic type
#### Arrays (covariant) v/s Generic type (invariant)
   * If Sub is a subtype of Super, then the array type Sub[] is a subtype of Super[]
   * For any two distinct types Type1 and Type2, List&lt;Type1&gt; is neither a subtype nor a supertype of List&lt;Type2&gt;

</pre>
// Fails at runtime!
Object[] objectArray = new Long[1];
objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

// Won't compile!
List&lt;Object&gt; ol = new ArrayList&lt;Long&gt;(); // Incompatible types ol.add("I don't fit in");
</pre>

#### Arrays (reification) v/s Generic type (erasure)
   * Arrays know and enforce their element types at runtime
   * Generic enforce their type constraints only at compile time and discard (or erase) their element type information at runtime

*arrays and generics do not mix well*
<pre class="prettyprint">
new List&lt;E&gt;[]
new List&lt;String&gt;[]
new E[]
</pre>

<pre class="prettyprint">
// List-based generic reduction
static &lt;E&gt; E reduce(List&lt;E&gt; list, Function&lt;E&gt; f, E initVal) {
   List&lt;E&gt; snapshot;
   synchronized(list) {
      snapshot = new ArrayList&lt;E&gt;(list);
   }
   E result = initVal;
   for (E e : snapshot)
      result = f.apply(result, e);
   return result;
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
