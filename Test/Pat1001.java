import java.util.Scanner;

public class Pat1001 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {
			Scanner sc = new Scanner(System.in);
			String scIn = sc.nextLine();
			sc.close();
			int number = Integer.parseInt(scIn);
			int count = Method(number, 0);
			System.out.println(count);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("����Ĳ�������");
		}
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��

		System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
	}

	private static int Method(int number, int count) {
		// TODO Auto-generated method stub
		if (number == 1)
			return count;
		else {
			return Method(number % 2 == 0 ? number / 2 : (number * 3 + 1) / 2,
					++count);
		}
	}
}
