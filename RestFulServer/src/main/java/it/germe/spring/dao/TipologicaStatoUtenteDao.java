package it.germe.spring.dao;

import java.util.List;

import it.germe.spring.model.TipologicaStatoUtente;

public interface TipologicaStatoUtenteDao {

   long save(TipologicaStatoUtente tipologicaStatoUtente);

   TipologicaStatoUtente get(long id);

   List<TipologicaStatoUtente> list();
   
   List<TipologicaStatoUtente> listLikeDescrizione(String descrizione);
   
   void update(long id, TipologicaStatoUtente tipologicaStatoUtente);

   void delete(long id);

}
