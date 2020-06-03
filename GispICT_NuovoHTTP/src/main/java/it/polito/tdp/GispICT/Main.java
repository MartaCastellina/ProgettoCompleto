package it.polito.tdp.GispICT;

public class Main {

	public static void main(String[] args) {
	// Devo distinguere tra parallelismo reale o concorrente nei thread
			//in un certo istante è eseguito thread 1, poi 2, poi 1 di nuovo => distribuzione simulata
			//Thread t1=new Thread (new EntryPoint()); //estende Thread, è come scrivere new Thread
			Thread t2=new Http();

			//t1.start();
			t2.start();
	}

}
