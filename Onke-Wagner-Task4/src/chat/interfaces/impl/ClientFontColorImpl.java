package chat.interfaces.impl;

import java.awt.Color;

import chat.interfaces.ClientColor;

public class ClientFontColorImpl implements ClientColor {
	@Override
	public Color getColorBlack() {
		return Color.BLACK;
	}

	@Override
	public Color getColorWhite() {
		return Color.WHITE;
	}

	
	public Color getColorYellow() {
		return Color.YELLOW;
	}

	@Override
	public Color getColorRed() {
		return Color.RED;
	}

	
	public Color getColorGreen() {
		return Color.GREEN;
	}

	@Override
	public Color getColorBlue() {
		return Color.BLUE;
	}

}
