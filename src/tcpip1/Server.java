package tcpip1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
		int a=0;

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		
		InputStreamReader inr = null;
		BufferedReader br = null;

		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			System.out.println("Start Server....");

			while (true) {
				socket = serverSocket.accept();// 서버를 기다리게 함.
				// Receive Data...
				System.out.println("Client Connected....");
				in = socket.getInputStream();
				inr = new InputStreamReader(in);
				br = new BufferedReader(inr);
				String str = br.readLine();
				System.out.println(str);
				System.out.println("Receive Completed...");

				System.out.println("End Server....");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				inr.close();
				in.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
