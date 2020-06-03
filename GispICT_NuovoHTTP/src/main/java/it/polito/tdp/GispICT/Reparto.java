package it.polito.tdp.GispICT;

public class Reparto {
	private String Nome;
	private int RID;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public Reparto(String nome, int rID) {
		super();
		Nome = nome;
		RID = rID;
	}
	public Reparto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return  "[" + RID + "] "+Nome;
	}
	

}
