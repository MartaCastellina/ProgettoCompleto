package it.polito.tdp.GispICT;

public class DigitalMed {
int id;
int temperatura;
Reparto reparto;
int temperaturaMAX;
public DigitalMed(int id, int temperatura, Reparto reparto, int temperaturaMAX) {
	super();
	this.id = id;
	this.temperatura = temperatura;
	this.reparto = reparto;
	this.temperaturaMAX = temperaturaMAX;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTemperatura() {
	return temperatura;
}
public void setTemperatura(int temperatura) {
	this.temperatura = temperatura;
}
public Reparto getReparto() {
	return reparto;
}
public void setReparto(Reparto reparto) {
	this.reparto = reparto;
}
public int getTemperaturaMAX() {
	return temperaturaMAX;
}
public void setTemperaturaMAX(int temperaturaMAX) {
	this.temperaturaMAX = temperaturaMAX;
}
@Override
public String toString() {
	return "Arduino [id=" + id + ", temperatura=" + temperatura + ", reparto=" + reparto + ", temperaturaMAX="
			+ temperaturaMAX + "]";
}
public DigitalMed(int id, int temperatura) {
	super();
	this.id = id;
	this.temperatura = temperatura;
}



}
