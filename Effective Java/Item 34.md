# Emulate extensible enums with interfaces

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* You cannot write an extensible enum type
* You can emulate it by writing an interface to go with a basic enum type that implements the interface
* This allows clients to write their own enums that implement the interface

<pre class="prettyprint">
// Emulated extensible enum using an interface
public interface Operation {
   double apply(double x, double y);
}

public enum BasicOperation  implements Operation {
   PLUS("+") {
      public double apply(double x, double y) { return x + y; }
   },
   MINUS("-") {
      public double apply(double x, double y) { return x - y; }
   },
   TIMES("*") {
      public double apply(double x, double y) { return x * y; }
   },
   DIVIDE("/") {
      public double apply(double x, double y) { return x / y; }
   };

   private final String symbol;

   BasicOperation(String symbol) {
      this.symbol = symbol;
   }

   @Override public String toString() {
      return symbol;
   }
}

// Emulated extension enum
public enum ExtendedOperation implements Operation {
   EXP("^") {
      public double apply(double x, double y) { return Math.pow(x, y); }
   },
   REMAINDER("%") {
      public double apply(double x, double y) { return x % y; }
   };

   private final String symbol;

   ExtendedOperation(String symbol) {
      this.symbol = symbol;
   }

   @Override public String toString() {
      return symbol;
   }
}
</pre>

## Use case
<pre class="prettyprint">
public static void main(String[] args) {
   double x = Double.parseDouble(args[0]);
   double y = Double.parseDouble(args[1]);
   test(ExtendedOperation.class, x, y);
}

private static &lt;T extends Enum&lt;T&gt; & Operation&gt; void test(Class&lt;T&gt; opSet, double x, double y) {
   for (Operation op : opSet.getEnumConstants())
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
}

public static void main(String[] args) {
   double x = Double.parseDouble(args[0]);
   double y = Double.parseDouble(args[1]);
   test(Arrays.asList(ExtendedOperation.values()), x, y);
}
private static void test(Collection&lt;? extends Operation&gt; opSet, double x, double y) {
   for (Operation op : opSet)
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
