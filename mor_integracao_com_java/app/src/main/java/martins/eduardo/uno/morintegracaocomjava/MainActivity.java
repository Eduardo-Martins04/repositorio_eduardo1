package martins.eduardo.uno.morintegracaocomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import martins.eduardo.uno.morintegracaocomjava.database_app.tabelas.Aluno;

public class MainActivity extends AppCompatActivity {
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aluno = new Aluno();
        aluno.setNome("Eduardo Martins");
        aluno.setCelular("4998838-9944");
        aluno.setEmail("dudumartinss2004@gma.com");
        aluno.setGitHubUsuario("Eduardo-Martins04");


    }
}