import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
 * The server as a GUI
 */
public class ServerGUI extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	// the stop and start buttons
	private JButton stopStart;
	// JTextArea for the chat room and the events
	public JTextArea chat;
	public JPanel center;
	private JTextArea event;
	// The port number
	private JTextField tPortNumber;
	// my server
	private Server server;

	// server constructor that receive the port to listen to for connection as
	// parameter
	ServerGUI(int port) {
		super("Chat Server");
		server = null;
		// in the NorthPanel the PortNumber the Start and Stop buttons
		JPanel north = new JPanel();
		north = addPortnumberFields(north, port);
		// to stop or start the server, we start with "Start"
		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);
		// the event and chat room
		center = new JPanel(new GridLayout(2, 1));
		chat = new JTextArea(80, 80);
		center = addChatArea();
		event = new JTextArea(80, 80);
		center = addEventArea();
		add(center);

		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(400, 600);
		setVisible(true);

	}

	public JPanel addPortnumberFields(JPanel north, int port) {
		tPortNumber = addTPort();
		getPort(port);
		return north;
	}

	public JTextField addTPort() {
		return tPortNumber;
	}

	public int getPort(int port) {
		return port;
	}

	public JPanel addChatArea() {
		chat = addChatFunctionality();
		return center;
	}

	private JTextArea addChatFunctionality() {
		return chat;
	}

	public JPanel addEventArea() {
		event = addEventFunctionality();
		return center;
	}

	public JTextArea addEventFunctionality() {
		callForChat();
		return event;
	}

	public JTextArea callForChat() {
		return chat;
	}

	// append message to the two JTextArea
	// position at the end
	public void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	void appendEvent(String str) {
		event.append(str);
		if (chat.getText().length() > 0) {
			event.setCaretPosition(chat.getText().length() - 1);
		} else {
			event.setCaretPosition(chat.getText().length());
		}
	}

	// start or stop where clicked
	public void actionPerformed(ActionEvent e) {
		// if running we have to stop
		if (server != null) {
			server.stop();
			server = null;
			tPortNumber = setTPortNumberEditable();
			stopStart.setText("Start");
			return;
		}
		// OK start the server

		int port = readPortNumber();
		if(port == 0){
			port = 1500;
		}
		// ceate a new Server
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber = setEditableFalse();
	}

	private JTextField setTPortNumberEditable() {
		return tPortNumber;
	}

	public int readPortNumber() {
		return 0;
	}

	public JTextField setEditableFalse() {
		return tPortNumber;

	}

	// entry point to start the Server
	// public static void main(String[] arg) {
	// // start server default port 1500
	// new ServerGUI(1500);
	// }

	/*
	 * If the user click the X button to close the application I need to close
	 * the connection with the server to free the port
	 */
	public void windowClosing(WindowEvent e) {
		// if my Server exist
		if (server != null) {
			try {
				server.stop(); // ask the server to close the conection
			} catch (Exception eClose) {
			}
			server = null;
		}
		// dispose the frame
		dispose();
		System.exit(0);
	}

	// I can ignore the other WindowListener method
	public void windowClosed(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	/*
	 * A thread to run the Server
	 */
	class ServerRunning extends Thread {
		public void run() {
			server.start(); // should execute until if fails
			// the server failed
			stopStart.setText("Start");
			tPortNumber = setTPortNumberEditable();
			appendEvent("Server crashed\n");
			server = null;
		}
	}

}
