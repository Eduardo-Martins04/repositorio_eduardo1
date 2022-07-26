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

@Dao
public interface ICRUDPerguntaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPergunta(Pergunta pergunta);

    @Query("SELECT * FROM tbl_pergunta WHERE id = :id")
    void getEspecificPerguntaById(int id);

    @Query("SELECT * FROM tbl_pergunta")
    List<Pergunta> getAllPerguntas();

    @Transaction
    @Update(entity = Pergunta.class, onConflict = OnConflictStrategy.REPLACE)
    void updatePergunta(Pergunta pergunta);

    @Transaction
    @Delete(entity = Pergunta.class)
    void deletePergunta(Pergunta tblPergunta);

    @Transaction
    @Query("DELETE FROM tbl_pergunta WHERE id = :id")
    void deletePerguntaById(int id);

    @Transaction
    @Query("DELETE FROM tbl_pergunta WHERE id > 0")
    void deleteAllPerguntas();



}
