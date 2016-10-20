import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 1330;
		Socket sock = new Socket("localhost", port);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
		pw.println("Hello, world");
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream(),"UTF-8"));
		String answer = br.readLine();
		System.out.println(answer);
		sock.close();
	}

}
