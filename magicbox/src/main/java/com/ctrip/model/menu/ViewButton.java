package com.ctrip.model.menu;

/**
 * view���͵İ�ť
 * @author Wu Shuai
 *
 */
public class ViewButton extends Button {
	/**
	 * ��ť����
	 */
	private String type;
	
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
