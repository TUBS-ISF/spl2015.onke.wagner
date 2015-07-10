import java.awt.Color;

import javax.swing.JTextArea;

public aspect ClientHintergrundfarbe {
	JTextArea ta;

	pointcut setBackgroundColor() :
		execution(* ClientGUI.setBackgroundColor());

	after() : setBackgroundColor() {
		ta = ClientGUI.ta;
		ta.setBackground(Color.BLACK);
	}
}