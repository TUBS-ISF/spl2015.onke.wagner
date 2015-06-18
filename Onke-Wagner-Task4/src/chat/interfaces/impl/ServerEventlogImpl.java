package chat.interfaces.impl;

import chat.interfaces.ServerEventlog;

public class ServerEventlogImpl implements ServerEventlog {

	@Override
	public Boolean setTextFieldEditable() {
		return true;
	}

	@Override
	public Boolean setTextFieldUnEditable() {
		return false;
	}

	@Override
	public String getEventLogText() {
		return "Events log.\n";
	}

	@Override
	public String getServerCrashedText() {
		return "Server crashed\n";
	}

	@Override
	public Integer getDimensions() {
		return 80;
	}

}
