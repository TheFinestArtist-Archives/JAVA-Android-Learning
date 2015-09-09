# Use varargs judiciously

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Varargs stands for variable arity method

Simple use of varargs
<pre class="prettyprint">
static int sum(int... args) {
   int sum = 0;
   for (int arg : args)
      sum += arg;
   return sum;
}
</pre>

Use varargs to pass one or more arguments
<pre class="prettyprint">
static int min(int firstArg, int... remainingArgs) {
   int min = firstArg;
   for (int arg : remainingArgs)
      if (arg &lt; min)
         min = arg;
   return min;
}
</pre>

* **Don’t retrofit every method that has a final array parameter; use varargs only when a call really operates on a variable-length sequence of values.**

<pre class="prettyprint">
// Consider the case of Arrays.asList
// This method was never designed to gather multiple arguments into a list
// but it seemed like a good idea to retrofit it to do so when varargs were added to the platform

// As a result, it became possible to do things like this
List&lt;String&gt; homophones = Arrays.asList("to", "too", "two");

// Obsolete idiom to print an array!
// It prints [Ljava.lang.Integer;@3e25a5.
System.out.println(Arrays.asList(myArray));

// The right way to print an array
System.out.println(Arrays.toString(myArray));

// If you accidentally tried it on an array of primitives, the program wouldn’t compile
// Error: asList(Object[]) in Arrays can't be applied to (int[])
public static void main(String[] args) {
   int[] digits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
   System.out.println(Arrays.asList(digits));
}
</pre>

* Exercise care when using the varargs facility in performance-critical situations. Every invocation of a varargs method causes an array allocation and initialization.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
