package dao;

import model.Client;

public class DaoClient extends Dao{

	public DaoClient(){
		super();
	}
	
	public static Client getClient(int id){
		String sql = "SELECT * FROM client_clt WHERE clt_id = ?";
		Client clt = (Client) getOne("Client", sql, id);
		return clt;
	}
	
	
	
	
	public static void main(String args[]){
		System.out.println(DaoClient.getClient(1).toString());
	}
}
