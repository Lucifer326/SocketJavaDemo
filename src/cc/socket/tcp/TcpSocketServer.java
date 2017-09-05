package cc.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ��ʵ��Socketͨ��-�����
 * 
 * @author �޷���
 */
public class TcpSocketServer {

	public static void main(String[] args) throws IOException {
		// 1������һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
		// ��1023֮��Ķ˿ڣ�0~1023һ��ΪϵͳĬ�϶˿ڣ�
		ServerSocket serverSocket = new ServerSocket(2500);
		
		// 2������accept()������ʼ�������ȴ��ͻ��˵�����
		Socket socket = serverSocket.accept();
		System.out.println("*****������ѿ���******");
		
		// 3����ȡ������������ȡ�ͻ�����Ϣ
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);// ת�����ַ�������
		BufferedReader br = new BufferedReader(isr);// �ַ�����������
		String info=null;
		while((info=br.readLine())!=null){// ѭ����ȡ�ͻ��˵���Ϣ
			System.out.println("*******�ͻ�����Ϣ��" + info);
		}
		socket.shutdownInput();// �ر�������
		
		// 4����ȡ���������Ӧ�ͻ���
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// ���������װΪ��ӡ��
		pw.write("���Ƿ���ˣ����");
		pw.flush();// ˢ�»��棬���������
		socket.shutdownOutput();// �ر������
		
		// 5���ر���Դ
		pw.close();
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
}
