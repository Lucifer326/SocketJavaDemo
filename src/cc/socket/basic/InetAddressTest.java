package cc.socket.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress���ڱ�ʶ������Ӳ����Դ
 * 
 * @author �޷���
 */
public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// ��ȡ������InetAddressʵ��
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("���������" + inetAddress.getHostName());
		System.out.println("IP��ַ��" + inetAddress.getHostAddress());
		// ��ȡ�ֽ�������ʽ��IP��ַ
		byte[] bytes = inetAddress.getAddress();
		System.out.println("�ֽ�������ʽ��IP��ַ��" + Arrays.toString(bytes));
		// ֱ�����InetAddress����
		System.out.println(inetAddress);
		
		// ������������ȡInetAddressʵ��
		// InetAddress address = InetAddress.getByName("SC-201702092057");
		// ����IP��ַ��ȡInetAddressʵ��
		InetAddress address = InetAddress.getByName("192.168.155.1");
		System.out.println("���������" + address.getHostName());
		System.out.println("IP��ַ��" + address.getHostAddress());
	}
}
