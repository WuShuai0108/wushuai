package com.ctrip.model.message.resp;

/**
 * ������Ϣ
 * @author Wu Shuai
 *
 */
public class VoiceResponseMessage extends BaseResponseMessage {
	/**
	 * ����
	 */
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
