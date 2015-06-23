#New Convention for Android (Deprecated)

##Application
```
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.startWith(this);
    }
}
```

##RealmDatabase

####Default Database
```Realm.getDatabase()``` or ```Realm.getDatabase(DefaultDatabase.class)``` to retrieve default RealmDatabase.

####Custom Database
```
// RealmDatabase are abstract class
public class SecondaryDatabase extends RealmDatabase {

   public String getDatabaseName() {
      return "Secondary";
   }

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
```
Realm.getDatabase(SecondaryDatabase.class);
```

##RealmObject

####Fields
```
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
```
public class BaseObject extends RealmObject {

   @RealmPrimaryKey
   @RealmFieldName("id")
   private int id;

   private Date createdAt;
   private Date updatedAt;

   public int getId() { return this.id; }
   public Date getCreatedAt() { return this.createdAt; }
   public Date getUpdatedAt() { return this.updatedAt; }
}

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
```
User user = new User();
user.setId(1);
user.setCreatedAt(new Date());
user.setUpdatedAt(new Date());
user.setEmail("contact@thefinestartist.com");
user.setFullname("Leonardo Taehwan Kim");
```

####Create RealmObject
```
User user;
Pet pet;
RealmList<Pet> pets;

user.createInBackground();
user.createInBackground(new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

user.createInBackground(SecondaryDatabase.class);
user.createInBackground(SecondaryDatabase.class, new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

pets.createInBackground();
pets.createInBackground(new OnRealmListUpdatedListener<Pet>() {
   public void onUpdated(RealmList<Pet> pets, RealmUpdateError error) {}
});

Realm.getDatabase().createAllInBackground(user, pet, pets, new OnRealmDatbaseUpdatedListener() {
   public void onUpdated(RealmDatabaseError error);
});
```

####Update RealmObject
```
User user;
Pet pet;
RealmList<Pet> pets;

user.updateInBackground();
user.updateInBackground(new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

user.updateInBackground(SecondaryDatabase.class);
user.updateInBackground(SecondaryDatabase.class, new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

pets.updateInBackground();
pets.updateInBackground(new OnRealmListUpdatedListener<Pet>() {
   public void onUpdated(RealmList<Pet> pets, RealmUpdateError error) {}
});

Realm.getDatabase().updateAllInBackground(user, pet, pets, new OnRealmDatbaseUpdatedListener() {
   public void onUpdated(RealmDatabaseError error);
});
```

####CreateOrUpdate RealmObject
```
User user;
Pet pet;
RealmList<Pet> pets;

user.createOrUpdateInBackground();
user.createOrUpdateInBackground(new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

user.createOrUpdateInBackground(SecondaryDatabase.class);
user.createOrUpdateInBackground(SecondaryDatabase.class, new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(User user, RealmUpdateError error) {}
});

pets.createOrUpdateInBackground();
pets.createOrUpdateInBackground(new OnRealmListUpdatedListener<Pet>() {
   public void onUpdated(RealmList<Pet> pets, RealmUpdateError error) {}
});

Realm.getDatabase().updateAllInBackground(user, pet, pets, new OnRealmDatbaseUpdatedListener() {
   public void onUpdated(RealmDatabaseError error);
});
```

##RealmQuery
**RealmQuery can't be modified after it's build** (Mainly because of RealmObserver)
```
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
query.findFirstInBackground(new OnRealmObjectFoundListener<User>() {
   public void onFound(User user, RealmQueryError error) {}
});

RealmList<User> friends = query.findAll();
query.findAllInBackground(new OnRealmListFoundListener<User>() {
   public void onFound(RealmList<User> friends, RealmQueryError error) {}
});

// Paging
RealmList<User> friends = query.findSome(10); // Find maximum 10 users
RealmList<User> friends = query.findSome(10, 30); // Find maximum 10 users skipping first 30 users
query.findSomeInBackground(10, new OnRealmListFoundListener<User>() {
   public void onFound(RealmList<User> friends, RealmQueryError error) {}
});
query.findSomeInBackground(10, 30, new OnRealmListFoundListener<User>() {
   public void onFound(RealmList<User> friends, RealmQueryError error) {}
});
```

##RealmObserver
```
RealmQuery query = queryBuilder.build();
RealmObserver observer = new RealmObserver(query, new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(RealmQuery query, User user, RealmUpdateError error) {}
});

User user = query.findFirst();
RealmObserver observer = new RealmObserver(user, new OnRealmObjectUpdatedListener<User>() {
   public void onUpdated(RealmQuery query, User user, RealmUpdateError error) {}
});

RealmObserver observer = new RealmObserver(query, new OnRealmListUpdatedListener<User>() {
   public void onUpdated(RealmQuery query, RealmList<User> users, RealmUpdateError error) {}
});

// This would have different results from the upper RealmObserver
RealmList<User> friends = query.findAll();
RealmObserver observer = new RealmObserver(friends, new OnRealmListUpdatedListener<User>() {
   public void onUpdated(RealmQuery query, RealmList<User> users, RealmUpdateError error) {}
});
```

##Gson & Json Support
```
User user = User.fromJson();
User user = User.fromGson();
User user = User.fromJsonString();
user.toJson();
user.toGson();
user.toJsonString();

OldUser oldUser = new OldUser();
User user = User.fromObject(oldUser);
```

##Migration
```
// Auto Migration
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.startWith(this);
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
