import java.io.*;
import java.net.*;

public class ThreadedEchoServer implements Runnable {

	private Socket sock;
	
	public ThreadedEchoServer(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));
			String s = br.readLine();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
			pw.println("La stringa ricevuta dal client è: " + s);
			// Svuota i buffer, forzando l'invio dei dati
			pw.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
