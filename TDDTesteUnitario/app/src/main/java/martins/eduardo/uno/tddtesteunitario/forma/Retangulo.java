package martins.eduardo.uno.tddtesteunitario.forma;

public class Retangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO = 2;
    public static final int POSICAO_ZERO_BASE   = 0;
    public static final int POSICAO_UM_ALTURA   = 1;

    /*public Retangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Retangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO); // CHAMANDO A CLASSE PAI/FORMA
    }

    public double calcularPerimetro(){
        return  2 * (getMedidas(POSICAO_ZERO_BASE) + getMedidas(POSICAO_UM_ALTURA));
    }

    @Override
    public double area() {
        return getMedidas(POSICAO_ZERO_BASE) * getMedidas(POSICAO_UM_ALTURA);
    }
}

