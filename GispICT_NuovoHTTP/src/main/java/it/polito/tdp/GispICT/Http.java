package it.polito.tdp.GispICT;

import java.awt.Dimension;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import it.polito.tdp.Controller.HomeController;
import it.polito.tdp.db.MartaDAO;


public class Http extends Thread{
	MartaDAO dao=new MartaDAO();

private boolean st=true;
int i=0;
  @Override
  public void run() { //Run() è la funzione che il thread carica in fase di costruzione. E' invocato quando si effettua chiamata al metodo start()
    while (true) {
      try {
      URL url = new URL("https://api.thingspeak.com/channels/1052295/fields/1.json?api_key=XQ8FC2GJYJJNTPBL&results=1");
      i++;
      if(i>=10) //10 letture
      { st=true;
      i=0;}
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();
      int res=conn.getResponseCode();
      System.out.println("Respond:\n");
      System.out.println(res);
      // checks if the connection is responding 200 code or not.
      
      if(res==200) {
        String inline = "";
        Scanner sc = new Scanner(url.openStream());
        while(sc.hasNext())
        
        {
        
        inline+=sc.nextLine();

        }
        String[] part=inline.split(Pattern.quote("{"));
          System.out.println(part[part.length-1]);
          String parte1=part[part.length-1];
          String[] temperatura=parte1.split(Pattern.quote(":"));
          String temp=temperatura[temperatura.length-1];
      
     
          String temp1=temp.substring(1, temp.length()-4);
          double temperaturadouble= Double.parseDouble(temp1);
          System.out.println(temperaturadouble);
          System.out.println(inline);
          double IDLettura=Math.random(); //Genero un codice univoco
          dao.addRecordDigitalMed(temperaturadouble,IDLettura);
        if ((temperaturadouble>25 || temperaturadouble<0) && st) { //check sulla temperatura
                    
                final JFrame parent = new JFrame();
                JButton button = new JButton();
                parent.setPreferredSize(new Dimension(400, 300));
                JLabel label1 = new JLabel("ALERT TEMPERATURE");
                JLabel label2 = new JLabel("Current temperature: "+temperaturadouble);
                button.setText("ALERT TEMPERATURE");
                parent.add(label1);
                parent.add(label2);
                parent.add(button);
                parent.pack();
                parent.setVisible(true);
                st= false;

                button.addActionListener(new java.awt.event.ActionListener() {
                	//Per gestire l'interazione con il bottone
                 
                    @Override
                    
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                     
                    
                        try {
                          String name = JOptionPane.showInputDialog(parent,
                                  "Change temperature",JOptionPane.INFORMATION_MESSAGE );
                        
                  Thread.sleep(200);
                } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                }
                    }
                });
            }
        
        sc.close();
      }
      try {
		Thread.sleep(5000); //Metto il thread in sleep per 5 secondi. Devo usare Try catch perchè è possibile che un altro thread
							//invochi il metodo interrupt() e interrompa lo stato di sleep. Infatti c'è InterruptedException
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }

      
    catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }}
    }
    
  


  }