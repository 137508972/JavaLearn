package IO;

import java.io.File;

public class DeleteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "iofile.txt");
		try {
			file.delete();// ���ҽ����ɹ�ɾ���ļ���Ŀ¼ʱ������ true�����򷵻� false��
							// ɾ���˳���·������ʾ���ļ���Ŀ¼�������·������ʾһ��Ŀ¼�����Ŀ¼����Ϊ�ղ���ɾ����
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
