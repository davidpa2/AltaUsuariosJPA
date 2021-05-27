package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the idioma database table.
 * 
 */
@Entity
@NamedQuery(name="Idioma.findAll", query="SELECT i FROM Idioma i")
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Acuerdo
	@OneToMany(mappedBy="idioma")
	private List<Acuerdo> acuerdos;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="idPais")
	private Pai pai;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idioma")
	private List<Usuario> usuarios;

	public Idioma() {
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

	public List<Acuerdo> getAcuerdos() {
		return this.acuerdos;
	}

	public void setAcuerdos(List<Acuerdo> acuerdos) {
		this.acuerdos = acuerdos;
	}

	public Acuerdo addAcuerdo(Acuerdo acuerdo) {
		getAcuerdos().add(acuerdo);
		acuerdo.setIdioma(this);

		return acuerdo;
	}

	public Acuerdo removeAcuerdo(Acuerdo acuerdo) {
		getAcuerdos().remove(acuerdo);
		acuerdo.setIdioma(null);

		return acuerdo;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setIdioma(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setIdioma(null);

		return usuario;
	}

}