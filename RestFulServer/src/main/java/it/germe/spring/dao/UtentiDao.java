package it.germe.spring.dao;

import java.util.List;

import it.germe.spring.model.Utenti;

public interface UtentiDao {

   long save(Utenti utenti);

   Utenti get(long id);

   List<Utenti> list();
   
   List<Utenti> listByIdRuolo(long idRuolo);
   
   List<Utenti> listByIdStatoUtente(long idStatoUtente);
   
   List<Utenti> listLikeNome(String nome);
   
   void update(long id, Utenti utenti);

   void delete(long id);

}
