package com.ctrip.service;

import javax.servlet.http.HttpServletRequest;

/**
 * ��Ϣ����ӿ�
 * @author Wu Shuai
 *
 */
public interface CoreService {
	/**
	 * ����΢�ŷ���������
	 * @param request
	 * @return
	 */
	String processRequest(HttpServletRequest request);
}
