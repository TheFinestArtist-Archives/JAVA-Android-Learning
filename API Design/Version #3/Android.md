#Android API Design

####Realm is a service/company name.
####And Realm serves a mobile database called RealmDatabase.

##Application
```java
public class BaseApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Realm.initialize(this);
   }
}
```

##RealmDatabase

####Default Database
```java
Realm.getDefaultDatabase();
Realm.getDatabase(DefaultDatabase.class);
```

####Custom Database
```java
// RealmDatabase are abstract class
public class SecondaryDatabase extends RealmDatabase {

   @Override
   public String getFileName() {
      return "secondary"; // Realm always uses .realm as file extension
   }

   // Cached database will only use memory (not using file system)
   // Cached database will automatically deleted or garbage collected whenever Application is removed from memory
   @Override
   public boolean forCache() {
      realm false;
   }

   @Override
   public byte[] getEncryptionKey() {
      return null; // null for no encryption
   }
}
```

####getDatabase
```java
Realm.getDatabase(SecondaryDatabase.class);
```

##RealmObject

####Fields
```java
boolean
short
ìnt
long
float
double
String
Date
byte[]
RealmObject
RealmList<? extends RealmObject>
```

####RealmObject, RealmList
```java
public abstract class RealmObject {
   ...
}

public class RealmList<E extends RealmObject> extends RealmObject implements List<E> {
   ...
}
```

####Models
**Rule #1**  
Create every field in public and don't bother to create a `getter` and `setter`  
**Rule #2**  
Use `setter` only if the data type of the field and parameter is different (e.g. `setDate(String date)`)  

**Why?**  
A model class will never be a library class. (No need to follow java conventions.)  
A model class usually has no method or function which have high dependency on each field.
In other language, they usually make fields in public without `setter` and `getter`.  
Easy in integrating Gson or other mapping libraries.

```java
/**
 * Annotations
 *
 * @RealmClassName
 * @RealmFieldName
 *
 * @RealmPrimaryKey
 * @RealmUnique
 * @RealmIndex
 * @RealmIgnore
 *
 * @RelamDefault
 * @RealmValidation
 */

public class BaseObject extends RealmObject {

   @RealmPrimaryKey
   @RealmFieldName("_id")
   public int id;

   public Date createdAt;
   public Date updatedAt;
}

@RealmClassName("_User")
public class User extends BaseObject {

   @RealmUnique
   public String email;

   @RealmIndex
   private String fullname;

   public String getFullname() {
      return this.fullname;
   }

   public void setFullname(@Nonnull String fullname) {
      this.fullname = fullname;
      this.fullnameUpper = fullname.toUpperCase();
   }

   @RealmIgnore
   private String fullnameUpper;

   public String getFullnameUpper() {
      return this.fullnameUpper;
   }

   private static final String VALIDATION_REGEX_URL = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
   @RealmValidation(
      regex = VALIDATION_REGEX_URL
   )
   public String profileUrl;

   @RealmUnique
   @RealmValidation(
      minLength = 5,
      maxLength = 20
   )
   public String username;

   public Settings settings;

   public RealmList<Pet> pets;
}

public class Settings extends RealmObject {

   @RelamDefault(true)
   public boolean isNotificationOn;

   public RealmList<Payment> payments;
}

public class Payment extends BaseObject {
   public String cardType;
   public String cardNumber;
   public String cardHolderName;
   public int expiredYear;
   public int expiredMonth;
   public int cvc;
}

// Using with Enum
public class Pet extends BaseObject {

   public String name;
   private String type; // This field can only be accessed by setter and getter for safety and usability

   public PetType getType() {
      return PetType.fromAttribute(this.type);
   }

   public setType(PetType petType) {
       this.type = petType.toAttribute();
   }

   public enum PetType {
      GIRL("girl"),
      DOG("dog"),
      CAT("cat");

      private String attribute;

      PetType(String attribute) {
        this.attribute = attribute;
      }

      public String toAttribute() {
         return this.attribute;
      }

      public static PetType fromAttribute(String attribute) {
         for (PetType petType : values())
            if (petType.toAttribute().equals(attribute))
               return petType.toAttribute();

         return null;
      }
   }
}
```

####Construct RealmObject
```java
User user = new User();
user.id = 1;
user.createdAt = new Date();
user.updatedAt = new Date();
user.email = "contact@thefinestartist.com";
user.setFullname("Leonardo Taehwan Kim");
```

####Save RealmObject
```java
public abstract class RealmObject {
   public void save() { ... }
   public void save(Class<? extends RealmDatabase> clazz) { ... }
   public void save(RealmTransaction transaction) { ... }
   public void save(Class<? extends RealmDatabase> clazz, RealmTransaction transaction) { ... }

   public void saveInBackground() { ... }
   public void saveInBackground(Class<? extends RealmDatabase> clazz) { ... }
   public void saveInBackground(RealmTransaction transaction) { ... }
   public void saveInBackground(OnRealmUpdatedListener listener) { ... }
   public void saveInBackground(Class<? extends RealmDatabase> clazz, RealmTransaction transaction) { ... }
   public void saveInBackground(Class<? extends RealmDatabase> clazz, OnRealmUpdatedListener listener) { ... }
   public void saveInBackground(RealmTransaction transaction, OnRealmUpdatedListener listener) { ... }
   public void saveInBackground(Class<? extends RealmDatabase> clazz, RealmTransaction transaction, OnRealmUpdatedListener listener) { ... }
}

public class RealmList<E extends RealmObject> extends RealmObject implements List<E> {
   public RealmList(RealmObject... objects) {
      ...
   }
}
```

