package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "fileWriterFile.txt");
		Writer wr = new FileWriter(file, true);
		wr.write("�Ұ����й�");
		// wr.flush();/*writer �ַ�������ʹ��flush ����close �����޷������ļ���*/
		// wr.close();
		System.out.println("done");
	}

}
