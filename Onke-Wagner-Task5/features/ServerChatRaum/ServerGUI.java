import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * TODO description
 */
public class ServerGUI {
	void addChatRoom(JPanel center) {
		chat = new JTextArea(80, 80);
		chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));
	}
}