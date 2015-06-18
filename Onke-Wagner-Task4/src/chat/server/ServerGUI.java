package chat.server;

import javax.swing.*;

import chat.interfaces.ServerChatRoom;
import chat.interfaces.ServerEventlog;
import chat.interfaces.ServerPortNumber;

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
	private JTextArea chat, event;
	// The port number
	private JTextField tPortNumber;
	// my server
	private Server server;
	// plugins
	private ServerEventlog eventlogPlugin;
	private ServerChatRoom chatPlugin;
	private ServerPortNumber portPlugin;

	public ServerGUI(ServerEventlog eventLog, ServerChatRoom chatRoom, ServerPortNumber portNumber) {
		this.eventlogPlugin = eventLog;
		this.chatPlugin = chatRoom;
		this.portPlugin = portNumber;
		portNumber.setServerGUI(this);
		init();
	}

	// server constructor that receive the port to listen to for connection as
	// parameter
	protected void init() {
		int port = 0;
		server = null;
		// in the NorthPanel the PortNumber the Start and Stop buttons

		JPanel north = new JPanel();
		if (portPlugin != null) {
			port = portPlugin.getDefaultPortnumber();
			north.add(new JLabel(portPlugin.getPortText()));
			tPortNumber = new JTextField("  " + port);
			north.add(tPortNumber);
		}
		// to stop or start the server, we start with "Start"
		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);

		// the event and chat room
		JPanel center = new JPanel(new GridLayout(2, 1));
		if (chatPlugin != null) {
			chat = new JTextArea(chatPlugin.getDimensoins(), chatPlugin.getDimensoins());
			chat.setEditable(chatPlugin.setTextFieldUnEditable());
			appendRoom(chatPlugin.getChatText());
			center.add(new JScrollPane(chat));
		}
		if (eventlogPlugin != null) {
			event = new JTextArea(eventlogPlugin.getDimensions(), eventlogPlugin.getDimensions());
			event.setEditable(eventlogPlugin.setTextFieldUnEditable());
			appendEvent(eventlogPlugin.getEventLogText());
			center.add(new JScrollPane(event));
		}
		add(center);

		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(400, 600);
		setVisible(true);
	}

	// append message to the two JTextArea
	// position at the end
	void appendRoom(String str) {
		if (chatPlugin != null) {
			chat.append(str);
			chat.setCaretPosition(chat.getText().length() - 1);
		}
	}

	void appendEvent(String str) {
		if (eventlogPlugin != null) {
			event.append(str);
			event.setCaretPosition(event.getText().length() - 1);
		}
	}

	// start or stop where clicked
	public void actionPerformed(ActionEvent e) {
		// if running we have to stop
		if (server != null) {
			server.stop();
			server = null;
			if (eventlogPlugin != null) {
				tPortNumber.setEditable(eventlogPlugin.setTextFieldEditable());
			}
			stopStart.setText("Start");
			return;
		}
		// OK start the server
		int port = 1500;

		try {
			if (portPlugin != null) {
				port = portPlugin.getInputPort();
			}
		} catch (Exception er) {
			if (portPlugin != null) {
				appendEvent(portPlugin.getInvalidPortNumberText());
			}
			return;
		}
		// ceate a new Server
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		if (portPlugin != null) {
			tPortNumber.setEditable(eventlogPlugin.setTextFieldUnEditable());
		}
	}

	public int getPortInput() {
		return Integer.parseInt(tPortNumber.getText().trim());
	}

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
			if (eventlogPlugin != null) {
				tPortNumber.setEditable(eventlogPlugin.setTextFieldEditable());
			}
			if (eventlogPlugin != null) {
				appendEvent(eventlogPlugin.getServerCrashedText());
			}
			server = null;
		}
	}

}
