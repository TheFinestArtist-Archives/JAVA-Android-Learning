RoyalExport.toEmail(Class<? extends RoyalDatabase>... clazzes);
RoyalExport.toEmail(String email, Class<? extends RoyalDatabase>... clazzes);
RoyalExport.toEmail(String email, Intent intent, Class<? extends RoyalDatabase>... clazzes);

RoyalExport.toEmail(RealmConfiguration... configurations);
RoyalExport.toEmail(String email, RealmConfiguration... configurations);
RoyalExport.toEmail(String email, Intent intent, RealmConfiguration... configurations);

RoyalExport.toEmail(Realm... realms);
RoyalExport.toEmail(String email, Realm... realms);
RoyalExport.toEmail(String email, Intent intent, Realm... realms);

RoyalExport.toEmailAsRawFile();
RoyalExport.toEmailAsRawFile(String email);
RoyalExport.toEmailAsRawFile(String email, Intent intent);

RoyalExport.toExternalStorage(Class<? extends RoyalDatabase>... clazzes)
RoyalExport.toExternalStorage(RealmConfiguration... configurations);
RoyalExport.toExternalStorage(Realm... realms);
RoyalExport.toExternalStorageAsRawFile();
