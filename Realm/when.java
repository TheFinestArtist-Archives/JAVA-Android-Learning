realm.beginTransaction();
{
   Owner owner = new Owner();
   owner.setName("Leonardo");
}
realm.commitTransaction();

Owner owner = new Owner();
owner.setName("Leonardo");
realm.beginTransaction();
{
   Owner ownerProxy = realm.copyToRealm(owner);
}
realm.commitTransaction();
