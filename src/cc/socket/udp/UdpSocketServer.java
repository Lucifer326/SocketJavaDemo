package cc.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ����UDPЭ��ʵ��Socketͨ��-�����
 * 
 * @author �޷���
 */
public class UdpSocketServer {

	public static void main(String[] args) throws IOException {
		/**
		 * ���ܿͻ��˷��͵�����
		 */
		// 1�����������DatagramSocket��ָ���˿�
		DatagramSocket datagramSocket = new DatagramSocket(2501);
		// 2���������ݱ��������տͻ��˴��ݹ���������
		byte[] data = new byte[1024];// �����ֽ����飬ָ���������ݰ���С
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
		// 3�����ܿͻ��˷��͵�����
		System.out.println("*******������ѿ���*******");
		datagramSocket.receive(datagramPacket);// �˷����ڽ��յ����ݱ�֮ǰ�ᴦ������
		// 4����ȡ����
		String info = new String(data, 0, datagramPacket.getLength());
		System.out.println("****�ͻ�������*****" + info);
		
		/**
		 * ��Ӧ�ͻ���
		 */
		// 1������ͻ��˵�ַ���˿ںţ�����
		InetAddress inetAddress = datagramPacket.getAddress();
		int port = datagramPacket.getPort();
		byte[] data2 = "���Ƿ���ˣ����".getBytes();
		// 2���������ݱ�������������Ϣ
		DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length, inetAddress, port);
		// 3����ͻ��˷������ݱ�
		datagramSocket.send(datagramPacket2);
		
		// �ر���Դ
		datagramSocket.close();
	}
}
