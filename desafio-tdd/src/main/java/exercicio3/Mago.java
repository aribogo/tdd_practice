package exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Mago extends Personagem {

	private List<String> magias = new ArrayList<String>();
	
	private MyRandomUtility myRandomUtility = new MyRandomUtility();

	public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
	}
	
	public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level, MyRandomUtility myRandomUtility) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.myRandomUtility = myRandomUtility;
	}
	public Mago() {
		
	}




	public List<String> getMagia() {
		return magias;
	}

	public void setMagia(List<String> magias) {
		this.magias = magias;
	}

	/**
	 * @inheritDoc Para o mago os aumentos são: Mana (10); Inteligncia (10); Fora
	 *             (3); Vida (5);
	 */
	public void lvlUp() {
		super.setLevel(getLevel()+1);
		super.setMana(getMana() + 10);
		super.setInteligencia(getInteligencia() + 10);
		super.setForca(getForca() + 3);
		super.setVida(getVida() + 5);
	};

	/**
	 * Ataca o adversrio
	 */
	public void attack() {
		
		int n = myRandomUtility.getRandom();

		int ataque = (super.getInteligencia() * super.getLevel()) + n;
		System.out.format("O ataque foi de %d pontos.\n", ataque);
	}

	
	/**
	 * Aprende magia nova, a qual  armazenada em uma lista.
	 * @param magia Nome da magia.
	 */
	public void aprenderMagia(String magia) {
		magias.add(magia);
	}
	
	/**
	 * Listar as magias aprendidas pelo personagem.
	 */
	public void listarMagias() {
		
		StringBuilder listaDeMagias = new StringBuilder("");
		
		for(String m: magias) {
			listaDeMagias.append(m);
			listaDeMagias.append("\n");
		}
		
		System.out.println(listaDeMagias);
	}

	
}
