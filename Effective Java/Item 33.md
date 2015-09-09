# Use Enum Map instead of ordinal indexing

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Ordinal indexing
<pre class="prettyprint">
public class Herb {
   public enum Type { ANNUAL, PERENNIAL, BIENNIAL }

   private final String name;
   private final Type type;

   Herb(String name, Type type) {
      this.name = name;
      this.type = type;
   }

   @Override public String toString() {
      return name;
   }
}

// Using ordinal() to index an array - DON'T DO THIS!
Herb[] garden = ... ;

// Indexed by Herb.Type.ordinal()
Set&lt;Herb&gt;[] herbsByType = (Set&lt;Herb&gt;[]) new Set[Herb.Type.values().length];

for (int i = 0; i &lt; herbsByType.length; i++)
   herbsByType[i] = new HashSet&lt;Herb&gt;();

for (Herb h : garden)
   herbsByType[h.type.ordinal()].add(h);

// Print the results
for (int i = 0; i &lt; herbsByType.length; i++) {
   System.out.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
}
</pre>

#### Problems
1. Arrays are not compatible with generics
2. The program requires an unchecked cast and will not compile cleanly
3. When you access an array that is indexed by an enum’s ordi- nal, it is your responsibility to use the correct int value

## EnumMap
<pre class="prettyprint">
// Using an EnumMap to associate data with an enum
Map&lt;Herb.Type, Set&lt;Herb&gt;&gt; herbsByType = new EnumMap&lt;Herb.Type, Set&lt;Herb&gt;&gt;(Herb.Type.class);

for (Herb.Type t : Herb.Type.values())
   herbsByType.put(t, new HashSet&lt;Herb&gt;());

for (Herb h : garden)
   herbsByType.get(h.type).add(h);

System.out.println(herbsByType);
</pre>

## Phase Transition Example
<pre class="prettyprint">
// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum Phase { SOLID, LIQUID, GAS;
   public enum Transition {
      MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

      // Rows indexed by src-ordinal, cols by dst-ordinal
      private static final Transition[][] TRANSITIONS = {
         { null,    MELT,     SUBLIME },
         { FREEZE,  null,     BOIL    },
         { DEPOSIT, CONDENSE, null    }
      };

      // Returns the phase transition from one phase to another
      public static Transition from(Phase src, Phase dst) {
         return TRANSITIONS[src.ordinal()][dst.ordinal()];
      }
   }
}

// Using a nested EnumMap to associate data with enum pairs
public enum Phase {
   SOLID, LIQUID, GAS;

   public enum Transition {
      MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
      BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
      SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

      final Phase src;
      final Phase dst;

      Transition(Phase src, Phase dst) {
         this.src = src;
         this.dst = dst;
      }

      // Initialize the phase transition map
      private static final Map&lt;Phase, Map&lt;Phase,Transition&gt;&gt; m = new EnumMap&lt;Phase, Map&lt;Phase,Transition&gt;&gt;(Phase.class);

      static {
         for (Phase p : Phase.values())
            m.put(p,new EnumMap&lt;Phase,Transition&gt;(Phase.class));

         for (Transition trans : Transition.values())
            m.get(trans.src).put(trans.dst, trans);
      }

      public static Transition from(Phase src, Phase dst) {
         return m.get(src).get(dst);
      }
   }
}
</pre>

EnumMap is easier to add new enum values: Now suppose you want to add a new phase to the system: the plasma, or ionized gas

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
