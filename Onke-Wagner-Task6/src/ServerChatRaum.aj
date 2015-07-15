import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public aspect ServerChatRaum {
	JTextArea chat;

	pointcut serverChatRaum() :
		call(JPanel addChatArea());

	pointcut serverChatRaum2() :
		call(JTextArea addChatFunctionality());

	after() returning(JPanel center): serverChatRaum(){
		center.add(new JScrollPane(chat));
	}

	after() returning(JTextArea chat): serverChatRaum2() {
		chat.setEditable(false);
		appendRoom("Chat room.\n", chat);
		this.chat = chat;
	}

	void appendRoom(String str, JTextArea chat) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

}