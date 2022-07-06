package martins.eduardo.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO = 3;
    private static final int POSICAO_ZERO = 0;
    private static final int POSICAO_UM   = 1;
    private static final int POSICAO_DOIS = 2;



    /*public Triangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Triangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO); // CHAMANDO A CLASSE PAI/FORMA
    }

    @Override
    public double area() {
        double perimetro = getMedidas(POSICAO_ZERO) + getMedidas(POSICAO_UM)
                + getMedidas(POSICAO_DOIS);

        double semiPerimetro = perimetro / 2;

        double area = semiPerimetro * (semiPerimetro - getMedidas(POSICAO_ZERO)) *
                (semiPerimetro - getMedidas(POSICAO_UM)) *
                (semiPerimetro - getMedidas(POSICAO_DOIS));

        return Math.sqrt(area);
    }
}
