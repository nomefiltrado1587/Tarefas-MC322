public class Jogo {
    Tabuleiro tabuleiro;
    boolean acabou;

    Jogo(){
        this.tabuleiro = new Tabuleiro();
        this.acabou = false;
    }

    int modulo_dif(int a,int b){
        if (a>b){
            return a-b;
        }
        return b-a;
    }

    void conferir_se_acabou(){
        this.acabou = tabuleiro.conferir_se_acabou();
    }

    void jogar(int x1,int y1,int x2,int y2){
        if(this.acabou){
            return;
        }

        boolean valido = false;

        if(x1 == x2 && modulo_dif(y1,y2) == 2){
            valido = true;
        }else if(y1 == y2 && modulo_dif(x1,x2) == 2){
            valido = true;
        }else{
            //System.out.println("Tipo de movimento invalido\n");
        }

        if (valido){
            if (this.tabuleiro.casas[x1][y1].jogada(this.tabuleiro,x2,y2)){
                //System.out.println("Movimento executado com sucesso\n");
            }else{
               //System.out.println("Uma ou mais casas escolhidas sao invalidas\n");
            }
        }

        conferir_se_acabou();
    }
}
