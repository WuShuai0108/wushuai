package com.ctrip.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ctrip.model.message.resp.ImageResponseMessage;
import com.ctrip.model.message.resp.MusicResponseMessage;
import com.ctrip.model.message.resp.NewsResponseMessage;
import com.ctrip.model.message.resp.TextResponseMessage;
import com.ctrip.model.message.resp.VideoResponseMessage;
import com.ctrip.model.message.resp.VoiceResponseMessage;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * ��Ϣ����������
 * @author Wu Shuai
 *
 */
public class MessageUtil {
	// ������Ϣ���ͣ��ı�
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	// ������Ϣ���ͣ�ͼƬ
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	// ������Ϣ���ͣ�����
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	// ������Ϣ���ͣ���Ƶ
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	// ������Ϣ���ͣ�����λ��
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	// ������Ϣ���ͣ����� 
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	
	// ������Ϣ���ͣ��¼����� 
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	
	// �¼����ͣ�subscribe�����ģ� 
	public static final String EVENT_MESSAGE_TYPE_SUBSCRIBE = "subscribe";
	// �¼����ͣ�unsubscribe��ȡ�����ģ� 
	public static final String EVENT_MESSAGE_TYPE_UNSUBSCRIBE = "unsubscribe";
	// �¼����ͣ�scan����ע�û�ɨ���������ά�룩 
	public static final String EVENT_MESSAGE_TYPE_SCAN = "scan";
	// �¼����ͣ�LOCATION���ϱ�����λ�ã� 
	public static final String EVENT_MESSAGE_TYPE_LOCATION = "LOCATION";
	// �¼����ͣ�CLICK���Զ���˵��� 
	public static final String EVENT_MESSAGE_TYPE_CLICK = "CLICK";
	
	// ��Ӧ��Ϣ���ͣ��ı�
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	// ��Ӧ��Ϣ���ͣ�ͼƬ
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	// ��Ӧ��Ϣ���ͣ�����
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	// ��Ӧ��Ϣ���ͣ���Ƶ
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	// ��Ӧ��Ϣ���ͣ�����
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	// ��Ӧ��Ϣ���ͣ�ͼ��
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	/**
	 * ��չxstreamʹ��֧��CDATA
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// ������XML�ڵ��ת��������CDATA���
				boolean cdata = true;
				
				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}
				
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} 
					else {
						writer.write(text);
					}
				}
			};
		}
	}); 
	
	/**
	 * ����΢�ŷ���������XML��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// ����������洢��hashmap��
		Map<String, String> map = Maps.newHashMap();
		
		// ��request��ȡ��������
		InputStream inputStream = request.getInputStream();
		// ��ȡ������
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// �õ�XML��Ԫ��
		Element root = document.getRootElement();
		// �õ� ��Ԫ�ص������ӽڵ�
		List<Element> elementList = root.elements();
		
		// ���������ӽڵ�
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		
		// �ͷ���Դ
		inputStream.close();
		inputStream = null;
		
		return map;
	}
	
	/**
	 * �ı���Ϣ����ת����XML 
	 * @param textMessage
	 * @return
	 */
	public static String messageToXml(TextResponseMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * ͼƬ��Ϣ����ת����XML 
	 * @param imageMessage
	 * @return
	 */
	public static String messageToXml(ImageResponseMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * ������Ϣ����ת����XML 
	 * @param voiceMessage
	 * @return
	 */
	public static String messageToXml(VoiceResponseMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	
	/**
	 * ��Ƶ��Ϣ����ת����XML 
	 * @param videoMessage
	 * @return
	 */
	public static String messageToXml(VideoResponseMessage videoMessage) {
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
	
	/**
	 * ������Ϣ����ת����XML 
	 * @param musicMessage
	 * @return
	 */
	public static String messageToXml(MusicResponseMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	/**
	 * ͼ����Ϣ����ת����XML 
	 * @param musicMessage
	 * @return
	 */
	public static String messageToXml(NewsResponseMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		return xstream.toXML(newsMessage);
	}
}