Basically, saving does createOrUpdate.
```java
User user;
Pet pet;
RealmList<Pet> pets;

user.save();
user.saveInBackground();
user.saveInBackground(new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

user.save(SecondaryDatabase.class);
user.saveInBackground(SecondaryDatabase.class);
user.saveInBackground(SecondaryDatabase.class, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

pets.save();
pets.saveInBackground();
pets.saveInBackground(new OnRealmUpdatedListener<RealmList<Pet>>() {
   public void onUpdated(RealmList<Pet> pets, RealmException exception) {}
});

// Saving Multiple RealmObjects and RealmList at once
new RealmList<RealmObject>(user, pet, pets).save();
new RealmList<RealmObject>(user, pet, pets).saveInBackground(new OnRealmUpdatedListener<RealmList<RealmObject>>() {
   public void onUpdated(RealmList<RealmObject> updates, RealmException exception) {}
});

// You can also set whether to create or update or createOrUpdate to make transaction faster
user.save(RealmTransaction.CREATE);
user.save(RealmTransaction.UPDATE);
user.save(RealmTransaction.CREATE_OR_UPDATE); // default option
```

##RealmQuery
**RealmQuery can't be modified after it's build** (Mainly because of RealmObserver)
```java
RealmQuery.Builder queryBuilder = new RealmQuery.Builder()
   .from(SecondaryDatabase.class)
   .of(User.class)
   .include("settings", "pets")
   // .includeDeeply("settings", "payments")
   .includeAll() // Try not to use this methods
   // .includeAllDeeply() // Don't ever use this methods
   .whereEqualTo("playerName", "Dan Stemkoski")
   .whereEqualTo("playerName", Arrays.asList({"Jonathan Walsh", "Dario Wunsch", "Shawn Simon"})
   .whereNotEqualTo("playerName", "Michael Yabuti")
   .whereNotEqualTo("playerName", Arrays.asList({"Jonathan Walsh", "Dario Wunsch", "Shawn Simon"})
   .whereGreaterThan("playerAge", 18)
   .whereGreaterThanOrEqualTo("wins", 50)
   .whereLessThan("wins", 50)
   .whereLessThanOrEqualTo("wins", 50)
   .orderByAscending("score", "playerName")
   .orderByDescending("score", "playerName")
   .whereExists("score")
   .whereDoesNotExist("score");

RealmQuery query = queryBuilder.build();

User user = query.findFirst();
query.findFirstInBackground(new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

RealmList<User> friends = query.findAll();
query.findAllInBackground(new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> friends, RealmException exception) {}
});

// Paging
RealmList<User> friends = query.findSome(10); // Find maximum 10 users
RealmList<User> friends = query.findSome(10, 30); // Find maximum 10 users skipping first 30 users
query.findSomeInBackground(10, new OnRealmUpdatedListener<User>() {
   public void onUpdated(RealmList<User> friends, RealmException exception) {}
});
query.findSomeInBackground(10, 30, new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> friends, RealmException exception) {}
});
```

##RealmObserver
```java
RealmQuery query = queryBuilder.build();
RealmObserver<User> observer = new RealmObserver<>(query);
observer.addOnRealmUpdatedListener(new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

User user = query.findFirst();
RealmObserver<User> observer = new RealmObserver(user);
observer.addOnRealmUpdatedListener(new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

RealmObserver<RealmList<User>> observer = new RealmObserver(query);
observer.addOnRealmUpdatedListener(new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> users, RealmException exception) {}
});

// This would have different results from the upper RealmObserver
RealmList<User> friends = query.findAll();
RealmObserver<RealmList<User>> observer = new RealmObserver(friends);
observer.addOnRealmUpdatedListener(new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> users, RealmException exception) {}
});
```

##OnRealmUpdatedListener
One single listener for all. The `onUpdated` method will be run in the UI thread.
```java
public interface OnRealmUpdatedListener<E extends RealmObject> {
   void onUpdated(E baseObject, RealmException exception);
}

public class RealmException extends exception {}
```

####Usage
```java
public class RealmAdapter extends BaseAdapter implements OnRealmUpdatedListener<RealmList<Post>> {

   RealmList<Post> posts;

   public RealmAdapter() {}

   @Override
   public void onUpdated(RealmList<Post> posts, RealmException exception) {
      this.posts = posts;
      notifyDataSetChanged();
   }
}

RealmAdapter adapter = new RealmAdapter();

Post post = new Post();
new RealmList<Post>(post).saveInBackground(adapter);

RealmQuery query = new RealmQuery.Builder().of(Post.class).build();
query.findAllInBackground(adapter);

RealmObserver observer = new RealmObserver(query, adapter);
```

##Gson & Json Support
```java
User user = User.fromJson(String string);
User user = User.fromJson(JsonObject object);

user.toJsonString();
user.toJsonObject();
```

##Migration
```java
// Auto Migration
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.initialize(this);
        Realm.setAutoMigration();
        Realm.setAutoMigration(SecondaryDatabase.class);
    }
}
```

##More


##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
```
