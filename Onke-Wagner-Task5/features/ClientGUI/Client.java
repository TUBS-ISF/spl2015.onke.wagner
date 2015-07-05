/**
 * TODO description
 */
public class Client {
	public static void initS(String[] args) {
		int portNumber = 1500;
		String serverAddress = "localhost";
		new ClientGUI(serverAddress, portNumber);
	}
}