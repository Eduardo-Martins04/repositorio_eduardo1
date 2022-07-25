package martins.eduardo.uno.morintegracaocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_resposta"
        , indices = {@Index(value = "id", unique = true)}
        , foreignKeys = {@ForeignKey(entity = Pergunta.class, parentColumns = "id",
            childColumns = "pergunta_id", onUpdate = CASCADE, onDelete = CASCADE)}

)


public class Resposta {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String resposta;
    private int pergunta_id;

    public Resposta(){}

    //CONSTRUTOR DE CÓPIA
    public Resposta(Resposta tbResposta){
        this.id          = tbResposta.getId();
        this.resposta    = tbResposta.getResposta();
        this.pergunta_id = tbResposta.getPergunta_id();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(int pergunta_id) {
        this.pergunta_id = pergunta_id;
    }
}
