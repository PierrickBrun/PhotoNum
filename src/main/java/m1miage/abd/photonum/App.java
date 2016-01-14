package m1miage.abd.photonum;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import m1miage.abd.photonum.db.Client;

/**
 * Hello world!
 *
 */
public class App {

	private static final String PERSISTENCE_UNIT_NAME = "db";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select c from Client c");
		List<Client> clientList = q.getResultList();
		for (Client client : clientList) {
			System.out.println(client);
		}
		System.out.println("Size: " + clientList.size());

		// create new client
		em.getTransaction().begin();
		Client client = new Client("Michel", "Louise", "louise@jacquieetmichel.fr", "Grenoble", "123456");
		em.persist(client);
		em.getTransaction().commit();

		em.close();
	}
}
