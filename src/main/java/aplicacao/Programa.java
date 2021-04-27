package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
	}
	public void incluir(Pessoa p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	public Pessoa buscar(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, id);
		em.close();
		emf.close();
		return p;
	}
	public void editar(int id,Pessoa np) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa p=em.find(Pessoa.class, id);
		if(np.getNome()!=null) {
			p.setNome(np.getNome());
		}
		if(np.getEmail()!=null) {
			p.setEmail(np.getEmail());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	public void deletar(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa p=em.find(Pessoa.class, id);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	public List<Pessoa> listar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Pessoa> pessoas = cb.createQuery(Pessoa.class);
	    Root<Pessoa> rootEntry = pessoas.from(Pessoa.class);
	    CriteriaQuery<Pessoa> all = pessoas.select(rootEntry);
	    TypedQuery<Pessoa> allQuery = em.createQuery(all);
		em.close();
		emf.close();
	    return allQuery.getResultList();
	}

}
