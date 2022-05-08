package partidaDeTenis;

public enum Pontuacao {
	
	ZERO("0"),
	QUINZE("15"),
	TRINTA("30"),
	QUARENTA( "40"),
	DEUCE("Deuce"),
	ADVANTAGE("Advantage"),
	VENCEDOR("Vencedor"),
	PERDEDOR("Perdedor");
	
	private final String displayValue;

	private Pontuacao(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}



	public static Pontuacao getEnum(String displayValue) {
		for(Pontuacao p: Pontuacao.values()) {
			if(p.getDisplayValue().equalsIgnoreCase(displayValue)) {
				return p;
			}
		}
		return null;
	}

	
	
}
