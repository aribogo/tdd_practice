package partidaDeTenis;

import java.util.HashMap;

public class Partida {

	private HashMap<String, Integer> sets = new HashMap<>();
	private HashMap<String, Pontuacao> contagemDaPontuacao = new HashMap<>();

	public HashMap<String, Integer> getSets() {
		return sets;
	}

	public void setSets(HashMap<String, Integer> sets) {
		this.sets = sets;
	}

	public String getContagemDaPontuacaoDoJogador(Jogador jogador) {
		return contagemDaPontuacao.get(jogador.getNome()).getDisplayValue();
	}

	public void setContagemDapontuacao(HashMap<String, Pontuacao> contagemDapontuacao) {
		this.contagemDaPontuacao = contagemDapontuacao;
	}

	public void inicializacaoDaPontuacaoeSet(Jogador j1, Jogador j2) {
		sets.put(j1.getNome(), 0);
		sets.put(j2.getNome(), 0);
		
		contagemDaPontuacao.put(j1.getNome(), Pontuacao.ZERO);
		contagemDaPontuacao.put(j2.getNome(), Pontuacao.ZERO);
	}

	private Pontuacao setPontuacaoOrdenada(int pontuacaoJogadorVez) {
		return Pontuacao.values()[pontuacaoJogadorVez];		
	}
	

	public void jogada(Jogador jogadorVez, Jogador jogadorDefesa) {
		
		int pontuou = jogadorVez.jogar();
		int pontuacaoJogadorVez = contagemDaPontuacao.get(jogadorVez.getNome()).ordinal();
		 	
		if(pontuou == 1 
				&& (! contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("40")
					&& ! contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("30")
					&& ! contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("Deuce")
					&& ! contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("Advantage")
				&& ! contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("40"))) {

			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), setPontuacaoOrdenada(pontuacaoJogadorVez + 1));
			System.out.format("%s pontuou! \n %s : %s \n %s : %s \n\n", jogadorVez.getNome(), jogadorVez.getNome(),
					contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue(), jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue());
			
		} else if(pontuou == 1 
				&& (contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("30")
				&& contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue().equals("40")
				|| contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("40")
				&& contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue().equals("Advantage")
						)) {

			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), Pontuacao.DEUCE);
			contagemDaPontuacao.replace(jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()), Pontuacao.DEUCE);
			
			System.out.format("%s pontuou! \n %s : %s \n %s : %s \n\n", jogadorVez.getNome(), jogadorVez.getNome(),
					contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue(), jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue());
			
		} else if(pontuou == 1 
				&& contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("30")) {
			
			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), Pontuacao.QUARENTA);
			System.out.format("%s pontuou! \n %s : %s \n %s : %s \n\n", jogadorVez.getNome(), jogadorVez.getNome(),
					contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue(), jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue());
			
		
		} else if(pontuou == 1
				&& contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("Deuce")) {
			
			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), Pontuacao.ADVANTAGE);
			contagemDaPontuacao.replace(jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()), Pontuacao.QUARENTA);
			
			System.out.format("%s pontuou! \n %s : %s \n %s : %s \n\n", jogadorVez.getNome(), jogadorVez.getNome(),
					contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue(), jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue());

		} else if(pontuou == 1
				&& ( contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("Advantage")
						|| contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue().equals("40"))) {

			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), Pontuacao.VENCEDOR);
			contagemDaPontuacao.replace(jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()), Pontuacao.PERDEDOR);
			
			sets.replace(jogadorVez.getNome(), sets.get(jogadorVez.getNome()), sets.get(jogadorVez.getNome())+1);
			
			System.out.format("%s pontuou! \n %s : %s \n %s : %s \n\n", jogadorVez.getNome(), jogadorVez.getNome(),
					contagemDaPontuacao.get(jogadorVez.getNome()).getDisplayValue(), jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()).getDisplayValue());
			
			contagemDaPontuacao.replace(jogadorVez.getNome(), contagemDaPontuacao.get(jogadorVez.getNome()), Pontuacao.ZERO);
			contagemDaPontuacao.replace(jogadorDefesa.getNome(), contagemDaPontuacao.get(jogadorDefesa.getNome()), Pontuacao.ZERO);
			
			contagemDoSet(jogadorVez, jogadorDefesa);
			
		}else {
			System.out.format("%s não pontuou... \n\n", jogadorVez.getNome());
		}
	}
	



	public void contagemDoSet(Jogador jogador1, Jogador jogador2) {
		if(sets.containsValue(2)) {
			if(sets.get(jogador1.getNome()) > 1) {
				System.out.format("%s venceu por %d sets a %d", jogador1.getNome(), sets.get(jogador1.getNome()), sets.get(jogador2.getNome()));
				System.exit(0);
			} else {
				System.out.format("%s venceu por %i sets a %i", jogador2.getNome(), sets.get(jogador2.getNome()), sets.get(jogador1.getNome()));
				System.exit(0);
			}
		}
	}


	
}
