package com.ctrip.model.message.resp;

/**
 * �ı���Ϣ
 * @author Wu Shuai
 *
 */
public class TextResponseMessage extends BaseResponseMessage {
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
