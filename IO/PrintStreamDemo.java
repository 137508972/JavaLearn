package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("D:" + File.separator + "JavaFile" + File.separator
				+ "printStreamFile.txt");
		PrintStream p = new PrintStream(new FileOutputStream(f,true));
		p.print("�Ұ���");
		p.println("�й�");
		p.printf("����:%s ��ϲ��:%s", "java learner","fishing");// %s String %d ���� %f С�� %c char�ַ�
		p.close();
	}

}
