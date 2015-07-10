realm.beginTransaction();
User user = realm.createObject(User.class); // Create a new object
user.setName("John");
user.setEmail("john@corporation.com");
realm.commitTransaction();

User user = new User("John");
user.setEmail("john@corporation.com");
realm.beginTransaction();
User realmUser = realm.copyToRealm(user);  // Copy the object to Realm.
realm.commitTransaction();
