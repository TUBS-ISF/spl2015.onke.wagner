import java.awt.Color;

import javax.swing.JTextArea;

public aspect ClientSchriftfarbe {
	JTextArea ta;

	pointcut setFontColor() :
		execution(* ClientGUI.setBackgroundColor());

	after() : setFontColor() {
		ta = ClientGUI.ta;
		ta.setForeground(Color.RED);
	}
}