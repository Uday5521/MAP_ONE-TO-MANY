package one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobleSim {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Sony");
		mobile.setCost(50000.00);
		mobile.setName("IPHONE");
		mobile.setCost(70000.00);
		mobile.setName("MI");
		mobile.setCost(15000.00);
		
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("3G");
		sim1.setProvider("JIO");
		sim1.setType("4G");
		
		Sim sim2 = new Sim();
		sim2.setProvider("BSNL");
		sim2.setType("4G");
		sim2.setProvider("VI");
		sim2.setType("5G");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		
		mobile.setSim(sims);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
}

}
