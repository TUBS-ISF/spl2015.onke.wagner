import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 

import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; import java.awt.event.ActionEvent; 

import javax.swing.JLabel; 
import javax.swing.JTextField; import java.util.Date; 

/**
 * TODO description
 */
public   class  ServerGUI  extends JFrame  implements ActionListener, WindowListener {
	
	
	private static final long serialVersionUID = 1L;

	
	// the stop and start buttons
	private JButton stopStart;

	
	// JTextArea for the chat room and the events
	private JTextArea chat, event;

	
	private JTextField tPortNumber  ;

	
	// my server
	private Server server;

	
	
	
	// server constructor that receive the port to listen to for connection as parameter
	ServerGUI(int port) {
		server = null;
		// in the NorthPanel the PortNumber the Start and Stop buttons
		JPanel north = new JPanel();
		addPortNumberArea(north, tPortNumber, port);


		// to stop or start the server, we start with "Start"
		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);
		
		// the event and chat room
		JPanel center = new JPanel(new GridLayout(2,1));
		addChatRoom(center);
		addEventLogArea(center);
		add(center);
		
		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(400, 600);
		setVisible(true);
	}

	
	void addPortNumberArea  (JPanel north, JTextField tPortNumber, int port){
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
	}

	
	void addEventLogArea  (JPanel center) {
		event = new JTextArea(80,80);
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));
	}

	
	void addChatRoom  (JPanel center) {
		chat = new JTextArea(80, 80);
		chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));
	}

	

	// append message to the two JTextArea
	// position at the end
	void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	
	 private void  appendEvent__wrappee__ServerGUI  (String str) {

	}

	
	void appendEvent(String str) {
		appendEvent__wrappee__ServerGUI(str);
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
	}

	
	public void actionPerformed  (ActionEvent e) {
			// if running we have to stop
			if(server != null) {
				server.stop();
				server = null;
				//#ifdef Portnummer 
				tPortNumber.setEditable(true);
				//#endif
				stopStart.setText("Start");
				return;
			}
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		// ceate a new Server
		server.Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}

	
	


	/*
	 * If the user click the X button to close the application
	 * I need to close the connection with the server to free the port
	 */
	public void windowClosing(WindowEvent e) {
		// if my Server exist
		if(server != null) {
			try {
				server.stop();			// ask the server to close the conection
			}
			catch(Exception eClose) {
			}
			server = null;
		}
		// dispose the frame
		dispose();
		System.exit(0);
	}

	
	// I can ignore the other WindowListener method
	public void windowClosed(WindowEvent e) {}

	
	public void windowOpened(WindowEvent e) {}

	
	public void windowIconified(WindowEvent e) {}

	
	public void windowDeiconified(WindowEvent e) {}

	
	public void windowActivated(WindowEvent e) {}

	
	public void windowDeactivated(WindowEvent e) {}

	

	/*
	 * A thread to run the Server
	 */
	 

	/*
	 * A thread to run the Server
	 */
	class  ServerRunning  extends Thread {
		
		public void run() {
			server.start();         // should execute until if fails
			// the server failed
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}


	}

	
	int port;


}
