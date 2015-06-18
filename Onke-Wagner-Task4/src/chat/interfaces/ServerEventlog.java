package chat.interfaces;

public interface ServerEventlog {
	String getEventLogText();

	String getServerCrashedText();

	Integer getDimensions();

	Boolean setTextFieldEditable();

	Boolean setTextFieldUnEditable();
}
