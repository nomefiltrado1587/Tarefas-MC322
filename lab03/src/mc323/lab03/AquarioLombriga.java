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
public class AquarioLombriga {
    int tamanho;
    Boolean orientacao; /// CABEÇA PARA A DIR -> TRUE, PARA A ESQ -> FALSE
    int posicao;
    int tamanho_aquario;

    AquarioLombriga(int tamanho_aquario,int tamanho_inicial,int posicao_inicial,Boolean orientacao_inicial){
        this.tamanho = tamanho_inicial;
        this.orientacao = orientacao_inicial;
        this.posicao = posicao_inicial;
        this.tamanho_aquario = tamanho_aquario;
    }

    void crescer(){
        if (this.orientacao){
            if(this.posicao != 0){
                this.tamanho += 1;
                this.posicao -= 1;
            }
        }else{
            if(this.posicao + this.tamanho > this.tamanho_aquario){
                this.tamanho += 1;
            }
        }
    }
    void mover(){
        if (this.orientacao){
            if(this.posicao + this.tamanho < this.tamanho_aquario){
                this.posicao += 1;
            }else{
                this.orientacao = false;
            }
        }else{
            if(this.posicao != 0){
                this.posicao -= 1;
            }else{
                this.orientacao = true;
            }
        }
    }
    void virar(){
        if (this.orientacao){
                this.orientacao = false;
            }
        else{
            if(this.posicao != 0){
                this.orientacao = true;
            }
        }
    }
    String apresenta(){
        String resultado = "";
        for(int i= 0;i<this.posicao;i++){
            resultado += "#";
        }
        if(!this.orientacao){
            resultado += "O";
        }
        for(int i = 0;i<this.tamanho-1;i++){
            resultado += "@";
        }
        if(this.orientacao){
            resultado += "O";
        }
        for(int i = 0;i<this.tamanho_aquario - this.tamanho - this.posicao;i++){
            resultado += "#";
        }
        return resultado;
    }

}

