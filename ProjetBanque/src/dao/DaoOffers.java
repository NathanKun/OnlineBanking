package dao;

import java.util.ArrayList;


import model.Offers;


public class DaoOffers extends Dao {


	
	
	/**
	 * return a specific Offer by it's id.
	 * 
	 * @param id
	 *            id of the Offer
	 * @return ofr - the Offer
	 */
	public static Offers getOffer(int id) {
		String sql = "SELECT * FROM offres_ofr WHERE ofr_id = ?";
		Offers ofr = (Offers) getOne("Offers", sql, id);
		return ofr;
	}

	/**
	 * allow to have the full list of Offers in the data base.
	 * 
	 * @return the list of all the Offers in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Offers> getOffersList() {
		String sql = "SELECT * FROM offres_ofr";
		return (ArrayList<Offers>) Dao.getList("Offers", sql);
	}

	/**
	 * add Offer in the date base.
	 * 
	 * @param ofr
	 *            - Offer to add
	 * @return the number of line add in the Offers list
	 */
	public static int addOffer(Offers ofr) {
		return Dao.addRow("Offers", ofr);
	}

	/**
	 * delete a News in the data base Offers table.
	 * 
	 * @param id
	 *            contain the id of the Offer we want to delete
	 * @return the number of line delete
	 */
	public static int deleteOffer(int id) {
		return Dao.deleteLine("Offers", id);
	}
	
	
	public static int updateOffer(Offers ofr) {
		return Dao.updateLine("Offers", ofr);
	}
	
	
	/**
	 * Main for testing
	 * @param args
	 */
	public static void main(String[] args) {

		// insert test
//		News ofr = new Offers(0, "ofr1 ofr1 ofr1",
//				"asdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasd");
//		DaoOffers.addOffer(ofr);

		// get one test
//		System.out.println(DaoOffers.getOffer(3).toString());

		// get all test
		
//		for (Offers ofr : DaoOffers.getNewsList()){
//			System.out.println(ofr); 
//		}
		

		// delete test
//		System.out.println(DaoOffers.deleteOffer(1));


	}

}
