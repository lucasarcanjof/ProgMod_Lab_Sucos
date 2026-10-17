
public class Suco extends Bebida {

	private static final int MAX_FRUTAS = 2;

	public Suco(EFruta fruta) {
		super("Suco");
		frutas.add(fruta);
	}

	/**
	 * Adiciona uma fruta ao suco. O suco aceita até duas frutas, desde que uma delas seja laranja.
	 * @param fruta Fruta a ser adicionada
	 * @return Quantidade de frutas no suco após a tentativa
	 */
	@Override 
	public int adicionar(EFruta fruta) {
		boolean temLaranja = frutas.contains(EFruta.LARANJA) || fruta == EFruta.LARANJA;
		if (fruta != null && frutas.size() < MAX_FRUTAS && temLaranja) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	@Override 
	public double preco() {
		return frutas.stream()
				.mapToDouble(EFruta::valor)
				.average()
				.orElse(0d);
	}

	@Override 
	public String toString() {
		return super.toString();
	}

}
