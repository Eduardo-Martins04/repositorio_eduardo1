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
        //area calculada por mim
        double areaPapel = 9.9216;

        //setando os lados dos triangulos
        triangulo.setMedidas(0, 4);
        triangulo.setMedidas(1, 5);
        triangulo.setMedidas(2, 6);

        //Calculo do perimetro
        double perimetro = triangulo.getMedidas(0) + triangulo.getMedidas(1) +
                triangulo.getMedidas(2);

        //metade do perimetro
        double semiPerimetro = perimetro / 2;

        //iniciando o calculo da base
        double area1 = semiPerimetro * (semiPerimetro - triangulo.getMedidas(0)) *
                (semiPerimetro - triangulo.getMedidas(1)) *
                (semiPerimetro - triangulo.getMedidas(2));

        //finalizando o calculo da base
        double areaFinal = Math.sqrt(area1);

        assertEquals("A area do triangulo é: ", areaPapel, areaFinal, DIFERENCA_ACEITAVEL);

    }

}
