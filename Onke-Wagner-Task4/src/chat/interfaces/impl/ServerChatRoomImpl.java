package chat.interfaces.impl;

import chat.interfaces.ServerChatRoom;

public class ServerChatRoomImpl implements ServerChatRoom {
	@Override
	public String getChatText() {
		return "Chat room.\n";
	}

	@Override
	public Integer getDimensoins() {
		return 80;
	}

	@Override
	public Boolean setTextFieldUnEditable() {
		return false;
	}
}
