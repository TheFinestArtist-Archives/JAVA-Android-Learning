# Use bounded wild cards to increase API flexibility

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Parameterized type is invariant, sometimes you need more flexibility than invariant typing can provide!

<pre class="prettyprint">
public class Stack&lt;E&gt; {
   public Stack();
   public void push(E e);
   public E pop();
   public boolean isEmpty();
}

// pushAll method without wildcard type - deficient!
public void pushAll(Iterable&lt;E&gt; src) {
   for (E e : src)
      push(e);
}

// Wildcard type for parameter that serves as an E producer
public void pushAll(Iterable&lt;? extends E&gt; src) {
   for (E e : src)
      push(e);
}

// popAll method without wildcard type - deficient!
public void popAll(Collection&lt;E&gt; dst) {
   while (!isEmpty())
      dst.add(pop());
}

// Wildcard type for parameter that serves as an E consumer
public void popAll(Collection&lt;? super E&gt; dst) {
   while (!isEmpty())
      dst.add(pop());
}
</pre>

* For maximum flexibility, use wildcard types on input parameters that represent producers or consumers
   * **PECS stands for producer-extends, consumer-super.**
* Do not use wildcard types as return types
   * Rather than providing additional flexibility for your users, it would force them to use wildcard types in client code
   * If the user of a class has to think about wildcard types, there is probably something wrong with the class’s API

<pre class="prettyprint">
public static &lt;E&gt; Set&lt;E&gt; union(Set&lt;E&gt; s1, Set&lt;E&gt; s2) {...}
public static &lt;E&gt; Set&lt;E&gt; union(Set&lt;? extends E&gt; s1, Set&lt;? extends E&gt; s2) {...}

Set&lt;Integer&gt; integers = ... ;
Set&lt;Double&gt; doubles = ... ;
// error message: incompatible types
Set&lt;Number&gt; numbers = union(integers, doubles);
// explicit type parameter
Set&lt;Number&gt; numbers = Union.&lt;Number&gt;union(integers, doubles);
</pre>

<pre class="prettyprint">
// always use Comparator&lt;? super T&gt; in preference to Comparator&lt;T&gt;
public static &lt;T extends Comparable&lt;T&gt;&gt; T max(List&lt;T&gt; list) {...}
public static &lt;T extends Comparable&lt;? super T&gt;&gt; T max(List&lt;? extends T&gt; list) {
   Iterator&lt;? extends T&gt; i = list.iterator();
   T result = i.next();
   while (i.hasNext()) {
      T t = i.next();
      if (t.compareTo(result) &gt; 0)
         result = t;
   }
   return result;
}
</pre>

## One more wildcard-related topic
There is a duality between type parameters and wildcards, and many methods can be declared using one or the other

<pre class="prettyprint">
// Two possible declarations for the swap method
public static &lt;E&gt; void swap(List&lt;E&gt; list, int i, int j);

public static void swap(List&lt;?&gt; list, int i, int j) {
       swapHelper(list, i, j);
}
// Private helper method for wildcard capture
private static &lt;E&gt; void swapHelper(List&lt;E&gt; list, int i, int j) {
   list.set(i, list.set(j, list.get(i)));
}
</pre>

In a public API, the second is better because it’s simpler. You pass in a list—any list—and the method swaps the indexed elements.  

**if a type parameter appears only once in a method declaration, replace it with a wildcard**

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
