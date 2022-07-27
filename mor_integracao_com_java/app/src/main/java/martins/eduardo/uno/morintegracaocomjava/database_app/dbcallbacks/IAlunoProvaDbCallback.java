package martins.eduardo.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;

public interface IAlunoProvaDbCallback {

    void getAlunoProvaFromDB(List<AlunoProva> tblAlunoProva);
}
