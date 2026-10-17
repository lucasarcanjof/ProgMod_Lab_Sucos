import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Bebida> itens;

	public Pedido() {
		itens = new ArrayList<>();
	}

	/**
	 * Adiciona uma bebida ao pedido.
	 * @param item Bebida a ser adicionada (nulos são ignorados)
	 * @return Quantidade de itens no pedido após a tentativa
	 */
	public int adicionar(Bebida item) {
		if (item != null) {
			itens.add(item);
		}
		return itens.size();
	}

	public double preco() {
		return itens.stream()
				.mapToDouble(Bebida::preco)
				.sum();
	}

	@Override 
	public String toString() {
		StringBuilder relatorio = new StringBuilder("Pedido:\n");
		for (Bebida item : itens) {
			relatorio.append("  ").append(item).append("\n");
		}
		relatorio.append(String.format("Total: R$ %.2f", preco()));
		return relatorio.toString();
	}

}
