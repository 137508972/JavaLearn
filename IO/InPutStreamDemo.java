package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InPutStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "outPutStreamFile.txt");
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[2];//�����ֽ�������2�ı�������֤���ֲ��ᱻ��֣����ﻹ�ǹ��ˡ���
		int temp = 0;
		int index = 0;
		StringBuilder sb=new StringBuilder();
		while ((temp = in.read()) != -1) {
			b[index] = (byte) temp;
			index++;
			if(index>1)
			{
				sb.append(new String(b));
				b=new  byte[2];
				index=0;
			}
		}
		in.close();
		System.out.println(sb.toString());
	}

}
