package chat;

import chat.interfaces.impl.ServerChatRoomImpl;
import chat.interfaces.impl.ServerEventlogImpl;
import chat.interfaces.impl.ServerPortNumberImpl;
import chat.server.ServerGUI;

public class ServerGUIStarter {
	public static void main(String args[]) {
		new ServerGUI(new ServerEventlogImpl(), new ServerChatRoomImpl(), new ServerPortNumberImpl()).setVisible(true);
	}
}
