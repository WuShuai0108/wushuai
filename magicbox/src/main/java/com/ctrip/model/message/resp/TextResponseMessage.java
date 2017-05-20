package com.ctrip.model.message.resp;

/**
 * 文本消息
 * @author Wu Shuai
 *
 */
public class TextResponseMessage extends BaseResponseMessage {
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
