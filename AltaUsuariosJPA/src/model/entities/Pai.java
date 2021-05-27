package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pai.findAll", query="SELECT p FROM Pai p")
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Idioma
	@OneToMany(mappedBy="pai")
	private List<Idioma> idiomas;

	public Pai() {
	}
	
	

	@Override
	public String toString() {
		return descripcion;
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

	public List<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Idioma addIdioma(Idioma idioma) {
		getIdiomas().add(idioma);
		idioma.setPai(this);

		return idioma;
	}

	public Idioma removeIdioma(Idioma idioma) {
		getIdiomas().remove(idioma);
		idioma.setPai(null);

		return idioma;
	}

}