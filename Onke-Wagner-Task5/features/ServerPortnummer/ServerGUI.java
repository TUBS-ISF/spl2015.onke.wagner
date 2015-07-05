import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO description
 */
public class ServerGUI {
	JTextField tPortNumber;
	void addPortNumberArea(JPanel north, JTextField tPortNumber, int port){
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
	}
	int port;
	public void actionPerformed(ActionEvent e) {
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

}