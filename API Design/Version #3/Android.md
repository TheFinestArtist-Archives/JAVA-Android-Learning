#Android API Design

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
RealmList<? extends RealmObject>
```

####Models
```java
/**
 * Annotations
 * @RealmClassName
 * @RealmPrimaryKey
 * @RealmUnique
 * @RealmIndex
 * @RealmIgnore
 * @RealmValidation
 */

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

   private static final String VALIDATION_REGEX_URL = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
   @RealmValidation(
      regex = VALIDATION_REGEX_URL
   )
   private String profileUrl;

   @RealmUnique
   @RealmValidation(
      minLength = 5,
      maxLength = 20
   )
   private String username;

   private Settings settings;

   private RealmList<Pet> pets;
}

public class Settings extends RealmObject {

   @RelamDefault(true)
   private boolean isNotificationOn;

   private RealmList<Payment> payments;
}

public class Payment extends BaseObject {

   private String cardType;
   private String cardNumber;
   private String cardHolderName;
   private int expiredYear;
   private int expiredMonth;
   private int cvc;
}

// Using with Enum
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

public void save (Class<? extends RealmDatabase> clazz, RealmTransaction transaction, RealmBaseObject baseObject);
public void saveInBackground (Class<? extends RealmDatabase> clazz, RealmTransaction transaction, RealmBaseObject baseObject, OnRealmUpdatedListener listener);
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
RealmObserver observer = new RealmObserver(query, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

User user = query.findFirst();
RealmObserver observer = new RealmObserver(user, new OnRealmUpdatedListener<User>() {
   public void onUpdated(User user, RealmException exception) {}
});

RealmObserver observer = new RealmObserver(query, new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> users, RealmException exception) {}
});

// This would have different results from the upper RealmObserver
RealmList<User> friends = query.findAll();
RealmObserver observer = new RealmObserver(friends, new OnRealmUpdatedListener<RealmList<User>>() {
   public void onUpdated(RealmList<User> users, RealmException exception) {}
});
```

##OnRealmUpdatedListener
One single listener for all. The `onUpdated` method will be run in the UI thread.
```java
public interface OnRealmUpdatedListener<E extends RealmBaseObject> {
   void onUpdated(E baseObject, RealmException exception);
}

public class RealmException extends exception {}

public class RealmObject extends RealmBaseObject{}
public class RealmList<E extends RealmObject> extends RealmBaseObject implements List {}
```

####Usage
```java
public class RealmAdapter extends BaseAdapter implements OnRealmUpdatedListener<RealmList<Post>> {
   public RealmAdapter() {}
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
Website  : http://www.thefinestartist.com
```
