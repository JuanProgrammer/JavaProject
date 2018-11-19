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

import it.germe.spring.model.TipologicaRuoli;

@Repository
public class TipologicaRuoliDaoImp implements TipologicaRuoliDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(TipologicaRuoli tipologicaRuoli) {
		sessionFactory.getCurrentSession().save(tipologicaRuoli);
		return tipologicaRuoli.getId();
	}

	@Override
	public TipologicaRuoli get(long id) {
		return sessionFactory.getCurrentSession().get(TipologicaRuoli.class, id);
	}

	@Override
	public List<TipologicaRuoli> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TipologicaRuoli> cq = cb.createQuery(TipologicaRuoli.class);
		Root<TipologicaRuoli> root = cq.from(TipologicaRuoli.class);
		cq.select(root);
		Query<TipologicaRuoli> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, TipologicaRuoli tipologicaRuoli) {
		Session session = sessionFactory.getCurrentSession();
		TipologicaRuoli tipologicaRuoliOld = session.byId(TipologicaRuoli.class).load(id);
		tipologicaRuoliOld.setNome(tipologicaRuoli.getNome());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		TipologicaRuoli tipologicaRuoli = session.byId(TipologicaRuoli.class).load(id);
		session.delete(tipologicaRuoli);
	}

	@Override
	public List<TipologicaRuoli> listLikeNome(String nome) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TipologicaRuoli> cq = cb.createQuery(TipologicaRuoli.class);
		Root<TipologicaRuoli> root = cq.from(TipologicaRuoli.class);
		cq.select(root).where(cb.like(root.get("nome"), "%" + nome + "%"));
		Query<TipologicaRuoli> query = session.createQuery(cq);
		return query.getResultList();
	}

}
