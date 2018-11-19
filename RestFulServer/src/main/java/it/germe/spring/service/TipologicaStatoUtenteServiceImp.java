package it.germe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.germe.spring.dao.TipologicaStatoUtenteDao;
import it.germe.spring.model.TipologicaStatoUtente;

@Service
@Transactional(readOnly = true)
public class TipologicaStatoUtenteServiceImp implements TipologicaStatoUtenteService {

	@Autowired
	private TipologicaStatoUtenteDao tipologicaStatoUtenteDao;

	@Transactional
	@Override
	public long save(TipologicaStatoUtente tipologicaStatoUtente) {
		return tipologicaStatoUtenteDao.save(tipologicaStatoUtente);
	}

	@Transactional
	@Override
	public TipologicaStatoUtente get(long id) {
		return tipologicaStatoUtenteDao.get(id);
	}

	@Transactional
	@Override
	public List<TipologicaStatoUtente> list() {
		return tipologicaStatoUtenteDao.list();
	}

	@Transactional
	@Override
	public List<TipologicaStatoUtente> listLikeDescrizione(String descrizione) {
		return tipologicaStatoUtenteDao.listLikeDescrizione(descrizione);
	}

	@Transactional
	@Override
	public void update(long id, TipologicaStatoUtente tipologicaStatoUtente) {
		tipologicaStatoUtenteDao.update(id, tipologicaStatoUtente);
	}

	@Transactional
	@Override
	public void delete(long id) {
		tipologicaStatoUtenteDao.delete(id);
	}

}
