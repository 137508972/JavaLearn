package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String string = bf.readLine();
			System.out.printf("��������ַ�����:%s \r\n", string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String num1 = bf.readLine();
			String num2 = bf.readLine();
			System.out.printf("������������ַ�����:%s �� %s \r\n", num1,num2);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
