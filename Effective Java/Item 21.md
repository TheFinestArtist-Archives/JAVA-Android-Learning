# Use function objects to represent strategies

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Java does not provide function pointers, but object references can be used to achieve a similar effect. Invoking a method on an object typically performs some operation on that object.

<pre class="prettyprint">
// Strategy interface
public interface Comparator&lt;T&gt; {
   public int compare(T t1, T t2);
}

class StringLengthComparator implements Comparator&lt;String&gt; {

   private StringLengthComparator() { }

   public static final StringLengthComparator INSTANCE = new StringLengthComparator();

   public int compare(String s1, String s2) {
      return s1.length() - s2.length();
   }
}
</pre>

Concrete strategy classes are often declared using anonymous classes

<pre class="prettyprint">
Arrays.sort(stringArray, new Comparator&lt;String&gt;() {
   public int compare(String s1, String s2) {
      return s1.length() - s2.length();
   }
});
</pre>

If it is to be executed repeatedly, consider storing the function object in a private static final field and reusing it

<pre class="prettyprint">
// Exporting a concrete strategy
class Host {
   private static class StrLenCmp implements Comparator&lt;String&gt;, Serializable {
      public int compare(String s1, String s2) {
         return s1.length() - s2.length();
      }
   }

   // Returned comparator is serializable
   public static final Comparator&lt;String&gt;
   STRING_LENGTH_COMPARATOR = new StrLenCmp();
   ...  // Bulk of class omitted
}
</pre>

## Conclusion
**Primary use of function pointers is to implement the Strategy pattern.**

1. declare an interface to represent the strategy
2. a class that implements this interface for each concrete strategy


* When a concrete strategy is used only once, it is typically declared and instantiated as an anonymous class
* When a concrete strategy is designed for repeated use, it is generally implemented as a private static member class and exported in a public static final field whose type is the strategy interface.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
