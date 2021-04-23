package mc322.lab05;

public class PecaDama {
	
	int linha;
	int coluna;
	int player;
	Tabuleiro tabuleiro;//A pe�a sabe o tabuleiro em que est�
	
	PecaDama(Tabuleiro tabuleiro,int linha,int coluna,int player){
		this.linha = linha;
		this.coluna = coluna;
		this.tabuleiro= tabuleiro;
		this.player = player;
		
	}

	boolean movimentoValido(int x1, int y1, int x2, int y2) {
		if(this.player == 0){ // DAMAS BRANCAS
			if (tabuleiro.moduloDif(x2,x1) == 1){ // MOVIMENTO NORMAL
				if (y2 == y1 + 1){
					return !tabuleiro.casaPreenchida(x2,y2);
				}
			}else if(tabuleiro.moduloDif(x2,x1) == 2){ // BRANCA CAPTURA
				if(tabuleiro.moduloDif(y2,y1) == 2){
					return !tabuleiro.casaPreenchida(x2,y2) && tabuleiro.casaPreenchida((x2+x1)/2,(y2+y1)/2);
				}
			}
		}else{ // DAMAS VERMELHAS
			if (tabuleiro.moduloDif(x2,x1) == 1){ // MOVIMENTO NORMAL
				if (y2 == y1 - 1){
					return !tabuleiro.casaPreenchida(x2,y2);
				}
			}else if(tabuleiro.moduloDif(x2,x1) == 2){ // VERMELHA CAPTURA
				if(tabuleiro.moduloDif(y2,y1) == 2){
					return !tabuleiro.casaPreenchida(x2,y2) && tabuleiro.casaPreenchida((x2+x1)/2,(y2+y1)/2);
				}
			}
		}
		return false;
	}


	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}
