package com.ctrip.model.event;

/**
 * ɨ���������ά���¼�
 * @author Wu Shuai
 *
 */
public class QRCodeEvent extends BaseEvent {
	/**
	 * �¼�KEYֵ��qrscene_Ϊǰ׺������Ϊ��ά��Ĳ���ֵ
	 */
	private String EventKey;
	
	/**
	 * ��ά���ticket����������ȡ��ά��ͼƬ
	 */
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
