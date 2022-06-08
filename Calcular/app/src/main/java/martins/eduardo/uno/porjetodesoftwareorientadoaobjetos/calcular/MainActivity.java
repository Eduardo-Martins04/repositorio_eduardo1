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
    public static final String DIVIDIR = "Dividir";
    public static final String MULTIPLICAR = "Multiplicar";
    public static final String SOMAR = "Somar";
    public static final String SUBTRAIR = "Subtrair";
    private int ZERO = 0;
    private Spinner spiOpcoes;
    private EditText edtNumero1, edtNumero2;
    private ImageView imgOperacao, imgLimpar;
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
        imgLimpar   = findViewById(R.id.imgLimpar);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        imgOperacao.setVisibility(View.INVISIBLE);


        ArrayAdapter<String> adapterOperacoes = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item // aparecer um em baixo do outro
                , getResources().getStringArray(R.array.operacoes_matematica)); // conteudo que vai aparecer
        adapterOperacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoes);
        spiOpcoes.setOnItemSelectedListener(this);//this usada como argumento de metodo



       btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if()*/
                //PEGA A OPCAO SELECIONADA DO SPINNER
                String operacaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if(operacaoSelecionada.equals(DIVIDIR)){// == "Dividir"
                    if(validarTermoVazio()){
                        if (verificaDivisao0()){
                            tvResultado.setText(dividir());
                        } else {
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a divisão", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(MULTIPLICAR)){// == "Multiplicar"
                    if(validarTermoVazio()){
                        tvResultado.setText(multiplicar());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a multiplicação", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(SOMAR)){// == "Somar"
                    if(validarTermoVazio()){
                        tvResultado.setText(somar());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a soma", Toast.LENGTH_SHORT).show();
                    }


                } else if (operacaoSelecionada.equals(SUBTRAIR)){// == "Subtrair"
                    if(validarTermoVazio()){
                        tvResultado.setText(subtrair());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a subtração", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(MainActivity.this, "Selecione uma operação matematica", Toast.LENGTH_SHORT).show();
                }

                //tvResultado.setText(operacaoSelecionada);
            }

       });

       imgLimpar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edtNumero1.setText("");
               edtNumero2.setText("");
               tvResultado.setText("");
               //imgOperacao.setVisibility(View.INVISIBLE);
           }
       });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if(adapterView.getItemAtPosition(i).toString().equals(DIVIDIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.divisao, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Dividendo");
            edtNumero2.setHint("Divisor");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.multiplica, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Multiplicando");
            edtNumero2.setHint("Multiplicador");

        } else if(adapterView.getItemAtPosition(i).toString().equals(SOMAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Parcela");
            edtNumero2.setHint("Parcela");


        } else if(adapterView.getItemAtPosition(i).toString().equals(SUBTRAIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.subtracao, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Minuendo");
            edtNumero2.setHint("Subtraendo");

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String dividir() {

            int n1 = Integer.valueOf(edtNumero1.getText().toString()).intValue();
            int n2 = Integer.valueOf(edtNumero2.getText().toString()).intValue();

            int res = n1 / n2;

            return "O resultado da divisão é " + res;
    }

    private String multiplicar() {
            int n1 = Integer.valueOf(edtNumero1.getText().toString()).intValue();
            int n2 = Integer.valueOf(edtNumero2.getText().toString()).intValue();

            int res = n1 * n2;

            return "O resultado da multiplicação é " + res;

    }

    private String somar(){
            int n1 = Integer.valueOf(edtNumero1.getText().toString()).intValue();
            int n2 = Integer.valueOf(edtNumero2.getText().toString()).intValue();

            int res = n1 + n2;

            //return String.valueOf(res);
            return "O resultado da soma é " + res;

    }

    private String subtrair(){
        if(!edtNumero1.getText().toString().isEmpty() || !edtNumero2.getText().toString().isEmpty()){
            int n1 = Integer.valueOf(edtNumero1.getText().toString()).intValue();
            int n2 = Integer.valueOf(edtNumero2.getText().toString()).intValue();

            int res = n1 - n2;

            //return String.valueOf(res);
            return "O resultado da subtração é " + res;
        } else {
            Toast.makeText(this, "Informe 2 numeros para realizar a subtração", Toast.LENGTH_SHORT).show();
            return "";
        }

    }

    private boolean validarTermoVazio(){
        if(!edtNumero1.getText().toString().isEmpty()){
            if (!edtNumero2.getText().toString().isEmpty()){
                return true;
            } else {
                edtNumero2.requestFocus();
                return false;
            }
        } else {
            edtNumero1.requestFocus();
            return false;
        }
    }

    private boolean verificaDivisao0(){
        int n2 = Integer.valueOf(edtNumero2.getText().toString()).intValue();
        if(n2 != ZERO){
            return true;
        } else {
            return false;
        }
    }


}
