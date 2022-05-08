package partidaDeTenis;

public class Jogador {

	private String nome;
	
	private MyRandomUtility myRandomUtility = new MyRandomUtility();

	public Jogador(String nome) {
		this.nome = nome;

	}

	public Jogador(String nome, MyRandomUtility myRandomUtility) {
		
		this.nome = nome;
		this.myRandomUtility = myRandomUtility;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int jogar() {

		int pontuou = myRandomUtility.getRandom();
		
		if(pontuou == 0) {
			return 0;
		} else {
			return 1;
		}
		
	}

}
