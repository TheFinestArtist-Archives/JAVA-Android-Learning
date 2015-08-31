private static Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .create();

private static RestAdapter restAdapter = new RestAdapter.Builder()
      .setEndpoint(END_POINT)
      .setConverter(new GsonConverter(gson))
      .setRequestInterceptor(requestInterceptor)
      .build();

private static InstagramService instagramService = restAdapter.create(InstagramService.class);
