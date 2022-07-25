package martins.eduardo.uno.morintegracaocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_pergunta"
        , indices = {@Index(value = "id", unique = true)}
        , foreignKeys = {@ForeignKey(entity = Prova.class, parentColumns = "id",
            childColumns = "prova_id", onUpdate = CASCADE, onDelete = CASCADE)})


public class Pergunta {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String pergunta;
    private int prova_id;

    public Pergunta(){
    }

    //CONSTRUTOR DE CÓPIA
    public Pergunta(Pergunta tbPergunta){
        this.id       = tbPergunta.getId();
        this.pergunta = tbPergunta.getPergunta();
        this.prova_id = tbPergunta.getProva_id();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getProva_id() {
        return prova_id;
    }

    public void setProva_id(int prova_id) {
        this.prova_id = prova_id;
    }
}
