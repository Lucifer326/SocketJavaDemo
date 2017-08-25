package cc.socket.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP-�ͻ���
 * 
 * @author �޷���
 */
public class TcpSocketClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1�������ͻ���Socket��ָ������˵�ַ�Ͷ˿�
		Socket socket = new Socket("localhost", 2500);
		
		// 2������������������˷�����Ϣ
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// ���������װΪ��ӡ��
		pw.write("���ǿͻ��ˣ���ð�");
		pw.flush();// ˢ�»���
//		pw.close();// ���ܹر���������ᵼ��socketҲ�ر�
		socket.shutdownOutput();// �ر������
		
		// 3����ȡ������������ȡ�������Ϣ
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);// ת�����ַ�������
		BufferedReader br = new BufferedReader(isr);// �ַ�����������
		String info=null;
		while((info=br.readLine())!=null){// ѭ����ȡ�ͻ��˵���Ϣ
			System.out.println("*******�������Ϣ��" + info);
		}
		socket.shutdownInput();// �ر�������
				
		// 4���ر���Դ
		br.close();
		isr.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}
}
