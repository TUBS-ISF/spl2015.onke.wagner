import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public aspect ClientServerAdresse {

	JTextField tfServer;

	pointcut addServerAddress():
		call(* ClientGUI.addServerAddressField());

	JPanel around() : addServerAddress() {
		JPanel serverAndPort = proceed();
		tfServer = new JTextField("localhost");
		serverAndPort.add(new JLabel("Server Address:  "));
		serverAndPort.add(tfServer);
		return serverAndPort;
	}

}