package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Loja {

	private String nome;
	private String cnpj;
	private List<Livro> livros = new ArrayList<Livro>();
	private List<VideoGame> videoGames = new ArrayList<VideoGame>();

	public Loja() {
	};

	public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.livros = livros;
		this.videoGames = videoGames;
	}

	public Loja(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

	/**
	 * Listagem dos livros contidos na lista
	 */
	public void listaLivros() {
		
		StringBuilder stringLlivros = new StringBuilder("");
		
		if (livros == null || livros.isEmpty()) {
			System.out.println("A loja no tem livros no seu estoque.");
		} else {
			for (Livro livro : livros) {
				stringLlivros.append(livro);
				stringLlivros.append("\n");
			}
			System.out.println(stringLlivros);
		}
	}
	
	/**
	 * Listagem dos video-games contidos na lista
	 */
	public void listaVideoGames() {
		
		StringBuilder stringVideoGames = new StringBuilder("");
		
		if (videoGames == null || videoGames.isEmpty()) {
			System.out.println("A loja no tem video-games no seu estoque.");
		} else {
			for (VideoGame videoGame : videoGames) {
				stringVideoGames.append(videoGame);
				stringVideoGames.append("\n");
			}
			System.out.println(stringVideoGames);
		}
	}
	/**
	 * Calculo do capital total da loja
	 * @return 0; Retorna patrimnio da loja
	 */
	public double calculaPatrimonio() {
		double precoTotalLivros = 0;
		double precoTotalVG = 0;
		// Calculo dos valores total dos livros
		for (Livro l : livros) {
			double precoUnitario = l.getPreco() * l.getQtd();
			precoTotalLivros = precoTotalLivros + precoUnitario;
		}
		// Calculo dos valores total dos video-games
		for (VideoGame vg : videoGames) {
			double precoUnitario = vg.getPreco() * vg.getQtd();
			precoTotalVG = precoTotalVG + precoUnitario;
		}

		double patrimonio = precoTotalLivros + precoTotalVG;

		System.out.format("O patrimonio total da loja %s de %.2f reais\n", getNome(), patrimonio);
		return 0;
	}

	
}
