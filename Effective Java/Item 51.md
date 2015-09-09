# Beware the performance of string concatenation

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**Strings are immutable**  
Using the string concatenation operator repeatedly to concatenate n strings requires time quadratic in n.

User StringBuilder instead of String it self
<pre class="prettyprint">
// Inappropriate use of string concatenation - Performs horribly!
public String statement() {
   String result = "";
   for (int i = 0; i &lt; numItems(); i++)
      result += lineForItem(i);  // String concatenation
   return result;
}

public String statement() {
   StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
   for (int i = 0; i &lt; numItems(); i++)
      b.append(lineForItem(i));
   return b.toString();
}
</pre>

Because the first method is quadratic in the number of items and the second is linear, the performance difference is even more dramatic for larger numbers of items.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
