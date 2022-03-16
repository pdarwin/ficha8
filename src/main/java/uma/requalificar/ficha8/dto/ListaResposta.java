package uma.requalificar.ficha8.dto;

import java.util.List;

public class ListaResposta extends SimpleResponse {

	private List<?> lista;
	public ListaResposta() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the pessoas
	 */
	public List<?> getLista() {
		return lista;
	}
	/**
	 * @param pessoas the pessoas to set
	 */
	public void setLista(List<?> lista) {
		this.lista = lista;
	}
	
	
	
}
