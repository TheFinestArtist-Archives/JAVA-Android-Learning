# Eliminate unchecked warnings

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Unchecked warnings while using generic
* unchecked cast warnings
* unchecked method invocation warnings
* unchecked generic array creation warnings
* unchecked conversion warnings

## @SuppressWarnings("unchecked") annotation
* If you can’t eliminate a warning, and you can prove that the code that provoked the warning is type-safe
* Always use the SuppressWarnings annotation on the smallest scope possible
* Every time you use an @SuppressWarnings("unchecked") annotation, add a comment saying why it’s safe to do so

<pre class="prettyprint">
// Adding local variable to reduce scope of @SuppressWarnings
public &lt;T&gt; T[] toArray(T[] a) {
   if (a.length &lt; size) {
      // This cast is correct because the array we're creating
      // is of the same type as the one passed in, which is T[].
      @SuppressWarnings("unchecked")
      T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
      return result;
   }

   System.arraycopy(elements, 0, a, 0, size);
   if (a.length &gt; size)
      a[size] = null;
   return a;
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
