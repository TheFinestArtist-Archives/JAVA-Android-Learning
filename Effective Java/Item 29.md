# Consider typesafe heterogeneous containers

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* The idea is to parameterize the key instead of the container.
* When a class literal is passed among methods to communicate both compile-time and runtime type information, it is called a **type token**

## Typesafe heterogeneous container
<pre class="prettyprint">
// Typesafe heterogeneous container pattern - API
public class Favorites {
   public &lt;T&gt; void putFavorite(Class&lt;T&gt; type, T instance);
   public &lt;T&gt; T getFavorite(Class&lt;T&gt; type);
}

// Typesafe heterogeneous container pattern - client
public static void main(String[] args) {
   Favorites f = new Favorites();
   f.putFavorite(String.class, "Java");
   f.putFavorite(Integer.class, 0xcafebabe);
   f.putFavorite(Class.class, Favorites.class);
   String favoriteString = f.getFavorite(String.class);
   int favoriteInteger = f.getFavorite(Integer.class);
   Class&lt;?&gt; favoriteClass = f.getFavorite(Class.class);
   System.out.printf("%s %x %s%n", favoriteString,
   favoriteInteger, favoriteClass.getName());
}

// Typesafe heterogeneous container pattern - implementation
public class Favorites {
   private Map&lt;Class&lt;?&gt;, Object&gt; favorites = new HashMap&lt;Class&lt;?&gt;, Object&gt;();

   public &lt;T&gt; void putFavorite(Class&lt;T&gt; type, T instance) {
      if (type == null)
         throw new NullPointerException("Type is null");
      favorites.put(type, instance);
      // favorites.put(type, type.cast(instance));
   }

   public &lt;T&gt; T getFavorite(Class&lt;T&gt; type) {
      return type.cast(favorites.get(type));
   }
}
</pre>

**Subtle #1**
* Each Favorites instance is backed by a private Map&lt;Class&lt;?&gt;, Object&gt; called favorites
* Every key can have a different parameterized type

**Subtle #2**
* Value type of the favorites Map is simply Object
* Map does not guarantee the type relationship between keys and values

## cast method
The cast method is the dynamic analog of Java’s cast operator
</pre>
public class Class&lt;T&gt; {
   T cast(Object obj);
}
</pre>

* The type tokens used by Favorites are unbounded and sometimes you may need to limit the types that can be passed to a method
* The annotations API makes extensive use of bounded type tokens

<pre class="prettyprint">
public &lt;T extends Annotation&gt; T getAnnotation(Class&lt;T&gt; annotationType);

// Use of asSubclass to safely cast to a bounded type token
static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
   Class&lt;?&gt; annotationType = null; // Unbounded type token
   try {
      annotationType = Class.forName(annotationTypeName);
   } catch (Exception ex) {
      throw new IllegalArgumentException(ex);
   }
   return element.getAnnotation(annotationType.asSubclass(Annotation.class));
}
</pre>

## asSubclass Method
Class provides an instance method that performs this sort of cast safely (and dynamically). The method is called asSubclass, and it casts the Class object on which it’s called to represent a subclass of the class represented by its argument.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
