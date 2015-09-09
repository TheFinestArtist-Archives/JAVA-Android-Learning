# Eliminate obsolete object references

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Garbage-collected language can easily lead to the impression that you don’t have to think about memory management, but this isn’t quite true.

Unintentional Object Retention Example
<pre class="prettyprint">
// Can you spot the "memory leak"?
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

      // memory leak
      return elements[--size];

      // fix memory leak
      // Object result = elements[size];
      // elements[size] = null;
      // return result;
   }

   /**
   * Ensure space for at least one more element, roughly
   * doubling the capacity each time the array needs to grow.
   */
   private void ensureCapacity() {
      if (elements.length == size)
         elements = Arrays.copyOf(elements, 2 * size + 1);
   }
}
</pre>

* Common source of memory leak
   * Cache
   * Listeners and Callbacks
* Use WeakReference to avoid memory leak
* Typically discovered by
   * careful code inspection
   * aid of a debugging tool known as a "Heap Profiler"

<pre class="prettyprint">
// http://www.javalobby.org/java/forums/t19468.html
// @author Santhosh Kumar T - santhosh@in.fiorano.com
public class WeakPropertyChangeListener implements PropertyChangeListener{
    WeakReference listenerRef;
    Object src;

    public WeakPropertyChangeListener(PropertyChangeListener listener, Object src){
        listenerRef = new WeakReference(listener);
        this.src = src;
    }

    public void propertyChange(PropertyChangeEvent evt){
        PropertyChangeListener listener = (PropertyChangeListener)listenerRef.get();
        if(listener==null){
            removeListener();
        }else
            listener.propertyChange(evt);
    }

    private void removeListener(){
        try{
            Method method = src.getClass().getMethod("removePropertyChangeListener"
                    , new Class[] {PropertyChangeListener.class});
            method.invoke(src, new Object[]{ this });
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
