# Avoid float and double if exact answers are required

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* The float and double types are particularly ill-suited for monetary calculations
* Use BigDecimal, int, or long for monetary calculations

Using <code id="inline">double</code> and <code id="inline">float</code>
<pre class="prettyprint">
// Broken - uses floating point for monetary calculation!
public static void main(String[] args) {
   double funds = 1.00;
   int itemsBought = 0;
   for (double price = .10; funds &gt;= price; price += .10) {
      funds -= price;
      itemsBought++;
   }
   System.out.println(itemsBought + " items bought.");
   System.out.println("Change: $" + funds); // $0.3999999999999999
}
</pre>

Using <code id="inline">BigDecimal</code>
<pre class="prettyprint">
public static void main(String[] args) {
   final BigDecimal TEN_CENTS = new BigDecimal( ".10");
   int itemsBought = 0;
   BigDecimal funds = new BigDecimal("1.00");
   for (BigDecimal price = TEN_CENTS; funds.compareTo(price) &gt;= 0; price = price.add(TEN_CENTS)) {
      itemsBought++;
      funds = funds.subtract(price);
   }
   System.out.println(itemsBought + " items bought.");
   System.out.println("Money left over: $" + funds); // $0.00
}
</pre>

Using <code id="inline">int</code>
<pre class="prettyprint">
public static void main(String[] args) {
   int itemsBought = 0;
   int funds = 100;
   for (int price = 10; funds &gt;= price; price += 10) {
      itemsBought++;
      funds -= price;
   }
   System.out.println(itemsBought + " items bought.");
   System.out.println("Money left over: "+ funds + " cents"); // 0
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
