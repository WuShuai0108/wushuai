package com.ctrip.model.message.resp;

/**
 * ”Ô“Ùœ˚œ¢
 * @author Wu Shuai
 *
 */
public class VoiceResponseMessage extends BaseResponseMessage {
	/**
	 * ”Ô“Ù
	 */
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
