package com.ctrip.model.message.req;

/**
 * ͼƬ��Ϣ
 * @author Wu Shuai
 *
 */
public class ImageRequestMessage extends BaseRequestMessage {
	/**
	 * ͼƬ���ӣ���ϵͳ���ɣ�
	 */
	private String PicUrl;
	
	/**
	 * ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
