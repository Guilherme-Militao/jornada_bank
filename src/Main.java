import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TELA DE MENU

        System.out.println("*** BEM-VINDO AO JORNADA JORNADA BANK ***");
        System.out.println("O seu banco hoje, amanhã e sempre!\n");
        int continuar=1; // variável de controle para o usuário poder retornar ao menu caso deseje
        while (continuar==1) { //laço while para poder retornar ao menu
            System.out.println("O que deseja fazer? Escolha uma das opções abaixo:");
            System.out.println("""
                    1-Registrar novo usuário
                    2-Criar conta
                    3-Realizar depósito
                    4-Realizar saque
                    5-Realizar transferência""");
            Scanner scanner = new Scanner(System.in);
            int opcao = Integer.parseInt(scanner.nextLine()); //variável que recebe a opção escolhida pelo usuário
            switch (opcao) { //switch case para executar a opção escolhida no menu
                case 1 -> {
                    System.out.println("op1");
                }

                case 2 -> {
                    System.out.println("op2");
                }
            }
            System.out.println("Digite 1 para voltar ao menu ou 2 para encerrar a sesão");
            continuar=Integer.parseInt(scanner.nextLine()); //lê a entrada do usuário e usa a variavel de controle para poder voltar au menu inicial
        }
        System.out.println("---------- SESSÃO ENCERRADA ----------\n"+ "Obrigado pela preferência. Conte sempre o JORNADA BANK!");
    }

    //método de Rgisto de usuário
    public static void RegistrarUsuario(){
       //INSERIR CÓDIGO AQUI

    }
}