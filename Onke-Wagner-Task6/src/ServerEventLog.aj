import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public aspect ServerEventLog {
	JTextArea event;
	JTextArea chat;

	pointcut serverEventLog() :
		call(JPanel addEventArea());

	pointcut serverEventLog2() :
		call(JTextArea addEventFunctionality());

	pointcut serverEventLog3() :
		call(JTextArea callForChat());

	after() returning(JPanel center): serverEventLog(){
		center.add(new JScrollPane(event));
	}

	after() returning(JTextArea event): serverEventLog2() {
		event.setEditable(false);
		appendEvent("Events log.\n", event);
		this.event = event;
	}

	after() returning(JTextArea chat) : serverEventLog3() {
		this.chat = chat;
	}

	void appendEvent(String str, JTextArea event) {
		event.append(str);
		if(chat.getText().length() > 0)
		event.setCaretPosition(chat.getText().length() - 1);
		else
			event.setCaretPosition(chat.getText().length() );

	}
}