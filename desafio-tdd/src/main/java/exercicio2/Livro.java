package exercicio2;

public class Livro extends Produto implements Imposto{

	private String autor;
	private String tema;
	private int qtdPag;

	public Livro() {
		super();
	}

	public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) {
		super(nome, preco, qtd);
		this.autor = autor;
		this.tema = tema;
		this.qtdPag = qtdPag;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	/** @inheritDoc */
	public double calculaImposto() {
		if (tema.equals("educativo")) {
			System.out.format(
					"Livros educativos nao possuem imposto, dessa forma, o imposto do livro %s de tema %s sera de 00.00 reais.\n",
					super.getNome(), getTema());
			return 0;
		} else {
			double imposto = (super.getPreco() * 10) / 100;
			System.out.format("O imposto do livro %s de tema %s sera de %.2f reais. \n", super.getNome(), getTema(),
					imposto);
			return imposto;
		}
	}

	@Override
	public String toString() {
		return "Livro " + getNome() + ", autor " + autor + ", tema " + tema + ", " + qtdPag + " paginas" + ", preco "
				+ getPreco() + " reais" + ", quantidade " + getQtd();
	}

	
}
