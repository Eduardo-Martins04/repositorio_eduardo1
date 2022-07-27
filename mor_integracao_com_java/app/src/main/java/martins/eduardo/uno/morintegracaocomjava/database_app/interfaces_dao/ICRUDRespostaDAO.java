package martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Pergunta;
import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Resposta;

@Dao
public interface ICRUDRespostaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResposta(Resposta resposta);

    @Query("SELECT * FROM tbl_resposta WHERE id = :id")
    void getEspecificAlunoById(int id);

    @Query("SELECT * FROM tbl_resposta")
    List<Resposta> getAllRespostas();

    @Transaction
    @Update(entity = Resposta.class, onConflict = OnConflictStrategy.REPLACE)
    void updateResposta(Resposta resposta);

    @Transaction
    @Delete(entity = Resposta.class)
    void deleteResposta(Resposta tblResposta);

    @Transaction
    @Query("DELETE FROM tbl_resposta WHERE id = :id")
    void deleteRespostaById(int id);

    @Transaction
    @Query("DELETE FROM tbl_resposta WHERE id > 0")
    void deleteAllRespostas();

}
