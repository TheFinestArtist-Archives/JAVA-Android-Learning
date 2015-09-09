# Prefer annotations to naming patterns

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Disadvantage of naming patterns
1. Typographical errors may result in silent failures
2. There is no way to ensure that they are used only on appropriate program elements
3. They provide no good way to associate parameter values with program elements

## Annotation
Such annotations on annotation type declarations are known as meta-annotations  

* <code id="inline">@Retention(RetentionPolicy.RUNTIME)</code> meta-annotation indicates that Test annotations should be retained at runtime
* <code id="inline">@Target(ElementType.METHOD)</code> meta-annotation indicates that the Test annotation is legal only on method declarations

<pre class="prettyprint">
public enum RetentionPolicy {
   SOURCE,
   CLASS,
   RUNTIME
}

public enum ElementType {
   TYPE,
   FIELD,
   METHOD,
   PARAMETER,
   CONSTRUCTOR,
   LOCAL_VARIABLE,
   ANNOTATION_TYPE,
   PACKAGE
}
</pre>

**Marker annotation**
<pre class="prettyprint">
// Marker annotation type declaration
import java.lang.annotation.*;

/**
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {}

// Program containing marker annotations
public class Sample {
   @Test public static void m1() { } // Test should pass public static void m2() { }
   @Test public static void m3() { // Test Should fail
      throw new RuntimeException("Boom");
   }
   public static void m4() { }
   @Test public void m5() { } // INVALID USE: nonstatic method public static void m6() { }
   @Test public static void m7() { // Test should fail
      throw new RuntimeException("Crash");
   }
   public static void m8() { }
}

// Program to process marker annotations
import java.lang.reflect.*;
public class RunTests {
   public static void main(String[] args) throws Exception {
      int tests = 0;
      int passed = 0;
      Class testClass = Class.forName(args[0]);

      for (Method m : testClass.getDeclaredMethods()) {
         if (m.isAnnotationPresent(Test.class)) {
            tests++;
            try {
               m.invoke(null);
               passed++;
            } catch (InvocationTargetException wrappedExc) {
               Throwable exc = wrappedExc.getCause();
               System.out.println(m + " failed: " + exc);
            } catch (Exception exc) {
               System.out.println("INVALID @Test: " + m);
            }
         }
      }
      System.out.printf("Passed: %d, Failed: %d%n",
      passed, tests - passed);
   }
}
</pre>

**Annotation type with a parameter**
<pre class="prettyprint">
// Annotation type with a parameter
import java.lang.annotation.*;
/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class&lt;? extends Exception&gt; value();
}

// Program containing annotations with a parameter
public class Sample2 {
   @ExceptionTest(ArithmeticException.class)
   public static void m1() {  // Test should pass
      int i = 0;
      i = i / i;
   }
   @ExceptionTest(ArithmeticException.class)
   public static void m2() {  // Should fail (wrong exception)
      int[] a = new int[0];
      int i = a[1];
   }
   @ExceptionTest(ArithmeticException.class)
   public static void m3() { }  // Should fail (no exception)
}

if (m.isAnnotationPresent(ExceptionTest.class)) {
   tests++;
   try {
      m.invoke(null);
      System.out.printf("Test %s failed: no exception%n", m);
   } catch (InvocationTargetException wrappedEx) {
      Throwable exc = wrappedEx.getCause();
      Class&lt;? extends Exception&gt; excType = m.getAnnotation(ExceptionTest.class).value();
      if (excType.isInstance(exc)) {
         passed++;
      } else {
         System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
      }
   } catch (Exception exc) {
      System.out.println("INVALID @Test: " + m);
   }
}
</pre>

**Annotation type with an array parameter**
<pre class="prettyprint">
// Annotation type with an array parameter
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
   Class&lt;? extends Exception&gt;[] value();
}

// Code containing an annotation with an array parameter
@ExceptionTest({ IndexOutOfBoundsException.class,
                 NullPointerException.class })
public static void doublyBad() {
   List&lt;String&gt; list = new ArrayList&lt;String&gt;();
   // The spec permits this method to throw either
   // IndexOutOfBoundsException or NullPointerException
   list.addAll(5, null);
}

if (m.isAnnotationPresent(ExceptionTest.class)) {
   tests++;
   try {
      m.invoke(null);
      System.out.printf("Test %s failed: no exception%n", m);
   } catch (Throwable wrappedExc) {
      Throwable exc = wrappedExc.getCause(); Class&lt;? extends Exception&gt;[] excTypes = m.getAnnotation(ExceptionTest.class).value();
      int oldPassed = passed;
      for (Class&lt;? extends Exception&gt; excType : excTypes) {
         if (excType.isInstance(exc)) {
            passed++;
            break;
         }
      }
      if (passed == oldPassed)
         System.out.printf("Test %s failed: %s %n", m, exc);
   }
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
