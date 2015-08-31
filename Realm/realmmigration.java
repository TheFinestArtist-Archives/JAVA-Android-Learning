public class Migration implements RealmMigration {
    @Override
    public long execute(Realm realm, long version) {
        // Migrate from version 0 to version 1
        if (version == 0) {
            Table personTable = realm.getTable(Person.class);

            long fistNameIndex = getIndexForProperty(personTable, "firstName");
            long lastNameIndex = getIndexForProperty(personTable, "lastName");
            long fullNameIndex = personTable.addColumn(ColumnType.STRING, "fullName");
            for (int i = 0; i < personTable.size(); i++) {
                personTable.setString(fullNameIndex, i, personTable.getString(fistNameIndex, i) + " " +
                        personTable.getString(lastNameIndex, i));
            }
            personTable.removeColumn(getIndexForProperty(personTable, "firstName"));
            personTable.removeColumn(getIndexForProperty(personTable, "lastName"));
            version++;
        }
        return version;
    }
}
