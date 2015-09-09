# Make defensive copies when needed

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

You must program defensively, with the assumption that clients of your class will do their best to destroy its invariants.

<pre class="prettyprint">
// Broken "immutable" time period class
public final class Period {
   private final Date start;
   private final Date end;

   /**
    * @param start the beginning of the period
    * @param end the end of the period; must not precede start * @throws IllegalArgumentException if start is after end
    * @throws NullPointerException if start or end is null
    */
   public Period(Date start, Date end) {
      if (start.compareTo(end) &gt; 0)
         throw new IllegalArgumentException(start + " after " + end);
      this.start = start;
      this.end   = end;
   }

   public Date start() { return start; }
   public Date end() { return end; }
   ...  // Remainder omitted
}
</pre>

## Attack the internals of a Period instance
It is essential to make a defensive copy of each mutable parameter to the constructor

<pre class="prettyprint">
// Attack the internals of a Period instance
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end); end.setYear(78); // Modifies internals of p!

// Repaired constructor - makes defensive copies of parameters
public Period(Date start, Date end) {
   this.start = new Date(start.getTime());
   this.end   = new Date(end.getTime());
   if (this.start.compareTo(this.end) &gt; 0)
      throw new IllegalArgumentException(start +" after "+ end);
}
</pre>

* defensive copies are made before checking the validity of the parameters (Item 38), and the validity check is performed on the copies rather than on the originals*

## Second attack on the internals of a Period instance
Modify the accessors to return defensive copies of mutable internal fields

<pre class="prettyprint">
// Second attack on the internals of a Period instance
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end); p.end().setYear(78); // Modifies internals of p!

// Repaired accessors - make defensive copies of internal fields
public Date start() {
   return new Date(start.getTime());
}
public Date end() {
   return new Date(end.getTime());
}
</pre>

* Do not use the clone method to make a defensive copy of a parameter whose type is subclassable by untrusted parties
* Experienced programmers often use the primitive long returned by Date.getTime() as an internal time representation instead of using a Date reference

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
