import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Jogador {
    public String getNome() {
        return Nome;
    }

    private String Nome;
    private ContraTorpedeiros contra = new ContraTorpedeiros();
    private Submarinos sub = new Submarinos();
    private NaviosTanque tanque = new NaviosTanque();
    private PortaAvioes porta = new PortaAvioes();
    private int [][]Tabuleiro = new int[10][10];

    public int getParte_navios_Restantes() {
        return Parte_navios_Restantes;
    }

    private int Parte_navios_Restantes = porta.gettam()+ tanque.gettam() + contra.gettam() + sub.gettam();

    public Jogador(String nome) {
        Nome = nome;
        posiciona(porta.gettam());
        posiciona(tanque.gettam());
        posiciona(contra.gettam());
        posiciona(sub.gettam());
    }

    private int LerInt(){
        Scanner teclado = new Scanner(System.in);
        int x;
        try {
            System.out.print("Digite um numero: ");
            x = teclado.nextInt();
        }catch(Exception e){
            System.out.println("Numero invalido! Digite novamente: ");
            x = LerInt();
        }
        return x;
    }
    private char LerChar(){
        Scanner teclado = new Scanner(System.in);
        char x;
        try{
            System.out.print("Digite um Caracter: ");
            x = teclado.next().charAt(0);
            x = Character.toUpperCase(x);
        }catch(Exception e){
            System.out.println("Caracter invalido! Digite novamente: ");
            x = LerChar();
        }
        return x;
    }
    private void posiciona(int x) {
        if(x == 5){
            posicionaPortaAvioes();
        }else if(x == 4){
            posicionaNaviosTanque();
        }else if(x == 3){
            posicionaSubmarinos();
        }else
            posicionaContraTorpedeiros();
    }

    private void posicionaPortaAvioes(){
        try {
            System.out.println("Posicionando PortaAvioes: ");
            test(porta.gettam());

        }catch (Exception e){
            System.out.println("Posicionamento Falhou!");
            posicionaPortaAvioes();
        }

    }

    private void test(int gettam) {
        int col;
        char linc;
        int lin;
        char dir;
        System.out.println("Digite a coluna que deseja posicionar a embarcação:  ");
        col = LerInt();
        System.out.println("Digite a linha que deseja posicionar a embarcação:  ");
        linc = LerChar();
        lin = linc;
        lin = lin - 65;
        System.out.println("Digite uma direção de inserção (representado por uma letra E-esquerda, D-direita, C-cima e B-baixo");
        dir = LerChar();
        posicionaTabela(lin,col,dir, gettam);
        imprimejogo();
    }

    private void posicionaNaviosTanque(){
        try {
            System.out.println("Posicionando NaviosTanque: ");
            test(tanque.gettam());

        }catch (Exception e){
            System.out.println("Posicionamento Falhou!");
            posicionaNaviosTanque();
        }

    }
    private void posicionaSubmarinos(){
        try {
            System.out.println("Posicionando Submarinos: ");
            test(sub.gettam());

        }catch (Exception e){
        System.out.println("Posicionamento Falhou!");
            posicionaSubmarinos();
    }

    }
    private void posicionaContraTorpedeiros(){
        try {
            System.out.println("Posicionando Contra Torpedeiros: ");
            test(contra.gettam());

        }catch (Exception e){
            System.out.println("Posicionamento Falhou!");
            posicionaContraTorpedeiros();
        }
    }
    private void posicionaTabela(int lin,int col,char dir,int tam){
        col = col - 1;
            try {
                if(dir == 'E'){
                    for(int i= 0 ;i< tam;i++) {
                        this.Tabuleiro[lin][col-i] = 1;
                    }
                }else if(dir == 'D'){
                    for(int i= 0 ;i< tam;i++) {
                        this.Tabuleiro[lin][col+i] = 1;
                    }
                }else if(dir == 'C'){
                    for(int i= 0 ;i< tam;i++) {
                        this.Tabuleiro[lin-i][col] = 1;
                    }

                }else if(dir == 'B'){
                    for(int i= 0 ;i < tam;i++) {
                        this.Tabuleiro[lin+i][col] = 1;
                    }
                }else{
                    System.out.println("Direção invalida,Digite novamente!");
                    dir = LerChar();
                    posicionaTabela(lin,col,dir,tam);
                }
            }catch (Exception e){
                System.out.println("Seu Barco não coube, Tente novamente!");
                posiciona(tam);
            }
    }

    private void imprimejogo(){
        for (int[] ints : Tabuleiro) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                if (ints[col] == 1) {
                    System.out.println(" E ");
                } else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public void Atacado (int lin,int col){

        if(Tabuleiro[lin][col] == 1) {
            System.out.println("FOGO");
            Tabuleiro[lin][col] = 2;
            Parte_navios_Restantes--;
        }else if(Tabuleiro[lin][col] == 0){
            System.out.print("ÁGUA");
            Tabuleiro[lin][col] = 3;
        }else {
            System.out.println("Local já Foi atacado");
            System.out.println("Digite uma nova Linha: ");
            lin = LerInt();
            System.out.println("Digite uma nova Coluna: ");
            col = LerInt();
            Atacado(lin,col);
        }
    }


    public void TabuleiroMascarado(){
        System.out.print("    ");
        for(int i = 0; i < Tabuleiro.length; i++){
            System.out.print((i+1) + "  ");
        }
        System.out.println();
        System.out.println();
        for (int lin = 0; lin < Tabuleiro.length; lin++){
            System.out.print( ( (char) (lin+65)) + "  ");
            for (int col = 0; col < Tabuleiro[0].length; col++) {

                if(Tabuleiro[lin][col] <= 1) {
                    System.out.print(" * ");
                }
                else if(Tabuleiro[lin][col] == 2){
                    System.out.print(" F ");
                }else
                    System.out.print(" A ");
            }
            System.out.println();
        }
    }
}
