# Prefer class hierarchies to tagged classes

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* Tagged classes are verbose, error-prone, and inefficient
* Tagged class is just a pallid imitation of a class hierarchy

<pre class="prettyprint">
// Tagged class - vastly inferior to a class hierarchy!
class Figure {

   enum Shape { RECTANGLE, CIRCLE };

   // Tag field - the shape of this figure
   final Shape shape;

   // These fields are used only if shape is RECTANGLE
   double length;
   double width;

   // This field is used only if shape is CIRCLE
   double radius;

   // Constructor for circle
   Figure(double radius) {
      shape = Shape.CIRCLE;
      this.radius = radius;
   }

   // Constructor for rectangle
   Figure(double length, double width) {
      shape = Shape.RECTANGLE;
      this.length = length;
      this.width = width;
   }

   double area() {
      switch(shape) {
         case RECTANGLE:
            return length * width;
         case CIRCLE:
            return Math.PI * (radius * radius);
         default:
            throw new AssertionError();
      }
   }
}
</pre>

<pre class="prettyprint">
// Class hierarchy replacement for a tagged class
abstract class Figure {
   abstract double area();
}

class Circle extends Figure {
   final double radius;

   Circle(double radius) { this.radius = radius; }
   double area() { return Math.PI * (radius * radius); }
}

class Rectangle extends Figure {
   final double length;
   final double width;

   Rectangle(double length, double width) {
      this.length = length;
      this.width  = width;
   }

   double area() { return length * width; }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
