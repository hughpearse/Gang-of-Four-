import java.io.*;
import java.net.*;
public class AutomatServer implements Runnable, AutomateInterface {
	State state;
	State waitingState;
	State gotApplicationState;
	State apartmentRentedState;
	State fullyRentedState;
	int count;
	ServerSocket socket;
	Socket communicationSocket;
	PrintWriter out;
	private Thread thread;


	public static void main(String args[]) {
		AutomatServer d = new AutomatServer();
	}

	public AutomatServer() {
		count = 9;
		waitingState = new WaitingState(this);
		gotApplicationState = new GotApplicationState(this);
		apartmentRentedState = new ApartmentRentedState(this);
		waitingState = new WaitingState(this);
		state = waitingState;

		try {
			socket = new ServerSocket(8765);
			communicationSocket = socket.accept();
			out = new PrintWriter(communicationSocket.getOutputStream(), true);
			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		String incomingString;
		try {
			BufferedReader in = new BufferedReader(new
			InputStreamReader(communicationSocket.getInputStream()));

			while ((incomingString = in.readLine()) != null) {
				if (incomingString.equals("gotApplication")) {
					gotApplication();
				} else if (incomingString.equals("checkApplication")) {
					checkApplication();
				} else if (incomingString.equals("rentApartment")) {
					rentApartment();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gotApplication() {
		out.println(state.gotApplication());
	}

	public void checkApplication() {
		out.println(state.checkApplication());
	}

	public void rentApartment() {
		out.println(state.rentApartment());
		out.println(state.dispenseKeys());
	}

	public State getWaitingState() {
		return waitingState;
	}

	public State getGotApplicationState() {
		return gotApplicationState;
	}

	public State getApartmentRentedState() {
		return apartmentRentedState;
	}

	public State getFullyRentedState() {
		return fullyRentedState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int n) {
		count = n;
	}

	public void setState(State s) {
		state = s;
	}
}

