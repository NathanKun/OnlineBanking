package model;

import org.joda.time.DateTime;

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
	 * Path of the image for title
	 */
	private String nws_image;
	/**
	 * type of the news
	 */
	private String nws_type;
	/**
	 * Date time when the news is save
	 */
	private DateTime nws_date;
	/**
	 * @param nws_id	id
	 * @param nws_title	title
	 * @param nws_text	text
	 * @param nws_image	path of image
	 * @param nws_type	type of the news
	 * @param nws_date 	Date time when the news is save
	 */
	public News(int nws_id, String nws_title, String nws_text, String nws_image, String nws_type, DateTime nws_date) {
		super();
		this.nws_id = nws_id;
		this.nws_title = nws_title;
		this.nws_text = nws_text;
		this.nws_image = nws_image;
		this.nws_type = nws_type;
		this.nws_date = nws_date;
	}
	/**
	 * @return the nws_id
	 */
	public int getNws_id() {
		return nws_id;
	}
	/**
	 * @param nws_id the nws_id to set
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
	 * @param nws_title the nws_title to set
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
	 * @param nws_text the nws_text to set
	 */
	public void setNws_text(String nws_text) {
		this.nws_text = nws_text;
	}
	/**
	 * @return the nws_image
	 */
	public String getNws_image() {
		return nws_image;
	}
	/**
	 * @param nws_image the nws_image to set
	 */
	public void setNws_image(String nws_image) {
		this.nws_image = nws_image;
	}
	/**
	 * @return the nws_type
	 */
	public String getNws_type() {
		return nws_type;
	}
	/**
	 * @param nws_type the nws_type to set
	 */
	public void setNws_type(String nws_type) {
		this.nws_type = nws_type;
	}
	/**
	 * @return the nws_date
	 */
	public DateTime getNws_date() {
		return nws_date;
	}
	/**
	 * @param nws_date the nws_date to set
	 */
	public void setNws_date(DateTime nws_date) {
		this.nws_date = nws_date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [nws_id=" + nws_id + ", nws_title=" + nws_title + ", nws_text=" + nws_text + ", nws_image="
				+ nws_image + ", nws_type=" + nws_type + ", nws_date=" + nws_date + "]";
	}
}
