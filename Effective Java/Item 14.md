# In public classes, use accessor methods, not public fields

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* If a class is accessible outside its package, provide accessor methods
* if a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields

<pre class="prettyprint">
// Encapsulation of data by accessor methods and mutators
class Point {
   private double x;
   private double y;

   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double getX() { return x; }
   public void setX(double x) { this.x = x; }

   public double getY() { return y; }
   public void setY(double y) { this.y = y; }
}
</pre>

* While it’s never a good idea for a public class to expose fields directly, it is less harmful if the fields are immutable.

<pre class="prettyprint">
// Public class with exposed immutable fields - questionable
public final class Time {
   public final int hour;
   public final int minute;

   public Time(int hour, int minute) {
      this.hour = hour;
      this.minute = minute;
   }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
