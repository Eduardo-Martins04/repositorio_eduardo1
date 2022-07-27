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
import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;

@Dao
public interface ICRUDAlunoProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlunoProva(AlunoProva alunoProva);

    @Query("SELECT * FROM tbl_alunoprova where aluno_id = :id")
    AlunoProva getEspecificAlunoProvaById(int id);

    @Query("SELECT * FROM tbl_alunoprova ORDER BY aluno_id DESC")
    List<AlunoProva> getAllAlunosProvas();

    @Transaction
    @Update(entity = AlunoProva.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunoProva(AlunoProva alunoProva);

    @Transaction
    @Delete(entity = AlunoProva.class)
    void deleteAlunoProva(AlunoProva tblAlunoProva);

    @Transaction
    @Query("DELETE FROM tbl_alunoprova WHERE aluno_id = :id")
    void deleteAlunoProvaById(int id);

    @Transaction
    @Query("DELETE FROM tbl_alunoprova WHERE aluno_id > 0")
    void deleteAllAlunosProvas();

}
