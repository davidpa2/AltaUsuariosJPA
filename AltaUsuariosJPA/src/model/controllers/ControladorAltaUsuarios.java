package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Acuerdo;
import model.entities.Idioma;
import model.entities.Pai;
import model.entities.Usuario;

public class ControladorAltaUsuarios {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorAltaUsuarios instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("AltaUsuariosJPA");
	
		
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorAltaUsuarios getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorAltaUsuarios();
		}
		return instance;
	}	
	
	public ControladorAltaUsuarios() {
		
	}

	/**
	 * Buscar todas los registros introducidos en la tabla valoracionmateria
	 * @return
	 */
	public List<Pai> findAllPaises() {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM pais;", Pai.class);
		
		List<Pai> paises = (List<Pai>) q.getResultList();
		
		em.close();
		
		return paises;
	}
	
	/**
	 * Buscar todas los registros introducidos en la tabla valoracionmateria
	 * @return
	 */
	public List<Idioma> findAllIdiomas(Pai pais) {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM idioma where idpais = ?;", Idioma.class);
		q.setParameter(1, pais.getId());
		
		List<Idioma> idiomas = (List<Idioma>) q.getResultList();
		
		em.close();
		
		return idiomas;
	}
	
	/**
	 * 
	 * @param idioma
	 * @return
	 */
	public Acuerdo mostrarIdioma(Idioma idioma) {
		Acuerdo a = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from acuerdo where idIdioma = ?;", Acuerdo.class);
			q.setParameter(1, idioma.getId());
			a = (Acuerdo) q.getSingleResult();
			em.close();
			return a;
		} catch (Exception e) {
			return a;
		}
	}
	
	/**
	 * 
	 * @param idioma
	 * @return
	 */
	public Acuerdo buscarUsuarioIgual(Usuario usuario) {
		Acuerdo a = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from usuario where idIdioma = ?;", Acuerdo.class);
			q.setParameter(1, usuario.getId());
			a = (Acuerdo) q.getSingleResult();
			em.close();
			return a;
		} catch (Exception e) {
			return a;
		}
	}
	
	/**
	 * Buscar todas los registros introducidos en la tabla valoracionmateria
	 * @return
	 */
	public List<Usuario> findAllUsuarios() {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM usuario;", Usuario.class);
		
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		em.close();
		
		return usuarios;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Usuario u) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (u.getId() == 0) {
				//Introducir uno nuevo
				em.persist(u);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
