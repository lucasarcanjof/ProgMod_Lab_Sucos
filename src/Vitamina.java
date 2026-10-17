
public class Vitamina extends Bebida {

	private static final double ACRESCIMO = 2.5;
	private static final int MAX_FRUTAS = 3;

	/** Ajuste de preço da vitamina de acordo com seu tamanho (quantidade de frutas). */
	private enum ETamanho {
		PEQUENA(0.0),
		MEDIA(0.40),
		GRANDE(0.60);

		private double ajuste;

		ETamanho(double ajuste) {
			this.ajuste = ajuste;
		}

		private static ETamanho paraQuantidade(int quantFrutas) {
			return values()[quantFrutas - 1];
		}
	}

	public Vitamina(EFruta fruta) {
		super("Vitamina");
		frutas.add(fruta);
	}

	/**
	 * Adiciona uma fruta à vitamina. A vitamina aceita até três frutas quaisquer.
	 * @param fruta Fruta a ser adicionada
	 * @return Quantidade de frutas na vitamina após a tentativa
	 */
	@Override 
	public int adicionar(EFruta fruta) {
		if (fruta != null && frutas.size() < MAX_FRUTAS) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	/**
	 * Preço da vitamina: (média das frutas + leite) com o ajuste do tamanho.
	 * @return Preço da vitamina
	 */
	@Override 
	public double preco() {
		double media = frutas.stream()
				.mapToDouble(EFruta::valor)
				.average()
				.orElse(0d);
		return (media + ACRESCIMO) * (1 + tamanho().ajuste);
	}

	private ETamanho tamanho() {
		return ETamanho.paraQuantidade(frutas.size());
	}

	@Override 
	public String toString() {
		return super.toString() + " (" + tamanho().name().toLowerCase() + ")";
	}

}
