package one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveFbAccount {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		FbAccount fbAccount = new FbAccount();
		fbAccount.setEmail("priya@gmail.com");
		fbAccount.setPassword("Priya123");

		FbPage fbPage1 = new FbPage();
		fbPage1.setName("tom");
		fbPage1.setTitle("Welcome to facebook");
		fbPage1.setDescription("Don't expect any thing from anyone");

		FbPage fbPage2 = new FbPage();
		fbPage2.setName("Jerry");
		fbPage2.setTitle("Welcome to Instagram");
		fbPage2.setDescription("Don't expect any thing from anyone");

		List<FbPage> fbPages = new ArrayList<FbPage>();
		fbPages.add(fbPage1);
		fbPages.add(fbPage2);

		fbAccount.setFbpage(fbPages);
		entityTransaction.begin();
		entityManager.persist(fbAccount);
		entityManager.persist(fbPage1);
		entityManager.persist(fbPage2);
		entityTransaction.commit();

	}
}
