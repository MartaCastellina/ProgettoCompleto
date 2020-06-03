package it.polito.tdp.GispICT;

import java.time.LocalDate;

public class Richiesta {

	private int idRiceve; //Chi riceve la richiesta
	private String nameRiceve;
	private int idRichiede; //Chi fa la richiesta
	private String nameRichiede;
	private int idFarmaco;
	private String nameFarmaco;
	private int qty;
	private LocalDate scadenza;
	public int getIdRiceve() {
		return idRiceve;
	}
	public void setIdRiceve(int idRiceve) {
		this.idRiceve = idRiceve;
	}
	public String getNameRiceve() {
		return nameRiceve;
	}
	public void setNameRiceve(String nameRiceve) {
		this.nameRiceve = nameRiceve;
	}
	public int getIdRichiede() {
		return idRichiede;
	}
	public void setIdRichiede(int idRichiede) {
		this.idRichiede = idRichiede;
	}
	public String getNameRichiede() {
		return nameRichiede;
	}
	public void setNameRichiede(String nameRichiede) {
		this.nameRichiede = nameRichiede;
	}
	public int getIdFarmaco() {
		return idFarmaco;
	}
	public void setIdFarmaco(int idFarmaco) {
		this.idFarmaco = idFarmaco;
	}
	public String getNameFarmaco() {
		return nameFarmaco;
	}
	public void setNameFarmaco(String nameFarmaco) {
		this.nameFarmaco = nameFarmaco;
	}
	public LocalDate getScadenza() {
		return scadenza;
	}
	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}
	public Richiesta(int idRiceve, String nameRiceve, int idRichiede, String nameRichiede, int idFarmaco,
			String nameFarmaco, int qty, LocalDate scadenza) {
		super();
		this.idRiceve = idRiceve;
		this.nameRiceve = nameRiceve;
		this.idRichiede = idRichiede;
		this.nameRichiede = nameRichiede;
		this.idFarmaco = idFarmaco;
		this.nameFarmaco = nameFarmaco;
		this.qty = qty;
		this.scadenza = scadenza;
	}
	public Richiesta() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Request: " +qty+" of "+nameFarmaco+" from "+nameRichiede+" exp: "+scadenza;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
