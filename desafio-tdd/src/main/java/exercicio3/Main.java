package exercicio3;

public class Main {

	public static void main(String[] args) {
		
		Mago amy = new Mago("Amy", 100, 10, 10, 10, 3, 1);
		Mago arme = new Mago("Arme", 100, 10, 10, 10, 3, 1);
		Guerreiro elesis = new Guerreiro("Elesis", 100, 3, 10, 3, 10, 1);
		Guerreiro lass = new Guerreiro("Lass", 100, 3, 10, 3, 10, 1);
		
		//Ataque
		amy.attack();
		elesis.attack();
		arme.attack();
		lass.attack();
		
		//Level up
		amy.lvlUp();
		elesis.lvlUp();
		
		//Aprender magia
		arme.aprenderMagia("Nvoa sombria");
		arme.listarMagias();
		
		//Aprender habilidade
		elesis.aprenderHabilidade("Trilha de Espadachim");
		elesis.aprenderHabilidade("Corte em cruz");
		elesis.listarHabilidades();

		//Quantidade Personagens
		System.out.format("Foram cadastrados %d personagens", Personagem.getTotalPersonagens());

	}

}
