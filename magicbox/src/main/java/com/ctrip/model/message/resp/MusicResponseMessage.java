package com.ctrip.model.message.resp;

/**
 * ÒôÀÖÏûÏ¢
 * @author Wu Shuai
 *
 */
public class MusicResponseMessage extends BaseResponseMessage {
	/**
	 * ÒôÀÖ
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
