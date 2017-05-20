package com.ctrip.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.model.Token;

/**
 * ͨ�ù�����
 * @author Wu Shuai
 *
 */
public class CommonUtil {
	private static final Logger LOGGER = Logger.getLogger(CommonUtil.class);
	
	// ƾ֤��ȡ��GET��
	public static final String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * ����https����
	 * @param requestUrl �����ַ  
	 * @param requestMethod ����ʽ��GET��POST��
	 * @param requestStr �ύ������
	 * @return JsonObject ͨ��JsonObject.get(key)�ķ�ʽ��ȡJson���������ֵ
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String requestStr) {
		JSONObject jsonObject = null;
		try {
			// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
			TrustManager[] tm = {new MyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			// ������SSLContext�����еõ�SSLSocketFactory����
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// ��������ʽ��GET��POST��
			conn.setRequestMethod(requestMethod);
			
			// ��outputStr��Ϊnullʱ���������д����
			if (null != requestStr) {
				OutputStream outputStream = conn.getOutputStream();
				// ע������ʽ
				outputStream.write(requestStr.getBytes("UTF-8"));
				outputStream.close();
			}
			
			// ����������ȡ��������
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			
			// �ͷ���Դ
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
		}
		catch (ConnectException ce) {
			LOGGER.error("���ӳ�ʱ��{}", ce);
		}
		catch (Exception e) {
			LOGGER.error("https�����쳣��{}", e);
		}
		
		return jsonObject;
	}
	
	/**
	 * ��ȡ�ӿڷ���ƾ֤
	 * @param appid 
	 * @param appsecret ��Կ
	 * @return
	 */
	public static Token getToken(String appid, String appsecret) {
		Token token = null;
		String requestUrl = tokenUrl.replace("APPID", appid).replace("APPSECRET", appsecret);
		// ����GET�����ȡƾ֤
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			try {
				token = new Token();
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getIntValue("expires_in"));
			}
			catch (Exception e) {
				token = null;
				// ��ȡtokenʧ��
				LOGGER.error("��ȡtokenʧ�� errcode:" + jsonObject.get("errcode") + " errmsg:" + jsonObject.get("errmsg"), e);
			}
		}
		return token;
	}
}
