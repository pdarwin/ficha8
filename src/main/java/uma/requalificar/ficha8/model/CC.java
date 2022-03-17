package uma.requalificar.ficha8.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Centro_Comercial")
public class CC
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private String morada;

	private int numero_max_andar;

	@OneToMany(mappedBy = "cc")
	private List<Andar> andares;

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the morada
	 */
	public String getMorada()
	{
		return morada;
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada)
	{
		this.morada = morada;
	}

	/**
	 * @return the numero_max_andar
	 */
	public int getNumero_max_andar()
	{
		return numero_max_andar;
	}

	/**
	 * @param numero_max_andar the numero_max_andar to set
	 */
	public void setNumero_max_andar(int numero_max_andar)
	{
		this.numero_max_andar = numero_max_andar;
	}

	/**
	 * @return the andares
	 */
	public List<Andar> getAndares()
	{
		return andares;
	}

	/**
	 * @param andares the andares to set
	 */
	public void setAndares(List<Andar> andares)
	{
		this.andares = andares;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

}
