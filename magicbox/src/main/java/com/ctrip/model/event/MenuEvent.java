package com.ctrip.model.event;

/**
 * �Զ���˵��¼�
 * @author Wu Shuai
 *
 */
public class MenuEvent extends BaseEvent {
	/**
	 * �¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	 */
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
