package martins.eduardo.uno.tddtesteunitario;

import org.junit.Test;
import static org.junit.Assert.*;



import martins.eduardo.uno.tddtesteunitario.forma.Retangulo;

public class RetanguloTest {

    private static Retangulo retangulo          = new Retangulo();
    double DIFERENCA_ACEITAVEL                  = 0.0001;
    public static final int POSICAO_ZERO_BASE   = 0;
    public static final int POSICAO_UM_ALTURA   = 1;



    @Test
    public void calcularAreaDoRetangulo(){
        double area_BaseXAltura = 10;


        retangulo.setMedidas(POSICAO_ZERO_BASE, 5);
        retangulo.setMedidas(POSICAO_UM_ALTURA, 2);

        //double baser = retangulo.getMedidas(0);
        //double alturar = retangulo.getMedidas(1);
        double area = retangulo.getMedidas(POSICAO_ZERO_BASE) * retangulo.getMedidas(POSICAO_UM_ALTURA);

        assertEquals("A area de um retangulo: " + area_BaseXAltura, area_BaseXAltura,
                area, DIFERENCA_ACEITAVEL);
        /*Double calculoPapel = new Double(area_BaseXAltura);
        boolean x = calculoPapel.equals(new Double(area));
        assertTrue(x);*/

    }

    @Test
    public void calcularPerimetroRetangulo(){
        double perimetro_BaseXAlturaY = 14;

        retangulo.setMedidas(POSICAO_ZERO_BASE, 2);
        retangulo.setMedidas(POSICAO_UM_ALTURA, 5);

        double perimetro = 2 * (retangulo.getMedidas(POSICAO_ZERO_BASE) + retangulo.getMedidas(POSICAO_UM_ALTURA));

        assertEquals("O perimetro de um retangulo de base 5 e altura 2 é: 20", perimetro_BaseXAlturaY,
                perimetro, DIFERENCA_ACEITAVEL);
    }
}
