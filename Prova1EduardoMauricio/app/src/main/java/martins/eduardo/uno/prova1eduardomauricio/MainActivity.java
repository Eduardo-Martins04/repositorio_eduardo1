package martins.eduardo.uno.prova1eduardomauricio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imgCheck, imgLimpar;
    private TextView tvPergunta, tvResposta;
    private EditText edtNumeroQuestao;
    private static int QUESTAO02 = 2;
    private static int QUESTAO03 = 3;
    private static int QUESTAO04 = 4;
    private static int QUESTAO05 = 5;
    private static int QUESTAO06 = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCheck         = findViewById(R.id.imgCheck);
        imgLimpar        = findViewById(R.id.imgLimpar);
        tvPergunta       = findViewById(R.id.tvPergunta);
        tvResposta       = findViewById(R.id.tvResposta);
        edtNumeroQuestao = findViewById(R.id.edtNumeroQuestao);

        PerguntasRespostas perguntasRespostas = new PerguntasRespostas();


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Desenvolvedores em TI");
        }

        imgLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPergunta.setText("");
                tvResposta.setText("");
                edtNumeroQuestao.setText("");
            }
        });

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtNumeroQuestao.getText().toString().isEmpty()){
                    if (Integer.valueOf(edtNumeroQuestao.getText().toString()) >= QUESTAO02 && Integer.valueOf(edtNumeroQuestao.getText().toString()) <= QUESTAO06){

                        int numeroQuestao = Integer.valueOf(edtNumeroQuestao.getText().toString());

                        if(numeroQuestao == QUESTAO02){
                            tvPergunta.setText(perguntasRespostas.pergunta2());
                            tvResposta.setText(perguntasRespostas.resposta2());
                            //tvPergunta.setText(String.valueOf(numeroQuestao));
                        }

                        if(numeroQuestao == QUESTAO03){
                            tvPergunta.setText(perguntasRespostas.pergunta3());
                            tvResposta.setText(perguntasRespostas.resposta3());
                        }

                        if(numeroQuestao == QUESTAO04){
                            tvPergunta.setText(perguntasRespostas.pergunta4());
                            tvResposta.setText(perguntasRespostas.resposta4());
                        }

                        if(numeroQuestao == QUESTAO05){
                            tvPergunta.setText(perguntasRespostas.pergunta5());
                            tvResposta.setText(perguntasRespostas.resposta5());
                        }

                        if(numeroQuestao == QUESTAO06){
                            tvPergunta.setText(perguntasRespostas.pergunta6());
                            tvResposta.setText(perguntasRespostas.resposta6());
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Digite um número de 2 a 6!!!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Por favor informe o número da questão!!!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}