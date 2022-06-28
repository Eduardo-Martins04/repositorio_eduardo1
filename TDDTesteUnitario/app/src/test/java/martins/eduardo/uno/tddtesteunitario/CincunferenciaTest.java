package martins.eduardo.uno.tddtesteunitario;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import martins.eduardo.uno.tddtesteunitario.forma.Circunferencia;


public class CincunferenciaTest {
    private static Circunferencia circunferencia = new Circunferencia(1);


    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){
        double raio;
        boolean validar;

        //Circunferencia circunferencia = new Circunferencia(1);
        circunferencia.setMedidas(0, 1);

        //posicao 0 pq a circunferencia precisa de apenas 1 informação para calcular a area
        raio = circunferencia.getMedida(0);

        validar = raio > 0;
        assertTrue(validar);

        /*if(raio > 0){
            assertTrue(validar);
        }*/
    }

    @Test
    public void deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea(){
        //boolean tamanhoValido = circunferencia.setMedidas(0, 1) > circunferencia;
    }



}
