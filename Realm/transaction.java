// RealmList, RealmResults, RealmObject, List<? extends RealmObject>
RoyalTransaction.create(Class<? extends RoyalDatabase> clazz, Object... objects);
RoyalTransaction.create(RealmConfiguration configuration, Object... objects);
RoyalTransaction.create(Realm realm, Object... objects);

RoyalTransaction.save(Class<? extends RoyalDatabase> clazz, Object... objects);
RoyalTransaction.save(RealmConfiguration configuration, Object... objects);
RoyalTransaction.save(Realm realm, Object... objects);

RoyalTransaction.delete(Class<? extends RoyalDatabase> clazz, Object... objects);
RoyalTransaction.delete(RealmConfiguration configuration, Object... objects);
RoyalTransaction.delete(Realm realm, Object... objects);
