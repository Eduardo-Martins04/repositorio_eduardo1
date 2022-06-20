package martins.eduardo.uno.conceitosclassesabstrataseinterfaces.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import martins.eduardo.uno.conceitosclassesabstrataseinterfaces.R;


public class CircunferenciaFrag extends Fragment {


    public CircunferenciaFrag() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutFragment = inflater.inflate(R.layout.fragment_circunferencia, container, false);

        return layoutFragment;
    }
}