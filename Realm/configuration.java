public class App extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Royal.joinWith(this);
      Royal.addDatabase(new SecondaryDatabase());
   }
}

RealmConfiguration configuration = Royal.getConfigurationOf(SecondaryDatabase.class);
