# Favor generic types

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Prime candidate for generification
* have to cast objects that are popped off the stack
* those casts might fail at runtime
<pre class="prettyprint">
// Object-based collection - a prime candidate for generics
public class Stack {
   private Object[] elements;
   private int size = 0;
   private static final int DEFAULT_INITIAL_CAPACITY = 16;

   public Stack() {
      elements = new Object[DEFAULT_INITIAL_CAPACITY];
   }

   public void push(Object e) {
      ensureCapacity();
      elements[size++] = e;
   }

   public Object pop() {
      if (size == 0)
         throw new EmptyStackException();
      Object result = elements[--size];
      elements[size] = null; // Eliminate obsolete reference return result;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   private void ensureCapacity() {
      if (elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
   }
}
</pre>

## First solution
<pre class="prettyprint">
public class Stack&lt;E&gt; {
   private E[] elements;
   private int size = 0;
   private static final int DEFAULT_INITIAL_CAPACITY = 16;

   // The elements array will contain only E instances from push(E)
   // This is sufficient to ensure type safety, but the runtime
   // type of the array won't be E[]; it will always be Object[]!
   @SuppressWarnings("unchecked")
   public Stack() {
      elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
   }

   public void push(E e) {
      ensureCapacity();
      elements[size++] = e;
   }

   public E pop() {
      if (size == 0)
         throw new EmptyStackException();
      Object result = elements[--size];
      elements[size] = null; // Eliminate obsolete reference return result;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   private void ensureCapacity() {
      if (elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
   }
}
</pre>

## Second solution
<pre class="prettyprint">
public class Stack&lt;E&gt; {
   private Object[] elements;
   private int size = 0;
   private static final int DEFAULT_INITIAL_CAPACITY = 16;

   public Stack() {
      elements = new Object[DEFAULT_INITIAL_CAPACITY];
   }

   public void push(E e) {
      ensureCapacity();
      elements[size++] = e;
   }

   // Appropriate suppression of unchecked warning
   public E pop() {
      if (size == 0)
         throw new EmptyStackException();

      // push requires elements to be of type E, so cast is correct
      @SuppressWarnings("unchecked")
      E result = (E) elements[--size];
      elements[size] = null; // Eliminate obsolete reference return result;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   private void ensureCapacity() {
      if (elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
   }
}
</pre>

####First solution v/s Second solution
* It is riskier to suppress an unchecked cast to an array type than to a scalar type, which would suggest the second solution.
* Second solution would require many casts to E rather than a single cast to E[], which is why the first solution is used more commonly

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
