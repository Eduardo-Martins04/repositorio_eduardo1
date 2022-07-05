package martins.eduardo.uno.tddtesteunitario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import martins.eduardo.uno.tddtesteunitario.forma.Triangulo;

public class TrianguloTest {
   private Triangulo triangulo;
    double DIFERENCA_ACEITAVEL = 0.0001;


    @Before
    public void instanciarObjeto (){
        triangulo = new Triangulo();
    }

    @Test
    public void calcularAreaDoTriangulo(){
        double areaPapel = 9.9216;

        triangulo.setMedidas(0, 4);
        triangulo.setMedidas(1, 5);
        triangulo.setMedidas(2, 6);

        double perimetro = triangulo.getMedidas(0) + triangulo.getMedidas(1) +
                triangulo.getMedidas(2);

        double semiPerimetro = perimetro / 2;


        double area1 = semiPerimetro * (semiPerimetro - triangulo.getMedidas(0)) *
                (semiPerimetro - triangulo.getMedidas(1)) *
                (semiPerimetro - triangulo.getMedidas(2));

        double areaFinal = Math.sqrt(area1);

        assertEquals("A area do triangulo é: ", areaPapel, areaFinal, DIFERENCA_ACEITAVEL);

    }

}
