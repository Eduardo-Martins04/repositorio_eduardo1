package martins.eduardo.uno.porjetodesoftwareorientadoaobjetos.calcular;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.KeyListener;
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
//teste commit
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DIVIDIR       = "Dividir";
    public static final String MULTIPLICAR   = "Multiplicar";
    public static final String SOMAR         = "Somar";
    public static final String SUBTRAIR      = "Subtrair";
    public static final String RAIZ_QUADRADA = "Raiz Quadrada";
    public static final String LOGARITMO     = "Logaritimo";
    public static final String POTENCIACAO   = "Potenciação";
    public static final String POTENCIA_10   = "Potencia de 10";
    private int ZERO                         = 0;
    private int BASE_DEZ                     = 10;
    private Spinner spiOpcoes;
    private EditText edtNumero1, edtNumero2;
    private ImageView imgOperacao, imgLimpar;
    private TextView tvResultado;
    private Button btnCalcular;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Calculadora");
        }

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

                //PEGA A OPCAO SELECIONADA DO SPINNER
                String operacaoSelecionada = spiOpcoes.getSelectedItem().toString();

                //Operações Basicas

                if(operacaoSelecionada.equals(DIVIDIR)){
                    if(validarTermosVazios()){
                        if (verificaDivisao0()){
                            tvResultado.setText(dividir());
                        } else {
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a divisão", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(MULTIPLICAR)){
                    if(validarTermosVazios()){
                        tvResultado.setText(multiplicar());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a multiplicação", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(SOMAR)){
                    if(validarTermosVazios()){
                        tvResultado.setText(somar());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a soma", Toast.LENGTH_SHORT).show();
                    }

                } else if (operacaoSelecionada.equals(SUBTRAIR)){
                    if(validarTermosVazios()){
                        tvResultado.setText(subtrair());
                    } else {
                        Toast.makeText(MainActivity.this, "Insira 2 numeros para realizar a subtração", Toast.LENGTH_SHORT).show();
                    }

                 // Operações complexas

                } else if(operacaoSelecionada.equals(RAIZ_QUADRADA)){
                    if(validaPrimeiroTermo()){
                        tvResultado.setText(raizQuadrada());
                    } else {
                        Toast.makeText(MainActivity.this, "Informe o RADICANDO", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(LOGARITMO)){
                    if(validarTermosVazios()){
                        tvResultado.setText(logaritmo());
                    } else {
                        Toast.makeText(MainActivity.this, "Informe 2 numeros para calcular o logaritmo", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(POTENCIA_10)){
                    if (validaPrimeiroTermo()){
                        tvResultado.setText(potencia10());
                    } else {
                        Toast.makeText(MainActivity.this, "Informe o EXPOENTE", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(POTENCIACAO)){
                    if(validarTermosVazios()){
                        tvResultado.setText(potenciacao());
                    } else {
                        Toast.makeText(MainActivity.this, "Informe a BASE e o EXPOENTE", Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    Toast.makeText(MainActivity.this, "Selecione uma operação matematica", Toast.LENGTH_SHORT).show();
                }
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
        bloquear(false);

        if(adapterView.getItemAtPosition(i).toString().equals(DIVIDIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.divisao, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero2.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Dividendo");
            edtNumero2.setHint("Divisor");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.multiplica, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero2.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Multiplicando");
            edtNumero2.setHint("Multiplicador");


        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero2.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Parcela");
            edtNumero2.setHint("Parcela");


        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRAIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.subtracao, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero2.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Minuendo");
            edtNumero2.setHint("Subtraendo");


        } else if (adapterView.getItemAtPosition(i).toString().equals(RAIZ_QUADRADA)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.raiz_quadrada, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero1.setHint("Radicando");
            bloquear(true);


        } else if (adapterView.getItemAtPosition(i).toString().equals(LOGARITMO)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.logaritmo, getTheme()));
            imgOperacao.setVisibility(View.VISIBLE);
            edtNumero2.setVisibility(View.VISIBLE);


        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIACAO)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.potenciacao, getTheme()));
            edtNumero1.setHint("Base");
            edtNumero2.setHint("Expoente");
            edtNumero2.setVisibility(View.VISIBLE);


        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIA_10)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.potencia10, getTheme()));
            edtNumero1.setHint("Expoente");
            bloquear(true);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //FUNÇÕES PARA CALCULAR OPERAÇÕES BASICAS
    private String dividir() {
            double n1 = Double.parseDouble(edtNumero1.getText().toString());
            double n2 = Double.parseDouble(edtNumero2.getText().toString());

            double res = n1 / n2;

            return "O resultado da divisão é " + res;
    }

    private String multiplicar() {
            double n1 = Double.parseDouble(edtNumero1.getText().toString());
            double n2 = Double.parseDouble(edtNumero2.getText().toString());

            double res = n1 * n2;

            return "O resultado da multiplicação é " + res;
    }

    private String somar(){
            double n1 = Double.parseDouble(edtNumero1.getText().toString());
            double n2 = Double.parseDouble(edtNumero2.getText().toString());

            double res = n1 + n2;

            return "O resultado da soma é " + res;
    }

    private String subtrair(){
            double n1 = Double.parseDouble(edtNumero1.getText().toString());
            double n2 = Double.parseDouble(edtNumero2.getText().toString());

            double res = n1 - n2;

            //return String.valueOf(res);
            return "O resultado da subtração é " + res;

    }

    //FUNÇÕES DE VERIFICAÇÕES DE DADOS
    private boolean validarTermosVazios(){
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

    private boolean validaPrimeiroTermo(){
        if(!edtNumero1.getText().toString().isEmpty()){
            return true;
        } else {
            edtNumero1.requestFocus();
            return false;
        }
    }

    private boolean verificaDivisao0(){
        Double n2 = Double.parseDouble(edtNumero2.getText().toString());
        if(n2 != ZERO){
            return true;
        } else {
            return false;
        }
    }

    // FUNÇÕES PARA CALCULAR OPERAÇOES COMPLEXAS
    private String raizQuadrada(){
        double n1 = Double.parseDouble(edtNumero1.getText().toString());
        double res = Math.sqrt(n1);
        String format = String.format("%.2f", res);

        return "A raiz quadrada de " + n1 + " é " + format;
    }

    private String logaritmo(){
        double n1 = Double.parseDouble(edtNumero1.getText().toString());
        double n2 = Double.parseDouble(edtNumero2.getText().toString());

        double res = Math.log(n1/n2);

        return "O logaritmo é "+ res;
    }

    private String potencia10(){
        double n1 = Double.parseDouble(edtNumero1.getText().toString());

        double res = Math.pow(BASE_DEZ, n1);

        return "O resultado da potencia de 10 é " + res;
    }

    private String potenciacao(){
        double n1 = Double.parseDouble(edtNumero1.getText().toString());
        double n2 = Double.parseDouble(edtNumero2.getText().toString());

        double res = Math.pow(n1, n2);

        return "o resultado da potenciação é " + res;
    }



    private void bloquear(boolean block){
        if(block){
            //edtNumero2.setFocusable(false);
            //edtNumero2.setKeyListener(null);
            edtNumero2.setEnabled(false);
        } else {
            edtNumero2.setFocusable(true);
            //edtNumero2.getKeyListener();
            edtNumero2.setEnabled(true);
        }
    }

}
