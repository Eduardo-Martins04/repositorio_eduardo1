package martins.eduardo.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Aluno;

public interface IAlunoDbCallback {
    void getAlunoFromDB(List<Aluno> tblAluno);
}
