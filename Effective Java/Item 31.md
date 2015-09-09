# Use instance fields instead of ordinals

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Never derive a value associated with an enum from its ordinal; store it in an instance field instead

<pre class="prettyprint">
// Abuse of ordinal to derive an associated value - DON'T DO THIS
public enum Ensemble {
   SOLO,   DUET,   TRIO, QUARTET, QUINTET,
   SEXTET, SEPTET, OCTET, NONET,  DECTET;

   public int numberOfMusicians() {
      return ordinal() + 1;
   }
}

public enum Ensemble {
   SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
   SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
   NONET(9), DECTET(10), TRIPLE_QUARTET(12);

   private final int numberOfMusicians;

   Ensemble(int size) {
      this.numberOfMusicians = size;
   }

   public int numberOfMusicians() {
      return numberOfMusicians;
   }
}
</pre>

**Enum specification has this to say about ordinal**  
*Most programmers will have no use for this method. It is designed for use by general-purpose enum- based data structures such as EnumSet and EnumMap.*

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
