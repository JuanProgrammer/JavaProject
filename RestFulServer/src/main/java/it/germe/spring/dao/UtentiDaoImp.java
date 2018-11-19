package it.germe.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.germe.spring.model.Utenti;

@Repository
public class UtentiDaoImp implements UtentiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Utenti utenti) {
		sessionFactory.getCurrentSession().save(utenti);
		return utenti.getId();
	}

	@Override
	public Utenti get(long id) {
		return sessionFactory.getCurrentSession().get(Utenti.class, id);
	}

	@Override
	public List<Utenti> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utenti> cq = cb.createQuery(Utenti.class);
		Root<Utenti> root = cq.from(Utenti.class);
		cq.select(root);
		Query<Utenti> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Utenti utenti) {
		Session session = sessionFactory.getCurrentSession();
		Utenti utentiOld = session.byId(Utenti.class).load(id);
		utentiOld.setIdRuolo(utenti.getIdRuolo());
		utentiOld.setIdStatoUtente(utenti.getIdStatoUtente());
		utentiOld.setNome(utenti.getNome());
		utentiOld.setPassword(utenti.getPassword());
		utentiOld.setSaldoIniziale(utenti.getSaldoIniziale());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Utenti utenti = session.byId(Utenti.class).load(id);
		session.delete(utenti);
	}

	@Override
	public List<Utenti> listByIdRuolo(long idRuolo) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utenti> cq = cb.createQuery(Utenti.class);
		Root<Utenti> root = cq.from(Utenti.class);
		cq.select(root).where(cb.equal(root.get("idRuolo"), idRuolo));
		Query<Utenti> query = session.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public List<Utenti> listByIdStatoUtente(long idStatoUtente) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utenti> cq = cb.createQuery(Utenti.class);
		Root<Utenti> root = cq.from(Utenti.class);
		cq.select(root).where(cb.equal(root.get("idStatoUtente"), idStatoUtente));
		Query<Utenti> query = session.createQuery(cq);
		return query.getResultList();
	}	
	

	@Override
	public List<Utenti> listLikeNome(String nome) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utenti> cq = cb.createQuery(Utenti.class);
		Root<Utenti> root = cq.from(Utenti.class);
		cq.select(root).where(cb.like(root.get("nome"), "%"+nome+"%"));
		Query<Utenti> query = session.createQuery(cq);
		return query.getResultList();
	}


}
