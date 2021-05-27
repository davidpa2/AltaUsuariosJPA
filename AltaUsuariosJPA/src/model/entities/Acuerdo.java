package model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acuerdo database table.
 * 
 */
@Entity
@NamedQuery(name="Acuerdo.findAll", query="SELECT a FROM Acuerdo a")
public class Acuerdo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Idioma
	@ManyToOne
	@JoinColumn(name="idIdioma")
	private Idioma idioma;

	public Acuerdo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Idioma getIdioma() {
		return this.idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

}