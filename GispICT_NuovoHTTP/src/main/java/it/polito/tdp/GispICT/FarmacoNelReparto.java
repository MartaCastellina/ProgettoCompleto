package it.polito.tdp.GispICT;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;

public class FarmacoNelReparto implements Comparable<FarmacoNelReparto> {
	private StringProperty NomeF1;
	private String NomeF;
	private LocalDate Scadenza;
    private int FID;
    private int Quantita;
    private String NomeR;
	private int RID;

	public FarmacoNelReparto(String nomeF, LocalDate localDate, int fID, int quantita, String nomeR, int rID) {
		super();
        NomeF=nomeF;
		Scadenza = localDate;
		FID = fID;
		Quantita = quantita;
		NomeR = nomeR;
		RID = rID;
	}
	public FarmacoNelReparto() {
		// TODO Auto-generated constructor stub
	}
	public FarmacoNelReparto(FarmacoNelReparto f) {
		NomeF=f.getNomeF();
		Scadenza=f.getScadenza();
		FID=f.getFID();
		Quantita=f.getQuantita();
		NomeR=f.getNomeR();
		RID=f.getRID();
	}
	public LocalDate getScadenza() {
		return Scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		Scadenza = scadenza;
	}
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}

	public void setNomeF(String nomeF) {
		NomeF = nomeF;
	}
	public int getQuantita() {
		return Quantita;
	}
	public void setQuantita(int quantita) {
		Quantita = quantita;
	}
	public String getNomeR() {
		return NomeR;
	}
	public void setNomeR(String nomeR) {
		NomeR = nomeR;
	}
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}

	@Override
	public String toString() {
		return  NomeF + ", there are "
				+ Quantita + " in " + NomeR + " - ExpDate: " + Scadenza + ";\n";
	}
	public ObservableValue<String> FIDO;

	public String getNomeF() {
		// TODO Auto-generated method stub
		return NomeF;
	}
	@Override
	public int compareTo(FarmacoNelReparto f) {
		int result= this.NomeF.compareTo(f.getNomeF());
		if(this.NomeF.equals(f.getNomeF()))
			{return Scadenza.compareTo(f.Scadenza);}
		return result;
	}
	
	
}