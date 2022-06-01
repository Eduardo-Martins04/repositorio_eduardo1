package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent.utils.app;

import android.content.Context;
import android.widget.Toast;

public class UtilsApp {
    //escopo de classe
    private int soma = 0;


    private void metodo(int x){
        //A variavel x tem escopo local de metodo
    }


    //CONVERSAO P/ TIPOS PRIMITIVOS
    public int convertToInt(double valorDouble){
        //convertendo double em int
        return (int) valorDouble;
    }

    public int convertToInt(byte valorByte){
        return (int) valorByte;
    }

    public int convertToInt(short valorShort){
        return (int) valorShort;
    }

    public int convertToInt(long valorLong){
        return (int) valorLong;
    }

    public int convertToInt(Context context, String objstring){

        try {
            return Integer.parseInt(objstring);
        } catch (NumberFormatException e){
            Toast.makeText(context, "Por favor informe um valor numerico valido", Toast.LENGTH_SHORT).show();
            return 0;
        }

    }

    /*public int convertToInt(String objstring){
        return Integer.valueOf(objstring);
    }*/
}
