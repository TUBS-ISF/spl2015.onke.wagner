package chat.interfaces;

import chat.client.ClientGUI;

public interface ClientServerAddress {
	String getDefaultHost();
	Integer getDefaultPort();
	String getServerAddressText();
	String getPortNumberText();
	String getServerInput();
	Boolean setEditableFalse();
	void setClientGUI(ClientGUI clientGui);

}
