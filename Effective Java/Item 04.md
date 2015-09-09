# Enforce noninstantiability with a private constructor

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Utility classes are not intended to make any constructor
* private constructor can prevent to create an object
* Sub-class can't be created

<pre class="prettyprint">
/**
 * DipPixelHelper
 *
 * @author The Finest Artist
 */
public class DipPixelHelper {

   // Suppress default constructor for noninstantiability
   private DipPixelHelper() {
      throw new AssertionError();
   }

   public static float getPixel(Context context, int dip) {
      Resources r = context.getResources();
      return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
   }

   public static float getPixel(Context context, float dip) {
      Resources r = context.getResources();
      return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
   }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
