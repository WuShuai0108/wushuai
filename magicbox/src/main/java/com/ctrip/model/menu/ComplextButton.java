package com.ctrip.model.menu;

/**
 * �������͵İ�ť
 * @author Wu Shuai
 *
 */
public class ComplextButton extends Button {
	private Button[] subButtons;

	public Button[] getSubButtons() {
		return subButtons;
	}

	public void setSubButtons(Button[] subButtons) {
		this.subButtons = subButtons;
	}
}
