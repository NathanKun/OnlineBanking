package dao;

import org.joda.time.DateTime;

import model.Client;

public class DaoClient extends Dao{


	/**
	 * return a specific Client by his id.
	 * 
	 * @param id
	 *            identifiant of the Client
	 * @return clt - the Client
	 */
	public static Client getClient(int id){
		String sql = "SELECT * FROM client_clt WHERE clt_id = ?";
		Client clt = (Client) getOne("Client", sql, id);
		return clt;
	}
	
	/**
	 * add Client in the date base.
	 * 
	 * @param Client
	 *            - Client to add
	 * @return the number of line add in the Client list
	 */
	public static int addClient(Client clt) {
		return Dao.addRow("Client", clt);
	}
	
	
	/**
	 * main for testing
	 */
	public static void main(String args[]){
		
		Client clt = new Client(0, "loginAdd3", "pwAdd3", "firstNameAdd3", "lastNameAdd3", 
				new DateTime(1993, 03, 03, 13, 45, 12),
				"Franch3", "F", "3 rue Abc3", "76333", "Sottevill3", "03335678", "e@mail.fr3", "Celebatair3", null, 
				new DateTime());
		DaoClient.addClient(clt);
		
		System.out.println(DaoClient.getClient(7).toString());
		//System.out.println(new java.sql.Date(new DateTime(1994, 01, 02, 13, 45, 12).getMillis()));
	}
}
