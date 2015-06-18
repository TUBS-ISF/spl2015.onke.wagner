package chat.interfaces.impl;

import chat.interfaces.ServerPortNumber;
import chat.server.ServerGUI;

public class ServerPortNumberImpl implements ServerPortNumber {
	public ServerGUI serverGui;

	@Override
	public String getInvalidPortNumberText() {
		return "Invalid port number";
	}

	@Override
	public Integer getDefaultPortnumber() {
		return 1500;
	}

	@Override
	public String getLabelText() {
		return "Port number: ";
	}

	@Override
	public Integer getInputPort() {
		return serverGui.getPortInput();
	}

	@Override
	public void setServerGUI(ServerGUI serverGui) {
		this.serverGui = serverGui;
	}

	@Override
	public String getPortText() {
		return "Port number: ";
	}

}
