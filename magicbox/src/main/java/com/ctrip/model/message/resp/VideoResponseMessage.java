package com.ctrip.model.message.resp;

/**
 * 视频消息
 * @author Wu Shuai
 *
 */
public class VideoResponseMessage extends BaseResponseMessage {
	/**
	 * 视频
	 */
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
