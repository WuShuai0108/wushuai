package com.ctrip.model.message.resp;

/**
 * ͼƬ��Ϣ
 * @author Wu Shuai
 *
 */
public class ImageResponseMessage extends BaseResponseMessage {
	/**
	 * ͼƬ
	 */
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
