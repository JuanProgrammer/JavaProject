package it.germe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.germe.spring.dao.ListaMovimentiDao;
import it.germe.spring.dao.UtentiDao;
import it.germe.spring.model.ListaMovimenti;

@Service
@Transactional(readOnly = true)
public class ListaMovimentiServiceImp implements ListaMovimentiService {

	@Autowired
	private ListaMovimentiDao listaMovimentiDao;
	
	@Autowired
	private UtentiDao utentiDao;

	@Transactional
	@Override
	public long save(ListaMovimenti listaMovimenti) {
		return listaMovimentiDao.save(listaMovimenti);
	}

	@Override
	public ListaMovimenti get(long id) {
		return listaMovimentiDao.get(id);
	}

	@Override
	public List<ListaMovimenti> list() {
		return listaMovimentiDao.list();
	}

	@Transactional
	@Override
	public void update(long id, ListaMovimenti listaMovimenti) {
		listaMovimentiDao.update(id, listaMovimenti);
	}

	@Transactional
	@Override
	public void delete(long id) {
		listaMovimentiDao.delete(id);
	}

	@Transactional
	@Override
	public List<ListaMovimenti> listByIdUtente(long idUtente) {
		return listaMovimentiDao.listByIdUtente(idUtente);
	}

	@Transactional
	@Override
	public List<ListaMovimenti> listLikeDescrizioneOperazione(String descrizioneOperazione) {
		return listaMovimentiDao.listLikeDescrizioneOperazione(descrizioneOperazione);
	}

	@Transactional
	@Override
	public List<ListaMovimenti> listByCausale(String causale) {
		return listaMovimentiDao.listByCausale(causale);
	}

	@Transactional
	@Override
	public Double getSaldoByIdUtente(long idUtente) {
		Double saldo = 0.0;
		if(utentiDao.get(idUtente) != null) {
			saldo = utentiDao.get(idUtente).getSaldoIniziale();
		}
		List<ListaMovimenti> listByIdUtente = listaMovimentiDao.listByIdUtente(idUtente);
		for (ListaMovimenti listaMovimenti : listByIdUtente) {
			saldo = saldo + listaMovimenti.getAccrediti();
			saldo = saldo - listaMovimenti.getAddebiti();
		}
		return saldo;
	}

}
