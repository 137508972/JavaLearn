package IO;

import java.io.File;

public class CreateDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile");
		// file.mkdir();//����Ŀ¼
		String[] fStrings = file.list();// ��ȡĿ¼�µ������ļ���Ϣ���ļ�+�ļ��У�ֻչʾ����
		for (String s : fStrings) {
			// System.out.println(s);

		}
		File[] files = file.listFiles();// ��ȡĿ¼�µ������ļ���Ϣ���ļ�+�ļ��У�չʾ����·��
		for (File s : files) {
			System.out.println(s);//File.toString ��д���� ʵ�������getPath����
			System.out.println(s.getPath());//

		}
	}

}
