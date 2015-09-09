# Prefer primitive types to boxed primitives

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Three differences
1. Primitives have only their values, whereas boxed primitives have identities distinct from their values
2. Primitive types have only fully functional values, whereas each boxed primitive type has one nonfunctional value which is null
3. Primitives are generally more time- and space-efficient than boxed primitives

**Example #1**
<pre class="prettyprint">
// naturalOrder.compare(new Integer(42), new Integer(42)) == 1 (should be 0)
Comparator&lt;Integer&gt; naturalOrder = new Comparator&lt;Integer&gt;() {
   public int compare(Integer first, Integer second) {
      return first &lt; second ? -1 : (first == second ? 0 : 1);
   }
};

// naturalOrder.compare(new Integer(42), new Integer(42)) == 0
Comparator&lt;Integer&gt; naturalOrder = new Comparator&lt;Integer&gt;() {
   public int compare(Integer first, Integer second) {
      int f = first;   // Auto-unboxing
      int s = second;  // Auto-unboxing
      return f &lt; s ? -1 : (f == s ? 0 : 1); // No unboxing
   }
};
</pre>

**Example #2**
<pre class="prettyprint">
// It throws a NullPointerException when evaluating the expression (i == 42)
public class Unbelievable {
   static Integer i;
   public static void main(String[] args) {
      if (i == 42)
         System.out.println("Unbelievable");
   }
}
</pre>

*In nearly every case when you mix primitives and boxed primitives in a single operation, the boxed primitive is auto-unboxed*

**Example #3**
<pre class="prettyprint">
// Hideously slow program! Can you spot the object creation?
public static void main(String[] args) {
   Long sum = 0L;
   for (long i = 0; i &lt; Integer.MAX_VALUE; i++) {
      sum += i;
   }
   System.out.println(sum);
}
</pre>

## Conclusion
* Autoboxing reduces the verbosity, but not the danger, of using boxed primitives
* When your program does mixed-type computations involving boxed and unboxed primitives, it does unboxing, and when your program does unboxing, it can throw a NullPointerException

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
