package IO;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("D:" + File.separator + "JavaFile" + File.separator
				+ "randomAccess.txt");
		RandomAccessFile randomAccessFile = new RandomAccessFile(f, "r");
		byte[] b = new byte[10];
		randomAccessFile.read(b);//����֮��ָ���Ѿ�ֱ����10 0-9
		byte[] b4 = new byte[4];
		randomAccessFile.skipBytes(1);//��1��ָ��ָ��11����ȡ11-14������
		randomAccessFile.read(b4);

		System.out.println(new String(b));
		System.out.println(new String(b4));
	}

}
