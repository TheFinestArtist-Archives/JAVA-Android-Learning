#ORM
An ORM (Object-Relational Mapping) is a tool that lets you query and manipulate data from a database using an object paradigm.
It's a completely ordinary library written in your language that encapsulates the code needed to manipulate the data, so you don't use SQL anymore, but directly an object of your language.

###Pros
Using an ORM save a lot of time because

* DRY : You write your data model in only one place, it's easier to update, maintain and reuse the code.
* A lot of stuff is done automatically, from the database handling to I18N.
* It forces you to write MVC code, and in the end your app is cleaner.
* You don't have to write poorly formed SQL (most Web programmers really suck at it, because SQL is treated like a "sub" language whereas it's a very powerful and complex one)
* Sanitizing, using prepared statements or transactions are as easy as calling a method.

Using an ORM is more flexible because

* It fits in your natural way of coding (it's your language !)
* It abstracts the DB system, so you can change it whenever you want.
* The model is weakly bound to the rest of the app, so you can change it or use it anywhere else.
* It let you use OOP goodness like data inheritance without head ache.

###Cons
* You have to learn it, and they are not lightweight tools
* You have to set it up. Same problem.
* Performances are ok for usual queries, but a SQL master will always do better with his little hands for the big dirty works.
* It abstracts the DB. While it's ok if you know what's happening behind the scene, it's a trap for the noobs that can write very greedy statements, like a heavy hit in a for loop...

##DAO
DATA ACCESS OBJECT (DAO) is a object/interface, which is used to access data from database of data storage.

**WHY WE USE DAO:** The Data Access Object Pattern, also known as the DAO pattern, abstracts the retrieval of data from a data resource such as a database. The concept is to "separate a data resource's client interface from its data access mechanism."

The problem with accessing data directly is that the source of the data can change. Consider, for example, that your application is deployed in an environment that accesses an Oracle database. Then it is subsequently deployed to an environment that uses Microsoft SQL Server. If your application uses stored procedures and database-specific code (such as generating a number sequence), how do you handle that in your application? You have two options:

 - Rewrite your application to use SQL Server instead of Oracle (or add conditional code to handle the differences), or
 - Create a layer inbetween your application logic and the data access


Its in all referred as **DAO Pattern**, It consist of following:

 - **Data Access Object Interface** - This interface *defines the standard operations* to be performed on a model object(s).
 - **Data Access Object concrete class** -This class implements above interface. This class is *responsible to get data from a datasource* which can be database / xml or any other storage mechanism.
 - **Model Object or Value Object** - This object is *simple POJO containing get/set methods* to store data retrieved using DAO class.


**This Example will makes things more clear:**

**1.Value Object:**
```java
public class Student {
   private String name;
   private int rollNo;

   Student(String name, int rollNo){
      this.name = name;
      this.rollNo = rollNo;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getRollNo() {
      return rollNo;
   }

   public void setRollNo(int rollNo) {
      this.rollNo = rollNo;
   }
}
```


**2.DAO Interface:**

```java
import java.util.List;

public interface StudentDao {
   /* defines standard operations to be performed on POJO*/
   public List<Student> getAllStudents();
   public Student getStudent(int rollNo);
   public void updateStudent(Student student);
   public void deleteStudent(Student student);
}
```

**3.DAO Concrete Class:**

```java
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

   //list is working as a database
   List<Student> students;

   public StudentDaoImpl(){
      students = new ArrayList<Student>();
      Student student1 = new Student("Robert",0);
      Student student2 = new Student("John",1);
      students.add(student1);
      students.add(student2);
   }
   @Override
   public void deleteStudent(Student student) {
      students.remove(student.getRollNo());
      System.out.println("Student: Roll No " + student.getRollNo()
      +", deleted from database");
   }

   //retrive list of students from the database
   @Override
   public List<Student> getAllStudents() {
      return students;
   }

   @Override
   public Student getStudent(int rollNo) {
      return students.get(rollNo);
   }

   @Override
   public void updateStudent(Student student) {
      students.get(student.getRollNo()).setName(student.getName());
      System.out.println("Student: Roll No " + student.getRollNo()
      +", updated in the database");
   }
}
```

**4.Main Class**
```java
public class DaoPatternDemo {
   public static void main(String[] args) {
      StudentDao studentDao = new StudentDaoImpl();

      //print all students
      for (Student student : studentDao.getAllStudents()) {
         System.out.println("Student: [RollNo : "
          +student.getRollNo()+", Name : "+student.getName()+" ]");
      }

      //update student
      Student student =studentDao.getAllStudents().get(0);
      student.setName("Michael");
      studentDao.updateStudent(student);

      //get the student
      studentDao.getStudent(0);
      System.out.println("Student: [RollNo : "
      +student.getRollNo()+", Name : "+student.getName()+" ]");
   }
}
```



I assume this things must have cleared your understanding of DAO up to certain extend.  

##Major ORM Solutions

###Speed
ORMLite < GreenDAO
SugarORM < Active Android < DB Flow

###ORMLite
OrmLite is a Java ORM with SQL databases support. It can be used anywhere Java is used, such as JDBC connections, Spring, and also Android. It makes heavy usage of annotations.

**Supporting Database**
```java
MySQL
Postgres
H2
SQLite
Derby
HSQLDB
Microsoft SQL Server
Netezza
ODBC
DB2
Oracle
```


**Objects**
```java
@DatabaseTable(tableName = "accounts")
public class Account {

   @DatabaseField(columnName = "name", id = true)
   private String name;
   @DatabaseField(columnName = "password", canBeNull = false)
   private String password;

   public Account() {
      // ORMLite needs a no-arg constructor
   }
   public Account(String name, String password) {
      this.name = name;
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
}
```

**Relations**
```java
// One to many
public class Game {
   @DatabaseField(columnName = "user", foreign = true)
   User user;
}

// Many to many
public class Book {
   @ForeignCollectionField(eager = false)
   ForeignCollection<Author> authors;
}
```

**Queries**
```java
Where<Account, String> where = queryBuilder.where();
where.or(
   where.and(
      where.eq(Account.NAME_FIELD_NAME, "foo"),
      where.eq(Account.PASSWORD_FIELD_NAME, "_secret")),
   where.and(
      where.eq(Account.NAME_FIELD_NAME, "bar"),
      where.eq(Account.PASSWORD_FIELD_NAME, "qwerty")));
```

**DAO**
```java
ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:h2:mem:account");
Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

// Create
Account account = new Account();
account.name = "Jim Coakley";
accountDao.create(account);

// Read
Account account = accountDao.queryForId(name);
if (account == null) {
   // account not found handling …
}

// Update
account.password = "_secret";
accountDao.update(account);

// Delete
accountDao.delete(account);

// Refresh
accountDao.refresh(account);
```

**Migrations**
```java
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
      // This allows you to adjust the various data to match the new version number.
	}
}
```

###GreenDAO

**Supporting Database**
`SQLite`

###Active Android
Much like other ORMs, ActiveAndroid helps you store and retrieve records from SQLite without writing SQL queries.
* No many to many relation supported

**Supporting Database**
`SQLite`

**Objects**
```java
@Table(name = "Items")
public class Item extends Model {
   // If name is omitted, then the field name is used.
   @Column(name = "Name")
   public String name;

   @Column(name = "Category")
   public Category category;

   public Item() {
      super();
   }

   public Item(String name, Category category) {
      super();
      this.name = name;
      this.category = category;
   }
}
```

**Relations**
```java
// One to Many
@Table(name = "Items")
public class Item extends Model {
    @Column(name = "Category")
    public Category category;
}

// Many to Many
public class Foo extends Model {
}
public class Bar extends Model {
}

public class FooBar extends Model {
    @Column(name = "foo", onDelete=ForeignKeyAction.CASCADE)
    public Foo foo;
    @Column(name = "bar" onDelete=ForeignKeyAction.CASCADE)
    public Bar bar;

    public List<Foo> foos() {
        return getMany(Foo.class, "FooBar");
    }
    public List<Bar> bars() {
        return getMany(Bar.class, "FooBar");
    }
}
```

**Queries**
```java
public static Item getRandom() {
    return new Select().from(Item.class).orderBy("RANDOM()").executeSingle();
}
```

**Migrations**
```xml
// manifest.xml
<meta-data android:name="AA_DB_NAME" android:value="Pickrand.db" />
<meta-data android:name="AA_DB_VERSION" android:value="5" />
```
```sql
// assets/migrations/<NewVersion>.sql
ALTER TABLE Items ADD COLUMN color INTEGER;
```


###DB Flow

**Supporting Database**
`SQLite`

###Parse
Parse has ORM inside the library which supports both local and server database. You can CRUD object and save it into local database or server.  
Since parse Android/iOS SDK doesn't support migration, Parse should be used like caching data to local database and make a week dependencies for local database than data from server.  
Parse suggests very fine API design for Developer and so it's very easy to use.

**Objects**  
There is two ways to create and object.

1. Simple way
   ```java
   ParseObject shield = new ParseObject("Armor");
   shield.put("displayName", "Wooden Shield");
   shield.put("fireproof", false);
   shield.put("rupees", 50);
   ```
2. Using subclasses
   ```java
   @ParseClassName("Armor")
   public class Armor extends ParseObject {
      setDisplayName(String);
      setFireproof(boolean);
      setRupees(int);
   }

   Armor shield = new Armor();
   shield.setDisplayName("Wooden Shield");
   shield.setFireproof(false);
   shield.setRupees(50);
   ```

**Relations**
```java
// One to many
ParseObject game = new ParseObject("Game");
game.put("createdBy", ParseUser.getCurrentUser());

// Many to many
ParseObject book = new ParseObject("Book");
ParseRelation<ParseObject> relation = book.getRelation("authors");
relation.add(authorOne);
relation.add(authorTwo);
relation.add(authorThree);
```


**Queries**
```java
ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
query.whereEqualTo("playerName", "Dan Stemkoski");
query.findInBackground(new FindCallback<ParseObject>() {
   public void done(List<ParseObject> scoreList, ParseException e) {
      if (e == null) {
         Log.d("score", "Retrieved " + scoreList.size() + " scores");
      } else {
         Log.d("score", "Error: " + e.getMessage());
      }
   }
});

// Skip the first 10 results
query.setSkip(10);
// Sorts the results in ascending order by the score field
query.orderByAscending("score");
// Sorts the results in descending order by the score field
query.orderByDescending("score");
// Sorts the results in ascending order by the score field if the previous sort keys are equal.
query.addAscendingOrder("score");
// Sorts the results in descending order by the score field if the previous sort keys are equal.
query.addDescendingOrder("score");
// Restricts to wins < 50
query.whereLessThan("wins", 50);
// Restricts to wins <= 50
query.whereLessThanOrEqualTo("wins", 50);
// Restricts to wins > 50
query.whereGreaterThan("wins", 50);
// Restricts to wins >= 50
query.whereGreaterThanOrEqualTo("wins", 50);
```

**Migrations**
No local migration supported.

###Firebase


##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
```
