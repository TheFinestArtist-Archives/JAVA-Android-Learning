# Obey the general contract when overriding equals

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Conditions which you don't need to override equals method
* Each instance of the class is inherently unique
* You don’t care whether the class provides a “logical equality” test
* A super class has already overridden equals, and the super class behavior is appropriate for this class
* The class is private or package-private, and you are certain that it sequals method will never be invoked

## Appropriate time to override equals method
* a class has a notion of logical equality that differs from mere object identity
* a superclass has not already overridden equals to implement the desired behavior

## General Contract to override equals method
* Reflexive <code id="inline">x.equals(x) = true</code>
* Symmetric <code id="inline">x.equals(y) = y.equals(x)</code>
* Transitive <code id="inline">x.equals(y) = y.equals(z) true =&gt; z.equals(x) = true</code>
* Consistent <code id="inline">x.equals(y) always has to be same if x, y value remains same</code>

**Symmetric violation example**
<pre class="prettyprint">
// Broken - violates symmetry!
public final class CaseInsensitiveString {
    private final String s;
    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }
    // Broken - violates symmetry!
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }
    ...  // Remainder omitted
}

CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
String s = "polish";

cis.equals(s) == true;
s.equals(cis) == false;
</pre>

**There is no way to extend an instantiable class and add a value component while preserving the equals**
<pre class="prettyprint">
public class Point {
    private final int x;
    private final int y;
    public Point(int x, int y) {
       this.x = x;
       this.y = y; }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }
    ...  // Remainder omitted
}

public class ColorPoint extends Point {
    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    ...  // Remainder omitted
}

// Broken - violates symmetry!
@Override public boolean equals(Object o) {
    if (!(o instanceof ColorPoint))
       return false;
    return super.equals(o) && ((ColorPoint) o).color == color;
}

// Broken - violates transitivity!
@Override public boolean equals(Object o) {
    if (!(o instanceof Point))
        return false;
    // If o is a normal Point, do a color-blind comparison
    if (!(o instanceof ColorPoint))
        return o.equals(this);
    // o is a ColorPoint; do a full comparison
    return super.equals(o) && ((ColorPoint)o).color == color;
}

ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
Point p2 = new Point(1, 2);
ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

p1.equals(p2) == true;
p2.equals(p3) == true;
p1.equals(p3) == false;
</pre>

**Null check** - Use instanceof
<pre class="prettyprint">
@Override public boolean equals(Object o) {
   // if o is null, instanceof will return false
   if (!(o instanceof MyType))
      return false;
   MyType mt = (MyType) o;
   ...
}
</pre>

## Recipe for a high-quality equals method
1. Use the == operator to check if the argument is a reference to this object
2. Use the instanceof operator to check if the argument has the correct type
   <pre class="prettyprint">
   @Override
   public boolean equals(Object o) {
      if (o == this)
         return true;
      if (!(o instanceof PhoneNumber))
         return false;
      PhoneNumber pn = (PhoneNumber)o;
      return pn.lineNumber == lineNumber
         && pn.prefix  == prefix
         && pn.areaCode  == areaCode;
   }
   </pre>

3. Cast the argument to the correct type
4. For each “significant” field in the class, check if that field of the argument matches the corresponding field of this object
5. When you are finished writing your equals method, ask yourself three questions: Is it symmetric? Is it transitive? Is it consistent?

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
