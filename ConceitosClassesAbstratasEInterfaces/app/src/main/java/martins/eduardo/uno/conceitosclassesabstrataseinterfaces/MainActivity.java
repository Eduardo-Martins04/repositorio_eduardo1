package martins.eduardo.uno.conceitosclassesabstrataseinterfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import martins.eduardo.uno.conceitosclassesabstrataseinterfaces.formas.Circunferencia;
import martins.eduardo.uno.conceitosclassesabstrataseinterfaces.formas.Forma;
import martins.eduardo.uno.conceitosclassesabstrataseinterfaces.formas.Retangulo;
import martins.eduardo.uno.conceitosclassesabstrataseinterfaces.formas.Triangulo;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Circunferencia c = new Circunferencia(1.5);
        System.out.println("areaCirc = " + c.area());
        Retangulo r = new Retangulo(2.5, 4.0);
        System.out.println("areaRet = " + r.area());
        Forma formas[] = new Forma[3];
        formas[0] = c;
        formas[1] = r;
        formas[2] = new Triangulo(1.0, 2.0, 2.0);
        for (int i = 0; i < formas.length; i++) {
            System.out.println(formas[i]);
            System.out.println("area = " + formas[i].area());
        }
    }
}