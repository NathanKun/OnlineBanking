package dao;

import java.util.ArrayList;


import model.Offer;


public class DaoOffer extends Dao {
	/**
	 * return a specific Offer by it's id.
	 * 
	 * @param id
	 *            id of the Offer
	 * @return ofr - the Offer
	 */
	public static Offer getOffer(int id) {
		String sql = "SELECT * FROM offer_ofr WHERE ofr_id = ?";
		Offer ofr = (Offer) getOne("Offer", sql, id);
		return ofr;
	}

	/**
	 * allow to have the full list of Offer in the data base.
	 * 
	 * @return the list of all the Offer in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Offer> getOfferList() {
		String sql = "SELECT * FROM offer_ofr";
		return (ArrayList<Offer>) Dao.getList("Offer", sql);
	}

	/**
	 * add Offer in the date base.
	 * 
	 * @param ofr
	 *            - Offer to add
	 * @return the number of line add in the Offer list
	 */
	public static int addOffer(Offer ofr) {
		return Dao.addRow("Offer", ofr);
	}

	/**
	 * delete a News in the data base Offer table.
	 * 
	 * @param id
	 *            contain the id of the Offer we want to delete
	 * @return the number of line delete
	 */
	public static int deleteOffer(int id) {
		return Dao.deleteLine("Offer", id);
	}
	
	
	
	/**
	 * Update a line in database.
	 * 
	 * @param ofr
	 *            Offer
	 * @return numbers of line updated in the data base
	 */
	
	public static int updateOffer(Offer ofr) {
		return Dao.updateLine("Offer", ofr);
	}
	
	
	/**
	 * Main for testing
	 * @param args	args for main
	 */
	public static void main(String[] args) {

		// insert test
//		News ofr = new Offer(0, "ofr1 ofr1 ofr1",
//				"asdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasd");
//		DaoOffer.addOffer(ofr);

		// get one test
//		System.out.println(DaoOffer.getOffer(3).toString());

		// get all test
		
//		for (Offer ofr : DaoOffer.getOfferList()){
//			System.out.println(ofr); 
//		}
		

		// delete test
//		System.out.println(DaoOffer.deleteOffer(1));


	}

}
