package it.germe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.germe.spring.dao.UtentiDao;
import it.germe.spring.model.Utenti;

@Service
@Transactional(readOnly = true)
public class UtentiServiceImp implements UtentiService {

	@Autowired
	private UtentiDao utentiDao;

	@Transactional
	@Override
	public long save(Utenti utenti) {
		return utentiDao.save(utenti);
	}

	@Transactional
	@Override
	public Utenti get(long id) {
		return utentiDao.get(id);
	}

	@Transactional
	@Override
	public List<Utenti> list() {
		return utentiDao.list();
	}

	@Transactional
	@Override
	public List<Utenti> listByIdRuolo(long idRuolo) {
		return utentiDao.listByIdRuolo(idRuolo);
	}

	@Override
	public List<Utenti> listByIdStatoUtente(long idStatoUtente) {
		return utentiDao.listByIdStatoUtente(idStatoUtente);
	}

	@Transactional
	@Override
	public List<Utenti> listLikeNome(String nome) {
		return utentiDao.listLikeNome(nome);
	}

	@Transactional
	@Override
	public void update(long id, Utenti utenti) {
		utentiDao.update(id, utenti);
	}

	@Transactional
	@Override
	public void delete(long id) {
		utentiDao.delete(id);
	}

}
