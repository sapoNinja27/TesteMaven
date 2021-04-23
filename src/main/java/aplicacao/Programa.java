package aplicacao;

import javax.persistence.*;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
//		Pessoa p1=new Pessoa("Nome1","email@gmail.com");
//		Pessoa p2=new Pessoa("Nome2","email@gmail.com");
//		Pessoa p3=new Pessoa("Nome3","email@gmail.com");
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em= emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		Pessoa p= em.find(Pessoa.class, 2);
		System.out.println(p);
		em.close();
		emf.close();
	}

}
