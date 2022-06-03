package martins.eduardo.uno.prova1eduardomauricio;

public class PerguntasRespostas {



    public String pergunta2(){
        return "2) Cite pelo menos 3 situações onde a referência “this” pode ser " +
                "usada. E onde não pode ser usada?";
    }

    public String resposta2(){
        return "Pode ser usada para: \n1 - Chamar um construtor do proprio objeto; \n" +
                "2 - Acessar uma instancia dentro de uma classe interna; \n" +
                "3 - Usar como argumento de um metodo de outro classe que vai chamar " +
                "quando dejesa passar o proprio objeto.\n" +
                "Não pode ser utilizado fora do escopo da classe.";
    }

    public String pergunta3(){
        return "3) Quais detalhes importantes podem ser observados na " +
                "declaração de uma classe Java?";
    }

    public String resposta3(){
        return "Para criar uma classe utiliza o modificador de acesso, palavra reservada class e o nome da classe que " +
                "deve ser iniciar com letra maiúscula e a primeira letra de novos palavras também devem ser maiúscula. \n" +
                "Exemplo: public class PerguntasRespostas{}";

    }

    public String pergunta4(){
        return "4) Explique o conceito de escopo presente na linguagem Java.";
    }

    public String resposta4(){
        return "É a vida de uma variável no Java, trata dos locais nos quais ela pode ou não ser acessada, " +
                "o escopo de variáveis vai de acordo com o bloco onde ela foi declarada, a variável é criada no primeiro acesso. " +
                "Temos como exemplo o atributo de método, que só pode ser utilizado dentro do método onde ele foi declarado e " +
                "o atributo de classe que só pode ser utilizado dentro da classe.";
    }

    public String pergunta5(){
        return "5) Como funciona a sobrecarga (overload) de métodos no Java?";
    }

    public String resposta5(){
        return "É utilizada para criar vários métodos diferentes com o mesmo nome, porém com assinaturas diferentes, " +
                "cada um com sua própria lista de argumentos e implementação.";
    }

    public String pergunta6(){
        return "6) Explique o conceito de cast. Quais os tipos existentes?";
    }

    public String resposta6(){
        return "Cast é uma conversão, é utilizado para converter um valor de um tipo para outro. \n" +
                "Exemplo: converter um tipo de dado 'float' para 'int'. \n" +
                "Existe dois tipos de conversões: Explicitas e Implícitas.";
    }

}
