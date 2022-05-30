package martins.eduardo.uno.porjetodesoftwareorientadoaobjetos.conceitofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextoFragment extends Fragment {
    private TextView tvTexto;

    public TextoFragment() {
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

        View textoFragmentLayoutInflater = inflater.inflate(R.layout.fragment_texto, container, false);

        tvTexto = textoFragmentLayoutInflater.findViewById(R.id.tvTexto);

        return textoFragmentLayoutInflater;
    }

    public void trocarPropriedadeDoTexto(int i, String x){
        tvTexto.setTextSize(i);
        tvTexto.setText(x);
    }
}