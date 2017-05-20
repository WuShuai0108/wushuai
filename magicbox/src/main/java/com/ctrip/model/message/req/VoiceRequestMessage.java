package com.ctrip.model.message.req;

/**
 * ������Ϣ
 * @author Wu Shuai
 *
 */
public class VoiceRequestMessage extends BaseRequestMessage {
	/**
	 * ������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	private String MediaId;
	
	/**
	 * ������ʽ����amr��speex��
	 */
	private String Format;
	
	/**
	 * ����ʶ������UTF8����
	 */
	private String Recognition;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
