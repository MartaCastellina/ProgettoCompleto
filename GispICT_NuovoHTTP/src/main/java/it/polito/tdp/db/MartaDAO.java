package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.GispICT.Farmaco;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.GispICT.Reparto;
import it.polito.tdp.GispICT.Richiesta;

public class MartaDAO {

	
	List<FarmacoNelReparto> farmaciNelReparto=farmaciNelReparto(106); //mi restituisce i farmaci che ho
	public List<Reparto>listaReparti(){
		String sql = "SELECT NameWard, IDWard \n" + 
				"FROM magazzinoreparti \n" + 
				"GROUP BY IDWard, NameWard";

		
		List<Reparto> result = new ArrayList<Reparto>();
		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add(new Reparto(res.getString("NameWard"), res.getInt("IDWard"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	private List<FarmacoNelReparto> farmaciNelReparto(int id) {
		String sql = "SELECT IDWard,NameWard,Quantity, NamePharma,IDPharma,ExpDate FROM magazzinoreparti WHERE IDWard=? ";
		
		List<FarmacoNelReparto> result = new ArrayList<FarmacoNelReparto>();
		
		Connection conn = DBConnection.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, id);
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add( new FarmacoNelReparto(res.getString("NamePharma"), res.getDate("ExpDate").toLocalDate(),res.getInt("IDPharma"), res.getInt("Quantity"), res.getString("NameWard"), res.getInt("IDWard"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public List<Farmaco> listaFarmaci() {
		String sql = "SELECT IDPharma,Name,Conservation,Link,Reorder " + 
				"FROM farmaci ";

		
		List<Farmaco> result = new ArrayList<Farmaco>();
		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add(new Farmaco(res.getInt("IDPharma"), res.getString("Name"), res.getInt("Conservation"),
						res.getString("Link"),res.getInt("Reorder"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public void aggiungiNuovoFarmaco(FarmacoNelReparto farmacoDaInserire) {
		String sql = "INSERT INTO magazzinoreparti (IDWard,NameWard,IDPharma,NamePharma,Quantity,ExpDate) " + 
				"VALUES (?,?,?,?,?,?) ";

		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setInt(1, farmacoDaInserire.getRID());
			st.setString(2, farmacoDaInserire.getNomeR());
			st.setInt(3,farmacoDaInserire.getFID());
			st.setString(4,farmacoDaInserire.getNomeF());
			st.setInt(5, farmacoDaInserire.getQuantita());
			st.setDate(6, Date.valueOf(farmacoDaInserire.getScadenza()));
			st.executeUpdate();
			System.out.println("aggiunto");
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	public String getElencoScadenza(int id) {
		String result="";
		
		String sql = "SELECT IDPharma,NamePharma, ExpDate " + 
				"FROM magazzinoreparti " + 
				"WHERE IDWard=? AND ExpDate>'2020-06-30' AND ExpDate < '2020-08-01' ";
	
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, id);
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result+=res.getString("NamePharma")+" [ID:"+res.getInt("IDPharma")+"] "+" - Exp: "+res.getDate("ExpDate")+"\n";
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	public String getElencoFarmaci(Reparto reparto) {
		String result="";
		
		String sql = "SELECT IDPharma,NamePharma, ExpDate , Quantity " + 
				"FROM magazzinoreparti " + 
				"WHERE IDWard=?";
	
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, reparto.getRID());
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result+= res.getString("NamePharma")+": Quantity = "+res.getInt("Quantity")+" - Expire = "+res.getDate("ExpDate").toLocalDate()+"\n";
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public List getRichieste(int id) {
	
		
		String sql = "SELECT IdWardRiceve,NomeRiceve,IdWardRichiede,NomeRichiede,IdPharma,NamePharma,Qty,ExpDate " + 
				"FROM richieste " + 
				"WHERE IdWardRiceve=? ";

		
		List<Richiesta> result = new ArrayList<Richiesta>();
		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, id);
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add(new Richiesta(res.getInt("IdWardRiceve"),res.getString("NomeRiceve"),res.getInt("IdWardRichiede"),
						res.getString("NomeRichiede"),res.getInt("IdPharma"),res.getString("NamePharma"),res.getInt("Qty"),res.getDate("ExpDate").toLocalDate())) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public void accetta(Richiesta richiesta) {
		int quantitaRichiesta=richiesta.getQty();
		FarmacoNelReparto selezionato=new FarmacoNelReparto();
		System.out.println(farmaciNelReparto);
		for (FarmacoNelReparto f: farmaciNelReparto) {
			if (f.getFID()==richiesta.getIdFarmaco() && f.getScadenza().equals(richiesta.getScadenza())) {
				selezionato=new FarmacoNelReparto(f);
				System.out.println(selezionato.toString());
			}
		}
			int nuova= selezionato.getQuantita()-quantitaRichiesta;
			System.out.println(selezionato.toString());
			Date data=Date.valueOf(selezionato.getScadenza());
			if(nuova==0){
				String sql="DELETE FROM magazzinoreparti WHERE IDWard=? AND IDPharma=? AND ExpDate=?;";
				Connection conn = DBConnection.getConnection() ;
			
			try {
				PreparedStatement st = conn.prepareStatement(sql) ;
				st.setInt(1,selezionato.getRID());
				st.setInt(2,selezionato.getFID());
				st.setDate(3,(java.sql.Date) data);
				
				st.executeUpdate();
				
				conn.close();
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
				
			}}
			else
			{   
				String sql="UPDATE magazzinoreparti SET Quantity = ? WHERE IDWard=? AND IDPharma=? AND ExpDate=?;";
				Connection conn = DBConnection.getConnection() ;
			
			try {
				PreparedStatement st = conn.prepareStatement(sql) ;
				st.setInt(1,nuova);
				st.setInt(2,selezionato.getRID());
				st.setInt(3,selezionato.getFID());
				st.setDate(4,(java.sql.Date) data);
				
				st.executeUpdate();
				
				conn.close();
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
				
				
			}
		}

	public void cancella(Richiesta richiesta) {
		String sql="DELETE FROM richieste WHERE IDWardRiceve=? AND IDPharma=? AND ExpDate=? AND IDWardRichiede=?";
		
		
		try {
			Connection conn = DBConnectionMarta.getConnection() ;
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,richiesta.getIdRiceve());
			st.setInt(2,richiesta.getIdFarmaco());
			st.setDate(3,Date.valueOf(richiesta.getScadenza()));
			st.setInt(4, richiesta.getIdRichiede());
			st.executeUpdate();
			
			conn.close();
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

			
		}
		
	}

	public List getFarmaciNelReparto(int id) {
		String sql = "SELECT IDWard,NameWard,Quantity, NamePharma,IDPharma,ExpDate FROM magazzinoreparti WHERE IDWard=? ";
		
		List<FarmacoNelReparto> result = new ArrayList<FarmacoNelReparto>();
		
		Connection conn = DBConnection.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, id);
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add( new FarmacoNelReparto(res.getString("NamePharma"), res.getDate("ExpDate").toLocalDate(),res.getInt("IDPharma"), res.getInt("Quantity"), res.getString("NameWard"), res.getInt("IDWard"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public List<Farmaco> getFarmaci() {
String sql = "SELECT * FROM farmaci ";
		
		List<Farmaco> result = new ArrayList<Farmaco>();
		
		Connection conn = DBConnection.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add( new Farmaco (res.getInt("IDPharma"),res.getString("Name"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	
		
	}
	

