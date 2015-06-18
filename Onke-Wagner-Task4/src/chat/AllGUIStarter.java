package chat;
import chat.client.ClientGUI;
import chat.interfaces.impl.ClientBackgroundColorImpl;
import chat.interfaces.impl.ClientFontColorImpl;
import chat.interfaces.impl.ClientServerAddressImpl;
import chat.interfaces.impl.ServerChatRoomImpl;
import chat.interfaces.impl.ServerEventlogImpl;
import chat.interfaces.impl.ServerPortNumberImpl;
import chat.server.ServerGUI;


public class AllGUIStarter {
	public static void main (String args[]){
		new ClientGUI(new ClientServerAddressImpl(), new ClientBackgroundColorImpl(), new ClientFontColorImpl()).setVisible(true);
		new ServerGUI(new ServerEventlogImpl(), new ServerChatRoomImpl(), new ServerPortNumberImpl()).setVisible(true);
	}
}
