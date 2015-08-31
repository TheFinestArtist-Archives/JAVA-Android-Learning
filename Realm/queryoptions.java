// Conditions
between(), greaterThan(), lessThan(), greaterThanOrEqualTo() & lessThanOrEqualTo()
equalTo() & notEqualTo()
contains(), beginsWith() & endsWith()
isNull() & isNotNull()
beginsWith() & endsWith() & contains()

// Conditions Grouping
beginGroup() & endGroup() & not() & or()

// Sorting
RealmResults<User> result = realm.where(User.class).findAll();
result.sort("age", RealmResults.SORT_ORDER_DESCENDING);

// Querying
findAll() & findFirst() & findAllSorted()
