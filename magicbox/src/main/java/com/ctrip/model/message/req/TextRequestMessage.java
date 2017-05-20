package com.ctrip.model.message.req;

/**
 * 文本消息
 * @author Wu Shuai
 *
 */
public class TextRequestMessage extends BaseRequestMessage {
	/**
	 * 文本消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
