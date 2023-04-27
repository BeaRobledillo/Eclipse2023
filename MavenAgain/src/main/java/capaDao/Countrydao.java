package capaDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Country;
import util.HibernateUtil;

public class Countrydao {

	public Country get(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Country.class, id);
		}
	}

	public List<Country> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Country", Country.class).list();
		}
	}

	public boolean save(Country country) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(country);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean delete(Country country) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.remove(country);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	// Metodo sobrecargado
	public boolean delete(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Country country = get(id);
			return delete(country);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
