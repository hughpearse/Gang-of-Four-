
public class TestCommand {

	public static void main(String args[]) {
		TestCommand t = new TestCommand();
	}

	public TestCommand() {
		Invoker invoker = new Invoker();
	
		//Create the receivers
		AsiaServer asiaServer = new AsiaServer();
		EuroServer euroServer = new EuroServer();
		USServer usServer = new USServer();

		//Create the commands
		ShutDownCommand shutDownAsia = new ShutDownCommand(asiaServer);	
		RunDiagnosticsCommand runDiagnosticsAsia = new RunDiagnosticsCommand(asiaServer);
		RebootCommand rebootAsia = new RebootCommand(asiaServer);
		
		ShutDownCommand shutDownEuro = new ShutDownCommand(euroServer);
		RunDiagnosticsCommand runDiagnosticsEuro = new RunDiagnosticsCommand(euroServer);
		RebootCommand rebootEuro = new RebootCommand(euroServer);

		ShutDownCommand shutDownUS = new ShutDownCommand(usServer);
		RunDiagnosticsCommand runDiagnosticsUS = new RunDiagnosticsCommand(usServer);
		RebootCommand rebootUS = new RebootCommand(usServer);


		invoker.setCommand(shutDownAsia);
		invoker.run();

		invoker.setCommand(rebootAsia);
		invoker.run();

		invoker.setCommand(runDiagnosticsAsia);
		invoker.run();

		invoker.setCommand(runDiagnosticsEuro);
		invoker.run();
	}
}



