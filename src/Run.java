import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Run {

	public static void main(String[] args) throws IOException {
		int port = 7777;
		ServerSocket serverSock = new ServerSocket(port);
		
		while(true) {
			System.out.println("Waiting connection...");
			// Una chiamata bloccante che aspetta fin quando non viene richiesta una connessione
			Socket sock = serverSock.accept();
			System.out.println("Accepted connection from client");
			Thread t = new Thread(new ThreadedEchoServer(sock));
			t.start();
		}
	}

}
