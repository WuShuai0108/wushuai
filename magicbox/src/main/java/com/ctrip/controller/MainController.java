package com.ctrip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctrip.service.CoreService;
import com.ctrip.util.SignUtil;

@Controller
public class MainController {
	private static final Logger LOGGER = Logger.getLogger(MainController.class);
	
	@Autowired
	private CoreService coreService;

	@RequestMapping("/main")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		request.setCharacterEncoding("UTF-8"); // ΢�ŷ�����POST��Ϣʱ�õ���UTF-8���룬�ڽ���ʱҲҪ��ͬ���ı��룬�������Ļ����룻
		response.setCharacterEncoding("UTF-8"); // ����Ӧ��Ϣ���ظ���Ϣ���û���ʱ��Ҳ�����뷽ʽ����ΪUTF-8��ԭ��ͬ�ϣ�
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		PrintWriter out = response.getWriter();
		String signature = request.getParameter("signature");// ΢�ż���ǩ��
		String timestamp = request.getParameter("timestamp");// ʱ���
		String nonce = request.getParameter("nonce");// �����

		try {
			if (isGet) { 
				String echostr = request.getParameter("echostr");// ����ַ���

				// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					LOGGER.info("Connect the weixin server is successful.");
					response.getWriter().write(echostr);
				} else {
					LOGGER.error("Failed to verify the signature!");
				}
			} else {
				//����У��
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					// ���ú��ķ�������մ�������
					String respXml = coreService.processRequest(request);
					out.println(respXml);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Connect the weixin server is error.");
		} finally {
			out.close();
		}
	}
}
