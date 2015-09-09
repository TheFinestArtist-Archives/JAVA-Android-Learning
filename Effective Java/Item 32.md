# Use EnumSet instead of bit fields

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Bit field
The bit field representation also lets you perform set operations such as union and intersection efficiently using bitwise arithmetic
<pre class="prettyprint">
// Bit field enumeration constants - OBSOLETE!
public class Text {
   public static final int STYLE_BOLD
   public static final int STYLE_ITALIC
   public static final int STYLE_UNDERLINE
   public static final int STYLE_STRIKETHROUGH = 1 &lt;&lt; 3;  // 8

   // Parameter is bitwise OR of zero or more STYLE_ constants
   public void applyStyles(int styles) { ... }
}

text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
</pre>

## EnumSet
<pre class="prettyprint">
// EnumSet - a modern replacement for bit fields
public class Text {
   public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

   // Any Set could be passed in, but EnumSet is clearly best
   public void applyStyles(Set&lt;Style&gt; styles) { ... }
}

text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
</pre>

#### Advantages
1. This class implements the Set interface, providing all of the richness, type safety, and interoperability you get with any other Set implementation.
2. The EnumSet class combines the conciseness and performance of bit fields
3. All the many advantages of enum types

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
