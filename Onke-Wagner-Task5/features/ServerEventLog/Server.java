import java.util.Date;

/**
 * TODO description
 */
public class Server {
	public void display(String msg) {
		original(msg);
		String time = sdf.format(new Date()) + " " + msg;
		if (sg == null)
			System.out.println(time);
		else
			sg.appendEvent(time + "\n");

	}
}