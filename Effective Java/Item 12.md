# Consider implementing Comparable

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**Comparable interface**
<pre class="prettyprint">
public interface Comparable&lt;T&gt; {
   int compareTo(T t);
}
</pre>

By implementing Comparable, you allow your class to **interoperate with all of the many generic algorithms and collection implementations** that depend on this interface
<pre class="prettyprint">
public class WordList {
   public static void main(String[] args) {
      Set&lt;String&gt; s = new TreeSet&lt;String&gt;();
      Collections.addAll(s, args);
      System.out.println(s);
   }
}
</pre>

## General Contract
* Symmetric <code id="inline">sgn(x.compareTo(y)) == -sgn(y.compare- To(x))</code>
* Transitive <code id="inline">(x.compareTo(y) &gt; 0 && y.compareTo(z) &gt; 0) implies x.compareTo(z) &gt; 0</code>
* <code id="inline">compareTo(y) == 0</code>implies that <code id="inline">sgn(x.compareTo(z)) == sgn(y.compareTo(z))</code>
* It is strongly recommended, but not strictly required, that <code id="inline">(x.compareTo(y) == 0) == (x.equals(y))</code>

**compareTo method Example**
<pre class="prettyprint">
public int compareTo(PhoneNumber pn) {
   // Compare area codes
   if (areaCode &lt; pn.areaCode)
      return -1;
   if (areaCode &gt; pn.areaCode)
      return 1;
   // Area codes are equal, compare prefixes
   if (prefix &lt; pn.prefix)
      return -1;
   if (prefix &gt; pn.prefix)
      return 1;
   // Area codes and prefixes are equal, compare line numbers
   if (lineNumber &lt; pn.lineNumber)
      return -1;
   if (lineNumber &gt; pn.lineNumber)
      return 1;
   return 0;  // All fields are equal
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
