# Always override hashCode when you override equals

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

You must override hashCode in every class that overrides equals

## The key provision that is violated when you fail to override hashCode
* If two objects are equal according to the equals(Object) method,then calling the hashCode method on each of the two objects must produce the same integer result.

## Simple Recipe
1. Store some constant nonzero value, say, 17, in an int variable called result.
2. For each significant field f in your object (each field taken into account by the
equals method, that is), do the following:
   1. Compute an int hash code c for the field:
      1. If the field is a boolean, compute (f ? 1 : 0).
      2. If the field is a byte, char, short, or int, compute (int) f.
      3. If the field is along, compute (int) (f^(f&gt;&gt;&gt;32)).
      4. If the field is a float, compute Float.floatToIntBits(f).
      5. If the field is a double, compute Double.doubleToLongBits(f), and then hash the resulting long as in step 2.1.3.
      6. If the field is an object reference and this class’s equals method compares the field by recursively invoking equals, recursively invoke hashCode on the field. If a more complex comparison is required, compute a “canonical representation” for this field and invoke hashCode on the canonical representation. If the value of the field is null, return 0 (or some other constant, but 0 is traditional).
      7. If the field is an array, treat it as if each element were a separate field. That is, compute a hash code for each significant element by applying these rules recursively, and combine these values per step 2.b. If every element in an array field is significant, you can use one of the Arrays.hashCode methods added in release 1.5.
   2. Combine the hash code c computed in step 2.a into result as follows: result = 31 * result + c;
3. Return result.
4. When you are finished writing the hashCode method, ask yourself whether equal instances have equal hash codes. Write unit tests to verify your intuition! If equal instances have unequal hash codes, figure out why and fix the problem.

<pre class="prettyprint">
// Lazily initialized, cached hashCode
private volatile int hashCode;  // (See Item 71)
@Override public int hashCode() {
   int result = hashCode;
   if (result == 0) {
      result = 17;
      result = 31 * result + areaCode;
      result = 31 * result + prefix;
      result = 31 * result + lineNumber;
      hashCode = result;
   }
   return result;
}
</pre>

Do not be tempted to exclude significant parts of an object from the hash code computation to improve performance

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
