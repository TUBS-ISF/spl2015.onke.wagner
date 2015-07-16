import java.awt.Color;

import javax.swing.JTextArea;

public aspect ClientHintergrundfarbe {

	pointcut setBackgroundColor() :
		execution(* ClientGUI.setBackgroundColor());

	JTextArea around() : setBackgroundColor() {
		JTextArea ta = proceed();
		ta.setBackground(Color.BLACK);
		return ta;
	}

}