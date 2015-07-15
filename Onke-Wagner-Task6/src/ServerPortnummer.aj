import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public aspect ServerPortnummer {
	JTextField tPortNumber;
	int port;

	pointcut addNorth() :
		call(JPanel addPortnumberFields(JPanel,int));

	pointcut getTPortNumber() :
		call(JTextField addTPort());

	pointcut getPortNumber() :
		call(int getPort(int));

	pointcut readPortNumber() :
		call(int readPortNumber());

	pointcut setTPortEditFalse() :
		call(JTextField setEditableFalse());

	pointcut setTPortEditTrue() : 
		call(JTextField setTPortNumberEditable());

	after() returning(JPanel north) : addNorth() {
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
	}

	after() returning(int port) : getPortNumber() {
		this.port = port;
	}

	after() returning(JTextField tPortNumber) : getTPortNumber(){
		this.tPortNumber = tPortNumber;
	}

	int around() : readPortNumber() {
		int x = proceed();
		x = Integer.parseInt(tPortNumber.getText().trim());
		return x;
	}

	after() returning(JTextField tPortNumber) : setTPortEditFalse() {
		tPortNumber = this.tPortNumber;
		tPortNumber.setEditable(false);
	}

	after() returning(JTextField tPortNumber) : setTPortEditTrue() {
		tPortNumber = this.tPortNumber;
		tPortNumber.setEditable(true);
	}

}