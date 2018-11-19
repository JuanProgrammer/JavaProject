package it.germe.spring.service;

import java.util.List;

import it.germe.spring.model.ListaMovimenti;

public interface ListaMovimentiService {

   long save(ListaMovimenti listaMovimenti);
   ListaMovimenti get(long id);
   List<ListaMovimenti> list();
   void update(long id, ListaMovimenti listaMovimenti);
   void delete(long id);
   List<ListaMovimenti> listByIdUtente(long idUtente);
   List<ListaMovimenti> listLikeDescrizioneOperazione(String descrizioneOperazione);
   List<ListaMovimenti> listByCausale(String causale);
   Double getSaldoByIdUtente(long idUtente);
}
