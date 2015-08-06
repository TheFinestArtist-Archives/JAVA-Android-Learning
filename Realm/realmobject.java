public abstract class RealmObject {
   protected Row row;
   protected Realm realm;

   public void removeFromRealm() { /* ... */ }
   public boolean isValid() { /* ... */ }
   protected static Realm getRealm(RealmObject obj) { /* ... */ }
   protected static Row getRow(RealmObject obj) { /* ... */ }
}
