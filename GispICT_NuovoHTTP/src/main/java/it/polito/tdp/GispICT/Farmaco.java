package it.polito.tdp.GispICT;

import java.util.Date;

public class Farmaco {
	private String Nome;
	private Date Scadenza;
    private int FID;
    private int Conservazione;
    private String Link;
    private int riordino;
    
	public Farmaco(int fID, String nome, int conservazione, String link, int riordino) {
		super();
		Nome = nome;
		FID = fID;
		Conservazione = conservazione;
		Link = link;
		this.riordino = riordino;
	}
	
	public Farmaco(int id, String name) {
		Nome = name;
		FID = id;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getScadenza() {
		return Scadenza;
	}
	public void setScadenza(Date scadenza) {
		Scadenza = scadenza;
	}
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	public int getConservazione() {
		return Conservazione;
	}
	public void setConservazione(int conservazione) {
		Conservazione = conservazione;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public int getRiordino() {
		return riordino;
	}
	public void setRiordino(int riordino) {
		this.riordino = riordino;
	}

	@Override
	public String toString() {
		return "[" + FID + "] "+Nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FID;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Farmaco other = (Farmaco) obj;
		if (FID != other.FID)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}
	
	
}
