package martins.eduardo.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;


import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Pergunta;

public interface IPerguntaDbCallback {
    void getPerguntaFromDB(List<Pergunta> tblPergunta);
}
