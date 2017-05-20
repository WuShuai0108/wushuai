package com.ctrip.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 消息处理接口
 * @author Wu Shuai
 *
 */
public interface CoreService {
	/**
	 * 处理微信发来的请求
	 * @param request
	 * @return
	 */
	String processRequest(HttpServletRequest request);
}
