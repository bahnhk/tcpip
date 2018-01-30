package tcpip1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		String ip = "70.12.111.147";
		Socket socket = null;
		int port = 7777;
		OutputStream outs=null;
		OutputStreamWriter ousw=null;
		try {
			System.out.println("Start Client...");
			socket = new Socket(ip,port);
			System.out.println("Connected OK...");
			
			//Send Data...
			
			 outs = socket.getOutputStream();
			
			 ousw= new OutputStreamWriter(outs);
			//outputStream�� 1����Ʈ�� ���۵ǳ� �����ʹ� 2����Ʈ��!
			ousw.write("���");
			System.out.println("Send Completed...");
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ousw.close();
				outs.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("����� ������ �ʾҽ��ϴ�.");
				e.printStackTrace();
			}
			
		}
			
	}

}
