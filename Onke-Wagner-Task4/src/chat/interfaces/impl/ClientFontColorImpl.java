package chat.interfaces.impl;

import java.awt.Color;

import chat.interfaces.ClientFontColor;

public class ClientFontColorImpl implements ClientFontColor {
	@Override
	public Color setFontColorBlack() {
		return Color.BLACK;
	}

	@Override
	public Color setFontColorWhite() {
		return Color.WHITE;
	}

	@Override
	public Color setFontColorYellow() {
		return Color.YELLOW;
	}

	@Override
	public Color setFontColorRed() {
		return Color.RED;
	}

}
