# Check parameters for validity

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

If an invalid parameter value is passed to a method and the method checks its parameters before execution, it will fail quickly and cleanly with an appropriate exception.

<pre class="prettyprint">
/**
 * Returns a BigInteger whose value is (this mod m). This method
 * differs from the remainder method in that it always returns a * non-negative BigInteger.
 *
 * @param m the modulus, which must be positive
 * @return this mod m
 * @throws ArithmeticException if m is less than or equal to 0 */
public BigInteger mod(BigInteger m) {
   if (m.signum() &lt;= 0)
      throw new ArithmeticException("Modulus &lt;= 0: " + m);
   ... // Do the computation
}
</pre>

## Assertions
<pre class="prettyprint">
// Private helper function for a recursive sort
private static void sort(long a[], int offset, int length) {
   assert a != null;
   assert offset &gt;= 0 && offset &lt;= a.length;
   assert length &gt;= 0 && length &lt;= a.length - offset;
   ... // Do the computation
}
</pre>

* Unlike normal validity checks, assertions throw AssertionError if they fail
* Assertions have no effect and essentially no cost unless you enable them, which you do by passing the -ea (or -enableassertions) flag to the java interpreter

## Static factory methods
<pre class="prettyprint">
// Concrete implementation built atop skeletal implementation
static List&lt;Integer&gt; intArrayAsList(final int[] a) {
   if (a == null)
      throw new NullPointerException();

   return new AbstractList&lt;Integer&gt;() {
      public Integer get(int i) {
         return a[i];  // Autoboxing (Item 5)
      }

      @Override public Integer set(int i, Integer val) {
         int oldVal = a[i];
         a[i] = val;     // Auto-unboxing
         return oldVal;  // Autoboxing
      }

      public int size() {
         return a.length;
      }
   };
}
</pre>

## Constructor
Constructors represent a special case of the principle that you should check the validity of parameters that are to be stored away for later use. It is critical to check the validity of constructor parameters to prevent the construction of an object that violates its class invariants.

## Exception translation
Occasionally, a computation implicitly performs a required validity check but throws the wrong exception if the check fails. In other words, the exception that the computation would naturally throw as the result of an invalid parameter value doesn’t match the exception that the method is documented to throw. Under these circumstances, you should use the exception translation idiom, described in Item 61, to translate the natural exception into the correct one.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
