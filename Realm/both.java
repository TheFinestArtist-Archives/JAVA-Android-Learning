AllTypes allTypes;
Logger.d("Gson(Realm Object)");
Logger.json(gson.toJson(allTypes));

realm.beginTransaction();
AllTypes allTypesProxy = realm.copyToRealm(allTypes);
realm.commitTransaction();
Logger.d("Gson(Proxy Object)");
Logger.json(gson.toJson(allTypesProxy));
