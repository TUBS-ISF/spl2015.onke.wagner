import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public aspect ClientEmail {
	JPanel northPanel;

	pointcut createEmailField() :
		call(JPanel addEmail(JPanel));

	JPanel around() : createEmailField() {
		JPanel northPanel = proceed();
		JLabel label1 = new JLabel("Enter your E-Mail address below", SwingConstants.CENTER);
		northPanel.add(label1);
		JTextField tu = new JTextField("example@example.com");
		tu.setBackground(Color.WHITE);
		northPanel.add(tu);
		return northPanel;
	}

}