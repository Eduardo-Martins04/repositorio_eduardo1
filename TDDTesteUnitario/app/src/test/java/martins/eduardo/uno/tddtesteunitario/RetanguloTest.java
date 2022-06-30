package martins.eduardo.uno.tddtesteunitario;

import org.junit.Test;
import static org.junit.Assert.*;


import martins.eduardo.uno.tddtesteunitario.forma.Retangulo;

public class RetanguloTest {

    private static Retangulo retangulo = new Retangulo();


    @Test
    public void calcularAreaDoRetangulo(){
        double area_Base5Altura2 = 10;
        int PRECISAO_4_CASAS_DECIMAIS = 4;

        retangulo.setMedidas(0, 3);
        retangulo.setMedidas(1, 8);

        double area = retangulo.getMedidas(0) * retangulo.getMedidas(1);

        assertEquals("A area de uma de um retangulo de base 5 e altura 2 é: 10", area_Base5Altura2,
                area, PRECISAO_4_CASAS_DECIMAIS);

    }

    @Test
    public void calcularPerimetroRetangulo(){
        double perimetro_Base5Altura2 = 20;
        int PRECISAO_4_CASAS_DECIMAIS = 4;

        retangulo.setMedidas(0, 5);
        retangulo.setMedidas(1, 2);

        double perimetro = retangulo.area() * 2;

        assertEquals("O perimetro de um retangulo de base 5 e altura 2 é: 20", perimetro_Base5Altura2,
                perimetro, PRECISAO_4_CASAS_DECIMAIS);
    }
}
