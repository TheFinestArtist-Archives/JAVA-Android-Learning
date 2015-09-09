# Prefer interfaces to abstract classes

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

1. Existing classes can be easily retrofitted to implement a new interface
2. Interfaces are ideal for defining mixins
3. Interfaces allow the construction of nonhierarchical type frameworks
4. Interfaces enable safe, powerful functionality enhancements
5. You can combine the virtues of interfaces and abstract classes by providing an abstract skeletal implementation class to go with each nontrivial interface that you export
   <pre class="prettyprint">
   // Skeletal Implementation
   public abstract class AbstractMapEntry&lt;K, V&gt; implements Map.Entry&lt;K, V&gt; {
      // Primitive operations
      public abstract K getKey();
      public abstract V getValue();

      // Entries in modifiable maps must override this method
      public V setValue(V value) {
         throw new UnsupportedOperationException();
      }

      // Implements the general contract of Map.Entry.equals
      @Override public boolean equals(Object o) {
         if (o == this)
            return true;
         if (! (o instanceof Map.Entry))
            return false;
         Map.Entry&lt;?, ?&gt; arg = (Map.Entry) o;
         return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());
      }

      private static boolean equals(Object o1, Object o2) {
         return o1 == null ? o2 == null : o1.equals(o2);
      }

      // Implements the general contract of Map.Entry.hashCode
      @Override public int hashCode() {
         return hashCode(getKey()) ^ hashCode(getValue());
      }

      private static int hashCode(Object obj) {
         return obj == null ? 0 : obj.hashCode();
      }
   }
   </pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
