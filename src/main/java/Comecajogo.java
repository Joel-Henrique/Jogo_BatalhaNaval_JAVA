import java.util.Scanner;
//O tabuleiro possui as colunas numeradas de 1 á 10 e as linhas
//de A até J (10 x 10).

public class Comecajogo {
    private static int Recordista = 100;

    public static String getRecordista_Nome() {
        return Recordista_Nome;
    }

    private static String Recordista_Nome = "";

    public static int getRecordista() {
        return Recordista;
    }

    public Comecajogo() {
        int lin,col;
        Scanner ler = new Scanner(System.in);
        String nome;
        System.out.print("Informe o nome do primeiro Comandante:\n");
        nome = ler.nextLine();
        Jogador JG1 = new Jogador(nome);


        System.out.print("Informe o nome do segundo Comandante:\n");
        nome = ler.nextLine();
        Jogador JG2 = new Jogador(nome);


        int turno = 0;
        for(; (JG1.getParte_navios_Restantes() > 0) && (JG2.getParte_navios_Restantes() > 0) ;) {
            turno++;
            System.out.println("Comandante "+ JG1.getNome() +" Atacando: ");
            System.out.println("Digite uma Linha: ");
            lin = LerInt();
            System.out.println("Digite uma Coluna: ");
            col = LerInt();
            JG2.Atacado(lin, col);
            JG2.TabuleiroMascarado();

            System.out.println("Comandante "+ JG2.getNome() +" Atacando: ");
            System.out.println("Digite uma Linha: ");
            lin = LerInt();
            System.out.println("Digite uma Coluna: ");
            col = LerInt();
            JG1.Atacado(lin, col);
            JG1.TabuleiroMascarado();
        }

        if((JG1.getParte_navios_Restantes() > 0)){
            System.out.println("Comandante "+ JG1.getNome() + " Ganhou no Turno: " + turno);
            if(turno < Recordista){
                System.out.println("Parabéns Comandante "+ JG1.getNome() + " você eh o novo recordista: ");
                Recordista = turno;
                Recordista_Nome = JG1.getNome();
            }
        }else {
            System.out.println("Comandante " + JG2.getNome() + " Ganhou no Turno: " + turno);
            if(turno < Recordista){
                System.out.println("Parabéns Comandante "+ JG2.getNome() + " você eh o novo recordista: ");
                Recordista = turno;
                Recordista_Nome = JG2.getNome();
            }
        }

    }
    private int LerInt(){
        Scanner teclado = new Scanner(System.in);
        int x;
        try {
            x = teclado.nextInt();
        }catch(Exception e){
            System.out.print("Numero invalido! Digite novamente: ");
            x = LerInt();
        }
        return x;
    }

}
