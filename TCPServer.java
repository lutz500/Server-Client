package MulitThreadTCP_Server;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public TCPServer() {
		// TODO Auto-generated constructor stub
	}

	//public static void main(String[] args) {
	//	final int port=6000;
	//	int anzahl=0;
	//	System.out.println("Server wird gestartet!");
	//	ServerSocket ss ;
	//	Socket connection;
	//	try {
	//		ss = new ServerSocket(port);
	//		while (true) {          
	//			connection=ss.accept();   
	//			TCPThread t1=new TCPThread(connection,anzahl);
	//			t1.start();
	//			anzahl++;
	//		}
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//}

	public void start() {
		final int port=6000;
		int anzahl=0;
		System.out.println("Server wird gestartet!");
		ServerSocket ss ;
		Socket connection;
		try {
			ss = new ServerSocket(port);
			while (true) {          
				connection=ss.accept();   
				TCPThread t1=new TCPThread(connection,anzahl);
				t1.start();
				anzahl++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


