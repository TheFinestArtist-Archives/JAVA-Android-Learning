   private RealmChangeListener realmListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realmListener = new RealmChangeListener() {
            @Override
            public void onChange() {
                // ... do something with the updates (UI, etc.) ...
            }
        };

        realm.addChangeListener(realmListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.removeChangeListener(realmListener);
    }
