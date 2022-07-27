package martins.eduardo.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Resposta;

public interface IRespostaDbCallback {
    void getRespostaFromDB(List<Resposta> tblResposta);
}
