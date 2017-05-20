package com.ctrip.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ctrip.model.message.resp.TextResponseMessage;
import com.ctrip.service.CoreService;
import com.ctrip.util.MessageUtil;

/**
 * ��Ϣ����Impl
 * @author Wu Shuai
 *
 */
@Service
public class CoreServiceImpl implements CoreService {
	private static final Logger LOGGER = Logger.getLogger(CoreServiceImpl.class);

	@Override
	public String processRequest(HttpServletRequest request) {
		// XML��ʽ����Ϣ����
		String respXml = null;
		// Ĭ�Ϸ��ص��ı���Ϣ����
		String respContent = "δ֪����Ϣ����";
		try {
			// ����parseXml��������������Ϣ
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ���ͷ��˺�
			String fromUserName = requestMap.get("FromUserName");
			// ������΢�ź�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");
			
			// �ظ��ı���Ϣ
			TextResponseMessage textMessage = new TextResponseMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			
			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "���ã�����������С���ӣ���ӭ������������";
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ��ע
				if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_SUBSCRIBE)) {
					respContent = "���ã���ӭ���������ٱ��䣡";
				}
				// ȡ����ע
				else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_UNSUBSCRIBE)) {
					// ȡ�����ĺ��û��������յ������˺ŷ�����Ϣ����˲���Ҫ�ظ�
				}
				// ɨ���������ά��
				else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_SCAN)) {
					// ����ɨ���������ά���¼�
				}
				// �ϱ�����λ��
				else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_LOCATION)) {
					// �����ϱ�����λ���¼�
				}
				// �Զ���˵�
				else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_CLICK)) {
					// ����˵������¼�
				}
			}
			
			// �����ı���Ϣ������
			textMessage.setContent(respContent);
			// ���ı���Ϣ����ת����XML
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			LOGGER.error("��Ϣ����ʧ��", e);
		}
		
		return respXml;
	}

}
