package it.germe.spring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.germe.spring.model.ListaMovimenti;
import it.germe.spring.model.Utenti;
import it.germe.spring.service.ListaMovimentiService;
import it.germe.spring.service.TipologicaRuoliService;
import it.germe.spring.service.TipologicaStatoUtenteService;
import it.germe.spring.service.UtentiService;

@RestController
public class ListaMovimentiController {

	private static final Logger logger = LogManager.getLogger("germelogger");

	@Autowired
	private ListaMovimentiService listaMovimentiService;
	
	@Autowired
	private UtentiService utentiService;
	
	@Autowired
	private TipologicaRuoliService tipologicaRuoliService;	
	
	@Autowired
	private TipologicaStatoUtenteService tipologicaStatoUtenteService;	
	

	/*---Add new book---*/
	@PostMapping("/listaMovimenti")
	public ResponseEntity<?> save(@RequestBody ListaMovimenti listaMovimenti) {
		long id = listaMovimentiService.save(listaMovimenti);
		logger.info("ListaMovimentiController: save - salvato id: "+id);
		return ResponseEntity.ok().body("New ListaMovimenti has been saved with ID:" + id);
	}

	/*---Get a book by id---*/
	@GetMapping("/listaMovimenti/{id}")
	public ResponseEntity<ListaMovimenti> get(@PathVariable("id") long id) {
		ListaMovimenti listaMovimenti = listaMovimentiService.get(id);
		logger.info("ListaMovimentiController: get - recuperato id: "+id);
		return ResponseEntity.ok().body(listaMovimenti);
	}

	/*---get all books---*/
	@GetMapping("/listaMovimenti")
	public ResponseEntity<List<ListaMovimenti>> list() {
		List<ListaMovimenti> listaMovimentis = listaMovimentiService.list();
		logger.info("ListaMovimentiController: list - la lista ha "+listaMovimentis.size()+" elementi");
		return ResponseEntity.ok().body(listaMovimentis);
	}

	/*---get all books like descrizioneOperazione---*/
	@GetMapping("/listaMovimentiLikeDescrizioneOperazione/{descrizioneOperazione}")
	public ResponseEntity<List<ListaMovimenti>> listLikeDescrizioneOperazione(@PathVariable("descrizioneOperazione") String descrizioneOperazione) {
		List<ListaMovimenti> listaMovimentis = listaMovimentiService.listLikeDescrizioneOperazione(descrizioneOperazione);
		logger.info("ListaMovimentiController: listLikeDescrizioneOperazione - lista like descrizioneOperazione: "+descrizioneOperazione+" con "+listaMovimentis.size()+" elementi");
		return ResponseEntity.ok().body(listaMovimentis);
	}

	/*---get all books by idUtente---*/
	@GetMapping("/listaMovimentiByIdUtyente/{idUtente}")
	public ResponseEntity<List<ListaMovimenti>> listIdUtyente(@PathVariable("idUtente") long idUtente) {
		List<ListaMovimenti> listaMovimentis = listaMovimentiService.listByIdUtente(idUtente);
		logger.info("ListaMovimentiController: listIdUtyente - lista by idUtente: "+idUtente+" con "+listaMovimentis.size()+" elementi");
		return ResponseEntity.ok().body(listaMovimentis);
	}

	/*---Update a book by id---*/
	@PutMapping("/listaMovimenti/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ListaMovimenti listaMovimenti) {
		listaMovimentiService.update(id, listaMovimenti);
		logger.info("ListaMovimentiController: update - aggiornato id: "+id);
		return ResponseEntity.ok().body("ListaMovimenti has been updated successfully.");
	}

	/*---Delete a book by id---*/
	@DeleteMapping("/listaMovimenti/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		listaMovimentiService.delete(id);
		logger.info("ListaMovimentiController: delete - cancellato id: "+id);
		return ResponseEntity.ok().body("ListaMovimenti has been deleted successfully.");
	}

	/*---Get Saldo by idUtente---*/
	@GetMapping("/getSaldoByIdUtente/{idUtente}")
	public ResponseEntity<Double> getSaldoByIdUtente(@PathVariable("idUtente") long idUtente) {
		Double saldo = listaMovimentiService.getSaldoByIdUtente(idUtente);
		logger.info("ListaMovimentiController: getSaldoByIdUtente - saldo per idUtente: "+idUtente+"  - Euro: "+saldo);
		return ResponseEntity.ok().body(saldo);
	}
	
	/*---get all books---*/
	@GetMapping("/listaUtenti")
	public ResponseEntity<List<Utenti>> listUtenti() {
		List<Utenti> listaUtenti = utentiService.list();
		logger.info("ListaMovimentiController: listUtenti - la lista ha "+listaUtenti.size()+" elementi");
		return ResponseEntity.ok().body(listaUtenti);
	}
	
	/*---Get a book by id---*/
	@GetMapping("/listaUtenti/{id}")
	public ResponseEntity<Utenti> getUtente(@PathVariable("id") long id) {
		Utenti utenti = utentiService.get(id);
		logger.info("ListaMovimentiController: getUtente - recuperato id: "+id);
		return ResponseEntity.ok().body(utenti);
	}
	
	/*---Get a book by id---*/
	@GetMapping("/listaUtentiByNome/{nome}")
	public ResponseEntity<List<Utenti>> listaUtentiByNome(@PathVariable("nome") String nome) {
		List<Utenti> listLikeNome = utentiService.listLikeNome(nome);
		logger.info("ListaMovimentiController: listaUtentiByNome - lista like nome: "+nome+" con "+listLikeNome.size()+" elementi");
		return ResponseEntity.ok().body(listLikeNome);
	}
	
	
	

}