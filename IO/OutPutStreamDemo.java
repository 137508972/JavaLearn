package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutPutStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "outPutStreamFile.txt");
		// OutputStream o = new FileOutputStream(file);
		OutputStream o = new FileOutputStream(file, true);// ������ԭ�ļ���׷��
		o.write("-�Ұ���".getBytes());
		//o.flush();/*stream �ֽ�������ʹ��ʹ��flush ����close �ֽ��������ɿ��Դ����ļ���*/
		// o.close();
		System.out.println("done");
	}
}
