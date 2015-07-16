import javax.swing.JTextField;

public aspect ClientNutzerName {
	JTextField tf;

	pointcut readUserName() :
		call(String readUsername(JTextField));

	pointcut getTf() :
		call(JTextField getTf(JTextField));

	String around() : readUserName(){
		String username = proceed();
		username = tf.getText().trim();
		return username;

	}

	after() returning(JTextField tf) : getTf(){
		this.tf = tf;
	}
}