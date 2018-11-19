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

import it.germe.spring.model.ListaMovimenti;

@Repository
public class ListaMovimentiDaoImp implements ListaMovimentiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(ListaMovimenti listaMovimenti) {
		sessionFactory.getCurrentSession().save(listaMovimenti);
		return listaMovimenti.getId();
	}

	@Override
	public ListaMovimenti get(long id) {
		return sessionFactory.getCurrentSession().get(ListaMovimenti.class, id);
	}

	@Override
	public List<ListaMovimenti> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ListaMovimenti> cq = cb.createQuery(ListaMovimenti.class);
		Root<ListaMovimenti> root = cq.from(ListaMovimenti.class);
		cq.select(root);
		Query<ListaMovimenti> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, ListaMovimenti listaMovimenti) {
		Session session = sessionFactory.getCurrentSession();
		ListaMovimenti listaMovimentiOld = session.byId(ListaMovimenti.class).load(id);
		listaMovimentiOld.setAccrediti(listaMovimenti.getAccrediti());
		listaMovimentiOld.setAddebiti(listaMovimenti.getAddebiti());
		listaMovimentiOld.setCodiceCausale(listaMovimenti.getCodiceCausale());
		listaMovimentiOld.setDataContabile(listaMovimenti.getDataContabile());
		listaMovimentiOld.setDataValuta(listaMovimenti.getDataValuta());
		listaMovimentiOld.setDescrizioneOperazioni(listaMovimenti.getDescrizioneOperazioni());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		ListaMovimenti listaMovimenti = session.byId(ListaMovimenti.class).load(id);
		session.delete(listaMovimenti);
	}

	@Override
	public List<ListaMovimenti> listByIdUtente(long idUtente) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ListaMovimenti> cq = cb.createQuery(ListaMovimenti.class);
		Root<ListaMovimenti> root = cq.from(ListaMovimenti.class);
		cq.select(root).where(cb.equal(root.get("idUtente"), idUtente));
		Query<ListaMovimenti> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<ListaMovimenti> listLikeDescrizioneOperazione(String descrizioneOperazione) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ListaMovimenti> cq = cb.createQuery(ListaMovimenti.class);
		Root<ListaMovimenti> root = cq.from(ListaMovimenti.class);
		cq.select(root).where(cb.like(root.get("descrizioneOperazioni"), "%"+descrizioneOperazione+"%"));
		Query<ListaMovimenti> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<ListaMovimenti> listByCausale(String causale) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ListaMovimenti> cq = cb.createQuery(ListaMovimenti.class);
		Root<ListaMovimenti> root = cq.from(ListaMovimenti.class);
		cq.select(root).where(cb.equal(root.get("causale"), causale));
		Query<ListaMovimenti> query = session.createQuery(cq);
		return query.getResultList();
	}

}
