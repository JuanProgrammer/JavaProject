package it.germe.spring.service;

import java.util.List;

import it.germe.spring.model.TipologicaStatoUtente;

public interface TipologicaStatoUtenteService {
	
	long save(TipologicaStatoUtente tipologicaStatoUtente);

	TipologicaStatoUtente get(long id);

	List<TipologicaStatoUtente> list();

	List<TipologicaStatoUtente> listLikeDescrizione(String descrizione);

	void update(long id, TipologicaStatoUtente tipologicaStatoUtente);

	void delete(long id);

}
