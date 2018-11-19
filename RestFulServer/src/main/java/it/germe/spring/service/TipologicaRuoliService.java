package it.germe.spring.service;

import java.util.List;

import it.germe.spring.model.TipologicaRuoli;

public interface TipologicaRuoliService {

	long save(TipologicaRuoli tipologicaRuoli);

	TipologicaRuoli get(long id);

	List<TipologicaRuoli> list();

	List<TipologicaRuoli> listLikeNome(String nome);

	void update(long id, TipologicaRuoli tipologicaRuoli);

	void delete(long id);

}
