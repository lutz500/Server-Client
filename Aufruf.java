package MulitThreadTCP_Server;

public class Aufruf {

	public Aufruf() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[]z1= {1,2,3,4,5,6,7,8,9,10,11,12,13,78,99};
		int[]z2= {14,23,34,4,45,64,74,84,94,12340,12341,1234232,1234243,7234348,99};
		int[]z3= {9,78678,6786874,564564,9};

		class ClientThread extends Thread{
			int[] z1;
			public ClientThread(int zahlen[]) {
				this.z1=zahlen;}
			public void run() {
				TCPClient t1=new TCPClient(z1);
				t1.start();
			}

		}

		Thread th1=new Thread(){
			public void run() {
				TCPServer s1=new TCPServer();
				s1.start();
			}
		};
		th1.start();
		
		ClientThread ct1=new ClientThread(z1);
		ClientThread ct2=new ClientThread(z2);
		ClientThread ct3=new ClientThread(z3);
		ct1.start();
		ct2.start();
		ct3.start();

//		Thread th2=new Thread(){
//			public void run() {
//				TCPClient t1=new TCPClient(z1);
//				t1.start();
//			}
//		};
//		th2.start();;
//
//		TCPClient t2=new TCPClient(z2);
//		t2.start();
//		System.out.println("Am ende angekommen!");
	}

}
