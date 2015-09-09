# Minimize mutability

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Immutable Class?
An immutable class is simply a class whose instances cannot be modified

## Immutable class examples
* String
* Boxed primitive classes
* BigInteger and BigDecimal

## Advantage of immutable classes
* Easier to design, implement, and use
* Less prone to error and are more secure

## Rules to follow to make immutable classes
1. Don’t provide any methods that modify the object’s state
2. Ensure that the class can’t be extended
3. Make all fields final
4. Make all fields private
5. Ensure exclusive access to any mutable components

<pre class="prettyprint">
public final class Complex {

   private final double re;
   private final double im;

   public Complex(double re, double im) {
      this.re = re;
      this.im = im;
   }

   // Static factories instead of constructors
   // private Complex(double re, double im) {
   //    this.re = re;
   //    this.im = im;
   // }
   //
   // public static Complex valueOf(double re, double im) {
   //    return new Complex(re, im);
   // }

   // Accessors with no corresponding mutators
   public double realPart()      { return re; }
   public double imaginaryPart() { return im; }

   public Complex add(Complex c) {
      return new Complex(re + c.re, im + c.im);
   }

   public Complex subtract(Complex c) {
      return new Complex(re - c.re, im - c.im);
   }

   public Complex multiply(Complex c) {
      return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
   }

   public Complex divide(Complex c) {
      double tmp = c.re * c.re + c.im * c.im;
      return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
   }

   @Override public boolean equals(Object o) {
      if (o == this)
         return true;
      if (!(o instanceof Complex))
         return false;
      Complex c = (Complex) o;
      // See page 43 to find out why we use compare instead of == return Double.compare(re, c.re) == 0 &&
      Double.compare(im, c.im) == 0;
   }

   @Override public int hashCode() {
      int result = 17 + hashDouble(re);
      result = 31 * result + hashDouble(im);
      return result;
   }

   private int hashDouble(double val) {
      long longBits = Double.doubleToLongBits(re);
      return (int) (longBits ^ (longBits &gt;&gt;&gt; 32));
   }

   @Override public String toString() {
      return "(" + re + " + " + im + "i)";
   }
}
</pre>

## Advantages of immutable objects
1. Immutable objects are simple
2. Immutable objects are inherently thread-safe; they require no synchronization
3. Immutable objects can be shared freely
   <pre class="prettyprint">
   public static final Complex ZERO = new Complex(0, 0);
   public static final Complex ONE  = new Complex(1, 0);
   public static final Complex I    = new Complex(0, 1);
   </pre>
4. Not only can you share immutable objects, but you can share their internals
5. Immutable objects make great building blocks for other objects (i.e. map, set)
6. The only real disadvantage of immutable classes is that they require a separate object for each distinct value

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
