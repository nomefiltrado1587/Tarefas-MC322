/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mc323.lab03;

/**
 *
 * @author Vini
 */
public class Animacao {
    
    
    AquarioLombriga lombriga;
    String acoes;
    int passo_atual;
    
    public static int str_to_int(String acoes,int posicao){
        int resultado;
        String aux = "";
        aux += acoes.charAt(posicao);
        aux += acoes.charAt(posicao + 1);
        return Integer.valueOf(aux);
    }    
    
    Animacao(String acoes){
        this.acoes = acoes;
        int param1 = str_to_int(acoes,0),
        param2 = str_to_int(acoes,2),
        param3 =  str_to_int(acoes,4);
        this.lombriga = new AquarioLombriga(param1,param2,param3,true);
        this.passo_atual = 6;
    }
    
    Boolean passo(){ ///RETORNA 1 CASO TENHO OCORRIDO TUDO CERTO
        if(this.passo_atual < this.acoes.length()){
            switch (this.acoes.charAt(this.passo_atual)) {
                case 'C':
                    this.lombriga.crescer();
                    break;
                case 'V':
                    this.lombriga.virar();
                    break;
                case 'M':
                    this.lombriga.mover();
                    break;
            }
            this.passo_atual += 1;
            return true;
        }
        return false;
    }
    
    String apresenta(){
        return this.lombriga.apresenta();
    }
    
}
