# Use enums instead of int constants

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**enumerated type**  
a type whose legal values consist of a fixed set of constants

## int enum pattern
<pre class="prettyprint">
// The int enum pattern - severely deficient!
public static final int APPLE_FUJI           = 0;
public static final int APPLE_PIPPIN         = 1;
public static final int APPLE_GRANNY_SMITH   = 2;

public static final int ORANGE_NAVEL         = 0;
public static final int ORANGE_TEMPLE        = 1;
public static final int ORANGE_BLOOD         = 2;
</pre>

**Shortcomings**
* Provides nothing in the way of type safety and little in the way of convenience
* Java doesn’t provide namespaces for int enum groups
* Programs that use the int enum pattern are brittle
* There is no easy way to translate int enum constants into printable strings

## Enum Type
<pre class="prettyprint">
public enum Apple  { FUJI, PIPPIN, GRANNY_SMITH }
public enum Orange { NAVEL, TEMPLE, BLOOD }
</pre>

**Java’s enum types are full-fledged classes, far more powerful than other languages**
* Enum types are effectively final
   * By virtue of having no accessible constructors
   * Cannot create instances of an enum type nor extend it
* Enum types are instance-controlled and generalization of singletons
* Provide compile-time type safety
* Enum types let you add arbitrary methods and fields and implement arbitrary interfaces

<pre class="prettyprint">
// Enum type with data and behavior
public enum Planet {
   MERCURY(3.302e+23, 2.439e6),
   VENUS  (4.869e+24, 6.052e6),
   EARTH  (5.975e+24, 6.378e6),
   MARS   (6.419e+23, 3.393e6),
   JUPITER(1.899e+27, 7.149e7),
   SATURN (5.685e+26, 6.027e7),
   URANUS (8.683e+25, 2.556e7),
   NEPTUNE(1.024e+26, 2.477e7);

   private final double mass;           // In kilograms
   private final double radius;         // In meters
   private final double surfaceGravity; // In m / s^2

   // Universal gravitational constant in m^3 / kg s^2
   private static final double G = 6.67300E-11;

   // Constructor
   Planet(double mass, double radius) {
      this.mass = mass;
      this.radius = radius;
      surfaceGravity = G * mass / (radius * radius);
   }

   public double mass()           { return mass; }
   public double radius()         { return radius; }
   public double surfaceGravity() { return surfaceGravity; }

   public double surfaceWeight(double mass) {
      return mass * surfaceGravity;  // F = ma
   }
}
</pre>

>*To associate data with enum constants, declare instance fields and write a constructor that takes the data and stores it in the fields.*  

>*Enums are by their nature immutable, so all fields should be final (Item 15). They can be public, but it is better to make them private and provide public accessors (Item 14)*

**static values method**  
Static <code id="inline">values()</code> method that returns an array of its values *in the order* they were declared.  

**toString**  
<code id="inline">toString()</code> method returns the declared name of each enum value. If you’re dissatisfied with this string representation, you can change it by *overriding the toString method*.  

## Case which you need to associate fundamentally different behavior with each constant such as the operations on a basic four function calculator

<pre class="prettyprint">
// Enum type that switches on its own value - questionable
public enum Operation {
   PLUS, MINUS, TIMES, DIVIDE;
   // Do the arithmetic op represented by this constant
   double apply(double x, double y) {
      switch(this) {
         case PLUS:   return x + y;
         case MINUS:  return x - y;
         case TIMES:  return x * y;
         case DIVIDE: return x / y;
      }
      throw new AssertionError("Unknown op: " + this);
   }
}

// Enum type with constant-specific method implementations
public enum Operation {
   PLUS   { double apply(double x, double y){return x + y;} },
   MINUS  { double apply(double x, double y){return x - y;} },
   TIMES  { double apply(double x, double y){return x * y;} },
   DIVIDE { double apply(double x, double y){return x / y;} };
   abstract double apply(double x, double y);
}
</pre>

*Switches code is not pretty and also fragile*  

**toString and fromString**
<pre class="prettyprint">
// Enum type with constant-specific class bodies and data
public enum Operation {
   PLUS("+") {
      double apply(double x, double y) { return x + y; }
   },
   MINUS("-") {
      double apply(double x, double y) { return x - y; }
   },
   TIMES("*") {
      double apply(double x, double y) { return x * y; }
   },
   DIVIDE("/") {
      double apply(double x, double y) { return x / y; }
   };

   abstract double apply(double x, double y);

   private final String symbol;

   Operation(String symbol) {
      this.symbol = symbol;
   }

   @Override
   public String toString() {
      return symbol;
   }

   // Implementing a fromString method on an enum type
   private static final Map&lt;String, Operation&gt; stringToEnum = new HashMap&lt;String, Operation&gt;();
   static { // Initialize map from constant name to enum constant
      for (Operation op : values())
         stringToEnum.put(op.toString(), op);
   }
   // Returns Operation for string, or null if string is invalid
   public static Operation fromString(String symbol) {
      return stringToEnum.get(symbol);
   }
}
</pre>


<pre class="prettyprint">
// Enum that switches on its value to share code - questionable
enum PayrollDay {
   MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
   private static final int HOURS_PER_SHIFT = 8;

   double pay(double hoursWorked, double payRate) {
      double basePay = hoursWorked * payRate;
      double overtimePay; // Calculate overtime pay
      switch(this) {
         case SATURDAY:
         case SUNDAY:
            overtimePay = hoursWorked * payRate / 2;
            break;
         default: // Weekdays
            overtimePay = hoursWorked &lt;= HOURS_PER_SHIFT ?
            0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
            break;
      }
      return basePay + overtimePay;
   }
}

// The strategy enum pattern
enum PayrollDay {
   MONDAY(PayType.WEEKDAY),
   TUESDAY(PayType.WEEKDAY),
   WEDNESDAY(PayType.WEEKDAY),
   THURSDAY(PayType.WEEKDAY),
   FRIDAY(PayType.WEEKDAY),
   SATURDAY(PayType.WEEKEND),
   SUNDAY(PayType.WEEKEND);

   private final PayType payType;
   PayrollDay(PayType payType) { this.payType = payType; }

   double pay(double hoursWorked, double payRate) {
      return payType.pay(hoursWorked, payRate);
   }

   // The strategy enum type
   private enum PayType {
      WEEKDAY {
         double overtimePay(double hours, double payRate) {
            return hours &lt;= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
         }
      },
      WEEKEND {
         double overtimePay(double hours, double payRate) {
            return hours * payRate / 2;
         }
      };

      private static final int HOURS_PER_SHIFT = 8;
      abstract double overtimePay(double hrs, double payRate);

      double pay(double hoursWorked, double payRate) {
         double basePay = hoursWorked * payRate;
         return basePay + overtimePay(hoursWorked, payRate);
      }
   }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
