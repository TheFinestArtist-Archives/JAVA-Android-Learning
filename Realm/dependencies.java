dependencies {
   compile 'com.thefinestartist:royal:0.82.0.6'
}

public class App extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Royal.joinWith(this);
   }
}
