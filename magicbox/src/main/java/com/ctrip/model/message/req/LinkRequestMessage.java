package com.ctrip.model.message.req;

/**
 * ������Ϣ
 * @author Wu Shuai
 *
 */
public class LinkRequestMessage {
	/**
	 * ��Ϣ����
	 */
	private String Title;
	
	/**
	 * ��Ϣ����
	 */
	private String Description;
	
	/**
	 * ��Ϣ����
	 */
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
