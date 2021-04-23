package mc322.lab05;

public class Tabuleiro {

	PecaDama[][] tabuleiro_damas = new PecaDama[8][8];
	PecaRainha[][] tabuleiro_rainhas = new PecaRainha[8][8];

	static int moduloDif(int a,int b){
		if (a>b){
			return a-b;
		}
		return b-a;
	}
	
	Tabuleiro() {
		//Inicia o tabuleiro
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				int player = noTabuleiro(i,j);
				if(player != -1) {
					
					tabuleiro_damas[i][j]=new PecaDama(this,i,j,player);
				}
				else {
					tabuleiro_damas[i][j]= null;
				}
			}		
			
		}
		
	}

	void movimentarPeca(int[] coordsAlvo) {
		//Movimenta a pe�a e come remove a da casa intermedi�ria

		tabuleiro.tabuleiro[linha][coluna] = null;
		tabuleiro.tabuleiro[(linha+coordsAlvo[0])/2][(coluna+coordsAlvo[1])/2] = null;
		linha=coordsAlvo[0];
		coluna=coordsAlvo[1];
		tabuleiro.tabuleiro[coordsAlvo[0]][coordsAlvo[1]]=this;


	}
	
	
	int[] strParaCoords(String coords){
		//Converte as coordenadas do Tipo CharInt -> IntInt
		int[] ret = {coords.charAt(1)-1-'0',coords.charAt(0)-'a'};
		return(ret);
		
	}
	
	int noTabuleiro(int i,int j) {
		//Verifica se deve ser colocada uma peça em i,j
		// retorna -1 para casa vazia, 1 para player 1 e 0 para player 0
		if (i<3){
			if ((j-i)%2 == 0) return 0;
			else return -1;
		}else if(i>4){
			if ((j-i)%2 == 0) return -1;
			return 1;
		}
		return -1;
	}


	boolean casaPreenchida(int x, int y){
		if (tabuleiro_damas[x][y] != null || tabuleiro_rainhas[x][y] != null){
			return true;
		}
		return false;
	}

	void movimentar(String fonte,String alvo) {
		//Movimenta a pe�a na casa fonte at� a casa alvo
		boolean movimento_valido;
		int[] coordsFonte = strParaCoords(fonte);
		int[] coordsAlvo = strParaCoords(alvo);
		if (tabuleiro_damas[coordsFonte[0]][coordsFonte[1]] != null) {
			movimento_valido = tabuleiro_damas[coordsFonte[0]][coordsFonte[1]].movimentoValido(coordsFonte[0],coordsFonte[1],coordsAlvo[0],coordsAlvo[1]);
			if (movimento_valido){
				if ()
				tabuleiro_damas[coordsFonte[0]][coordsFonte[1]]
			}
		}else if(tabuleiro_rainhas[coordsFonte[0]][coordsFonte[1]] != null) {
			movimento_valido = tabuleiro_rainhas[coordsFonte[0]][coordsFonte[1]].movimentoValido(coordsFonte[0], coordsFonte[1], coordsAlvo[0], coordsAlvo[1]);
		}
			PecaDama pecaFonte = tabuleiro_damas[coordsFonte[0]][coordsFonte[1]];
		
	}
	
	String estadoEmString() {
		//Retorna o estado atual do tabuleiro em uma string
		String estadoAtual = "";
		for(int i=7;i>=0;i--) {
			for(int j=0;j<8;j++){

				if(tabuleiro_damas[i][j]!=null) {
					if (tabuleiro_damas[i][j].)
					estadoAtual+="P";
				}
				else if(noTabuleiro(i,j) == 0) {

					estadoAtual+="-";
				}
				else {

					estadoAtual+=" ";
				}
				
			}
			estadoAtual+='\n';
		}

		return estadoAtual;
		
		
	}
	
	void imprimir() {
		//Imprime como o tabuleiro est� no momento.
		for(int i=6;i>=0;i--) {
			System.out.print(i+1+" ");
			for(int j=0;j<7;j++){

				if(tabuleiro_damas[i][j]!=null) {
					System.out.print("P");
				}
				else if(noTabuleiro(i,j)) {
					System.out.print("-");
				}
				else {
					System.out.print(" ");
				}
				System.out.print(" ");
			
			
		}
			
			System.out.print("\n");
	}
	System.out.print("  a b c d e f g \n");
	}


}
