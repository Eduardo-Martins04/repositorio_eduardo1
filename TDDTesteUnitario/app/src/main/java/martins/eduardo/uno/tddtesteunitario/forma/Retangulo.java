package martins.eduardo.uno.tddtesteunitario.forma;

public class Retangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO = 2;
    public static final int BASE = 0;
    public static final int ALTURA = 0;

    /*public Retangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Retangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO);
    }

    public double calcularPerimetro(){
        return  2 * (getMedidas(BASE) + getMedidas(ALTURA));
    }

    @Override
    public double area() {
        return getMedidas(BASE) * getMedidas(ALTURA);
    }
}

