# Override clone judiciously

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**Object's clone() method**
<pre class="prettyprint">
protected native Object clone() throws CloneNotSupportedException;
</pre>

**Cloneable interface**
<pre class="prettyprint">
public interface Cloneable {
}
</pre>

## [General contract](http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/Object.java#Object.clone%28%29) for the clone method

> Creates and returns a copy of this object. The precise meaning of “copy” may depend on the class of the object. The general intent is that, for any object x, the expression  
<code id="inline">x.clone() != x</code>  
will be true, and the expression  
<code id="inline">x.clone().getClass() == x.getClass()</code>  
will be true, but these are not absolute requirements. While it is typically the case that  <code id="inline">x.clone().equals(x)</code>  
will be true, this is not an absolute requirement. Copying an object will typically entail creating a new instance of its class, but it may require copying of internal data structures as well. No constructors are called.

* If you override the clone method in a nonfinal class, you should return an object obtained by invoking super.clone()
   * super.clone() methods copys primitive values automatically
* In practice, a class that implements Cloneable is expected to provide a properly functioning public clone() method.
* clone() method functions as another constructor; you must ensure that it does no harm to the original object and that it properly establishes invariants on the clone

**Example #1**
<pre class="prettyprint">
public class Stack {
   private Object[] elements;
   private int size = 0;

   @Override public Stack clone() {
      try {
         Stack result = (Stack) super.clone();
         result.elements = elements.clone();
         return result;
      } catch (CloneNotSupportedException e) {
         throw new AssertionError();
      }
   }
}
</pre>

**Example #2**
<pre class="prettyprint">
public class HashTable implements Cloneable {
   private Entry[] buckets = ...;
   private static class Entry {
   final Object key;
   Object value;
   Entry  next;

   Entry(Object key, Object value, Entry next) {
      this.key   = key;
      this.value = value;
      this.next  = next;
   }

   // Recursively copy the linked list headed by this Entry
   Entry deepCopy() {
      return new Entry(key, value, next == null ? null : next.deepCopy());
   }

   // Iteratively copy the linked list headed by this Entry
   Entry deepCopy() {
      Entry result = new Entry(key, value, next);
      for (Entry p = result; p.next != null; p = p.next)
         p.next = new Entry(p.next.key, p.next.value, p.next.next);
      return result;
   }

   }
   @Override public HashTable clone() {
      try {
         HashTable result = (HashTable) super.clone();
         result.buckets = new Entry[buckets.length];
         for (int i = 0; i &lt; buckets.length; i++)
            if (buckets[i] != null)
               result.buckets[i] = buckets[i].deepCopy();
         return result;
      } catch (CloneNotSupportedException e) {
         throw new AssertionError();
      }
   }
}
</pre>

## Conclusion
* All classes that implement Cloneable should override clone
* clone() method should first call super.clone and then fix any fields that need to be fixed
* Do not make any interface which extends cloneable
* Do not implement cloneable for any classe designed for inheritance

## Alternatives
* Copy constructor
   <pre class="prettyprint">
   public Yum(Yum yum);
   </pre>

* Copy factory
   <pre class="prettyprint">
   public static Yum newInstance(Yum yum);
   </pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
