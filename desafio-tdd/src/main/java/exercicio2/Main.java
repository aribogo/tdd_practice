package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Livros
		Livro l1 = new Livro("Harry Potter", 40, 50,"J.K. Rolling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anis", 60, 30,"J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("JAVA POO", 20, 50,"GFT", "educativo", 500);
		
		//Videogames
		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("Xbox", 1500, 500, "Microsoft", "One", false);
		
		//Lista Livros
		List<Livro> livros = new ArrayList<>();
		livros.add(l3);
		livros.add(l2);
		livros.add(l1);
		
		//Lista VideoGames
		List<VideoGame> videoGames = new ArrayList<>();
		videoGames.add(ps4);
		videoGames.add(ps4Usado);
		videoGames.add(xbox);
		
		//Objeto tipo Loja
		Loja americanas = new Loja("Americanas", "123456", livros, videoGames);
		
		//chamada do mtodo calculaImposto dos livros
		l1.calculaImposto();
		l2.calculaImposto();
		l3.calculaImposto();
		System.out.println();

		
		//chamada dos mtodos calculaImposto dos video-games
		ps4.calculaImposto();
		ps4Usado.calculaImposto();
		xbox.calculaImposto();
		System.out.println();

		
		//chamada dos mtodo de listagem dos livros e video-games
		americanas.listaLivros();
		System.out.println();
		americanas.listaVideoGames();
		System.out.println();
		
		//chamada dos mtodo para calcular patrimnio da loja
		americanas.calculaPatrimonio();
		System.out.println();


	}

}
