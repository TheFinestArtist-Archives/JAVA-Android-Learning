# Use interfaces only to define types

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

The constant interface pattern is a poor use of interfaces

<pre class="prettyprint">
// Constant interface antipattern - do not use!
public interface PhysicalConstants {
   // Avogadro's number (1/mol)
   static final double AVOGADROS_NUMBER   = 6.02214199e23;
   // Boltzmann constant (J/K)
   static final double BOLTZMANN_CONSTANT = 1.3806503e-23;
   // Mass of the electron (kg)
   static final double ELECTRON_MASS      = 9.10938188e-31;
}
</pre>

If you want to export constants, there are several reasonable choices. If the constants are strongly tied to an existing class or interface, you should add them to the class or interface

<pre class="prettyprint">
// Constant utility class
public class PhysicalConstants {
   private PhysicalConstants() { }  // Prevents instantiation

   public static final double AVOGADROS_NUMBER = 6.02214199e23;
   public static final double BOLTZMANN_CONSTANT = 1.3806503e-23;
   public static final double ELECTRON_MASS = 9.10938188e-31;
}
</pre>

*you can avoid the need for qualifying the constants with the class name by making use of the **static import** facility*

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
