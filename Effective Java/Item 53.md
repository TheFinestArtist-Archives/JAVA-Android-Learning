# Prefer interfaces to reflection

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## The core reflection facility, java.lang.reflect
* Originally designed for component-based application builder tools
   * Class browsers, object inspectors, code analysis tools, and interpretive embedded systems
* Offers programmatic access to information about loaded classes
   * Given a Class object, you can obtain Constructor, Method, and Field instances representing the constructors, methods, and fields of the class represented by the Class instance.
   * These objects provide programmatic access to the class’s member names, field types, method signatures, and so on
* Constructor, Method, and Field instances let you manipulate their underlying counterparts reflectively: you can construct instances, invoke methods, and access fields of the underlying class by invoking methods on the Constructor, Method, and Field instances

## Defects of reflection
* You lose all the benefits of compile-time type checking
* The code required to perform reflective access is clumsy and verbose
* Performance suffers

## Rules
* Objects should not be accessed reflectively in normal applications at runtime
* You can obtain many of the benefits of reflection while incurring few of its costs by using it only in a very limited form
* Create instances reflectively and access them normally via their interface or superclass


<pre class="prettyprint">
// Reflective instantiation with interface access
public static void main(String[] args) {
   // Translate the class name into a Class object
   Class&lt;?&gt; cl = null;
   try {
      cl = Class.forName(args[0]);
   } catch(ClassNotFoundException e) {
      System.err.println("Class not found.");
      System.exit(1);
   }
   // Instantiate the class
   Set&lt;String&gt; s = null;
   try {
      s = (Set&lt;String&gt;) cl.newInstance();
   } catch(IllegalAccessException e) {
      System.err.println("Class not accessible.");
      System.exit(1);
   } catch(InstantiationException e) {
      System.err.println("Class not instantiable.");
      System.exit(1);
   }
   // Exercise the set
   s.addAll(Arrays.asList(args).subList(1, args.length));
   System.out.println(s);
}
</pre>

## Pros
* Easily be turned into a generic set tester that validates the specified Set implementation by aggressively manipulating one or more instances and checking that they obey the Set contract
* Easily be turned into a generic set performance analysis tool

## Cons
* Generate three runtime errors, all of which would have been compile-time errors if reflective instantiation were not used
* It takes twenty lines of tedious code to generate an instance of the class

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
