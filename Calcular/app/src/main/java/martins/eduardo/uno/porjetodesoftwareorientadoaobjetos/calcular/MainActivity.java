package martins.eduardo.uno.porjetodesoftwareorientadoaobjetos.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DIVISAO = "Dividir";
    public static final String MULTIPLICAR = "Multiplicar";
    public static final String SOMA = "Somar";
    public static final String SUBTRAIR = "Subtrair";
    private Spinner spiOpcoes;
    private EditText edtNumero1, edtNumero2;
    private ImageView imgOperacao;
    private TextView tvResultado;
    private Button btnCalcular;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spiOpcoes   = findViewById(R.id.spiOpcoes);
        edtNumero1  = findViewById(R.id.edtNumero1);
        edtNumero2  = findViewById(R.id.edtNumero2);
        imgOperacao = findViewById(R.id.imgOperacao);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        imgOperacao.setVisibility(View.INVISIBLE);


        ArrayAdapter<String> adapterOperacoes = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.operacoes_matematica));
        adapterOperacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoes);
        spiOpcoes.setOnItemSelectedListener(this);//this usada como argumento de metodo

        //PEGA A OPCAO SELECIONADA DO SPINNER
        String operacaoSelecionada = spiOpcoes.getSelectedItem().toString();

       btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operacaoSelecionada == DIVISAO){// == "Dividir"
                    Toast.makeText(MainActivity.this, "DIVISAO", Toast.LENGTH_SHORT).show();
          
                }

                else if(operacaoSelecionada == MULTIPLICAR){// == "Multiplicar"

                }

                else if(operacaoSelecionada == SOMA){// == "Somar"

                }

                else if (operacaoSelecionada == SUBTRAIR){// == "Subtrair"

                }

            }
       });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}