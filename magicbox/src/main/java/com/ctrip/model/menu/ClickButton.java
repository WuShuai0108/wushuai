package com.ctrip.model.menu;

/**
 * click���͵İ�ť
 * @author Wu Shuai
 *
 */
public class ClickButton extends Button {
	/**
	 * ��ť����
	 */
	private String type;
	
	/**
	 * Ψһ��ʶKey
	 */
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
