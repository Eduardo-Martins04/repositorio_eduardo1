package martins.eduardo.uno.morintegracaocomjava.utils_app;

public class UtilsApp {
    private static final String TAG = "UtilsApp";
    private static DataBaseCrudOperations dataBaseCrudOperations;

    public enum DataBaseCrudOperations{
        CREATE,
        READ,
        UPDATE,
        DELETE,
        NONE
    }

}
