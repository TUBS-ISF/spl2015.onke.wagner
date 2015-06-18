package chat.interfaces.impl;

import chat.client.ClientGUI;
import chat.interfaces.ClientServerAddress;

public class ClientServerAddressImpl implements ClientServerAddress {
	private ClientGUI clientGui;

	@Override
	public void setClientGUI(ClientGUI clientGui) {
		this.clientGui = clientGui;
	}

	@Override
	public String getDefaultHost() {
		return "localhost";
	}

	@Override
	public Integer getDefaultPort() {
		return 1500;
	}

	@Override
	public String getServerAddressText() {
		return "Server Address:  ";
	}

	@Override
	public String getPortNumberText() {
		return "Port Number:  ";
	}

	@Override
	public String getServerInput() {
		return clientGui.getServerInput();
	}

	@Override
	public Boolean setEditableFalse() {
		return false;
	}

}
