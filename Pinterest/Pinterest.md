```
src/com/pinterest/activity/search/adapter/GuidedSearchTypeAheadAdapter.java:    private void mergeApiResultsWithRealmData(List list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType searchtype)
src/com/pinterest/activity/search/adapter/GuidedSearchTypeAheadAdapter.java:    private void setTypeAheadRealmData(List list)
src/com/pinterest/activity/search/adapter/GuidedSearchTypeAheadAdapter.java:    public void loadRealmData(final String searchTerm, final List newData)
src/com/pinterest/activity/search/adapter/GuidedSearchTypeAheadAdapter.java:                setTypeAheadRealmData(newData);
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:import com.pinterest.activity.search.model.TypeAheadRealmItem;
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:import io.realm.Realm;
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:import io.realm.RealmQuery;
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:import io.realm.RealmResults;
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:    private void loadSuggestionsFromRealm(String s)
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:       RealmResults realmresults;
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:        realmresults = Realm.getInstance(Application.context(), AppUtils.getRealmKey()).where(com/pinterest/activity/search/model/TypeAheadRealmItem).beginsWith("query", s, false).findAllSorted("score", false);
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:        guidedsearchtypeaheaditem.setTitle(((TypeAheadRealmItem)realmresults.get(i)).getQuery());
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:            _searchAdapter.loadRealmData(s, arraylist);
src/com/pinterest/activity/search/fragment/SearchTypeaheadFragment.java:                    loadSuggestionsFromRealm(s);
src/com/pinterest/activity/search/model/TypeAheadRealmItem.java:import io.realmRealmObject;
src/com/pinterest/activity/search/model/TypeAheadRealmItem.java:public class TypeAheadRealmItem extends RealmObject
src/com/pinterest/activity/search/model/TypeAheadRealmItem.java:    public TypeAheadRealmItem()
src/com/pinterest/activity/task/activity/MainActivity$3.java:            (new pulateRealmTask(MainActivity.this)).execute();
src/com/pinterest/activity/task/activity/MainActivity.java:import com.pinterest.activity.search.model.TypeAheadRealmItem;
src/com/pinterest/activity/task/activity/MainActivity.java:import io.realm.Real;
src/com/pinterest/activity/task/activity/MainActivity.java:import io.realm.RealResults;
src/com/pinterest/activity/task/activity/MainActivity.java:        Realm realm;
src/com/pinterest/activity/task/activity/MainActivity.java:        realm = Real.getInstance(this, AppUtils.getRealmKey());
src/com/pinterest/activity/task/activity/MainActivity.java:        TypeAheadRealmItem typeaheadrealmitem = (TypeAheadRealmItem)realm.createObject(com/pinterest/activity/search/model/TypeAheadRealmItem);
src/com/pinterest/activity/task/activity/MainActivity.java:        if (realm.allObjects(com/pinterest/activity/search/model/TypeAheadRealmItem).size() > 0)
src/com/pinterest/activity/task/activity/MainActivity.java:        if (!flag && realm.allObjects(com/pinterest/activity/search/model/TypeAheadRealmItem).size() > 0)
src/com/pinterest/activity/task/activity/MainActivity.java:                (new PopulateRealmTask()).execute();
src/com/pinterest/activity/task/activity/MainActivity.java:        private class PopulateRealmTask extends BackgroundTask
src/com/pinterest/activity/task/activity/MainActivity.java:            PopulateRealmTask()
src/com/pinterest/base/Constants.java:    public static final String METADATA_KEY_REALM = "RealmEncKey";
src/com/pinterest/kit/utils/AppUtils.java:    public static byte[] getRealmKey()
src/com/pinterest/kit/utils/AppUtils.java:        int i = getApplicationInfo(Application.context().getPackageName(), 128).metaData.getInt("RealmEncKey");
```
```

src/io/realm/annotations/RealmClass.java:public interface RealmClass
src/io/realm/exceptions/RealmException.java:public class RealmException extends RuntimeException
src/io/realm/exceptions/RealmException.java:    public RealmException(String s)
src/io/realm/exceptions/RealmException.java:    public RealmException(String s, Throwable throwable)
src/io/realm/exceptions/RealmIOException.java:public class RealmIOException extends RuntimeException
src/io/realm/exceptions/RealmIOException.java:    public RealmIOException()
src/io/realm/exceptions/RealmIOException.java:    public RealmIOException(String s)
src/io/realm/exceptions/RealmIOException.java:    public RealmIOException(String s, Throwable throwable)
src/io/realm/exceptions/RealmIOException.java:    public RealmIOException(Throwable throwable)
src/io/realm/exceptions/RealmMigrationNeededException.java:public class RealmMigrationNeededException extends RuntimeException
src/io/realm/exceptions/RealmMigrationNeededException.java:    public RealmMigrationNeededException(String s)
src/io/realm/exceptions/RealmMigrationNeededException.java:    public RealmMigrationNeededException(String s, Throwable throwable)
src/io/realm/internal/Group.java:            throw new IllegalStateException((new StringBuilder("Requested table is not in this Realm. Creating it requires a transaction: ")).append(s).toString());
src/io/realm/internal/Group.java:            throw new IllegalArgumentException("Realm AES keys must be 64 bytes long");
src/io/realm/internal/log/RealmLog.java:public final class RealmLog
src/io/realm/internal/log/RealmLog.java:    public RealmLog()
src/io/realm/internal/RealmJson.java:import io.realm.RealmObject;
src/io/realm/internal/RealmJson.java:public interface RealmJson
src/io/realm/internal/RealmJson.java:    public abstract void populateUsingJsonObject(RealmObject realmobject, JSONObject jsonobject);
src/io/realm/internal/RealmJson.java:    public abstract void populateUsingJsonStream(RealmObject realmobject, JsonReader jsonreader);
src/io/realm/internal/SharedGroup.java:import io.realm.exceptions.RealmIOException;
src/io/realm/internal/SharedGroup.java:            throw new IOError(new RealmIOException("Realm could not be opened"));
src/io/realm/internal/Table.java:import io.realm.exceptions.RealmException;
src/io/realm/internal/Table.java:        throw new RealmException((new StringBuilder("Primary key constraint broken. Value already exists: ")).append(obj).toString());
src/io/realm/internal/Table.java:        throw new RealmException((new StringBuilder("Cannot check for duplicate rows for unsupported primary key type: ")).append(columntype).toString());
src/io/realm/internal/Table.java:                throw new RealmException("Multiple empty rows cannot be created if a primary key is defined for the table.");
src/io/realm/internal/Table.java:            throw new RealmException("Primary keys are only supported if Table is part of a Group");
src/io/realm/processor/ClassMetaData.java:            Utils.error("The RealmClass annotation does not support nested classes", classType);
src/io/realm/processor/ClassMetaData.java:        if (!((TypeElement)Utils.getSuperClass(classType)).toString().endsWith(".RealmObject"))
src/io/realm/processor/ClassMetaData.java:            Utils.error("A RealmClass annotated object must be derived from RealmObject", classType);
src/io/realm/processor/ClassMetaData.java:        return !classType.toString().endsWith(".RealmObject") && !classType.toString().endsWith("RealmProxy");
src/io/realm/processor/Constants.java:    public static final String PROXY_SUFFIX = "RealmProxy";
src/io/realm/processor/RealmJSonImplGenerator.java:public class RealmJSonImplGenerator
src/io/realm/processor/RealmJSonImplGenerator.java:    private static final String CLASS_NAME = "RealmJsonImpl";
src/io/realm/processor/RealmJSonImplGenerator.java:    public RealmJSonImplGenerator(ProcessingEnvironment processingenvironment, Set set)
src/io/realm/processor/RealmJSonImplGenerator.java:        javawriter.a("<E extends RealmObject> void", "populateUsingJsonObject", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
src/io/realm/processor/RealmJSonImplGenerator.java:        javawriter.a("<E extends RealmObject> void", "populateUsingJsonStream", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
src/io/realm/processor/RealmJSonImplGenerator.java:            javawriter.a("throw new RealmException(%s)", new Object[] {
src/io/realm/processor/RealmJSonImplGenerator.java:        javawriter.a("throw new RealmException(%s)", new Object[] {
src/io/realm/processor/RealmJSonImplGenerator.java:            "io.realm", "RealmJsonImpl"
src/io/realm/processor/RealmJSonImplGenerator.java:            "android.util.JsonReader", "io.realm.exceptions.RealmException", "io.realm.internal.RealmJson", "java.io.IOException", "java.util.ArrayList", "java.util.Collections", "java.util.List", "org.json.JSONException", "org.json.JSONObject"
src/io/realm/processor/RealmJSonImplGenerator.java:            "RealmJson"
src/io/realm/processor/RealmJsonTypeHelper$1.java:final class onToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper$1.java:    implements onToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper$1.java:    onToRealmTypeConverter()
src/io/realm/processor/RealmJsonTypeHelper$2.java:final class onToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper$2.java:    implements onToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper$2.java:    onToRealmTypeConverter()
src/io/realm/processor/RealmJsonTypeHelper.java:public class RealmJsonTypeHelper
src/io/realm/processor/RealmJsonTypeHelper.java:    public RealmJsonTypeHelper()
src/io/realm/processor/RealmJsonTypeHelper.java:            ((JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2)).emitStreamTypeConversion(s, s1, s2, javawriter);
src/io/realm/processor/RealmJsonTypeHelper.java:        JsonToRealmTypeConverter jsontorealmtypeconverter = (JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2);
src/io/realm/processor/RealmJsonTypeHelper.java:    public static void emitFillRealmListFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
src/io/realm/processor/RealmJsonTypeHelper.java:        javawriter.a("reader.beginArray()", new Object[0]).b("if (standalone)", new Object[0]).a("obj.%s(new RealmList<%s>())", new Object[] {
src/io/realm/processor/RealmJsonTypeHelper.java:    public static void emitFillRealmListWithJsonValue(String s, String s1, String s2, String s3, String s4, JavaWriter javawriter)
src/io/realm/processor/RealmJsonTypeHelper.java:        }).b("if (standalone)", new Object[0]).a("obj.%s(new RealmList<%s>())", new Object[] {
src/io/realm/processor/RealmJsonTypeHelper.java:    public static void emitFillRealmObjectFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
src/io/realm/processor/RealmJsonTypeHelper.java:    public static void emitFillRealmObjectWithJsonValue(String s, String s1, String s2, String s3, JavaWriter javawriter)
src/io/realm/processor/RealmJsonTypeHelper.java:    private class JsonToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper.java:        implements JsonToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper.java:        implements JsonToRealmTypeConverter
src/io/realm/processor/RealmJsonTypeHelper.java:        implements JsonToRealmTypeConverter
src/io/realm/processor/RealmProcessor.java:import io.realm.annotations.RealmClass;
src/io/realm/processor/RealmProcessor.java://            RealmVersionChecker, Utils, ClassMetaData, RealmProxyClassGenerator,
src/io/realm/processor/RealmProcessor.java://            RealmValidationListGenerator, RealmJSonImplGenerator
src/io/realm/processor/RealmProcessor.java:public class RealmProcessor extends AbstractProcessor
src/io/realm/processor/RealmProcessor.java:    public RealmProcessor()
src/io/realm/processor/RealmProcessor.java:        RealmVersionChecker.getInstance(processingEnv).executeRealmVersionUpdate();
src/io/realm/processor/RealmProcessor.java:        set = roundenvironment.getElementsAnnotatedWith(io/realm/annotations/RealmClass).iterator();
src/io/realm/processor/RealmProcessor.java:            Utils.error("The RealmClass annotation can only be applied to classes", roundenvironment);
src/io/realm/processor/RealmProcessor.java:        obj = new RealmProxyClassGenerator(processingEnv, ((ClassMetaData) (obj)));
src/io/realm/processor/RealmProcessor.java:            ((RealmProxyClassGenerator) (obj)).generate();
src/io/realm/processor/RealmProcessor.java:        set = new RealmValidationListGenerator(processingEnv, classesToValidate);
src/io/realm/processor/RealmProcessor.java:        roundenvironment = new RealmJSonImplGenerator(processingEnv, classesToValidate);
src/io/realm/processor/RealmProxyClassGenerator.java://            ClassMetaData, Utils, RealmJsonTypeHelper
src/io/realm/processor/RealmProxyClassGenerator.java:public class RealmProxyClassGenerator
src/io/realm/processor/RealmProxyClassGenerator.java:    public RealmProxyClassGenerator(ProcessingEnvironment processingenvironment, ClassMetaData classmetadata)
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("return (%s) row.get%s(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("row.set%s(Realm.columnIndices.get(\"%s\").get(\"%s\"), (%s) value)", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.b("if (row.isNullLink(Realm.columnIndices.get(\"%s\").get(\"%s\")))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("return realm.get(%s.class, row.getLink(Realm.columnIndices.get(\"%s\").get(\"%s\")))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("row.nullifyLink(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("row.setLink(Realm.columnIndices.get(\"%s\").get(\"%s\"), value.row.getIndex())", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("return new RealmList<%s>(%s.class, row.getLinkList(Realm.columnIndices.get(\"%s\").get(\"%s\")), realm)", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("LinkView links = row.getLinkList(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.b("for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value)", new Object[0]);
src/io/realm/processor/RealmProxyClassGenerator.java:            "Realm", "realm", className, "newObject", "boolean", "update", "Map<RealmObject,RealmObject>", "cache"
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.b().a("RealmList<%s> %sList = newObject.%s()", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).a("RealList<%s> %sRealmList = realmObject.%s()", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).a("%sRealmList.add(cache%s)", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).c("else", new Object[0]).a("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), update, cache))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:            "Realm", "realm", className, "object", "boolean", "update", "Map<RealmObject,RealmObject>", "cache"
src/io/realm/processor/RealmProxyClassGenerator.java:        String s = (new StringBuilder()).append(className).append("RealmProxy").toString();
src/io/realm/processor/RealmProxyClassGenerator.java:                    s2, "RealmProxy"
src/io/realm/processor/RealmProxyClassGenerator.java:                    obj, "RealmProxy"
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillRealmObjectWithJsonValue(metadata.getSetter(s), s, s1, Utils.getProxyClassSimpleName(variableelement), javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillRealmListWithJsonValue(metadata.getGetter(s), metadata.getSetter(s), s, ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillJavaTypeWithJsonValue(metadata.getSetter(s), s, s1, javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillRealmObjectFromStream(metadata.getSetter(s), s, s1, Utils.getProxyClassSimpleName(variableelement), javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillRealmListFromStream(metadata.getGetter(s), metadata.getSetter(s), ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                RealmJsonTypeHelper.emitFillJavaTypeFromStream(metadata.getSetter(s), s, s1, javawriter);
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("stringBuilder.append(\"RealmList<%s>[\").append(%s().size()).append(\"]\")", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:            "Realm", "realm", className, "realmObject", className, "newObject", "Map<RealmObject, RealmObject>", "cache"
src/io/realm/processor/RealmProxyClassGenerator.java:                javawriter.a("RealmList<%s> %sList = newObject.%s()", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).a("RealList<%s> %sRealmList = realmObject.%s()", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).a("%sRealmList.clear()", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).a("%sRealmList.add(cache%s)", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:                }).c("else", new Object[0]).a("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), true, cache))", new Object[] {
src/io/realm/processor/RealmProxyClassGenerator.java:        realmObject = elementUtils.getTypeElement("io.realm.RealmObject").asType();
src/io/realm/processor/RealmProxyClassGenerator.java:        realmList = typeUtils.getDeclaredType(elementUtils.getTypeElement("io.realm.RealmList"), new TypeMirror[] {
src/io/realm/processor/RealmProxyClassGenerator.java:        arraylist.add("io.realm.RealmObject");
src/io/realm/processor/RealmProxyClassGenerator.java:        arraylist.add("io.realm.exceptions.RealmException");
src/io/realm/processor/RealmValidationListGenerator.java:public class RealmValidationListGenerator
src/io/realm/processor/RealmValidationListGenerator.java:    public RealmValidationListGenerator(ProcessingEnvironment processingenvironment, Set set)
src/io/realm/processor/RealmVersionChecker$1.java://            RealmVersionChecker
src/io/realm/processor/RealmVersionChecker$1.java:    final RealmVersionChecker this$0;
src/io/realm/processor/RealmVersionChecker$1.java:        RealmVersionChecker.access$000(RealmVersionChecker.this);
src/io/realm/processor/RealmVersionChecker$1.java:        this$0 = RealmVersionChecker.this;
src/io/realm/processor/RealmVersionChecker.java:public class RealmVersionChecker
src/io/realm/processor/RealmVersionChecker.java:    private static RealmVersionChecker instance = null;
src/io/realm/processor/RealmVersionChecker.java:    private RealmVersionChecker(ProcessingEnvironment processingenvironment)
src/io/realm/processor/RealmVersionChecker.java:    public static RealmVersionChecker getInstance(ProcessingEnvironment processingenvironment)
src/io/realm/processor/RealmVersionChecker.java:            instance = new RealVersionChecker(processingenvironment);
src/io/realm/processor/RealmVersionChecker.java:    private void launchRealmCheck()
src/io/realm/processor/RealmVersionChecker.java:            printMessage((new StringBuilder("Version ")).append(s).append(" of Realm is now available: http://static.realm.io/downloads/java/latest").toString());
src/io/realm/processor/RealmVersionChecker.java:    public void executeRealmVersionUpdate()
src/io/realm/processor/RealmVersionChecker.java:        final RealmVersionChecker this$0;
src/io/realm/processor/RealmVersionChecker.java:            launchRealmCheck();
src/io/realm/processor/RealmVersionChecker.java:            this$0 = RealmVersionChecker.this;
src/io/realm/processor/Utils.java:        return (new StringBuilder()).append(s).append("RealmProxy").toString();
src/io/realm/processor/Utils.java:        realmList = typeUtils.getDeclaredType(processingenvironment.getElementUtils().getTypeElement("io.realm.RealmList"), new TypeMirror[] {
src/io/realm/Realm$RealmCallback.java://            Realm
src/io/realm/Realm$RealmCallback.java:    final Realm this$0;
src/io/realm/Realm$RealmCallback.java:            Realm.access$000(Realm.this).advanceRead();
src/io/realm/Realm$RealmCallback.java:        this$0 = Realm.this;
src/io/realm/Realm$Transaction.java://            Realm
src/io/realm/Realm$Transaction.java:    public abstract void execute(Realm realm);
src/io/realm/Realm.java:import io.realm.exceptions.RealmException;
src/io/realm/Realm.java:import io.realm.exceptions.RealmMigrationNeededException;
src/io/realm/Realm.java:import io.realm.internal.RealmJson;
src/io/realm/Realm.java:import io.realm.internal.log.RealmLog;
src/io/realm/Realm.java://            RealmObject, RealmMigration, RealmQuery, RealmResults,
src/io/realm/Realm.java://            RealmChangeListener
src/io/realm/Realm.java:public final class Realm
src/io/realm/Realm.java:    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
src/io/realm/Realm.java:    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
src/io/realm/Realm.java:    private static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they where created.";
src/io/realm/Realm.java:    private static final Map openRealms = new ConcurrentHashMap();
src/io/realm/Realm.java:    private final RealmJson realmJson = getRealmJson();
src/io/realm/Realm.java:    private Realm(String s, byte abyte0[], boolean flag)
src/io/realm/Realm.java:    private void checkHasPrimaryKey(RealmObject realmobject)
src/io/realm/Realm.java:            throw new IllegalArgumentException((new StringBuilder("RealmObject has no @PrimaryKey defined: ")).append(getClassSimpleName(realmobject)).toString());
src/io/realm/Realm.java:            throw new IllegalArgumentException((new StringBuilder("A RealmObject with no @PrimaryKey cannot be updated: ")).append(class1.toString()).toString());
src/io/realm/Realm.java:    private void checkNotNullObject(RealmObject realmobject)
src/io/realm/Realm.java:            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
src/io/realm/Realm.java:    private static void checkValidRealmPath(File file, String s)
src/io/realm/Realm.java:    public static boolean compactRealmFile(Context context)
src/io/realm/Realm.java:        return compactRealmFile(context, "default.realm");
src/io/realm/Realm.java:    public static boolean compactRealmFile(Context context, String s)
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:    private RealmObject copyOrUpdate(RealmObject realmobject, boolean flag)
src/io/realm/Realm.java:        Class class2 = getRealmClassFromObject(realmobject);
src/io/realm/Realm.java:                    io/realm/Realm, class2, Boolean.TYPE, java/util/Map
src/io/realm/Realm.java:            catch (RealmObject realmobject)
src/io/realm/Realm.java:                throw new RealmException((new StringBuilder("Could not find the copyOrUpdate() method in generated proxy class for ")).append(class1.getName()).append(": Annotation processor may not have been executed.").toString(), realmobject);
src/io/realm/Realm.java:            realmobject = (RealmObject)method.invoke(null, new Object[] {
src/io/realm/Realm.java:        catch (RealmObject realmobject)
src/io/realm/Realm.java:            throw new RealmException("Could not execute the copyToRealm method : Annotation processor may not have been executed.", realmobject);
src/io/realm/Realm.java:        catch (RealmObject realmobject)
src/io/realm/Realm.java:            throw new RealmException((new StringBuilder("An exception was thrown in the copyToRealm method in the proxy class  ")).append(class1.getName()).append(": Annotation processor may not have been executed.").toString(), realmobject);
src/io/realm/Realm.java:    private static Realm create(File file, String s, byte abyte0[])
src/io/realm/Realm.java:        checkValidRealmPath(file, s);
src/io/realm/Realm.java:    private static Realm createAndValidate(String s, byte abyte0[], boolean flag, boolean flag1)
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        Object obj = (AtomicInteger)openRealms.get(Integer.valueOf(i));
src/io/realm/Realm.java:        openRealms.put(Integer.valueOf(i), new AtomicInteger(1));
src/io/realm/Realm.java:        obj = (Realm)map1.get(Integer.valueOf(s.hashCode()));
src/io/realm/Realm.java:        if (!Arrays.equals(((Realm) (obj)).key, abyte0))
src/io/realm/Realm.java:            throw new IllegalStateException("Wrong key used to decrypt Realm.");
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        abyte0 = new Realm(s, abyte0, flag1);
src/io/realm/Realm.java:        initializeRealm(abyte0);
src/io/realm/Realm.java:    private RealmObject createStandaloneRealmObjectInstance(Class class1)
src/io/realm/Realm.java:        RealmObject realmobject;
src/io/realm/Realm.java:            realmobject = (RealmObject)class1.newInstance();
src/io/realm/Realm.java:            throw new RealmException((new StringBuilder("Could not create an object of class: ")).append(class1).toString(), instantiationexception);
src/io/realm/Realm.java:            throw new RealmException((new StringBuilder("Could not create an object of class: ")).append(class1).toString(), illegalaccessexception);
src/io/realm/Realm.java:    public static boolean deleteRealmFile(Context context)
src/io/realm/Realm.java:        return deleteRealmFile(context, "default.realm");
src/io/realm/Realm.java:    public static boolean deleteRealmFile(Context context, String s)
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        atomicinteger = (AtomicInteger)openRealms.get(Integer.valueOf(i));
src/io/realm/Realm.java:            throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file.");
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:    public static Realm getInstance(Context context)
src/io/realm/Realm.java:    public static Realm getInstance(Context context, String s)
src/io/realm/Realm.java:    public static Realm getInstance(Context context, String s, byte abyte0[])
src/io/realm/Realm.java:    public static Realm getInstance(Context context, byte abyte0[])
src/io/realm/Realm.java:    public static Realm getInstance(File file)
src/io/realm/Realm.java:    public static Realm getInstance(File file, String s)
src/io/realm/Realm.java:    public static Realm getInstance(File file, String s, byte abyte0[])
src/io/realm/Realm.java:    public static Realm getInstance(File file, byte abyte0[])
src/io/realm/Realm.java:                throw new RealmException("Could not find the generated proxy class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:        return (new StringBuilder("io.realm.")).append(s).append("RealmProxy").toString();
src/io/realm/Realm.java:    private Class getRealmClassFromObject(RealmObject realmobject)
src/io/realm/Realm.java:    private static void initializeRealm(Realm realm)
src/io/realm/Realm.java:        catch (Realm realm)
src/io/realm/Realm.java:            throw new RealmException("Could not find the generated ValidationList class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:        catch (Realm realm)
src/io/realm/Realm.java:            throw new RealmException("Could not find the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:        catch (Realm realm)
src/io/realm/Realm.java:            throw new RealmException("Could not execute the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:        catch (Realm realm)
src/io/realm/Realm.java:            throw new RealmException("An exception was thrown in the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:        throw new RealmMigrationNeededException((new StringBuilder("Field '")).append(s1).append("' not found for type '").append(s).append("'").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not find the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not find the initTable method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not execute the initTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("An exception was thrown in the initTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not find the validateTable method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not execute the validateTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmMigrationNeededException(as.getMessage(), as);
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not find the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("Could not execute the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:        throw new RealmException((new StringBuilder("An exception was thrown in the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
src/io/realm/Realm.java:    private boolean isObjectInRealm(RealmObject realmobject)
src/io/realm/Realm.java:    public static void migrateRealmAtPath(String s, RealmMigration realmmigration)
src/io/realm/Realm.java:        migrateRealmAtPath(s, null, realmmigration, true);
src/io/realm/Realm.java:    public static void migrateRealmAtPath(String s, RealmMigration realmmigration, boolean flag)
src/io/realm/Realm.java:        migrateRealmAtPath(s, null, realmmigration, flag);
src/io/realm/Realm.java:    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration)
src/io/realm/Realm.java:        migrateRealmAtPath(s, abyte0, realmmigration, true);
src/io/realm/Realm.java:    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration, boolean flag)
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:        io/realm/Realm;
src/io/realm/Realm.java:    public final void addChangeListener(RealmChangeListener realmchangelistener)
src/io/realm/Realm.java:    public final RealmResults allObjects(Class class1)
src/io/realm/Realm.java:    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag)
src/io/realm/Realm.java:            return new RealmResults(this, table.getSortedView(long1.longValue(), order), class1);
src/io/realm/Realm.java:    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1)
src/io/realm/Realm.java:    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
src/io/realm/Realm.java:    public final RealmResults allObjectsSorted(Class class1, String as[], boolean aflag[])
src/io/realm/Realm.java:        return new RealmResults(this, table.getSortedView(al, aflag), class1);
src/io/realm/Realm.java:            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
src/io/realm/Realm.java:        if ((Realm)((Map)realmsCache.get()).get(Integer.valueOf(id)) != this)
src/io/realm/Realm.java:            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they where created.");
src/io/realm/Realm.java:            ((AtomicInteger)openRealms.get(Integer.valueOf(id))).decrementAndGet();
src/io/realm/Realm.java:            RealmLog.w((new StringBuilder("Calling close() on a Realm that is already closed: ")).append(getPath()).toString());
src/io/realm/Realm.java:    public final RealmObject copyToRealm(RealmObject realmobject)
src/io/realm/Realm.java:        if (isObjectInRealm(realmobject))
src/io/realm/Realm.java:    public final List copyToRealm(Iterable iterable)
src/io/realm/Realm.java:        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealm((RealmObject)iterable.next()))) { }
src/io/realm/Realm.java:    public final RealmObject copyToRealmOrUpdate(RealmObject realmobject)
src/io/realm/Realm.java:        if (isObjectInRealm(realmobject))
src/io/realm/Realm.java:    public final List copyToRealmOrUpdate(Iterable iterable)
src/io/realm/Realm.java:        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealmOrUpdate((RealmObject)iterable.next()))) { }
src/io/realm/Realm.java:        RealmObject realmobject;
src/io/realm/Realm.java:            throw new RealmException("Could not create JSON array from string", class1);
src/io/realm/Realm.java:                RealmObject realmobject = createObject(class1);
src/io/realm/Realm.java:                    throw new RealmException("Could not map Json", class1);
src/io/realm/Realm.java:    public final RealmObject createObject(Class class1)
src/io/realm/Realm.java:                    throw new RealmException("Could not find the initTable() method in generated proxy class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:                throw new RealmException("Could not launch the initTable method: Annotation processor may not have been executed.");
src/io/realm/Realm.java:                throw new RealmException("An exception occurred while running the initTable method: Annotation processor may not have been executed.");
src/io/realm/Realm.java:    public final RealmObject createObjectFromJson(Class class1, InputStream inputstream)
src/io/realm/Realm.java:    public final RealmObject createObjectFromJson(Class class1, String s)
src/io/realm/Realm.java:            throw new RealmException("Could not create Json object from string", class1);
src/io/realm/Realm.java:    public final RealmObject createObjectFromJson(Class class1, JSONObject jsonobject)
src/io/realm/Realm.java:            throw new RealmException("Could not map Json", class1);
src/io/realm/Realm.java:        RealmObject realmobject;
src/io/realm/Realm.java:        for (; inputstream.hasNext(); copyToRealmOrUpdate(realmobject))
src/io/realm/Realm.java:            realmobject = createStandaloneRealmObjectInstance(class1);
src/io/realm/Realm.java:            throw new RealmException("Could not create JSON array from string", class1);
src/io/realm/Realm.java:                RealmObject realmobject = createStandaloneRealmObjectInstance(class1);
src/io/realm/Realm.java:                    copyToRealmOrUpdate(realmobject);
src/io/realm/Realm.java:                    throw new RealmException("Could not map Json", class1);
src/io/realm/Realm.java:    public final RealmObject createOrUpdateObjectFromJson(Class class1, InputStream inputstream)
src/io/realm/Realm.java:        class1 = createStandaloneRealmObjectInstance(class1);
src/io/realm/Realm.java:            copyToRealmOrUpdate(class1);
src/io/realm/Realm.java:            throw new RealmException("Could not create Json object from string", class1);
src/io/realm/Realm.java:    public final RealmObject createOrUpdateObjectFromJson(Class class1, String s)
src/io/realm/Realm.java:            throw new RealmException("Could not create Json object from string", class1);
src/io/realm/Realm.java:    public final RealmObject createOrUpdateObjectFromJson(Class class1, JSONObject jsonobject)
src/io/realm/Realm.java:        class1 = createStandaloneRealmObjectInstance(class1);
src/io/realm/Realm.java:            copyToRealmOrUpdate(class1);
src/io/realm/Realm.java:            throw new RealmException("Could not map Json", class1);
src/io/realm/Realm.java:            throw new RealmException("Error during transaction.", transaction1);
src/io/realm/Realm.java:            RealmLog.w((new StringBuilder("Remember to call close() on all Realm instances. Realm ")).append(path).append(" is being finalized without being closed, this can lead to running out of native memory.").toString());
src/io/realm/Realm.java:    final RealmObject get(Class class1, long l)
src/io/realm/Realm.java:                    throw new RealmException("Could not find the generated proxy class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:                    throw new RealmException("Could not find the constructor in generated proxy class: Annotation processor may not have been executed.");
src/io/realm/Realm.java:            class1 = (RealmObject)((Constructor) (obj)).newInstance(new Object[0]);
src/io/realm/Realm.java:            throw new RealmException("Could not instantiate the proxy class");
src/io/realm/Realm.java:            throw new RealmException("Could not run the constructor of the proxy class");
src/io/realm/Realm.java:            throw new RealmException("An exception occurred while instantiating the proxy class");
src/io/realm/Realm.java:    public final RealmJson getRealmJson()
src/io/realm/Realm.java:            obj = Class.forName("io.realm.RealmJsonImpl").getDeclaredConstructors()[0];
src/io/realm/Realm.java:            obj = (RealmJson)((Constructor) (obj)).newInstance(new Object[0]);
src/io/realm/Realm.java:            throw new RealmException("Could not find io.realm.RealmJsonImpl", classnotfoundexception);
src/io/realm/Realm.java:            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", invocationtargetexception);
src/io/realm/Realm.java:            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", instantiationexception);
src/io/realm/Realm.java:            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", illegalaccessexception);
src/io/realm/Realm.java:        return ((RealmJson) (obj));
src/io/realm/Realm.java:            s = class1.getSimpleName().replace("RealmProxy", "");
src/io/realm/Realm.java:    public final void removeChangeListener(RealmChangeListener realmchangelistener)
src/io/realm/Realm.java:        for (Iterator iterator = (new ArrayList(changeListeners)).iterator(); iterator.hasNext(); ((RealmChangeListener)iterator.next()).onChange()) { }
src/io/realm/Realm.java:        handler = new Handler(new RealmCallback(null));
src/io/realm/Realm.java:    public final RealmQuery where(Class class1)
src/io/realm/Realm.java:        return new RealmQuery(this, class1);
src/io/realm/Realm.java:        RealmLog.add(new ReleaseAndroidLogger());
src/io/realm/Realm.java:        public abstract void execute(Realm realm);
src/io/realm/Realm.java:    private class RealmCallback
src/io/realm/Realm.java:        final Realm this$0;
src/io/realm/Realm.java:        private RealmCallback()
src/io/realm/Realm.java:            this$0 = Realm.this;
src/io/realm/Realm.java:        RealmCallback(_cls1 _pcls1)
src/io/realm/RealmBaseAdapter$1.java://            RealmChangeListener, RealmBaseAdapter
src/io/realm/RealmBaseAdapter$1.java:    implements RealmChangeListener
src/io/realm/RealmBaseAdapter$1.java:    final RealmBaseAdapter this$0;
src/io/realm/RealmBaseAdapter$1.java:        this$0 = RealmBaseAdapter.this;
src/io/realm/RealmBaseAdapter.java://            RealmResults, Realm, RealmObject
src/io/realm/RealmBaseAdapter.java:public abstract class RealmBaseAdapter extends BaseAdapter
src/io/realm/RealmBaseAdapter.java:    protected RealmResults realmResults;
src/io/realm/RealmBaseAdapter.java:    public RealmBaseAdapter(Context context1, RealmResults realmresults, boolean flag)
src/io/realm/RealmBaseAdapter.java:            throw new IllegalArgumentException("RealmResults cannot be null");
src/io/realm/RealmBaseAdapter.java:            realmresults.getRealm().addChangeListener(new _cls1());
src/io/realm/RealmBaseAdapter.java:    public RealmObject getItem(int i)
src/io/realm/RealmBaseAdapter.java:    public void updateRealmResults(RealmResults realmresults)
src/io/realm/RealmBaseAdapter.java:        implements RealmChangeListener
src/io/realm/RealmBaseAdapter.java:        final RealmBaseAdapter this$0;
src/io/realm/RealmBaseAdapter.java:            this$0 = RealmBaseAdapter.this;
src/io/realm/RealmChangeListener.java:public interface RealmChangeListener
src/io/realm/RealmJsonImpl.java:import com.pinterest.activity.search.model.TypeAheadRealmItem;
src/io/realm/RealmJsonImpl.java:import io.realm.exceptions.RealmException;
src/io/realm/RealmJsonImpl.java:import io.realm.internal.RealmJson;
src/io/realm/RealmJsonImpl.java://            RealmObject, TypeAheadRealmItemRealmProxy
src/io/realm/RealmJsonImpl.java:class RealmJsonImpl
src/io/realm/RealmJsonImpl.java:    implements RealmJson
src/io/realm/RealmJsonImpl.java:    RealmJsonImpl()
src/io/realm/RealmJsonImpl.java:    public void populateUsingJsonObject(RealmObject realmobject, JSONObject jsonobject)
src/io/realm/RealmJsonImpl.java:        if (s.equals(com/pinterest/activity/search/model/TypeAheadRealmItem.getName()))
src/io/realm/RealmJsonImpl.java:            TypeAheadRealmItemRealmProxy.populateUsingJsonObject((TypeAheadRealmItem)realmobject, jsonobject);
src/io/realm/RealmJsonImpl.java:            throw new RealmException((new StringBuilder("Could not find the generated proxy class for ")).append(s).toString());
src/io/realm/RealmJsonImpl.java:    public void populateUsingJsonStream(RealmObject realmobject, JsonReader jsonreader)
src/io/realm/RealmJsonImpl.java:        if (s.equals(com/pinterest/activity/search/model/TypeAheadRealmItem.getName()))
src/io/realm/RealmJsonImpl.java:            TypeAheadRealmItemRealmProxy.populateUsingJsonStream((TypeAheadRealmItem)realmobject, jsonreader);
src/io/realm/RealmJsonImpl.java:            throw new RealmException((new StringBuilder("Could not find the generated proxy class for ")).append(s).toString());
src/io/realm/RealmList.java:import io.realm.exceptions.RealmException;
src/io/realm/RealmList.java://            RealmObject, Realm, RealmQuery
src/io/realm/RealmList.java:public class RealmList extends AbstractList
src/io/realm/RealmList.java:    public static final String MANAGED_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmObjects already managed by Realm cannot be added to RealList in non-managed mode.";
src/io/realm/RealmList.java:    private static final String NULL_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmList does not accept null values";
src/io/realm/RealmList.java:    private Realm realm;
src/io/realm/RealmList.java:    public RealmList()
src/io/realm/RealmList.java:    RealmList(Class class1, LinkView linkview, Real realm1)
src/io/realm/RealmList.java:    public transient RealmList(RealmObject arealmobject[])
src/io/realm/RealmList.java:    private void checkValidObject(RealmObject realmobject)
src/io/realm/RealmList.java:            throw new IllegalArgumentException("RealmList does not accept null values");
src/io/realm/RealmList.java:    public void add(int i, RealmObject realmobject)
src/io/realm/RealmList.java:        add(i, (RealmObject)obj);
src/io/realm/RealmList.java:    public boolean add(RealmObject realmobject)
src/io/realm/RealmList.java:        return add((RealmObject)obj);
src/io/realm/RealmList.java:    public RealmObject first()
src/io/realm/RealmList.java:            return (RealmObject)nonManagedList.get(0);
src/io/realm/RealmList.java:    public RealmObject get(int i)
src/io/realm/RealmList.java:            return (RealmObject)nonManagedList.get(i);
src/io/realm/RealmList.java:    public RealmObject last()
src/io/realm/RealmList.java:            return (RealmObject)nonManagedList.get(nonManagedList.size() - 1);
src/io/realm/RealmList.java:        RealmObject realmobject = (RealmObject)nonManagedList.remove(i);
src/io/realm/RealmList.java:    public RealmObject remove(int i)
src/io/realm/RealmList.java:            RealmObject realmobject = get(i);
src/io/realm/RealmList.java:            return (RealmObject)nonManagedList.remove(i);
src/io/realm/RealmList.java:    public RealmObject set(int i, RealmObject realmobject)
src/io/realm/RealmList.java:                throw new RealmException("This method is only available in managed mode");
src/io/realm/RealmList.java:        return set(i, (RealmObject)obj);
src/io/realm/RealmList.java:    public RealmQuery where()
src/io/realm/RealmList.java:            return new RealmQuery(realm, view, clazz);
src/io/realm/RealmList.java:            throw new RealmException("This method is only available in managed mode");
src/io/realm/RealmMigration.java://            Realm
src/io/realm/RealmMigration.java:public interface RealmMigration
src/io/realm/RealmMigration.java:    public abstract long execute(Realm realm, long l);
src/io/realm/RealmObject.java://            Realm
src/io/realm/RealmObject.java:public abstract class RealmObject
src/io/realm/RealmObject.java:    protected Realm realm;
src/io/realm/RealmObject.java:    public RealmObject()
src/io/realm/RealmObject.java:    public void removeFromRealm()
src/io/realm/RealmObject.java:            throw new IllegalStateException("Object malformed: missing object in Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
src/io/realm/RealmObject.java:            throw new IllegalStateException("Object malformed: missing Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
src/io/realm/RealmQuery.java://            Realm, RealmResults, RealmObject
src/io/realm/RealmQuery.java:public class RealmQuery
src/io/realm/RealmQuery.java:    private Realm realm;
src/io/realm/RealmQuery.java:    RealmQuery(Realm realm1, LinkView linkview, Class class1)
src/io/realm/RealmQuery.java:        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
src/io/realm/RealmQuery.java:    public RealmQuery(Realm realm1, Class class1)
src/io/realm/RealmQuery.java:        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
src/io/realm/RealmQuery.java:    public RealmQuery(RealmResults realmresults, Class class1)
src/io/realm/RealmQuery.java:        realm = realmresults.getRealm();
src/io/realm/RealmQuery.java:        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
src/io/realm/RealmQuery.java:    public RealmQuery beginGroup()
src/io/realm/RealmQuery.java:    public RealmQuery beginsWith(String s, String s1)
src/io/realm/RealmQuery.java:    public RealmQuery beginsWith(String s, String s1, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery between(String s, double d, double d1)
src/io/realm/RealmQuery.java:    public RealmQuery between(String s, float f, float f1)
src/io/realm/RealmQuery.java:    public RealmQuery between(String s, int i, int j)
src/io/realm/RealmQuery.java:    public RealmQuery between(String s, long l, long l1)
src/io/realm/RealmQuery.java:    public RealmQuery between(String s, Date date, Date date1)
src/io/realm/RealmQuery.java:    public RealmQuery contains(String s, String s1)
src/io/realm/RealmQuery.java:    public RealmQuery contains(String s, String s1, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery endGroup()
src/io/realm/RealmQuery.java:    public RealmQuery endsWith(String s, String s1)
src/io/realm/RealmQuery.java:    public RealmQuery endsWith(String s, String s1, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, String s1)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, String s1, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery equalTo(String s, boolean flag)
src/io/realm/RealmQuery.java:    public RealmResults findAll()
src/io/realm/RealmQuery.java:        return new RealmResults(realm, query.findAll(), clazz);
src/io/realm/RealmQuery.java:    public RealmResults findAllSorted(String s)
src/io/realm/RealmQuery.java:    public RealmResults findAllSorted(String s, boolean flag)
src/io/realm/RealmQuery.java:            return new RealmResults(realm, tableview, clazz);
src/io/realm/RealmQuery.java:    public RealmResults findAllSorted(String s, boolean flag, String s1, boolean flag1)
src/io/realm/RealmQuery.java:    public RealmResults findAllSorted(String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
src/io/realm/RealmQuery.java:    public RealmResults findAllSorted(String as[], boolean aflag[])
src/io/realm/RealmQuery.java:        return new RealmResults(realm, tableview, clazz);
src/io/realm/RealmQuery.java:    public RealmObject findFirst()
src/io/realm/RealmQuery.java:            Realm realm1 = realm;
src/io/realm/RealmQuery.java:    public RealmQuery greaterThan(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThan(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThan(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThan(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThan(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThanOrEqualTo(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThanOrEqualTo(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThanOrEqualTo(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThanOrEqualTo(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery greaterThanOrEqualTo(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery lessThan(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery lessThan(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery lessThan(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery lessThan(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery lessThan(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery lessThanOrEqualTo(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery lessThanOrEqualTo(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery lessThanOrEqualTo(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery lessThanOrEqualTo(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery lessThanOrEqualTo(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery not()
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, double d)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, float f)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, int i)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, long l)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, String s1)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, String s1, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, Date date)
src/io/realm/RealmQuery.java:    public RealmQuery notEqualTo(String s, boolean flag)
src/io/realm/RealmQuery.java:    public RealmQuery or()
src/io/realm/RealmResults$RealmResultsIterator.java:import io.realm.exceptions.RealmException;
src/io/realm/RealmResults$RealmResultsIterator.java://            RealmResults,RealmObject
src/io/realm/RealmResults$RealmResultsIterator.java:    final RealmResults this$0;
src/io/realm/RealmResults$RealmResultsIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsIterator.java:    public RealmObject next()
src/io/realm/RealmResults$RealmResultsIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsIterator.java:        throw new RealmException("Removing is not supported.");
src/io/realm/RealmResults$RealmResultsIterator.java:        this$0 = RealmResults.this;
src/io/realm/RealmResults$RealmResultsIterator.java:        RealmResults.access$002(RealmResults.this, RealmResults.access$100(RealmResults.this).sync());
src/io/realm/RealmResults$RealmResultsListIterator.java:import io.realm.exceptions.RealmException;
src/io/realm/RealmResults$RealmResultsListIterator.java://            RealmResults, RealmObject
src/io/realm/RealmResults$RealmResultsListIterator.java:    final RealmResults this$0;
src/io/realm/RealmResults$RealmResultsListIterator.java:    public void add(RealmObject realmobject)
src/io/realm/RealmResults$RealmResultsListIterator.java:        throw new RealmException("Adding elements not supported. Use Realm.createObject() instead.");
src/io/realm/RealmResults$RealmResultsListIterator.java:        add((RealmObject)obj);
src/io/realm/RealmResults$RealmResultsListIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsListIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsListIterator.java:    public RealmObject previous()
src/io/realm/RealmResults$RealmResultsListIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsListIterator.java:        RealmResults.access$200(RealmResults.this);
src/io/realm/RealmResults$RealmResultsListIterator.java:        throw new RealmException("Removing elements not supported.");
src/io/realm/RealmResults$RealmResultsListIterator.java:    public void set(RealmObject realmobject)
src/io/realm/RealmResults$RealmResultsListIterator.java:        throw new RealmException("Replacing elements not supported.");
src/io/realm/RealmResults$RealmResultsListIterator.java:        set((RealmObject)obj);
src/io/realm/RealmResults$RealmResultsListIterator.java:        this$0 = RealmResults.this;
src/io/realm/RealmResults$RealmResultsListIterator.java:        super(RealmResults.this);
src/io/realm/RealmResults.java://            RealmObject, Realm, RealmQuery
src/io/realm/RealmResults.java:public class RealmResults extends AbstractList
src/io/realm/RealmResults.java:    private Realm realm;
src/io/realm/RealmResults.java:    RealmResults(Realm realm1, TableOrView tableorview, Class class1)
src/io/realm/RealmResults.java:    RealmResults(Realm realm1, Class class1)
src/io/realm/RealmResults.java:    private void assertRealmIsStable()
src/io/realm/RealmResults.java:            throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a RealmResults. Use iterators methods instead.");
src/io/realm/RealmResults.java:    public void add(int i, RealmObject realmobject)
src/io/realm/RealmResults.java:        add(i, (RealmObject)obj);
src/io/realm/RealmResults.java:    public boolean add(RealmObject realmobject)
src/io/realm/RealmResults.java:        return add((RealmObject)obj);
src/io/realm/RealmResults.java:    public RealmObject first()
src/io/realm/RealmResults.java:    public RealmObject get(int i)
src/io/realm/RealmResults.java:    Realm getRealm()
src/io/realm/RealmResults.java:        throw new NoSuchMethodError("indexOf is not supported on RealmResults");
src/io/realm/RealmResults.java:        return new RealmResultsIterator();
src/io/realm/RealmResults.java:    public RealmObject last()
src/io/realm/RealmResults.java:        return new RealmResultsListIterator(0);
src/io/realm/RealmResults.java:        return new RealmResultsListIterator(i);
src/io/realm/RealmResults.java:    public RealmObject remove(int i)
src/io/realm/RealmResults.java:            throw new IllegalArgumentException("Only RealmResults can be sorted - please use allObject() to create a RealmResults.");
src/io/realm/RealmResults.java:    public RealmQuery where()
src/io/realm/RealmResults.java:        return new RealmQuery(this, classSpec);
src/io/realm/RealmResults.java:    static long access$002(RealmResults realmresults, long l)
src/io/realm/RealmResults.java:    private class RealmResultsIterator
src/io/realm/RealmResults.java:        final RealmResults this$0;
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:        public RealmObject next()
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:            throw new RealmException("Removing is not supported.");
src/io/realm/RealmResults.java:        RealmResultsIterator()
src/io/realm/RealmResults.java:            this$0 = RealmResults.this;
src/io/realm/RealmResults.java:    private class RealmResultsListIterator extends RealmResultsIterator
src/io/realm/RealmResults.java:        final RealmResults this$0;
src/io/realm/RealmResults.java:        public void add(RealmObject realmobject)
src/io/realm/RealmResults.java:            throw new RealmException("Adding elements not supported. Use Realm.createObject() instead.");
src/io/realm/RealmResults.java:            add((RealmObject)obj);
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:        public RealmObject previous()
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:            assertRealmIsStable();
src/io/realm/RealmResults.java:            throw new RealmException("Removing elements not supported.");
src/io/realm/RealmResults.java:        public void set(RealmObject realmobject)
src/io/realm/RealmResults.java:            throw new RealmException("Replacing elements not supported.");
src/io/realm/RealmResults.java:            set((RealmObject)obj);
src/io/realm/RealmResults.java:        RealmResultsListIterator(int i)
src/io/realm/RealmResults.java:            this$0 = RealmResults.this;
src/io/realm/TypeAheadRealmItemRealmProxy.java:import com.pinterest.activity.search.model.TypeAheadRealmItem;
src/io/realm/TypeAheadRealmItemRealmProxy.java://            Realm
src/io/realm/TypeAheadRealmItemRealmProxy.java:public class TypeAheadRealmItemRealmProxy extends TypeAheadRealmItem
src/io/realm/TypeAheadRealmItemRealmProxy.java:    public TypeAheadRealmItemRealmProxy()
src/io/realm/TypeAheadRealmItemRealmProxy.java:    public static TypeAheadRealmItem copy(Realm realm, TypeAheadRealmItem typeaheadrealmitem, boolean flag, Map map)
src/io/realm/TypeAheadRealmItemRealmProxy.java:        TypeAheadRealmItem typeaheadrealmitem1 = (TypeAheadRealmItem)realm.createObject(com/pinterest/activity/search/model/TypeAheadRealmItem);
src/io/realm/TypeAheadRealmItemRealmProxy.java:    public static TypeAheadRealmItem copyOrUpdate(Realm realm, TypeAheadRealmItem typeaheadrealmitem, boolean flag, Map map)
src/io/realm/TypeAheadRealmItemRealmProxy.java:        TypeAheadRealmItemRealmProxy typeaheadrealmitemrealmproxy = null;
src/io/realm/TypeAheadRealmItemRealmProxy.java:            Table table = realm.getTable(com/pinterest/activity/search/model/TypeAheadRealmItem);
src/io/realm/TypeAheadRealmItemRealmProxy.java:                typeaheadrealmitemrealmproxy = new TypeAheadRealmItemRealmProxy();
src/io/realm/TypeAheadRealmItemRealmProxy.java:        if (!implicittransaction.hasTable("class_TypeAheadRealmItem"))
src/io/realm/TypeAheadRealmItemRealmProxy.java:            implicittransaction = implicittransaction.getTable("class_TypeAheadRealmItem");
src/io/realm/TypeAheadRealmItemRealmProxy.java:            return implicittransaction.getTable("class_TypeAheadRealmItem");
src/io/realm/TypeAheadRealmItemRealmProxy.java:    public static void populateUsingJsonObject(TypeAheadRealmItem typeaheadrealmitem, JSONObject jsonobject)
src/io/realm/TypeAheadRealmItemRealmProxy.java:    public static void populateUsingJsonStream(TypeAheadRealmItem typeaheadrealmitem, JsonReader jsonreader)
src/io/realm/TypeAheadRealmItemRealmProxy.java:    static TypeAheadRealmItem update(Realm realm, TypeAheadRealmItem typeaheadrealmitem, TypeAheadRealmItem typeaheadrealmitem1, Map map)
src/io/realm/TypeAheadRealmItemRealmProxy.java:        if (implicittransaction.hasTable("class_TypeAheadRealmItem"))
src/io/realm/TypeAheadRealmItemRealmProxy.java:            implicittransaction = implicittransaction.getTable("class_TypeAheadRealmItem");
src/io/realm/TypeAheadRealmItemRealmProxy.java:            obj = (TypeAheadRealItemRealmProxy)obj;
src/io/realm/TypeAheadRealmItemRealmProxy.java:            String s1 = ((TypeAheadRealmItemRealmProxy) (obj)).realm.getPath();
src/io/realm/TypeAheadRealmItemRealmProxy.java:            s1 = ((TypeAheadRealItemRealmProxy) (obj)).row.getTable().getName();
src/io/realm/TypeAheadRealmItemRealmProxy.java:            if (row.getIndex() != ((TypeAheadRealmItemRealmProxy) (obj)).row.getIndex())
src/io/realm/TypeAheadRealmItemRealmProxy.java:        return row.getString(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("query")).longValue());
src/io/realm/TypeAheadRealmItemRealmProxy.java:        return row.getFloat(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("score")).longValue());
src/io/realm/TypeAheadRealmItemRealmProxy.java:        row.setString(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("query")).longValue(), s);
src/io/realm/TypeAheadRealmItemRealmProxy.java:        row.setFloat(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("score")).longValue(), f);
src/io/realm/TypeAheadRealmItemRealmProxy.java:            StringBuilder stringbuilder = new StringBuilder("TypeAheadRealmItem = [");
src/io/realm/ValidationList.java:            "TypeAheadRealmItem"
src/org/scribe/extractors/HeaderExtractorImpl.java:        if (oauthrequest.getRealm() != null && !oauthrequest.getRealm().isEmpty())
src/org/scribe/extractors/HeaderExtractorImpl.java:                "realm", oauthrequest.getRealm()
src/org/scribe/model/OAuthRequest.java:    public String getRealm()
src/org/scribe/model/OAuthRequest.java:    public void setRealm(String s)
➜  source git:(master) ✗ 
```
