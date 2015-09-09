# Avoid creating unnecessary objects

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**Case of String**
<pre class="prettyprint">
// Creating two String objects
String s = new String("Hello World");

// Creating one String object
String s = "Hello World";
</pre>

**Case of static factory methods**
<pre class="prettyprint">
// Creating Boolean object
Boolean b = Boolean("false");

// Reusing Boolean object
Boolean b = Boolean.valueOf("true");
</pre>

**Use case of static initializer**
<pre class="prettyprint">
public class Person {
   private final Date birthDate;
   // Other fields, methods, and constructor omitted

   // DON'T DO THIS!
   public boolean isBabyBoomer() {
      // Unnecessary allocation of expensive object
      Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);

      Date boomStart = gmtCal.getTime();
      gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);

      Date boomEnd = gmtCal.getTime();
      return birthDate.compareTo(boomStart) &gt;= 0 && birthDate.compareTo(boomEnd) &lt; 0;
   }
}
</pre>

<pre class="prettyprint">
class Person {
   private final Date birthDate;
   // Other fields, methods, and constructor omitted
   /**
    * The starting and ending dates of the baby boom.
    */
   private static final Date BOOM_START;
   private static final Date BOOM_END;
   static {
      Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
      BOOM_START = gmtCal.getTime();

      gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
      BOOM_END = gmtCal.getTime();
   }

   public boolean isBabyBoomer() {
      return birthDate.compareTo(BOOM_START) &gt;= 0 && birthDate.compareTo(BOOM_END) &lt; 0;
   }
}
</pre>

Times to run isBabyBoomer 100,000 times
   * Old Example : 32000ms
   * New Example : 130ms


User primitives instead of auto-boxed-primitives and watch out unintentional auto-boxing
<pre class="prettyprint">
// Takes 43 seconds
public static void main(String... args) {
   Long sum = 0L;
   for (long i = 0; i &lt; Integer.MAX_VALUE; i++) {
      sum += i;
   }
   System.out.println(sum);
}

// Takes 6.8 seconds
public static void main(String... args) {
   long sum = 0L;
   for (long i = 0; i &lt; Integer.MAX_VALUE; i++) {
      sum += i;
   }
   System.out.println(sum);
}
</pre>

**Don’t create a new object when you should reuse an existing one**

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
