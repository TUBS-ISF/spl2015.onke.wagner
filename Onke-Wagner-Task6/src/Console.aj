
public aspect Console {
	
	int portNumber = 1500;
	String serverAddress = "localhost";
	String userName = "Anonymous";
	String [] argsConsole;
	String [] argsServer;
	
	pointcut clientConsole():
		execution(* Client.consoleCall());
	
	pointcut serverConsole():
		execution(* Server.consoleCall());
	
	before() : clientConsole() {
		argsConsole = Client.argsNew;
		Client.console(portNumber, serverAddress, userName, argsConsole);
	}
	
	before() : serverConsole() {
		argsServer = Server.argsNew;
		Server.console(portNumber, argsServer);
	}
}