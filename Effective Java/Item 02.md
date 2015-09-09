# Consider a builder when faced with many constructor parameters

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Advantages
1. Possible to apply invariant
2. Possible to accept multiple varargs parameters
3. Possible to make multiple objects with one builder object

## Useful for class which
1. contains many fields
2. needs static factory methods
3. contains many optional fields

### Telescoping Constructor Pattern, Java Bean Pattern, Builder Pattern

**[Telescoping Constructor Pattern](http://www.captaindebug.com/2011/05/telescoping-constructor-antipattern.html#.VV1RdVmeDRY)**
<pre class="prettyprint">
public class FoodTelescopingDemo {

   private final int id;
   private final String name;
   private final int calories;
   private final int servingSize;
   private final int fat;
   private final String description;

   public FoodTelescopingDemo(int id, String name) {
      this(id, name, 0, 0, 0, "default description");
   }

   public FoodTelescopingDemo(int id, String name, int calories) {
      this(id, name, calories, 0, 0, "default description");
   }

   public FoodTelescopingDemo(int id, String name, int calories, int servingSize) {
      this(id, name, calories, servingSize, 0, "default description");
   }

   public FoodTelescopingDemo(int id, String name, int calories, int servingSize, int fat) {
      this(id, name, calories, servingSize, fat, "default description");
   }

   /**
   * Main Constructor - actually builds the object
   */
   public FoodTelescopingDemo(int id, String name, int calories, int servingSize, int fat,
      String description) {
      this.id = id;
      this.name = name;
      this.calories = calories;
      this.servingSize = servingSize;
      this.fat = fat;
      this.description = description;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public int getCalories() {
      return calories;
   }

   public int getServingSize() {
      return servingSize;
   }

   public int getFat() {
      return fat;
   }

   public String getDescription() {
      return description;
   }

}
</pre>

**[Builder Pattern](http://en.wikipedia.org/wiki/Builder_pattern)**
<pre class="prettyprint">
public class StreetMap {
	private final Point origin;
	private final Point destination;

	private final Color waterColor;
	private final Color landColor;
	private final Color highTrafficColor;
	private final Color mediumTrafficColor;
	private final Color lowTrafficColor;

	public static class Builder {
		// Required parameters
		private final Point origin;
		private final Point destination;

		// Optional parameters - initialize with default values
		private Color waterColor         = Color.BLUE;
		private Color landColor          = new Color(30, 30, 30);
		private Color highTrafficColor   = Color.RED;
		private Color mediumTrafficColor = Color.YELLOW;
		private Color lowTrafficColor    = Color.GREEN;

		public Builder(Point origin, Point destination) {
			this.origin      = origin;
			this.destination = destination;
		}

		public Builder waterColor(Color color) {
			waterColor = color;
			return this;
		}

		public Builder landColor(Color color) {
			landColor = color;
			return this;
		}

		public Builder highTrafficColor(Color color) {
			highTrafficColor = color;
			return this;
		}

		public Builder mediumTrafficColor(Color color) {
			mediumTrafficColor = color;
			return this;
		}

		public Builder lowTrafficColor(Color color) {
			lowTrafficColor = color;
			return this;
		}

		public StreetMap build() {
			return new StreetMap(this);
		}

	}

	private StreetMap(Builder builder) {
		// Required parameters
		origin      = builder.origin;
		destination = builder.destination;

		// Optional parameters
		waterColor         = builder.waterColor;
		landColor          = builder.landColor;
		highTrafficColor   = builder.highTrafficColor;
		mediumTrafficColor = builder.mediumTrafficColor;
		lowTrafficColor    = builder.lowTrafficColor;
	}

	public static void main(String args[]) {
		StreetMap map = new StreetMap.Builder(new Point(50, 50), new Point(100,
				100)).landColor(Color.GRAY).waterColor(Color.BLUE.brighter())
				.build();
	}
}
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
