package martins.eduardo.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Aluno;

@Dao
public interface ICRUDRespostaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAluno(Aluno tblAluno);

    @Query("SELECT * FROM tbl_aluno where id = :id")
    public Aluno getEspecificaAlunoById(int id);
}
