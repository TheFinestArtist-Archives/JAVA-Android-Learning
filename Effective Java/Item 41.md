# Use overloading judiciously

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* The choice of which overloading to invoke is made at compile time
* Selection among overloaded methods is static, while selection among overridden methods is dynamic.
* The compile-time type of an object has no effect on which method is executed when an overridden method is invoked; the “most specific” overriding method always gets executed. Compare this to overloading, where the runtime type of an object has no effect on which overloading is executed;

Example shows difference between overloading and overriding
<pre class="prettyprint">
// It prints Unknown Collection three times
public class CollectionClassifier {
   public static String classify(Set&lt;?&gt; s) {
      return "Set";
   }
   public static String classify(List&lt;?&gt; lst) {
      return "List";
   }
   public static String classify(Collection&lt;?&gt; c) {
      return "Unknown Collection";
   }
   public static void main(String[] args) {
      Collection&lt;?&gt;[] collections = {
         new HashSet&lt;String&gt;(),
         new ArrayList&lt;BigInteger&gt;(),
         new HashMap&lt;String, String&gt;().values()
      };
      for (Collection&lt;?&gt; c : collections)
         System.out.println(classify(c));
   }
}
</pre>

<pre class="prettyprint">
// It prints out wine, sparkling wine, and champagne
class Wine {
   String name() { return "wine"; }
}
class SparklingWine extends Wine {
   @Override String name() { return "sparkling wine"; }
}
class Champagne extends SparklingWine {
   @Override String name() { return "champagne"; }
}
public class Overriding {
   public static void main(String[] args) {
      Wine[] wines = {
         new Wine(), new SparklingWine(), new Champagne()
      };
      for (Wine wine : wines)
         System.out.println(wine.name());
   }
}
</pre>

## Avoid confusing uses of overloading
* A safe, conservative policy is never to export two overloadings with the same number of parameters

<pre class="prettyprint">
// ObjectOutputStream
void writeBoolean(boolean);
void writeInt(int);
void writeLong(long);

boolean readBoolean();
int readInt();
long readLong();
</pre>

* For constructors, you do have the option of exporting static factories instead of constructor
* When at least one corresponding formal parameter in each pair of overloadings has a “radically different” type in the two overloadings

## Confusion by auto-boxing
<pre class="prettyprint">
// It prints out [-2, 0, 2]
public class ListOverloading {
   public static void main(String[] args) {
      List&lt;Integer&gt; list = new ArrayList&lt;Integer&gt;();
      for (int i = -3; i &lt; 3; i++)
         list.add(i);
      for (int i = 0; i &lt; 3; i++)
         list.remove(i); // should be list.remove((Integer) i);
      System.out.println(list);
   }
}

public class List {
   void remove(int);
   void remove(E);
}
</pre>

**There may be times when you feel the need to violate the guidelines in this item, especially when evolving existing classes.**

* The standard way to ensure this behavior is to have the more specific overloading forward to the more general
<pre class="prettyprint">
public boolean contentEquals(StringBuffer sb) {
   return contentEquals((CharSequence) sb);
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
