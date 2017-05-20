package com.ctrip.main;

import org.apache.log4j.Logger;

import com.ctrip.model.Token;
import com.ctrip.model.menu.Button;
import com.ctrip.model.menu.Menu;
import com.ctrip.model.menu.ViewButton;
import com.ctrip.util.CommonUtil;
import com.ctrip.util.MenuUtil;

/**
 * �˵���������
 * @author Wu Shuai
 *
 */
public class MenuManager {
	private static final Logger LOGGER = Logger.getLogger(MenuManager.class);
	
	/**
	 * ����˵��ṹ
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton mainBtn1 = new ViewButton();
		mainBtn1.setName("����");
		mainBtn1.setType("view");
		mainBtn1.setUrl("");

		ViewButton mainBtn2 = new ViewButton();
		mainBtn2.setName("������");
		mainBtn2.setType("view");
		mainBtn2.setUrl("");

		ViewButton mainBtn3 = new ViewButton();
		mainBtn3.setName("С����");
		mainBtn3.setType("view");
		mainBtn3.setUrl("");
		
		Menu menu = new Menu();
		menu.setButtons(new Button[] {mainBtn1, mainBtn2, mainBtn3});
		
		return menu;
	}
	
	public static void main(String[] args) {
		// ����������Ψһƾ֤
		String appId = "wx9d5385df30378877";
		// �������û�Ψһƾ֤��Կ
		String appSecret = "08ea22d487566938850152ed21321b53";
		
		// ���ýӿڻ�ȡƾ֤
		Token token = CommonUtil.getToken(appId, appSecret);
		if (null != token) {
			// �����˵�
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			// �жϲ˵��������
			if (result) 
				LOGGER.info("�˵������ɹ���");
			else 
				LOGGER.info("�˵�����ʧ�ܣ�");
		}
	}
}
