package IO;

import java.io.File;

public class CreateFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\IOFile.txt");
		File f2 = new File("D:" + File.separator + "IOFile.txt");
		try {
			f.createNewFile();
			f2.createNewFile();// ���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ�������ļ��Ƿ���ڣ����������򴴽����ļ�
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
