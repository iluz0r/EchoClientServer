import java.io.*;
import java.net.*;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		int port = 7777;
		ServerSocket servSock = new ServerSocket(port);
		System.out.println("Waiting connection...");
		// Una chiamata bloccante che aspetta fin quando non viene richiesta una connessione
		Socket sock = servSock.accept();
		System.out.println("Accepted connection from client");
		BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));
		String s = br.readLine();
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
		pw.println("La stringa ricevuta dal client è: " + s);
		// Svuota i buffer, forzando l'invio dei dati
		pw.flush();
		sock.close();
		servSock.close();
	}

}
