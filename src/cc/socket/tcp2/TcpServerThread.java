package cc.socket.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������߳�
 * 
 * @author �޷���
 */
public class TcpServerThread extends Thread {
	// �ͱ��߳���ص�socket
	private Socket socket = null;

	public TcpServerThread(Socket socket) {
		this.socket = socket;
	}

	// �߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	@Override
	public void run() {
		super.run();
		if (socket != null) {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			OutputStream os = null;
			PrintWriter pw = null;
			try {
				// ��ȡ������������ȡ�ͻ�����Ϣ
				is = socket.getInputStream();
				isr = new InputStreamReader(is);// ת�����ַ�������
				br = new BufferedReader(isr);// �ַ�����������
				String info = null;
				while ((info = br.readLine()) != null) {// ѭ����ȡ�ͻ��˵���Ϣ
					System.out.println("*******�ͻ�����Ϣ��" + info);
				}
				socket.shutdownInput();// �ر�������

				// ��ȡ���������Ӧ�ͻ���
				os = socket.getOutputStream();
				pw = new PrintWriter(os);// ���������װΪ��ӡ��
				pw.write("���Ƿ���ˣ����");
				pw.flush();// ˢ�»��棬���������
				socket.shutdownOutput();// �ر������
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// �ر���Դ
				try {
					if (pw != null)
						pw.close();
					if (os != null)
						os.close();
					if (br != null)
						br.close();
					if (isr != null)
						isr.close();
					if (is != null)
						is.close();
					if (socket != null)
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
