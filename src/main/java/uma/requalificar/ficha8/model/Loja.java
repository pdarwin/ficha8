package uma.requalificar.ficha8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Loja")
public class Loja
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private int numero_funcionarios;

	private int area;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "andar_id", nullable = false)
	private Andar andar;

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
	 * @return the numero_funcionarios
	 */
	public int getNumero_funcionarios()
	{
		return numero_funcionarios;
	}

	/**
	 * @param numero_funcionarios the numero_funcionarios to set
	 */
	public void setNumero_funcionarios(int numero_funcionarios)
	{
		this.numero_funcionarios = numero_funcionarios;
	}

	/**
	 * @return the area
	 */
	public int getArea()
	{
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(int area)
	{
		this.area = area;
	}

	/**
	 * @return the andar
	 */
	public Andar getAndar()
	{
		return andar;
	}

	/**
	 * @param andar the andar to set
	 */
	public void setAndar(Andar andar)
	{
		this.andar = andar;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

}
