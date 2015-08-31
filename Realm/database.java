public class SecondaryDatabase extends RoyalDatabase {

   public String getFileName() { return "secondary"; }
   public boolean forCache() { return false; }
   public byte[] getEncryptionKey() { return null; }
   public int getVersion() { return 0; }
   public boolean shouldDeleteIfMigrationNeeded() { return false; }
   public Set<Object> getModules() {
      Set<Object> set = new HashSet<>();
      set.add(new SecondaryModule());
      return set;
   }
   @Override
   public long execute(Realm realm, long version) {
      return getVersion();
   }
}
