import java.awt.Color;

import javax.swing.JTextArea;

public aspect ClientSchriftfarbe {

	pointcut setFontColor() :
		execution(* ClientGUI.setBackgroundColor());

	JTextArea around() : setFontColor() {
		JTextArea ta = proceed();
		ta.setForeground(Color.RED);
		return ta;
	}
}