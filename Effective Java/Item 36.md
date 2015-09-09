# Consistently use the Override annotation

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

You should use the Override annotation on every method decla- ration that you believe to override a superclass declaration

**Overloading**
<pre class="prettyprint">
// Can you spot the bug?
public class Bigram {
   private final char first;
   private final char second;

   public Bigram(char first, char second) {
      this.first  = first;
      this.second = second;
   }

   public boolean equals(Bigram b) {
      return b.first == first && b.second == second;
   }

   public int hashCode() {
      return 31 * first + second;
   }

   public static void main(String[] args) {
      Set&lt;Bigram&gt; s = new HashSet&lt;Bigram&gt;();
      for (int i = 0; i &lt; 10; i++)
         for (char ch = 'a'; ch &lt;= 'z'; ch++)
            s.add(new Bigram(ch, ch));
      System.out.println(s.size());
   }
}
</pre>

**Override**
<pre class="prettyprint">
@Override
public boolean equals(Object o) {
   if (!(o instanceof Bigram))
      return false;
   Bigram b = (Bigram) o;
   return b.first == first && b.second == second;
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
