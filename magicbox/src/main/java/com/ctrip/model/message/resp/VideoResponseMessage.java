package com.ctrip.model.message.resp;

/**
 * ��Ƶ��Ϣ
 * @author Wu Shuai
 *
 */
public class VideoResponseMessage extends BaseResponseMessage {
	/**
	 * ��Ƶ
	 */
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
