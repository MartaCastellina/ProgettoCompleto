package it.polito.tdp.GispICT;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.MartaDAO;

public class MartaModel {

	private MartaDAO mDAO;
	private Reparto selezionato=new Reparto();
	private List <Farmaco> farmaci;
	
	public MartaModel() {
		mDAO=new MartaDAO();
		farmaci=new ArrayList<Farmaco>();
		
	}
	public List <Reparto> getAllReparti(){
		return mDAO.listaReparti();
	}
	public void setRepartoSelezionato(Reparto reparto) {
		this.selezionato=reparto;		
	}
	public Reparto getRepartoSelezionato() {
		return selezionato;
	}
	public List <Farmaco> getAllFarmaci(){
		return mDAO.listaFarmaci();
	}
	public Farmaco getFarmaco(int idFarmaco) {
		
		this.farmaci=mDAO.listaFarmaci();
		for (Farmaco farmaco:farmaci) {
			if (farmaco.getFID()==idFarmaco) {
				return farmaco;
			}
		}
		return null;
	}
	public void aggiungiFarmacoNelReparto(FarmacoNelReparto farmacoDaInserire) {
		mDAO.aggiungiNuovoFarmaco(farmacoDaInserire);
		
	}
	
	
	
	
}
