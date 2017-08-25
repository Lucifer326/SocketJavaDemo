package cc.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP-�ͻ���
 * 
 * @author �޷���
 */
public class UdpSocketClient {

	public static void main(String[] args) throws IOException {
		/**
		 * �����˷�������
		 */
		// 1���������˵�ַ���˿ںţ�����
		InetAddress inetAddress = InetAddress.getByName("localhost");
		int port = 2501;
		byte[] data = "���ǿͻ��ˣ����".getBytes();
		// 2���������ݱ�������������Ϣ
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, port);
		// 3������DataGramSocket����
		DatagramSocket datagramSocket = new DatagramSocket();
		// 4�������˷������ݱ�
		datagramSocket.send(datagramPacket);
		
		/**
		 * ���ܷ������Ӧ������
		 */
		// 1���������ݱ��������շ���˴��ݹ���������
		byte[] data2 = new byte[1024];// �����ֽ����飬ָ���������ݰ���С
		DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length);
		// 2�����ܷ���˷��͵�����
		datagramSocket.receive(datagramPacket2);// �˷����ڽ��յ����ݱ�֮ǰ�ᴦ������
		// 2����ȡ����
		String info = new String(data2, 0, datagramPacket2.getLength());
		System.out.println("****���������*****" + info);
		
		// �ر���Դ
		datagramSocket.close();
	}
}
