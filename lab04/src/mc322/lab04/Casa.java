package mc322.lab04;
public class Casa {
    int tipo; // VAZIA = 0, PREENCHIDA = 1, INDISPONIVEL = -1
    Peca p; // É A PEÇA QUE ESTA NESSA CASA, NULL CASO A CASA ESTEJA VAZIA

    Casa(int tipo,int x,int y){
        this.tipo = tipo;
        if (tipo == 1){
            this.p = new Peca(x,y,this);
        }else{
            this.p = null;
        }
    }

    boolean jogada(Tabuleiro tabuleiro,int x,int y){
        if (this.tipo == 1){
            return this.p.jogada(tabuleiro,x,y);
        }
        return false;
    }

    void esvaziar(){
        this.tipo = 0;
        this.p = null;
    }

    void colocar_peca(Peca p){
        this.tipo = 1;
        this.p = p;
        p.casa = this;
    }

    boolean disponivel(){
        if(this.tipo == 0){            
            return true;
        }
        return false;
        }

    boolean preenchido(){
        if (this.tipo == 1){
            return true;
        }
        return false;
    }

    boolean jogada_disponivel(Tabuleiro tabuleiro){
        if (this.tipo == 1){
            return this.p.consegue_se_movimentar(tabuleiro);
        }
        return false;
    }
}
