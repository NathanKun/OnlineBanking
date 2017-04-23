package model;

public class News {
	/**
	 * id of news
	 */
	private int nws_id;
	/**
	 * title of news
	 */
	private String nws_title;
	/**
	 * the article
	 */
	private String nws_text;

	/**
	 * @param nws_id
	 *            id of news
	 * @param nws_title
	 *            title of news
	 * @param nws_text
	 */
	public News(int nws_id, String nws_title, String nws_text) {
		super();
		this.nws_id = nws_id;
		this.nws_title = nws_title;
		this.nws_text = nws_text;
	}

	/**
	 * @return the nws_id
	 */
	public int getNws_id() {
		return nws_id;
	}

	/**
	 * @param nws_id
	 *            the nws_id to set
	 */
	public void setNws_id(int nws_id) {
		this.nws_id = nws_id;
	}

	/**
	 * @return the nws_title
	 */
	public String getNws_title() {
		return nws_title;
	}

	/**
	 * @param nws_title
	 *            the nws_title to set
	 */
	public void setNws_title(String nws_title) {
		this.nws_title = nws_title;
	}

	/**
	 * @return the nws_text
	 */
	public String getNws_text() {
		return nws_text;
	}

	/**
	 * @param nws_text
	 *            the nws_text to set
	 */
	public void setNws_text(String nws_text) {
		this.nws_text = nws_text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [nws_id=" + nws_id + ", nws_title=" + nws_title + ", nws_text=" + nws_text + "]";
	}
}
