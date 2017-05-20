package com.ctrip.model.menu;

/**
 * 复合类型的按钮
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
