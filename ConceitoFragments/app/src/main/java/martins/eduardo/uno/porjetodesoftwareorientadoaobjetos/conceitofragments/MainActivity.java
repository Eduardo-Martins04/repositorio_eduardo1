package martins.eduardo.uno.porjetodesoftwareorientadoaobjetos.conceitofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {
    /*private TextView tvtexto;
    private EditText edtInformarTexto;
    private Button btnAlteralTexto;
    private SeekBar skbFormatarTexto;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*tvtexto = findViewById(R.id.tvTexto);
        edtInformarTexto = findViewById(R.id.edtInformarTexto);
        btnAlteralTexto = findViewById(R.id.btnAlterarTexto);
        skbFormatarTexto = findViewById(R.id.skbFormatarTexto);

        skbFormatarTexto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvtexto.setTextSize(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnAlteralTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvtexto.setText(edtInformarTexto.getText());
            }
        });*/


    }
    @Override
    public void onButtonClick(int position, String texto) {
        TextoFragment tvTexto = (TextoFragment) getSupportFragmentManager().findFragmentById(R.id.frgTexto);
        tvTexto.trocarPropriedadeDoTexto(position, texto);

    }
}