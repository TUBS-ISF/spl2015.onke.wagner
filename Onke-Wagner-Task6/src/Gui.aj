public aspect Gui {
	
	int portNumber = 1500;
	String serverAddress = "localhost";

	pointcut clientGui():
		execution(* Client.main(*));
	
	pointcut serverGui():
		execution(* Server.main(*));

	before() : clientGui() {
		new ClientGUI(serverAddress, portNumber);
	}
	
	before() : serverGui() {
		new ServerGUI(portNumber);
	}
}