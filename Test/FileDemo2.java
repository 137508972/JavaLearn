import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
class FileDemo2 
{
	public static void main(String[] args) throws Exception 
	{
		File f=new File("D:\\IOTest.txt");
		OutputStream out=null;
		//out=new FileOutputStream(f);//ֱ��д�룬
		out=new FileOutputStream(f,true);//׷��ʽд��
		String str=" \r\n Hello world";//\r\n �ı�����
		byte[] b=str.getBytes();
		out.write(b);
		//���ֽ�д���ֱ��д���ֽ����飬Ч��һ��
		/*for(int i=0;i<b.length;i++){
			out.write(b[i]);
		}*/
		out.close();
		System.out.println("Hello World!");
	}
}
