package martins.eduardo.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;


import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Prova;

public interface IProvaDbCallback {
    void getProvaFromDB(List<Prova> tblProva);
}
