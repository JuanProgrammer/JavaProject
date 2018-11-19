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

import it.germe.spring.model.TipologicaStatoUtente;

@Repository
public class TipologicaStatoUtenteDaoImp implements TipologicaStatoUtenteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(TipologicaStatoUtente tipologicaStatoUtente) {
		sessionFactory.getCurrentSession().save(tipologicaStatoUtente);
		return tipologicaStatoUtente.getId();
	}

	@Override
	public TipologicaStatoUtente get(long id) {
		return sessionFactory.getCurrentSession().get(TipologicaStatoUtente.class, id);
	}

	@Override
	public List<TipologicaStatoUtente> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TipologicaStatoUtente> cq = cb.createQuery(TipologicaStatoUtente.class);
		Root<TipologicaStatoUtente> root = cq.from(TipologicaStatoUtente.class);
		cq.select(root);
		Query<TipologicaStatoUtente> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, TipologicaStatoUtente tipologicaStatoUtente) {
		Session session = sessionFactory.getCurrentSession();
		TipologicaStatoUtente tipologicaStatoUtenteOld = session.byId(TipologicaStatoUtente.class).load(id);
		tipologicaStatoUtenteOld.setDescrizione(tipologicaStatoUtente.getDescrizione());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		TipologicaStatoUtente tipologicaStatoUtente = session.byId(TipologicaStatoUtente.class).load(id);
		session.delete(tipologicaStatoUtente);
	}


	@Override
	public List<TipologicaStatoUtente> listLikeDescrizione(String descrizione) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TipologicaStatoUtente> cq = cb.createQuery(TipologicaStatoUtente.class);
		Root<TipologicaStatoUtente> root = cq.from(TipologicaStatoUtente.class);
		cq.select(root).where(cb.like(root.get("descrizione"), "%"+descrizione+"%"));
		Query<TipologicaStatoUtente> query = session.createQuery(cq);
		return query.getResultList();
	}


}
