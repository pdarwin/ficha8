package uma.requalificar.ficha8.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Andar")
public class Andar {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name ="id", nullable = false)
	private Long id;
	
	private int numero_andar;
	
	private int numero_max_lojas;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="centro_comercial_id", nullable=false)
    private CC cc;
    
	@OneToMany(mappedBy="andar")
	private List <Loja> lojas;

	/**
	 * @return the numero_andar
	 */
	public int getNumero_andar() {
		return numero_andar;
	}

	/**
	 * @param numero_andar the numero_andar to set
	 */
	public void setNumero_andar(int numero_andar) {
		this.numero_andar = numero_andar;
	}

	/**
	 * @return the numero_max_lojas
	 */
	public int getNumero_max_lojas() {
		return numero_max_lojas;
	}

	/**
	 * @param numero_max_lojas the numero_max_lojas to set
	 */
	public void setNumero_max_lojas(int numero_max_lojas) {
		this.numero_max_lojas = numero_max_lojas;
	}

	/**
	 * @return the cc
	 */
	public CC getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(CC cc) {
		this.cc = cc;
	}

	/**
	 * @return the lojas
	 */
	public List<Loja> getLojas() {
		return lojas;
	}

	/**
	 * @param lojas the lojas to set
	 */
	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	

}
