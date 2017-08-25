package cc.socket.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * URLͳһ��Դ��λ����ͨ����Դ���Զ�ȡ��д�������ϵ�����
 * 
 * @author �޷���
 */
public class URLTest {

	public static void main(String[] args) throws IOException {
		// ����URLʵ��
		URL baidu = new URL("http://www.baidu.com");
		// �����Ѵ���URL���Դ���һ���µ�URL
		URL url = new URL(baidu, "/index.html?username=tom#test");// ?�����ʾ������#�����ʾê��
		System.out.println("Э�飺" + url.getProtocol());
		System.out.println("������" + url.getHost());
		// ���δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱurl.getPort()��ȡ�ķ���ֵΪ-1
		System.out.println("�˿ڣ�" + url.getPort());
		System.out.println("�ļ�·����" + url.getPath());
		System.out.println("�ļ�����" + url.getFile());
		System.out.println("���·����" + url.getRef());
		System.out.println("��ѯ�ַ�����" + url.getQuery());
		
		
		/**
		 * ʹ��URL��ȡ��������
		 */
		// ͨ��URL��openStream������ȡURL��������ʾ����Դ���ֽ�������
		InputStream is = baidu.openStream();
		// ���ֽ�������ת�����ַ����������ֽ������ַ���֮���������
		InputStreamReader isr = new InputStreamReader(is, "utf8");
		// Ϊ�ַ���������ӻ��壨���ַ��������ж�ȡ�ı���
		BufferedReader br = new BufferedReader(isr);
		String data = null;
		while ((data = br.readLine()) != null) {
			System.out.println("��ǰ�����ݣ�" + data);
		}
	}
}
