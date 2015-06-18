package chat.interfaces.impl;

import java.awt.Color;

import chat.interfaces.ClientBackgroundColor;

public class ClientBackgroundColorImpl implements ClientBackgroundColor {

	@Override
	public Color setBackgroundColorWhite() {
		return Color.WHITE;
	}

	@Override
	public Color setBackgroundColorGreen() {
		return Color.GREEN;
	}


	@Override
	public Color setBackgroundColorBlue() {
		return Color.BLUE;
	}

}
