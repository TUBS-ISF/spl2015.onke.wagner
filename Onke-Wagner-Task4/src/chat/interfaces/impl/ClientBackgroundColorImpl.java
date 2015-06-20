package chat.interfaces.impl;

import java.awt.Color;

import chat.interfaces.ClientColor;

public class ClientBackgroundColorImpl implements ClientColor {

	@Override
	public Color getColorWhite() {
		return Color.WHITE;
	}

	public Color getColorGreen() {
		return Color.GREEN;
	}

	@Override
	public Color getColorBlue() {
		return Color.BLUE;
	}

	@Override
	public Color getColorBlack() {
		return Color.BLACK;
	}

	@Override
	public Color getColorRed() {
		return Color.RED;
	}

	public Color getColorYellow() {
		return Color.YELLOW;
	}

}
