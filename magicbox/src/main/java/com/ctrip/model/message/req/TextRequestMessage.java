package com.ctrip.model.message.req;

/**
 * �ı���Ϣ
 * @author Wu Shuai
 *
 */
public class TextRequestMessage extends BaseRequestMessage {
	/**
	 * �ı���Ϣ����
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
