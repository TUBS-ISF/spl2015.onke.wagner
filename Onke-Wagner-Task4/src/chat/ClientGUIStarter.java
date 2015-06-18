package chat;

import chat.client.ClientGUI;
import chat.interfaces.impl.ClientBackgroundColorImpl;
import chat.interfaces.impl.ClientFontColorImpl;
import chat.interfaces.impl.ClientServerAddressImpl;



public class ClientGUIStarter {
	public static void main (String args[]){
		new ClientGUI(new ClientServerAddressImpl(), new ClientBackgroundColorImpl(), new ClientFontColorImpl()).setVisible(true);
	}
}
