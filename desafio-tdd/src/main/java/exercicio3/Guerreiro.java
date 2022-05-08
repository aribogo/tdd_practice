package exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Guerreiro extends Personagem {

	private List<String> habilidades = new ArrayList<String>();
	
	private MyRandomUtility myRandomUtility = new MyRandomUtility();

	public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
	}
	
	public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level, MyRandomUtility myRandomUtility) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.myRandomUtility = myRandomUtility;
	}


	public List<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}

	/**
	 * @inhertirDoc Para o guerreiro os aumentos são: Mana (3); Inteligncia (5);
	 *              Fora (10); Vida (10);
	 */
	public void lvlUp() {
		super.setLevel(getLevel()+1);
		super.setMana(getMana() + 3);
		super.setInteligencia(getInteligencia() + 5);
		super.setForca(getForca() + 10);
		super.setVida(getVida() + 10);
	};

	/**
	 * Ataca o adversrio
	 */
	public void attack() {
		int n = myRandomUtility.getRandom();

		int ataque = (super.getForca() * super.getLevel()) + n;
		System.out.format("O ataque foi de %d pontos.\n", ataque);
	}

	/**
	 * Aprende habilidade nova, a qual  armazenada em uma lista.
	 * 
	 * @param habilidade Nome da habilidade.
	 */
	public void aprenderHabilidade(String habilidade) {
		habilidades.add(habilidade);
	}
	/**
	 * Listar habildades aprendidas pelo personagem
	 */
	
	public void listarHabilidades() {
		StringBuilder listaHabilidadesString = new StringBuilder("");
		for(String h : habilidades) {
			listaHabilidadesString.append(h);
			listaHabilidadesString.append("\n");
		}
		System.out.println(listaHabilidadesString);
	}

	
}
