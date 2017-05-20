package com.ctrip.util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.model.menu.Menu;

/**
 * �Զ���˵�������
 * @author Wu Shuai
 *
 */
public class MenuUtil {
	private static final Logger LOGGER = Logger.getLogger(MenuUtil.class);
	
	/**
	 * �˵�������POST��
	 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * �˵���ѯ��POST��
	 */
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * �˵�ɾ����POST��
	 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * �����˵�
	 * @param menu �˵�ʵ��
	 * @param accessToken ƾ֤
	 * @return
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		// ���˵�����ת����JSON�ַ���
		String jsonMenu = JSONObject.toJSONString(menu);
		// ����POST���󴴽��˵�
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			}
			else {
				result = false;
				LOGGER.error("�����˵�ʧ�� errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		
		return result;
	}
	
	/**
	 * ��ѯ�˵�
	 * @param accessToken ƾ֤
	 * @return
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String url = MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
		// ����POST���󴴽��˵�
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		
		if (jsonObject != null) {
			result = jsonObject.toJSONString();
		}
		
		return result;
	}
	
	/**
	 * ɾ���˵�
	 * @param accessToken ƾ֤
	 * @return
	 */
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String url = MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		// ����POST���󴴽��˵�
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			}
			else {
				result = false;
				LOGGER.error("ɾ���˵�ʧ�� errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		
		return result;
	}
}
