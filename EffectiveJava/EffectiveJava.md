##Effective Java

####Use static factory method instead of constructor if you can

Pros
  1. Meaningful name for each constructor
  ```
  BigInteger.probablePrime()
  ```
  2. No need to create object every time if it's unnecessary
    * Choose to use cached object or create a new one
  3. Possible to return subclass object **(NEED REVIEW)**
    * i.e) http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Collection.java#Collection
  4. Easy to create parameterized type object
  ```
  public static <K, V> HashMap<K, V> newInstance() {
    return new HashMap<K, V>();
  }

  Map<String, List<String>> m = HashMap.newInstance();
  ```

Cons
  1. Impossible to make subclass if a class is consist of static factory method without any public or protected constructor
  2. Hard to distinguish between static factory method and static method

Naming Convention
```
valueOf()
of()
getInstance()
newInstance()
getType()
newType()
```

Consider to make static factory method for each class because it has lots of advantages.

---
####Consider to use builder pattern if there is too many fields in constructor
Telescoping Constructor Pattern <=> Builder Pattern

[Telescoping Constructor Pattern](http://www.captaindebug.com/2011/05/telescoping-constructor-antipattern.html#.VV1RdVmeDRY)
```
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
```
[Builder Pattern](http://en.wikipedia.org/wiki/Builder_pattern)
```
class Car is
  Can have GPS, trip computer and various numbers of seats. Can be a city car, a sports car, or a cabriolet.

class CarBuilder is
  method getResult() is
      output:  a Car with the right options
    Construct and return the car.

  method setSeats(number) is
      input:  the number of seats the car may have.
    Tell the builder the number of seats.

  method setCityCar() is
    Make the builder remember that the car is a city car.

  method setCabriolet() is
    Make the builder remember that the car is a cabriolet.

  method setSportsCar() is
    Make the builder remember that the car is a sports car.

  method setTripComputer() is
    Make the builder remember that the car has a trip computer.

  method unsetTripComputer() is
    Make the builder remember that the car does not have a trip computer.

  method setGPS() is
    Make the builder remember that the car has a global positioning system.

  method unsetGPS() is
    Make the builder remember that the car does not have a global positioning system.

Construct a CarBuilder called carBuilder
carBuilder.setSeats(2)
carBuilder.setSportsCar()
carBuilder.setTripComputer()
carBuilder.unsetGPS()
car := carBuilder.getResult()
```
