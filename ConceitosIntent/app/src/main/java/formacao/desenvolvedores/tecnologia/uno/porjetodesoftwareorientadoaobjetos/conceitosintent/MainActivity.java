package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent.utils.app.UtilsApp;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Main";
    private Button btnPerguntar;
    private TextView tvExibirRespota;
    private TextView tvTitulo;
    private EditText edtPergunta;
    private ImageButton btnDelete;
    public static final int REQUEST_CODE = 5;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPerguntar    = findViewById(R.id.btnPerguntar);
        tvExibirRespota = findViewById(R.id.tvExibirResposta);
        edtPergunta     = findViewById(R.id.edtPergunta);
        btnDelete       = findViewById(R.id.btnDelete);
        tvTitulo        = findViewById(R.id.tvTitulo);


        tvTitulo.setVisibility(View.INVISIBLE);


        btnPerguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtPergunta.getText().toString().isEmpty()){

                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.R){
                        Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);

                        String conteudo = edtPergunta.getText().toString();
                        irParaOutraActivity.putExtra("Pergunta", conteudo);

                        startActivityForResult(irParaOutraActivity, REQUEST_CODE);

                    } else {
                        openActivityForResult();
                    }



                } else {
                    Toast.makeText(MainActivity.this, "Insira uma pergunta", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPergunta.setText("");
                tvExibirRespota.setText("");
            }
        });

        //Novo jeito em execução
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    //tvExibirRespota.setText(data.getExtras().toString());
                    tvExibirRespota.setText(data.getExtras().getString("returnData"));
                    tvTitulo.setVisibility(View.VISIBLE);
                }
            }
        });

        UtilsApp utilsApp = new UtilsApp();
        Log.d(TAG, "Valor convertido de float p/ int: " + utilsApp.convertToInt(5.1987));

        byte b = -27;
        Log.d(TAG, "Valor convertido de byte p/ int: " + utilsApp.convertToInt(b));

        short s = 2;
        Log.d(TAG, "Valor convertido de short p/ int: " + utilsApp.convertToInt(s));

        long l = 921221654321432L;
        Log.d(TAG, "Valor convertido de long p/ int: " + utilsApp.convertToInt(l));

        Log.d(TAG, "Valor convetido tipo abstrato string p/ int: " + utilsApp.convertToInt(this, "1"));
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString = data.getExtras().getString("returnData");

            if(returnString != null){
                if(!returnString.isEmpty()){
                    tvTitulo.setVisibility(View.VISIBLE);
                    //edtPergunta.setText(returnString);

                }
            }

            tvExibirRespota.setText(returnString);
        }
    }

    //Novo jeito em execução
    private void openActivityForResult(){
        Intent intent2 = new Intent(this, RespostaActivity.class);

        intent2.putExtra("Pergunta", edtPergunta.getText().toString());

        activityResultLauncher.launch(intent2);
    }

}