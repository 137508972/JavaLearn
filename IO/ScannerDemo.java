package IO;

import java.io.File;
import java.util.Scanner;

public class ScannerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getInt();
		// getFloat();
		readFile();
	}

	static void readFile() {
		File f = new File("D:" + File.separator + "JavaFile" + File.separator
				+ "printStreamFile.txt");
		StringBuilder sb = new StringBuilder();
		try {
			Scanner sc = new Scanner(f);//���ļ��ж�ȡ����
			while (sc.hasNext()) {
				sb.append(sc.next()).append("-\r\n");//scanner �Կո񡢻س���Ϊnext�ķָ���
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sb.toString());

	}

	static int getInt() {
		int a = 0;
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("������һ������");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				flag = false;
				System.out.printf("���������:%d\r\n", a);
			} else {
				System.out.println("������Ĳ���һ������");
			}
		}
		return a;
	}

	static float getFloat() {
		float f = 0;
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("������һ��С��");
			if (sc.hasNextFloat()) {
				f = sc.nextFloat();
				flag = false;
				System.out.printf("���������:%f\r\n", f);
			} else {
				System.out.println("������Ĳ���һ��С��");
			}
		}
		return f;
	}

}
