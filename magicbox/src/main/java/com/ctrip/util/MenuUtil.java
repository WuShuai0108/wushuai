package com.ctrip.util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.model.menu.Menu;

/**
 * 自定义菜单工具类
 * @author Wu Shuai
 *
 */
public class MenuUtil {
	private static final Logger LOGGER = Logger.getLogger(MenuUtil.class);
	
	/**
	 * 菜单创建（POST）
	 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 菜单查询（POST）
	 */
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 菜单删除（POST）
	 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建菜单
	 * @param menu 菜单实例
	 * @param accessToken 凭证
	 * @return
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成JSON字符串
		String jsonMenu = JSONObject.toJSONString(menu);
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			}
			else {
				result = false;
				LOGGER.error("创建菜单失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		
		return result;
	}
	
	/**
	 * 查询菜单
	 * @param accessToken 凭证
	 * @return
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String url = MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		
		if (jsonObject != null) {
			result = jsonObject.toJSONString();
		}
		
		return result;
	}
	
	/**
	 * 删除菜单
	 * @param accessToken 凭证
	 * @return
	 */
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String url = MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			}
			else {
				result = false;
				LOGGER.error("删除菜单失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		
		return result;
	}
}
