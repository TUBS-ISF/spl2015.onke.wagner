import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * TODO description
 */
public class ServerGUI {
	void addEventLogArea(JPanel center) {
		event = new JTextArea(80,80);
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));
	}
	void appendEvent(String str) {
		original(str);
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
	}
}