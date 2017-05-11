package dao;

import java.util.ArrayList;

import model.News;

public class DaoNews extends Dao {


	/**
	 * get 3 pieces of latest bank's news
	 * 
	 * @return the list of all the News in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<News> find3BankNews() {
		String sql = "SELECT * FROM News_nws WHERE nws_type = 'BankRading' ORDER BY nws_date DESC LIMIT 3";
		return (ArrayList<News>) Dao.getList("find3BankNews", sql);
	}


	/**
	 * get 3 pieces of latest other news
	 * 
	 * @return the list of all the News in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<News> find3OtherNews() {
		String sql = "SELECT * FROM News_nws WHERE nws_type != 'BankRading' ORDER BY nws_date DESC LIMIT 3";
		return (ArrayList<News>) Dao.getList("find3BankNews", sql);
	}

	
	/**
	 * get 3 pieces of latest bank's news
	 * 
	 * @return the list of all the News in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<News> findAllBankNews() {
		String sql = "SELECT * FROM News_nws WHERE nws_type = 'BankRading' ORDER BY nws_date DESC";
		return (ArrayList<News>) Dao.getList("findAllBankNews", sql);
	}


	/**
	 * get 3 pieces of latest other news
	 * 
	 * @return the list of all the News in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<News> findAllOtherNews() {
		String sql = "SELECT * FROM News_nws WHERE nws_type != 'BankRading' ORDER BY nws_date DESC";
		return (ArrayList<News>) Dao.getList("findAllOtherNews", sql);
	}
	
	
	/**
	 * return a specific News by it's id.
	 * 
	 * @param id
	 *            id of the News
	 * @return nws - the News
	 */
	public static News getNews(int id) {
		String sql = "SELECT * FROM news_nws WHERE nws_id = ?";
		News nws = (News) getOne("News", sql, id);
		return nws;
	}

	/**
	 * allow to have the full list of News in the data base.
	 * 
	 * @return the list of all the News in the data base
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<News> getNewsList() {
		String sql = "SELECT * FROM News_nws";
		return (ArrayList<News>) Dao.getList("News", sql);
	}

	/**
	 * add News in the date base.
	 * 
	 * @param nws
	 *            - News to add
	 * @return the number of line add in the News list
	 */
	public static int addNews(News nws) {
		return Dao.addRow("News", nws);
	}

	/**
	 * delete a News in the data base News table.
	 * 
	 * @param id
	 *            contain the id of the News we want to delete
	 * @return the number of line delete
	 */
	public static int deleteNews(int id) {
		return Dao.deleteLine("News", id);
	}
	
	
	
	
	public static int updateNews(News nws) {
		return Dao.updateLine("News", nws);
	}
	
	/**
	 * Main for testing
	 * @param args args for main
	 */
	public static void main(String[] args) {

		// insert test
//		News nws = new News(0, "nws1 nws1 nws1",
//				"asdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasdasdasd asdas asdasdas a saasdasd a asd  ads\nasdasd");
//		DaoNews.addNews(nws);

		// get one test
//		System.out.println(DaoNews.getNews(3).toString());

		// get all test
		
//		for (News nws : DaoNews.getNewsList()){
//			System.out.println(nws); 
//		}
		

		// delete test
//		System.out.println(DaoNews.deleteNews(1));

//		System.out.println(DaoNews.find3BankNews());
		System.out.println(DaoNews.find3OtherNews());
	}

}
