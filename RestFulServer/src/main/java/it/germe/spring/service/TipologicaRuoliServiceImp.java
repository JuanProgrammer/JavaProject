package it.germe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.germe.spring.dao.TipologicaRuoliDao;
import it.germe.spring.model.TipologicaRuoli;

@Service
@Transactional(readOnly = true)
public class TipologicaRuoliServiceImp implements TipologicaRuoliService {

	@Autowired
	private TipologicaRuoliDao tipologicaRuoliDao;

	@Transactional
	@Override
	public long save(TipologicaRuoli tipologicaRuoli) {
		return tipologicaRuoliDao.save(tipologicaRuoli);
	}

	@Transactional
	@Override
	public TipologicaRuoli get(long id) {
		return tipologicaRuoliDao.get(id);
	}

	@Transactional
	@Override
	public List<TipologicaRuoli> list() {
		return tipologicaRuoliDao.list();
	}

	@Transactional
	@Override
	public List<TipologicaRuoli> listLikeNome(String nome) {
		return tipologicaRuoliDao.listLikeNome(nome);
	}

	@Transactional
	@Override
	public void update(long id, TipologicaRuoli tipologicaRuoli) {
		tipologicaRuoliDao.update(id, tipologicaRuoli);
	}

	@Transactional
	@Override
	public void delete(long id) {
		tipologicaRuoliDao.delete(id);
	}

}
