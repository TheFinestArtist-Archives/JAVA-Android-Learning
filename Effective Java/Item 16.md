# Favor composition over inheritance

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Safe way to use inheritance
* Where the subclass and the superclass implementations are under the control of the same programmers
* When extending classes specifically designed and documented for extension

<pre class="prettyprint">
// Broken - Inappropriate use of inheritance!
public class InstrumentedHashSet&lt;E&gt; extends HashSet&lt;E&gt; {

   // The number of attempted element insertions
   private int addCount = 0;

   public InstrumentedHashSet() {
   }

   public InstrumentedHashSet(int initCap, float loadFactor) {
      super(initCap, loadFactor);
   }

   @Override public boolean add(E e) {
      addCount++;
      return super.add(e);
   }

   @Override public boolean addAll(Collection&lt;? extends E&gt; c) { addCount += c.size();
      return super.addAll(c);
   }

   public int getAddCount() {
      return addCount;
   }
}
</pre>

<pre class="prettyprint">
// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet&lt;E&gt; extends ForwardingSet&lt;E&gt; {

   private int addCount = 0;

   public InstrumentedSet(Set&lt;E&gt; s) {
      super(s);
   }

   @Override public boolean add(E e) {
      addCount++;
      return super.add(e);
   }

   @Override public boolean addAll(Collection&lt;? extends E&gt; c) { addCount += c.size();
      return super.addAll(c);
   }

   public int getAddCount() {
      return addCount;
   }
}

// Reusable forwarding class
public class ForwardingSet&lt;E&gt; implements Set&lt;E&gt; {

   private final Set&lt;E&gt; s;
   public ForwardingSet(Set&lt;E&gt; s) { this.s = s; }

   public void clear()                                { s.clear();               }
   public boolean contains(Object o)                  { return s.contains(o);    }
   public boolean isEmpty()                           { return s.isEmpty();      }
   public int size()                                  { return s.size();         }
   public Iterator&lt;E&gt; iterator()                      { return s.iterator();     }
   public boolean add(E e)                            { return s.add(e);         }
   public boolean remove(Object o)                    { return s.remove(o);      }
   public boolean containsAll(Collection&lt;?&gt; c)        { return s.containsAll(c); }
   public boolean addAll(Collection&lt;? extends E&gt; c)   { return s.addAll(c);      }
   public boolean removeAll(Collection&lt;?&gt; c)          { return s.removeAll(c);   }
   public boolean retainAll(Collection&lt;?&gt; c)          { return s.retainAll(c);   }
   public Object[] toArray()                          { return s.toArray();      }
   public &lt;T&gt; T[] toArray(T[] a)                      { return s.toArray(a);     }
   @Override public boolean equals(Object o)          { return s.equals(o);      }
   @Override public int hashCode()                    { return s.hashCode();     }
   @Override public String toString()                 { return s.toString();     }
}
</pre>

**Inheritance is appropriate only in circumstances where the subclass really is a subtype of the superclass**

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
