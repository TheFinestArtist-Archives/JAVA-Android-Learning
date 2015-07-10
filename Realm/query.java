// Fluent interface
RealmResults<User> result = realm.where(User.class)
                                 .sort("age");
                                 .beginGroup()
                                    .equalTo("name", "John")
                                    .or()
                                    .equalTo("name", "Peter")
                                 .endGroup()
                                 .findAll();

for (User user : result) {
   // do something...
}
