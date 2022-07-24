import java.util.Scanner;

public class BatalhaNavalcontrole {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int verifica = 0;
        for (; verifica != 3 ;){
            System.out.println("1 - Começar a partida");
            System.out.println("2 - Exibir recordista");
            System.out.println("3 - Sair do jogo");
            System.out.println("Digite: ");
            verifica = teclado.nextInt();
            switch (verifica) {
                case 1 -> {
                    Comecajogo jogo = new Comecajogo();
                }case 2 -> {
                    System.out.println("O Atual recordista eh o comandante " + Comecajogo.getRecordista_Nome()+" ,que venceu no turno "+ Comecajogo.getRecordista());

                }case 3 -> {
                    System.exit(0); //sai do jogo
                }
                default -> System.out.println("Digite um numero valido!");
            }
        }
    }
}
