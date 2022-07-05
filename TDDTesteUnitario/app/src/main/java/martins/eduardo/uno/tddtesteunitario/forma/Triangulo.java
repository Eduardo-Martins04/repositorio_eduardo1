package martins.eduardo.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO = 3;

    /*public Triangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Triangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO);
    }

    @Override
    public double area() {
        double perimetro = getMedidas(0) + getMedidas(1) + getMedidas(2);

        double semiPerimetro = perimetro / 2;

        double area = semiPerimetro * (semiPerimetro - getMedidas(0)) *
                (semiPerimetro - getMedidas(1)) *
                (semiPerimetro - getMedidas(2));

        return Math.sqrt(area);
    }
}
