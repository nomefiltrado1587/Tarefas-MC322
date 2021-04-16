public class Tabuleiro {
    int altura = 7,largura =7 ;
    Casa casas[][] = new Casa[this.altura][this.largura];

    void criar_linha(int i){
        if (i>1 && 5>i){
            for(int j = 0;j<this.largura;j++){
                this.casas[i][j] = new Casa(1,i,j);
            }
        }else{
            for(int j = 0;j<2;j++){
                this.casas[i][j] = new Casa(-1,i,j);
            }
            for(int j = 2;j<this.largura-2;j++){
                this.casas[i][j] = new Casa(1,i,j);
            }
            for(int j = this.largura-2;j<this.largura;j++){
                this.casas[i][j] = new Casa(-1,i,j);
            }
        }
    }

    Tabuleiro(){
        for(int i = 0;i<this.altura;i++){
            criar_linha(i);
        }
        this.casas[3][3].esvaziar();
    }

    String[] mostrar(){
        String saida[] = new String[this.altura];
        for (int i = 0;i<this.altura;i++){
            saida[i] = "";
            for(int j = 0;j<this.largura;j++){
                if(this.casas[i][j].tipo == -1){
                    saida[i] += " ";
                }else if(this.casas[i][j].tipo == 1){
                    saida[i] += "P";
                }else{
                    saida[i] += "-";
                }
            }
            saida[i] += "\n";
        }
        return saida;
    }

    boolean disponivel(int x,int y){
        return this.casas[x][y].disponivel();
    }

    boolean preenchido(int x,int y){
        return this.casas[x][y].preenchido();
    }

    boolean conferir_se_acabou(){
        for (int i = 0;i<this.altura;i++){
            for (int j =0;j<this.largura;j++){
                if (this.casas[i][j].jogada_disponivel(this)){
                    return false;
                }
            }
        }
        return true;
    }
}
