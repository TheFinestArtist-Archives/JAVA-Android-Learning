# Enforce the singleton property with a private constructor or an enum type

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Hard to test client if the class itself is a singleton

**Two ways to make singleton before Java 1.5**
<pre class="prettyprint">
// Singleton with public final field
public class Elvis {
   public static final Elvis INSTANCE = new Elvis();
   private Elvis() {...}
}

// Singleton with static factory
public class Elvis {
   private static final Elvis INSTANCE = new Elvis();
   private Elvis() {...}
   public static Elvis getInstance() { return INSTANCE; }
}
</pre>
<pre class="prettyprint">
// readResolve method to preserve singleton property
private Object readResolve() {
   // Return the one true Elvis and let the garbage collector
   // take care of the Elvis impersonator.
   return INSTANCE;
}

// Enum singleton - the preferred approach
public enum Elvis {
   INSTANCE;
   public void leaveTheBuilding() { ... }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
