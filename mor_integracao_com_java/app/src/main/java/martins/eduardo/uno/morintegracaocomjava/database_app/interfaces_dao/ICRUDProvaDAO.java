package martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Pergunta;
import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Prova;

@Dao
public interface ICRUDProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProva(Prova prova);

    @Query("SELECT * FROM tbl_prova WHERE id = :id")
    Prova getEspecifProvaById(int id);

    @Query("SELECT * FROM tbl_prova")
    List<Prova> getAllProvas();

    @Transaction
    @Update(entity = Prova.class, onConflict = OnConflictStrategy.REPLACE)
    void updateProva(Prova prova);

    @Transaction
    @Delete(entity = Prova.class)
    void deleteProva(Prova tblProva);

    @Transaction
    @Query("DELETE FROM tbl_prova WHERE id = :id")
    void deleteProvaById(int id);

    @Transaction
    @Query("DELETE FROM tbl_prova WHERE id > 0")
    void deleteAllProvas();
}
