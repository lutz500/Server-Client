package MulitThreadTCP_Server;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class TCPClient {
	int[] zahlen;
	
	public TCPClient(int[]zahlen) {
		this.zahlen=zahlen;
		
	}
//	public static void main(String[] args) {
//		final String HOST ="localhost";
//		final int PORT=6000;
//		try(Socket s1 = new Socket(HOST, PORT);	
//				InputStream is = s1.getInputStream();
//				BufferedReader br = new BufferedReader(new InputStreamReader(is));
//				BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
//				OutputStream os = s1.getOutputStream();
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//				){
//			System.out.println("Client gestartet!");
//			System.out.println(br.readLine());
//			System.out.println("Nachricht empfangen!");
//			bw.write(zahlen.length);
//			bw.flush();
//			for(int i=0;i<zahlen.length;i++) {
//				bw.write(zahlen[i]);
//				bw.flush();
//			}
//			for(int i=0;i<zahlen.length;i++) {
//				System.out.println(br.readLine());
//			}
//	
//			System.out.println("Array wurde vom Client gesendet");
//			
//		}
//
//		catch(Exception e)
//		{
//			e.printStackTrace();	
//		
//	}


	public static void ausgabe() {
		System.out.println("Client gestartet und verbunden!");
	}
	
	public void start() {
		final String HOST ="localhost";
		final int PORT=6000;
		try(Socket s1 = new Socket(HOST, PORT);	
				InputStream is = s1.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
				OutputStream os = s1.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
				){
			
			int nummer=br.read();
			System.out.println("Client " + nummer+":  gestartet!");
			bw.write(zahlen.length);
			bw.flush();
			for(int i=0;i<zahlen.length;i++) {
				bw.write(zahlen[i]);
				bw.flush();
			}
			for(int i=0;i<zahlen.length;i++) {
				System.out.println("Client "+ nummer+":"+ br.readLine());
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();	
		}
	}



}
