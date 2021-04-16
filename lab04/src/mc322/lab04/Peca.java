package mc322.lab04;

public class Peca {
    int x,y;
    Casa casa; // CASA QUE CONTEM ESTA PEÇA

    Peca(int x, int y, Casa casa){
        this.casa = casa;
        this.x = x;
        this.y = y;
    }

    void comer(int x2, int y2,int x3,int y3, Tabuleiro tabuleiro){
        tabuleiro.casas[x3][y3].colocar_peca(this);
        tabuleiro.casas[this.x][this.y].esvaziar();
        tabuleiro.casas[x2][y2].esvaziar();
        this.x = x3;
        this.y = y3;
    }

    int media(int a,int b){
        return (a+b)/2;
    }

    boolean jogada(Tabuleiro tabuleiro,int x2,int y2){
        
        int x1 = media(this.x,x2),y1=media(this.y,y2);

        if (tabuleiro.disponivel(x2,y2) && tabuleiro.preenchido(x1,y1)){
            comer(x1,y1,x2,y2,tabuleiro);
            return true;
        }
        return false;
    }

    boolean consegue_se_movimentar(Tabuleiro tabuleiro){
        if (this.x > 1){
            if (tabuleiro.casas[this.x-1][y].preenchido() && tabuleiro.casas[this.x-2][y].disponivel()) return true;
        }
        if (this.x < tabuleiro.largura-1){
            if (tabuleiro.casas[this.x+1][y].preenchido() && tabuleiro.casas[this.x+2][y].disponivel()) return true;
        }
        if (this.y > 1){
            if (tabuleiro.casas[this.x][y-1].preenchido() && tabuleiro.casas[this.x][y-2].disponivel()) return true;
        }
        if (this.y < tabuleiro.altura-1){
            if (tabuleiro.casas[this.x][y+1].preenchido() && tabuleiro.casas[this.x][y+2].disponivel()) return true;
        }
        return false;
    }
}
