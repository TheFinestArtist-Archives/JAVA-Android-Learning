# Avoid strings where other types are more appropriate

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* Strings are poor substitutes for other value types
   * When a piece of data comes into a program from a file, from the network, or from keyboard input, it should be translated into the appropriate type (int, float, boolean)
* Strings are poor substitutes for enum types
* Strings are poor substitutes for aggregate types
   <pre class="prettyprint">
   // Inappropriate use of string as aggregate type
   String compoundKey = className + "#" + i.next();
   </pre>
   
   * To access individual fields, you have to parse the string, which is slow, tedious, and error-prone
* Strings are poor substitutes for capabilities
   <pre class="prettyprint">
   // Broken - inappropriate use of string as capability!
   public class ThreadLocal {
      private ThreadLocal() { } // Noninstantiable
      // Sets the current thread's value for the named variable.
      public static void set(String key, Object value);
      // Returns the current thread's value for the named variable.
      public static Object get(String key);
   }
   </pre>

* String keys represent a shared glo- bal namespace for thread-local variables. In order for the approach to work, the client-provided string keys have to be unique
   <pre class="prettyprint">
   public final class ThreadLocal&lt;T&gt; {
      public ThreadLocal() { }
      public void set(T value);
      public T get();
   }
   </pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
