package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutPutStreamWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "fileWriterUseOutputStreamWriterFile2.txt");
		Writer wr = new OutputStreamWriter(new FileOutputStream(file, true));//OutputStreamWriter���ֽ���ת�����ַ���
		wr.write("�Ұ����й�");
		 wr.flush();/*writer �ַ�������ʹ��flush ����close �����޷������ļ���*/
		// wr.close();
		System.out.println("done");
	}

}
