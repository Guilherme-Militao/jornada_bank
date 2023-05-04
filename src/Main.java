import java.util.Scanner;
public class Main {
    static String[][] usuarios = new String[20][4];// vetor de registro de usuários
    static double[][] conta = new double[20][2];// vetor de registro de usuários
    static boolean logado;
    static int contidx = 0;
    public static void main(String[] args) {

        //TELA DE MENU

        System.out.println("*** BEM-VINDO AO JORNADA BANK ***");
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
                    registra();
                }

                case 2 -> {
                    criarConta();
                }

                case 3 -> {
                    deposito();
                }

                case 4 -> {
                    saque();
                }

                case 5 -> {
                    transferencia();
                }
                case 6 -> {
                    consultarSaldo();
                }
            }
            System.out.println("Digite 1 para voltar ao menu ou 2 para encerrar a sessão");
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

    //Método de depósito
    public static void deposito(){
        Scanner scan = new Scanner(System.in);
        //informar qual conta que vai depositar
        System.out.println("Informe o CPF do titular da conta: ");
        String cpf = scan.nextLine();
        System.out.println("Informe a ID do titular da conta: ");
        double id = scan.nextDouble();
        scan.nextLine();

        //verificação da conta
        boolean finded = false;
        for (int i =0;i<=contidx;i++){
            if(cpf.equalsIgnoreCase(usuarios[i][1]) && id == conta[i][0]) {
                System.out.println("Titular: " + usuarios[i][0]);
                System.out.println("Saldo atual " + conta[i][1]);
                //criar um deposito
                System.out.println("Informe o valor para o depósito");
                double valor = scan.nextDouble();
                scan.nextLine();


                //caso o valor seja igual ou menor que 0 não pode ser depositado
                if(valor <= 0){
                    System.out.println("Não é possível depositar menos que 0");
                } else {
                    //aumentar valor da conta
                    conta[i][1] += valor;
                    System.out.println("Novo Saldo: " + conta[i][1]);
                }

                finded = true;
                break;
            }

        }

        if(!finded){
            System.out.println("Conta não encontrada!");
        }

    }

    public static void saque(){
        Scanner scan = new Scanner(System.in);
        //informar qual conta que vai sacar
        System.out.println("Informe o CPF do titular da conta: ");
        String cpf = scan.nextLine();
        System.out.println("Informe a senha do titular da conta: ");
        String senha = scan.nextLine();

        //verificação da conta
        boolean finded = false;
        for (int i =0;i<=contidx;i++){
            if(cpf.equalsIgnoreCase(usuarios[i][1]) && senha.equals(conta[i][0])) {
                System.out.println("Titular: " + usuarios[i][0]);
                System.out.println("Saldo atual " + conta[i][1]);
                //fazer um saque
                System.out.println("Informe o valor para o saque");
                double valor = scan.nextDouble();
                scan.nextLine();


                //caso o valor seja igual ou menor que 0 não pode ter saque
                if(valor <= 0){
                    System.out.println("Não é possível sacar o valor informado");
                }else if(conta[i][1] <= 0 || valor > conta[i][1]){
                    System.out.println("Não foi possível sacar, pois o saldo não é suficiente!");
                }
                else {
                    //diminuir valor da conta
                    conta[i][1] -= valor;
                    System.out.println("Novo Saldo: " + conta[i][1]);
                }

                finded = true;
                break;
            }

        }

        if(!finded){
            System.out.println("Conta não encontrada!");
        }

    }

    //método de transferência
    public static void transferencia(){
        boolean finded = false;
        int idxTemp = 0;

        //verificação de conta da conta que realizará a trasnferência
        Scanner scan =  new Scanner(System.in);
        System.out.println("Informe o cpf do titular: ");
        String cpf1 = scan.nextLine();
        System.out.println("Informe a senha do titular: ");
        String senha = scan.nextLine();

        for (int i =0;i<=contidx;i++){
            if(cpf1.equalsIgnoreCase(usuarios[i][1]) && senha.equals(usuarios[i][3])){

                finded = true;
                idxTemp = i;
                //return;
                break;

            }

        }
        if(!finded){
            System.out.println("Conta não encontrada! ");

        }

        //verificação da conta que receberá a transferência
        System.out.println("Informe o CPF do titular da conta depósito: ");
        String cpf2 = scan.nextLine();
        System.out.println("Informe a ID do titular da conta depósito: ");
        double id =scan.nextDouble();
        scan.nextLine();

        for (int i =0;i<=contidx;i++){
            if(cpf2.equalsIgnoreCase(usuarios[i][1]) && id == conta[i][0]){
                System.out.println("Informe o valor da transferência: ");
                double valor= scan.nextDouble();
                scan.nextLine();

                if(valor<=0 || valor>conta[idxTemp][1]){
                    System.out.println("Saldo indisponível!");
                }else{
//					System.out.println("Valor antes da transferência de quem está transferindo "+conta[idxTemp][1]);
//					System.out.println("Valor antes da transferência de quem está recebendo "+conta[i][1]);
                    conta[idxTemp][1]-=valor;
                    conta[i][1]+=valor;
//					System.out.println("Valor depois da transferência de quem está transferindo "+conta[idxTemp][1]);
//					System.out.println("Valor depois da transferência de quem está recebendo "+conta[i][1]);
                    System.out.println("Transferência realizada com sucesso!");
                }

                finded = true;
                break;

            }

        }
        if(!finded){
            System.out.println("Conta não encontrada! ");
        }
    }

    //Método para consultar saldo
    public static void consultarSaldo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o CPF do titular da conta: ");
        String cpf = scan.nextLine();
        System.out.println("Informe a senha do titular da conta: ");
        String senha = scan.nextLine();

        boolean finded = false;
        for (int i =0;i<=contidx;i++){
            if(cpf.equalsIgnoreCase(usuarios[i][1]) && senha.equals(usuarios[i][3])) {
                System.out.println("Titular: " + usuarios[i][0]);
                System.out.println("Saldo atual " + conta[i][1]);

                finded = true;
                break;
            }

        }

        if(!finded){
            System.out.println("Conta não encontrada!");
        }



    }


}