package com.ctrip.main;

import org.apache.log4j.Logger;

import com.ctrip.model.Token;
import com.ctrip.model.menu.Button;
import com.ctrip.model.menu.Menu;
import com.ctrip.model.menu.ViewButton;
import com.ctrip.util.CommonUtil;
import com.ctrip.util.MenuUtil;

/**
 * 菜单管理器类
 * @author Wu Shuai
 *
 */
public class MenuManager {
	private static final Logger LOGGER = Logger.getLogger(MenuManager.class);
	
	/**
	 * 定义菜单结构
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton mainBtn1 = new ViewButton();
		mainBtn1.setName("最新");
		mainBtn1.setType("view");
		mainBtn1.setUrl("");

		ViewButton mainBtn2 = new ViewButton();
		mainBtn2.setName("倒垃圾");
		mainBtn2.setType("view");
		mainBtn2.setUrl("");

		ViewButton mainBtn3 = new ViewButton();
		mainBtn3.setName("小箱子");
		mainBtn3.setType("view");
		mainBtn3.setUrl("");
		
		Menu menu = new Menu();
		menu.setButtons(new Button[] {mainBtn1, mainBtn2, mainBtn3});
		
		return menu;
	}
	
	public static void main(String[] args) {
		// 第三方用于唯一凭证
		String appId = "wx9d5385df30378877";
		// 第三方用户唯一凭证密钥
		String appSecret = "08ea22d487566938850152ed21321b53";
		
		// 调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);
		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			// 判断菜单创建结果
			if (result) 
				LOGGER.info("菜单创建成功！");
			else 
				LOGGER.info("菜单创建失败！");
		}
	}
}
