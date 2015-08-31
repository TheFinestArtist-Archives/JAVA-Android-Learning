RealmConfiguration config1 = new RealmConfiguration.Builder(context)
  .name("myrealm1.realm")
  .encryptionKey(getKey1())
  .schemaVersion(1)
  .setModules(new MySchemaModule1())
  .migration(new MyMigration1())
  .build();

RealmConfiguration config2 = new RealmConfiguration.Builder(context)
 .name("myrealm2.realm")
 .encryptionKey(getKey2())
 .schemaVersion(2)
 .setModules(new MySchemaModule2())
 .migration(new MyMigration2())
 .build();
