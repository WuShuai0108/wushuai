package com.ctrip.model.message.resp;

/**
 * ������Ϣ
 * @author Wu Shuai
 *
 */
public class MusicResponseMessage extends BaseResponseMessage {
	/**
	 * ����
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
