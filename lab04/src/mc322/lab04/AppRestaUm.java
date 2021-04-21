package mc322.lab04;

public class AppRestaUm {

    static void jogada(String comando,Jogo jogo){
        int x1 = comando.charAt(0) - 'a';
        int x2 = comando.charAt(3) - 'a';
        int y1 = comando.charAt(1) - '1';
        int y2 = comando.charAt(4) - '1';
        System.out.println("Source: "+comando.charAt(0)+comando.charAt(1));
        System.out.println("Target: "+comando.charAt(3)+comando.charAt(4));
        jogo.jogar(y1, x1, y2, x2);
    }

    static String mostrar_tabuleiro_atual(Jogo jogo){
        String saida = "";
        String[] tabuleiro_atual = jogo.tabuleiro.mostrar();
        for (int j = 0;j<tabuleiro_atual.length;j++){
            System.out.print(j+1);
            System.out.print(" ");
            saida += tabuleiro_atual[j];
            for (int k = 0;k<tabuleiro_atual[j].length()-1;k++){
                System.out.print(tabuleiro_atual[j].charAt(k)+" ");
            }
            System.out.print(tabuleiro_atual[j].charAt(tabuleiro_atual[j].length()-1));
        }
        String abc = "  a b c d e f g \n";
        System.out.println(abc);
        return saida;
    }

    public static String[] executaJogo(String path){
        CSVReader leitor = new CSVReader();
        leitor.setDataSource(path);
        String comandos[] = leitor.requestCommands();
        String saida[] = new String[comandos.length];

        Jogo jogo = new Jogo();
        System.out.println("Tabuleiro inicial:");
        saida[0] = mostrar_tabuleiro_atual(jogo);

        for (int i = 1;i<comandos.length;i++){
            jogada(comandos[i-1],jogo);
            saida[i] = mostrar_tabuleiro_atual(jogo);
        }
        return saida;
    }
    public static void main(String[] args) throws Exception {

        CSVReader leitor = new CSVReader();
        leitor.setDataSource("testes/teste08.csv");
        String comandos[] = leitor.requestCommands();
        String saida[] = new String[comandos.length];

        Jogo jogo = new Jogo();
        System.out.println("Tabuleiro inicial:");
        jogo.tabuleiro.mostrar();
        saida[0] = mostrar_tabuleiro_atual(jogo);
        for (int i = 1;i<comandos.length;i++){
            jogada(comandos[i-1],jogo);
            saida[i] = mostrar_tabuleiro_atual(jogo);
        }
    }
}
