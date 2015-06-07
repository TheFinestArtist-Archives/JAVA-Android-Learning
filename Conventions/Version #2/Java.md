#Convention for Android

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
Realm.getDatabase();
Realm.getDatabase(DefaultDatabase.class);
```

####Custom Database
```java
// RealmDatabase are abstract class
public class SecondaryDatabase extends RealmDatabase {

   public String getFileName() {
      return "secondary";
   }

   // Cached database will only use memory (not using file system)
   // Cached database will automatically deleted or garbage collected whenever Application is removed from memory
   public boolean forCache() {
      realm false;
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
List<? extends RealmObject>
```

####Models
```java
public class BaseObject extends RealmObject {

   @RealmPrimaryKey
   @RealmFieldName("_id")
   private int id;

   private Date createdAt;
   private Date updatedAt;

   public int getId() { return this.id; }
   public Date getCreatedAt() { return this.createdAt; }
   public Date getUpdatedAt() { return this.updatedAt; }
}

@RealmClassName("_User")
public class User extends BaseObject {

   @RealmUnique
   private String email;

   @RealmIndex
   private String fullname;

   @RealmIgnore
   private String fullnameUpper;

   // Working On
   private static final String VALIDATION_REGEX_URL = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
   @RealmValidation(VALIDATION_REGEX_URL)
   private String profileUrl;

   // Working On
   @RealmUnique
   @RealmValidation(5, 20)
   private String username;

   private Settings settings;

   private List<Pet> pets;
}

public class Settings extends RealmObject {

   @RelamDefault(true)
   private boolean isNotificationOn;

   private List<Payment> payments;
}

public class Payment extends BaseObject {

   private String cardType;
   private String cardNumber;
   private String cardHolderName;
   private int expiredYear;
   private int expiredMonth;
   private int cvc;
}

public class Pet extends BaseObject {

   private String name;
   private String type;

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
user.setId(1);
user.setCreatedAt(new Date());
user.setUpdatedAt(new Date());
user.setEmail("contact@thefinestartist.com");
user.setFullname("Leonardo Taehwan Kim");
```

####Save RealmObject
Basically, it create or update each object in Database.
```java
User user;
Pet pet;
List<Pet> pets;

user.saveInBackground();
user.saveInBackground(new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

user.saveInBackground(SecondaryDatabase.class);
user.saveInBackground(SecondaryDatabase.class, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

pets.saveInBackground();
pets.saveInBackground(new OnRealmUpdatedListener<List<Pet>>() {
   public void onUpdated(List<Pet> pets, RealmUpdateError error) {}
});

Realm.getDatabase().saveAllInBackground(user, pet, pets, new OnRealmUpdatedListener<List<RealmObject>>() {
   public void onUpdated(List<RealmObject> updates, RealmUpdateError error) {}
});
```

##RealmQuery
**RealmQuery can't be modified after it's build** (Mainly because of RealmObserver)
```java
RealmQuery.Builder queryBuilder = new RealmQuery.Builder()
                                                .from(SecondaryDatabase.class)
                                                .of(User.class)
                                                .include("settings", "pets")
                                                .includeDeeply("settings", "payments")
                                                .includeAll() // Try not to use this methods
                                                .includeAllDeeply() // Don't ever use this methods
                                                .whereEqualTo("playerName", "Dan Stemkoski")
                                                .whereNotEqualTo("playerName", "Michael Yabuti")
                                                .whereGreaterThan("playerAge", 18)
                                                .whereGreaterThanOrEqualTo("wins", 50)
                                                .whereLessThan("wins", 50)
                                                .whereLessThanOrEqualTo("wins", 50)
                                                .orderByAscending("score", "playerName")
                                                .orderByDescending("score", "playerName")
                                                .whereContainedIn("playerName", Arrays.asList({"Jonathan Walsh", "Dario Wunsch", "Shawn Simon"}))
                                                .whereExists("score")
                                                .whereDoesNotExist("score");

RealmQuery query = queryBuilder.build();

User user = query.findFirst();
query.findFirstInBackground(new OnRealmFindListener<User>() {
   public void onFound(User user, RealmQueryError error) {}
});

List<User> friends = query.findAll();
query.findAllInBackground(new OnRealmFindListener<List<User>>() {
   public void onFound(List<User> friends, RealmQueryError error) {}
});

// Paging
List<User> friends = query.findSome(10); // Find maximum 10 users
List<User> friends = query.findSome(10, 30); // Find maximum 10 users skipping first 30 users
query.findSomeInBackground(10, new OnRealmFindListener<User>() {
   public void onFound(List<User> friends, RealmQueryError error) {}
});
query.findSomeInBackground(10, 30, new OnRealmFindListener<List<User>>() {
   public void onFound(List<User> friends, RealmQueryError error) {}
});
```

##RealmObserver
```java
RealmQuery query = queryBuilder.build();
RealmObserver observer = new RealmObserver(query, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

User user = query.findFirst();
RealmObserver observer = new RealmObserver(user, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

RealmObserver observer = new RealmObserver(query, new OnRealmUpdatedListener<List<User>>() {
   public void onUpdated(List<User> users, RealmUpdateError error) {}
});

// This would have different results from the upper RealmObserver
List<User> friends = query.findAll();
RealmObserver observer = new RealmObserver(friends, new OnRealmUpdatedListener<List<User>>() {
   public void onUpdated(List<User> users, RealmUpdateError error) {}
});
```

##Gson & Json Support
```java
User user = User.fromJsonString();
User user = User.fromJson();
User user = User.fromGson();
user.toJsonString();
user.toJson();
user.toGson();

OldUser oldUser = new OldUser();
User user = User.fromObject(oldUser);
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
Website  : https://www.thefinestartist.com
```
