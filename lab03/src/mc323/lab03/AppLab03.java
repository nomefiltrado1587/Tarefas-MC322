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
public class AppLab03 {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {

        String acoes = "080403MCMVM";
        Animacao animacao = new Animacao(acoes);
        
        System.out.println(animacao.apresenta());
        while(animacao.passo()){
            System.out.println(animacao.apresenta());
        }
        
    }

    
}
