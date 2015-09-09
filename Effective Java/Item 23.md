# Don’t use raw types in new code

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Terms
<table id="markdown-table">
   <tr>
      <th>Term</th>
      <th>Example</th>
      <th>Item</th>
   </tr>
   <tr>
      <td>Parameterized type</td>
      <td>List&lt;String&gt;</td>
      <td>Item 23</td>
   </tr>
   <tr>
      <td>Actual type parameter</td>
      <td>String</td>
      <td>Item 23</td>
   </tr>
   <tr>
      <td>Generic type</td>
      <td>List&lt;E&gt;</td>
      <td>Item 23, 26</td>
   </tr>
   <tr>
      <td>Formal type parameter</td>
      <td>E</td>
      <td>Item 23</td>
   </tr>
   <tr>
      <td>Unbounded wildcard type</td>
      <td>List&lt;?&gt;</td>
      <td>Item 23</td>
   </tr>
   <tr>
      <td>Raw type</td>
      <td>List</td>
      <td>Item 23</td>
   </tr>
   <tr>
      <td>Bounded type parameter</td>
      <td>List&lt;E extends Number&gt;</td>
      <td>Item 26</td>
   </tr>
   <tr>
      <td>Recursive type bound</td>
      <td>List&lt;T extends Comparable&lt;T&gt;&gt;</td>
      <td>Item 27</td>
   </tr>
   <tr>
      <td>Bounded wildcard type</td>
      <td>List&lt;? extends Number&gt;</td>
      <td>Item 28</td>
   </tr>
   <tr>
      <td>Generic method</td>
      <td>static E List asList(E[] a)</td>
      <td>Item 27</td>
   </tr>
   <tr>
      <td>Type token</td>
      <td>String.class</td>
      <td>Item 29</td>
   </tr>
</table>

### Generic Convention

   * T is meant to be a Type
   * E is meant to be an Element (List&lt;E&gt;: a list of Elements)
   * K is Key (in a Map&lt;K,V&gt;)
   * V is Value (as a return value or mapped value)

### Advantages of Generic and Parameterized type

   1. Suggest type-safe way to implement codes
   2. Warning on compile time
   3. No longer have to cast manually when getting elements from collections

*generic type information is erased at runtime*  
*Ray type are provided only for compatibility and interoperability with legacy code that predates the introduction of generics*

## Raw type
<pre class="prettyprint">
/**
 * My stamp collection. Contains only Stamp instances.
 */
private Collection stamps = ... ;

// Erroneous insertion of coin into stamp collection
stamps.add(new Coin( ... ));

// Now a raw iterator type - don't do this!
for (Iterator i = stamps.iterator(); i.hasNext();) {
   Stamp s = (Stamp) i.next(); // Throws ClassCastException
   ... // Do something with the stamp
}
</pre>

## Parameterized type
<pre class="prettyprint">
List&lt;String&gt; strings  = new List&lt;String&gt;();
strings.add(new String());

// for-each loop over a parameterized collection - typesafe
for (Stamp s : stamps) { // No cast
   ... // Do something with the stamp
}

// for loop with parameterized iterator declaration - typesafe
for (Iterator&lt;Stamp&gt; i = stamps.iterator(); i.hasNext(); ) {
   Stamp s = i.next(); // No cast necessary
   ... // Do something with the stamp
}
</pre>

### List v/s List&lt;Object&gt;
* List has opted out of generic type checking
* List&lt;Object&gt; has explicitly told the compiler that it is capable of holding objects of any type

<pre class="prettyprint">
// Uses raw type (List) - fails at runtime!
public static void main(String[] args) {
   List&lt;String&gt; strings = new ArrayList&lt;String&gt;();
   unsafeAdd(strings, new Integer(42));
   String s = strings.get(0); // Compiler-generated cast
}

// warning: unchecked call to add(E) in raw type List
private static void unsafeAdd(List list, Object o) {
   list.add(o);
}

// unsafeAdd(List&lt;Object&gt;,Object) cannot be applied to (List&lt;String&gt;,Integer)
private static void unsafeAdd(List&lt;Object&gt; list, Object o) {
   list.add(o);
}

// Parameterized type
private static void safeAdd(List&lt;String&gt; list, String s) {
   list.add(s);
}

// Generic method
private static &lt;E&gt; void safeAdd(List&lt;E&gt; list, E e) {
   list.add(e);
}
</pre>

### Unbounded wildcard type
<pre class="prettyprint">
// Use of raw type for unknown element type - don't do this!
static int numElementsInCommon(Set s1, Set s2) {
   int result = 0;
   for (Object o1 : s1)
      if (s2.contains(o1))
         result++;
   return result;
}

// Unbounded wildcard type - typesafe and flexible
static int numElementsInCommon(Set&lt;?&gt; s1, Set&lt;?&gt; s2) {
   int result = 0;
   for (Object o1 : s1)
      if (s2.contains(o1))
         result++;
   return result;
}
</pre>

### List&lt;?&gt; v/s List&lt;? extends Number&gt;
* Only null can be added to List&lt;?&gt;
* Number or Object extending Number can be added to List&lt;? extends Number&gt;

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
