package martins.eduardo.uno.porjetodesoftwareorientadoaobjetos.conceitofragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.net.InterfaceAddress;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private static int textSize = 15; //tamannho inicial da fonte
    private EditText edtInformarTexto;
    private SeekBar skbFormatarTexto;
    private Button btnAlterarTexto;
    private ToolbarListener toolbarListener;

    public interface ToolbarListener{
        public void onButtonClick(int position, String texto);

    }

    public ToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View toolbarLayoutInflater = inflater.inflate(R.layout.fragment_tool_bar, container, false);

        edtInformarTexto = toolbarLayoutInflater.findViewById(R.id.edtInformarTexto);
        skbFormatarTexto = toolbarLayoutInflater.findViewById(R.id.skbFormatarTexto);
        btnAlterarTexto  = toolbarLayoutInflater.findViewById(R.id.btnAlterarTexto);

        btnAlterarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        skbFormatarTexto.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);

        return toolbarLayoutInflater;

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            toolbarListener = (ToolbarListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                + "Obrigatorio implementar a interface ToolbarListener");
        }
    }

    public void buttonClicked(View view){
            toolbarListener.onButtonClick(textSize, edtInformarTexto.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textSize = progress;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



}