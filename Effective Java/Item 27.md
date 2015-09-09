# Favor generic methods

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Static utility methods are particularly good candidates for generification
*All of the “algorithm” methods in Collections (such as binarySearch and sort) have been generified*

**The type parameter list, which declares the type parameter, goes between the method’s modifiers and its return type**
<pre class="prettyprint">
// Uses raw types - unacceptable! (Item 23)
public static Set union(Set s1, Set s2) {
   Set result = new HashSet(s1);
   result.addAll(s2);
   return result;
}

// Generic method
public static &lt;E&gt; Set&lt;E&gt; union(Set&lt;E&gt; s1, Set&lt;E&gt; s2) {
   Set&lt;E&gt; result = new HashSet&lt;E&gt;(s1); result.addAll(s2);
   return result;
}
</pre>
* Compiles without generating any warnings
* Provides type safety as well as ease of use

## Type inference
* The compiler figures out the value of the type parameters by examining the types of the method arguments

<pre class="prettyprint">
// Type inference for generic contstructor
Map&lt;String, List&lt;String&gt;&gt; anagrams = new HashMap&lt;&gt;();

// Generic static factory method
public static &lt;K, V&gt; HashMap&lt;K, V&gt; newHashMap() {
   return new HashMap&lt;K, V&gt;();
}

// Parameterized type instance creation with static factory
Map&lt;String, List&lt;String&gt;&gt; anagrams = newHashMap();
</pre>

## Generic singleton pattern
<pre class="prettyprint">
// Generic singleton factory pattern
private static UnaryFunction&lt;Object&gt; IDENTITY_FUNCTION =
   new UnaryFunction&lt;Object&gt;() {
      public Object apply(Object arg) { return arg; }
   };

// IDENTITY_FUNCTION is stateless and its type parameter is
// unbounded so it's safe to share one instance across all types.
@SuppressWarnings("unchecked")
public static &lt;T&gt; UnaryFunction&lt;T&gt; identityFunction() {
   return (UnaryFunction&lt;T&gt;) IDENTITY_FUNCTION;
}

// Sample program to exercise generic singleton
public static void main(String[] args) {
   String[] strings = { "jute", "hemp", "nylon" };
   UnaryFunction&lt;String&gt; sameString = identityFunction();
   for (String s : strings)
      System.out.println(sameString.apply(s));

   Number[] numbers = { 1, 2.0, 3L };
   UnaryFunction&lt;Number&gt; sameNumber = identityFunction();
   for (Number n : numbers)
      System.out.println(sameNumber.apply(n));
}
</pre>

## Recursive type bound
for a type parameter to be bounded by some expression involving that type parameter itself
<pre class="prettyprint">
public interface Comparable&lt;T&gt; {
   int compareTo(T o);
}

// Returns the maximum value in a list - uses recursive type bound
public static &lt;T extends Comparable&lt;T&gt;&gt; T max(List&lt;T&gt; list) {
   Iterator&lt;T&gt; i = list.iterator();
   T result = i.next();
   while (i.hasNext()) {
      T t = i.next();
      if (t.compareTo(result) &gt; 0)
         result = t;
   }
   return result;
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
