import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public aspect ClientServerAdresse {

	JTextField tfServer;
	JPanel serverAndPort;

	pointcut addServerAddress():
		call(* ClientGUI.addServerAddressField(*));

	after() returning : addServerAddress(){
		tfServer = new JTextField("localhost");
		serverAndPort = ClientGUI.serverAndPort;
		serverAndPort.add(new JLabel("Server Address:  "));
		serverAndPort.add(tfServer);
	}

}