import java.util.Scanner;

public class globalSolution2 {

    static Scanner input = new Scanner(System.in);
    static int aux = 0;

    static String[] raca = new String[50];
    static double[] peso = new double[50];
    static int[] idade = new int[50];

    static String[] codigoUnico = new String[50];
    static String[] codigoCriptografado = new String[50];

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int menuLogin = 0;

        System.out.println("=============MENU=============");
        System.out.println("1-[CADASTRAR]");
        System.out.println("2-[RELATÓRIO]");
        System.out.println("3-[PESQUISA]");
        System.out.println("Escolha alguma opção acima");
        menuLogin = input.nextInt();

        while (menuLogin > 3) {
            System.out.println("Numero inválido, por favor digite um numero correto, somente até a 3");
            menuLogin = input.nextInt();
        }

        if (menuLogin == 1) {
            aux++;
            cadastro();
        } else if (menuLogin == 2) {
            relatorio();
        } else {
            pesquisa();
        }
    }

    public static void cadastro() {
        if (aux == 50){
            System.out.println("Desculpe, nosso servidor está cheio :(");
            System.out.println("Utilize nossos outros serviços");
            menu();
        }
        int subMenu = 0;
        System.out.println("============= SUBMENU =============");
        System.out.println("1-[BOVINO]");
        System.out.println("2-[SUINO]");
        System.out.println("3-[CAPRINO]");
        System.out.println("Digite a opção escolhida");
        subMenu = input.nextInt();

        while (subMenu > 3) {
            System.out.println("Numero inválido, por favor digite um numero correto, somente até a 3");
            subMenu = input.nextInt();
        }


        for (int i = 1; i <= aux; i++) {
            System.out.print("Digite a raça do animal: ");
            raca[aux] = input.next();

            System.out.print("Digite o peso do animal: ");
            peso[aux] = input.nextInt();

            System.out.print("Digite a idade do animal: ");
            idade[aux] = input.nextInt();


            //================================================
            String[] letra = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                    "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C"};
            StringBuilder codigo = new StringBuilder();
            StringBuilder codigoCifras = new StringBuilder();
            StringBuilder deslocamento = new StringBuilder();
            int posicaoLetras = 0;
            for (int r = 0; r < 3; r++) {
                posicaoLetras = (int) (Math.random() * 26);
                codigo.append(letra[posicaoLetras]);
                codigoCifras.append(letra[posicaoLetras + 3]);
            }
            int quantCifras = 0;
            System.out.print("Digite o numero de cifras, para terminar o cadastro: ");
            quantCifras = input.nextInt();
            for (int r = 0; r < quantCifras; r++) {
                posicaoLetras = (int) (Math.random() * 26);
                deslocamento.append(letra[posicaoLetras]);
            }
            //================================================

            if (subMenu == 1) {
                codigoBovino(letra, codigo, codigoCifras, deslocamento);

            } else if (subMenu == 2) {
                codigoSuino(letra, codigo, codigoCifras, deslocamento);

            } else {
                codigoCaprino(letra, codigo, codigoCifras, deslocamento);

            }
            menu();
        }
    }

    public static void codigoBovino(String[] letra, StringBuilder codigo, StringBuilder codigoCifras, StringBuilder deslocamento) {
        for (int i = 1; i <= aux; i++) {
            codigoUnico[aux] = (letra[1] + letra[14] + codigo);
            codigoCriptografado[aux] = (letra[1 + 3] + letra[14 + 3] + codigoCifras + deslocamento);
        }
    }

    public static void codigoSuino(String[] letra, StringBuilder codigo, StringBuilder codigoCifras, StringBuilder deslocamento) {
        for (int i = 1; i <= aux; i++) {
            codigoUnico[aux] = (letra[18] + letra[20] + codigo);
            codigoCriptografado[aux] = (letra[18 + 3] + letra[20 + 3] + codigoCifras + deslocamento);
        }
    }

    public static void codigoCaprino(String[] letra, StringBuilder codigo, StringBuilder codigoCifras, StringBuilder deslocamento) {
        for (int i = 1; i <= aux; i++) {
            codigoUnico[aux] = (letra[2] + letra[0] + codigo);
            codigoCriptografado[aux] = (letra[2 + 3] + letra[0 + 3] + codigoCifras + deslocamento);
        }
    }

    public static void relatorio() {
        for (int i = 1; i <= aux; i++) {
            System.out.println("=========== ANIMAL CADASTRADO " + i + " ===========");
            System.out.println("Raça: " + raca[i]);
            System.out.println("Peso: " + peso[i]);
            System.out.println("Idade: " + idade[i]);
            System.out.println("Codigo: " + codigoUnico[i]);
            System.out.println("Codigo Criptografado: " + codigoCriptografado[i]);
            System.out.println("");
        }
        System.out.println("Deseja continuar no programa? (S/N) ");
        String resp = input.next().toUpperCase();
        if (resp.equalsIgnoreCase("N")) {
            System.exit(0);
        } else {
            menu();
        }
    }

    public static void pesquisa() {
        System.out.println("Coloque o código para ver se o animal está registado: ");
        String registo = input.next().toUpperCase();

        String a = "";
        double b = 0;
        int c = 0;
        for (int i = 1; i <= aux; i++) {
            if (registo.equalsIgnoreCase(codigoCriptografado[i])) {
                a = raca[i];
                b = peso[i];
                c = idade[i];
            }
        }

        if (a.equalsIgnoreCase("") && (b == 0) && (c==0)){
            System.out.println("Não temos esse código no registro");
        } else {
            System.out.println("Raça: "+a);
            System.out.println("Peso: "+b);
            System.out.println("Idade: "+c);
        }
        System.out.println("Deseja continuar no programa? (S/N) ");
        String resp = input.next().toUpperCase();
        if (resp.equalsIgnoreCase("N")) {
            System.exit(0);
        } else {
            menu();
        }
    }
}
