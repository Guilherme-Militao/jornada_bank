import java.util.Scanner;
public class Main {
	static String[][] usuarios = new String[20][4];// vetor de registro de usuários
	static double[][] conta = new double[20][2];// vetor de registro de usuários
	static boolean logado;
	static int contidx = 0;
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
	public static void registra() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o NOME COMPLETO: ");
		String nome=scan.nextLine();
		
		System.out.println("Informe o CPF: ");
		String cpf=scan.nextLine();
		
		System.out.println("Informe o EMAIL");
		String email=scan.nextLine();
		
		System.out.println("Informe a SENHA: ");
		String senha=scan.nextLine();
		
		usuarios[contidx][0]=nome;
		usuarios[contidx][1]=cpf;
		usuarios[contidx][2]=email;
		usuarios[contidx][3]=senha;
		
		
		System.out.println("Usuario registrado com sucesso !");
		
		contidx++;

		
	}
	public static void imprimeUsuarios() {

		for (int i = 0; i < contidx; i++) {

			for (int j = 0; j <4; j++) {

				System.out.println(usuarios[i][j]);
			}

			System.out.println();
		}

	}

	public static void criarConta(){
		boolean finded = false;
		Scanner scan =  new Scanner(System.in);
		System.out.println("Informe o cpf do titular: ");
		String cpf = scan.nextLine();
		System.out.println("Informe a senha do titular: ");
		String senha = scan.nextLine();

		for (int i =0;i<=contidx;i++){

			if(cpf.equalsIgnoreCase(usuarios[i][1]) && senha.equals(usuarios[i][3])){

				conta[i][0]= i;
				conta[i][1]=0.0;

				System.out.println("Conta criada com sucesso! ");
				finded = true;
				break;

			}

		}
		if(!finded){
			System.out.println("Usuario não encontrado! ");
		}

	}
}