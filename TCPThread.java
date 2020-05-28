package MulitThreadTCP_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TCPThread extends Thread{
	Socket s1;
	Map<Integer,String > ergebnis=new HashMap<>();
	int nummer;
	
	public TCPThread(Socket s1,int nummer) {
		this.s1=s1;
		this.nummer=nummer;
	}
	
	@Override
	public void run() {
	try(    InputStream is = s1.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));	
			OutputStream os = s1.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));){
		System.out.println("Thread #"+ nummer + " gestartet!" );
		bw.write(nummer);
		bw.flush();
		
		ArrayList<Integer> a1=new ArrayList<Integer>();
		int lenght=br.read();
		for (int i=0;i<lenght;i++) {
			int zahl=br.read();
			a1.add(zahl);
		}
		
		for(Integer i: a1) {
			String prim=istPrim(i);
			bw.write("Die zahl "+ i +" ist eine Primzahl: "+ prim +"\n" );
			sleep(2000);
			bw.flush();
		}
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}	
	}
	
//	public void istPrim(int index) {
//			int zahl=zahlen[index];
//			System.out.println("Die Zahl ist " +zahl);
//			boolean istPrimzahl;
//			if (zahl< 2) istPrimzahl = false;
//			else istPrimzahl = true;
//			for (int divisor = 2; divisor < zahl; divisor++)
//			if (zahl % divisor == 0) istPrimzahl = false;
//		    System.out.println("Die zahl ist eine Primzahl= "+istPrimzahl);
//			if(istPrimzahl) {
//			 ergebnis.put(zahl, "true");
//			 System.out.println(zahl+"ist true");
//			}else {
//				ergebnis.put(zahl, "false");
//			}
//		}
	
	public String istPrim(int index) {
		int zahl=index;
//		System.out.println("Die Zahl ist " +zahl);
		boolean istPrimzahl;
		if (zahl< 2) istPrimzahl = false;
		else istPrimzahl = true;
		for (int divisor = 2; divisor < zahl; divisor++)
		if (zahl % divisor == 0) istPrimzahl = false;
//	    System.out.println("Die zahl ist eine Primzahl= "+istPrimzahl);
		if(istPrimzahl) {
		 return "true";
		}else {
			return "false";
		}
	}
		
	
}
