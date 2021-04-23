package mc322.lab05;

public class PecaRainha {
	int linha;
	int coluna;
	int player;
	Tabuleiro tabuleiro;//A pe�a sabe o tabuleiro em que est�
	
	PecaRainha(Tabuleiro tabuleiro,int linha,int coluna,int player){
		this.linha = linha;
		this.coluna = coluna;
		this.tabuleiro= tabuleiro;
		this.player = player;
		
	}
	String String(){
		if (player == 0) return ("B");
		return ("V");
	}


	boolean movimentoValido(int x1,int y1,int x2, int y2) {
		return true;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
