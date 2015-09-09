# Favor static member classes over nonstatic

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Four kinds of nested classes

#### static member classes
Ordinary class that happens to be declared inside another class and has access to all of the enclosing class’s members, even those declared private  
i.e. One common use of a static member class is as a public helper class, useful only in conjunction with its outer class

<pre class="prettyprint">
class Outer {
	static class Inner {
		void go() {
			System.out.println("Inner class reference is: " + this);
		}
	}
}

public class Test {
	public static void main(String[] args) {
		Outer.Inner n = new Outer.Inner();
		n.go();
	}
}
</pre>

#### nonstatic member classes
   * Each instance of a nonstatic member class is implicitly associated with an enclosing instance of its containing class
   * You can invoke methods on the enclosing instance or obtain a refer- ence to the enclosing instance using the qualified this construct
   * The association between a nonstatic member class instance and its enclosing instance is established when the former is created
   * The association takes up space in the nonstatic member class instance and adds time to its construction  
   i.e One common use of a nonstatic member class is to define an Adapter  

<pre class="prettyprint">
public class Outer {
   private int x = 100;

   public void makeInner() {
      Inner in = new Inner();
      in.seeOuter();
   }

   class Inner{
      public void seeOuter() {
         System.out.println("Outer x is " + x);
         System.out.println("Inner class reference is " + this);
         System.out.println("Outer class reference is " + Outer.this);
      }
   }

   public static void main(String [] args) {
      Outer o = new Outer();
      Inner i = o.new Inner();
      i.seeOuter();
   }
}
</pre>

#### anonymous classes
One common use of anonymous classes is to create function objects  

<pre class="prettyprint">
button.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e){
      comp.setText("Button has been clicked");
   }
});
</pre>

#### local classes
Local classes are the least frequently used of the four kinds of nested classes. A local class can be declared anywhere a local variable can be declared and obeys the same scoping rules

<pre class="prettyprint">
public class Outer {
	private String x = "outer";

	public void doStuff() {
		class MyInner {
			public void seeOuter() {
				System.out.println("x is " + x);
			}
		}

		MyInner i = new MyInner();
		i.seeOuter();
	}

	public static void main(String[] args) {
		Outer o = new Outer();
		o.doStuff();
	}
}

public class Outer {
	private static String x = "static outer";

	public static void doStuff() {
		class MyInner {
			public void seeOuter() {
				System.out.println("x is " + x);
			}
		}

		MyInner i = new MyInner();
		i.seeOuter();
	}

	public static void main(String[] args) {
		Outer.doStuff();
	}
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
