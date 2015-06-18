package chat.interfaces;

import chat.server.ServerGUI;

public interface ServerPortNumber {
	Integer getDefaultPortnumber();
	String getLabelText();
	Integer getInputPort();
	String getInvalidPortNumberText();
	String getPortText();
	void setServerGUI(ServerGUI serverGui);
}
