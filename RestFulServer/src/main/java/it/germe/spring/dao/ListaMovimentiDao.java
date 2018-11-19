package it.germe.spring.dao;

import java.util.List;

import it.germe.spring.model.ListaMovimenti;

public interface ListaMovimentiDao {

   long save(ListaMovimenti listaMovimenti);

   ListaMovimenti get(long id);

   List<ListaMovimenti> list();
   
   List<ListaMovimenti> listByIdUtente(long idUtente);
   
   List<ListaMovimenti> listLikeDescrizioneOperazione(String descrizioneOperazione);
   
   List<ListaMovimenti> listByCausale(String causale);

   void update(long id, ListaMovimenti listaMovimenti);

   void delete(long id);

}
