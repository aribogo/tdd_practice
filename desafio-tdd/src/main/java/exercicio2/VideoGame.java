package exercicio2;

public class VideoGame extends Produto implements Imposto{

	private String marca;
	private String modelo;
	private boolean isUsado;

	public VideoGame() {
		super();
	}
	public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado) {
		super(nome, preco, qtd);
		this.marca = marca;
		this.modelo = modelo;
		this.isUsado = isUsado;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isUsado() {
		return isUsado;
	}
	public void setUsado(boolean isUsado) {
		this.isUsado = isUsado;
	}
	
	
	/** @inheritDoc */
	public double calculaImposto() {
		if(isUsado) {
			double imposto = getPreco() * 0.25;
			System.out.format("O imposto do video-game %s (usado) sera de %.2f reais. \n", super.getNome(), imposto);
			return imposto;
		} else {
			double imposto = getPreco() * 0.45;
			System.out.format("O imposto do video-game %s (novo) sera de %.2f reais. \n", super.getNome(), imposto);
			return imposto;
		}
	}
	
	//toString
	@Override
	public String toString() {
		String eUsado = isUsado? "usado":"novo";
		return "VideoGame " + getNome() + ", modelo " + modelo + ", " + eUsado
				+ ", valor " + getPreco() + ", quantidade " + getQtd();
	}
	

	
}
