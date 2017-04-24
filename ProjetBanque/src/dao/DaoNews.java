package dao;

import java.util.ArrayList;

import model.News;

public class DaoNews extends Dao {

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
	
	
	
	/**
	 * Main for testing
	 * @param args
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
	}

}
