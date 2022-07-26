package martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Aluno;

@Dao
public interface ICRUDAlunoDAO {

    //METODOS NAO PRECISAM DE PUBLIC, POIS POR SER INTERFACE SÃO PUBLICOS COMO PADRAO

    @Transaction // OU FAZ TUDO OU FAZ NADA, OU EXECUTA TUDO OU NAO EXECUTA NADA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tblAluno);

    @Query("SELECT * FROM tbl_aluno where id = :id") //QUERY = CONSULTA
    Aluno getEspecificAlunoById(int id);

    @Query("SELECT * FROM tbl_aluno ORDER BY id DESC")
    List<Aluno> getAllAlunos();

    @Transaction
    @Update(entity = Aluno.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAluno(Aluno tblAluno);

    @Transaction
    @Delete(entity = Aluno.class)
    void deleteAluno(Aluno tblAluno);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id = :id")
    void deleteAlunoById(int id);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id > 0")
    void deleteAllAlunos();
}
