package com.ctrip.model.message.req;

/**
 * ��Ƶ��Ϣ
 * @author Wu Shuai
 *
 */
public class VideoRequestMessage extends BaseRequestMessage {
	/**
	 * ��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	private String MediaId;
	
	/**
	 * ��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
