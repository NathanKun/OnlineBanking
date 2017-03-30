package dao;

import java.util.ArrayList;

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
	 * allow to have the full list of Client in the data base.
	 * 
	 * @return the list of all the Clients in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Client> getClientList() {
		String sql = "SELECT * FROM client_clt";
		return (ArrayList<Client>) Dao.getList("Client", sql);
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
	 * delete a Client in the data base Client table.
	 * 
	 * @param id
	 *            contain the id of the Client we want to delete
	 * @return the number of line delete
	 */
	public static int deleteClient(int id) {
		return Dao.deleteLine("Client", id);
	}

	/**
	 * update a Client.
	 * 
	 * @param Client
	 *            the Client for update
	 * @return numbers of line updated
	 */
	public static int updateClient(Client clt) {
		return Dao.updateLine("Client", clt);
	}
	
	/**
	 * main for testing
	 */
	public static void main(String args[]){
		// insert test
		Client clt = new Client(0, "loginAdd3", "pwAdd3", "firstNameAdd3", "lastNameAdd3", 
				new DateTime(1993, 03, 03, 13, 45, 12),
				"Franch3", "F", "3 rue Abc3", "76333", "Sottevill3", "03335678", "e@mail.fr3", "Celebatair3", null, 
				new DateTime(1993, 03, 03, 13, 45, 12));
		DaoClient.addClient(clt);
		System.out.println(DaoClient.addClient(clt));
		
		// get one test
		//System.out.println(DaoClient.getClient(7).toString());
		
		// get all test
		/*
		for (Client clt : DaoClient.getClientList()){
			System.out.println(clt);
		}*/
		
		// delete test
		//DaoClient.deleteClient(2);
		
		// Update test
		/*
		Client clt = DaoClient.getClient(3);
		clt.setClt_city("updated");
		clt.setClt_fname("updated");
		clt.setClt_email("updated");
		clt.setClt_address("updated");
		clt.setClt_fname("updated");
		clt.setClt_lname("updated");
		clt.setClt_gender("X");
		clt.setClt_lastlogin(new DateTime());
		clt.setClt_nationality("updated");
		clt.setClt_password("updated");
		clt.setClt_postalcode("00000");
		clt.setClt_telephonenumber("0000000000");
		clt.setClt_birthday(new DateTime());
		DaoClient.updateClient(clt);
		System.out.println(DaoClient.getClient(3).toString());*/
	}
}
