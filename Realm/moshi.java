Moshi moshi = new Moshi.Builder()
                    .add(new MoshiDateAdapter())
                    .build();
JsonAdapter<AllTypes> adapter = moshi.adapter(AllTypes.class);

// Moshi: error: No JsonAdapter for
// java.lang.Class<com.thefinestartist.realm.json.models.Dog> annotated
