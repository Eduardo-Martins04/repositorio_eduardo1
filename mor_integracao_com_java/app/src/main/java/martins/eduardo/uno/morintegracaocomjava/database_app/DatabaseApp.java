package martins.eduardo.uno.morintegracaocomjava.database_app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import martins.eduardo.uno.morintegracaocomjava.database_app.converter.Converters;
import martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDAlunoDAO;
import martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDAlunoProvaDAO;
import martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDPerguntaDAO;
import martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDProvaDAO;
import martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDRespostaDAO;

@TypeConverters({Converters.class})

public abstract class DatabaseApp extends RoomDatabase {

    private static final String DB_NAME = "db_app.db";
    public static final String TAG      = "DatabaseApp";
    private static volatile DatabaseApp sInstance;

    //Definicao dos atributos da classe das interfaces DAO
    public abstract ICRUDAlunoDAO alunoDAO();
    public abstract ICRUDProvaDAO provaDAO();
    public abstract ICRUDAlunoProvaDAO alunoProvaDAO();
    public abstract ICRUDPerguntaDAO perguntaDAO();
    public abstract ICRUDRespostaDAO respostaDAO();

    public DatabaseApp(){}

    public static synchronized DatabaseApp getInstance(Context context){
        if(sInstance == null){
            sInstance = getConnection(context);
        }
        return sInstance;
    }

    private static DatabaseApp getConnection(Context activityContext){
        DatabaseApp db = Room.databaseBuilder(activityContext, DatabaseApp.class, DB_NAME)
                .addCallback(initDB)
                .build();

        return db;
    }

    static RoomDatabase.Callback initDB = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(() -> {
                //Executar métodos e\ou rotinas logo após a criação do banco
                Log.d(TAG, "Banco criado com sucesso! Executar rotinas posteriores. ");
            });
        }

        public  void onOpen(SupportSQLiteDatabase db){

        }
    };

}
