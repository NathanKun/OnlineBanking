package model;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Offers implements Serializable{
	/**
	 * generate serialVersionUID
	 */
	private static final long serialVersionUID = -5116067082860499178L;
	/**
	 * id of offer
	 */
	private int ofr_id;
	/**
	 * title of offer
	 */
	private String ofr_title;
	/**
	 * the article
	 */
	private String ofr_text;
	/**
	 * Path of the image for title
	 */
	private String ofr_image;
	/**
	 * type of the offer
	 */
	private String ofr_type;
	/**
	 * Date time when the offer is save
	 */
	private DateTime ofr_date;
	/**
	 * @param ofr_id	id
	 * @param ofr_title	title
	 * @param ofr_text	text
	 * @param ofr_image	path of image
	 * @param ofr_type	type of the offer
	 * @param ofr_date 	Date time when the offer is save
	 */
	public Offers(int ofr_id, String ofr_title, String ofr_text, String ofr_image, String ofr_type, DateTime ofr_date) {
		super();
		this.ofr_id = ofr_id;
		this.ofr_title = ofr_title;
		this.ofr_text = ofr_text;
		this.ofr_image = ofr_image;
		this.ofr_type = ofr_type;
		this.ofr_date = ofr_date;
	}
	/**
	 * @return the ofr_id
	 */
	public int getOfr_id() {
		return ofr_id;
	}
	/**
	 * @param ofr_id the ofr_id to set
	 */
	public void setOfr_id(int ofr_id) {
		this.ofr_id = ofr_id;
	}
	/**
	 * @return the ofr_title
	 */
	public String getOfr_title() {
		return ofr_title;
	}
	/**
	 * @param ofr_title the ofr_title to set
	 */
	public void setOfr_title(String ofr_title) {
		this.ofr_title = ofr_title;
	}
	/**
	 * @return the ofr_text
	 */
	public String getOfr_text() {
		return ofr_text;
	}
	/**
	 * @param ofr_text the ofr_text to set
	 */
	public void setOfr_text(String ofr_text) {
		this.ofr_text = ofr_text;
	}
	/**
	 * @return the ofr_image
	 */
	public String getOfr_image() {
		return ofr_image;
	}
	/**
	 * @param ofr_image the ofr_image to set
	 */
	public void setOfr_image(String ofr_image) {
		this.ofr_image = ofr_image;
	}
	/**
	 * @return the ofr_type
	 */
	public String getOfr_type() {
		return ofr_type;
	}
	/**
	 * @param ofr_type the ofr_type to set
	 */
	public void setOfr_type(String ofr_type) {
		this.ofr_type = ofr_type;
	}
	/**
	 * @return the ofr_date
	 */
	public DateTime getOfr_date() {
		return ofr_date;
	}
	/**
	 * @param ofr_date the ofr_date to set
	 */
	public void setOfr_date(DateTime ofr_date) {
		this.ofr_date = ofr_date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Offers [ofr_id=" + ofr_id + ", ofr_title=" + ofr_title + ", ofr_text=" + ofr_text + ", ofr_image="
				+ ofr_image + ", ofr_type=" + ofr_type + ", ofr_date=" + ofr_date + "]";
	}
}
