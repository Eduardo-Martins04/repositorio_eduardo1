package martins.eduardo.uno.morintegracaocomjava.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_aluno"
    ,indices = {@Index(value = "id", unique = true)})


public class Aluno {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome, celular, email, gitHubUsuario;

    public Aluno(){}

    //CONSTRUTOR DE CÓPIA
    public Aluno(Aluno tbAluno){
        this.id            = tbAluno.getId();
        this.nome          = tbAluno.getNome();
        this.celular       = tbAluno.getCelular();
        this.email         = tbAluno.getEmail();
        this.gitHubUsuario = tbAluno.getGitHubUsuario();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGitHubUsuario() {
        return gitHubUsuario;
    }

    public void setGitHubUsuario(String github_usuario) {
        this.gitHubUsuario = github_usuario;
    }
}
