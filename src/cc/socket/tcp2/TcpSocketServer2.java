package cc.socket.tcp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ��ʵ��Socketͨ��-�����
 * ObjectInputStream ����
 * ObjectOutputStream
 * FileInputStream �ļ�
 * FileOutputStram
 * @author �޷���
 */
public class TcpSocketServer2 {

	public static void main(String[] args) throws IOException {
		// 1������һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
		// ��0~65535��ʹ��1023֮��Ķ˿ڣ�0~1023һ��ΪϵͳĬ�϶˿ڣ�
		ServerSocket serverSocket = new ServerSocket(2500);
		Socket socket = null;
		// ��¼�ͻ��˵�����
		int count = 0;
		System.out.println("*****������ѿ���******");
		// ѭ�������ȴ��ͻ��˵�����
		while (true) {
			// ����accept()������ʼ�������ȴ��ͻ��˵�����
			socket = serverSocket.accept();
			// ����һ���µ��߳�
			TcpServerThread tcpServerThread = new TcpServerThread(socket);
			tcpServerThread.setPriority(4);// �����߳����ȼ���[0,10]��Ĭ��5
			// �����߳�
			tcpServerThread.start();

			count++;// ͳ�ƿͻ��˵�����
			System.out.println("�ͻ��˵�������" + count);
			InetAddress address = socket.getInetAddress();
			System.out.println("��ǰ�ͻ��˵�IP��" + address.getHostAddress());
		}
		// serverSocket.close();
	}
}
