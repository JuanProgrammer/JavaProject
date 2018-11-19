package it.germe.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "lista_movimenti")
public class ListaMovimenti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="data_contabile")
	private Date dataContabile;
	
	@Column(name="data_valuta")
	private Date dataValuta;
	
	@Column(name="addebiti")
	private Double addebiti;
	
	@Column(name="accrediti")
	private Double accrediti;
	
	@Column(name="descrizione_operazioni")
	private String descrizioneOperazioni;
	
	@Column(name="codice_causale")
	private String codiceCausale;
	
	@Column(name="id_utente")
	private Long idUtente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataContabile() {
		return dataContabile;
	}

	public void setDataContabile(Date dataContabile) {
		this.dataContabile = dataContabile;
	}

	public Date getDataValuta() {
		return dataValuta;
	}

	public void setDataValuta(Date dataValuta) {
		this.dataValuta = dataValuta;
	}

	public Double getAddebiti() {
		return addebiti;
	}

	public void setAddebiti(Double addebiti) {
		this.addebiti = addebiti;
	}

	public Double getAccrediti() {
		return accrediti;
	}

	public void setAccrediti(Double accrediti) {
		this.accrediti = accrediti;
	}

	public String getDescrizioneOperazioni() {
		return descrizioneOperazioni;
	}

	public void setDescrizioneOperazioni(String descrizioneOperazioni) {
		this.descrizioneOperazioni = descrizioneOperazioni;
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public String getCodiceCausale() {
		return codiceCausale;
	}

	public void setCodiceCausale(String codiceCausale) {
		this.codiceCausale = codiceCausale;
	}

}
