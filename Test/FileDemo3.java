import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

class FileDemo3 
{
	public static void main(String[] args)  throws Exception
	{
		//File f=new File("D:\\useWriter.txt");
		File f=new File("D:\\IOTest.txt");
		InputStream input=null;
		input=new FileInputStream(f);
		//System.out.println(input.available());
		//byte b[]=new byte[input.available()];//available()ֻ�ڷ�����״̬�»�ȡ׼ȷֵ������ʹ��f.length()
		byte b[]=new byte[(int)f.length()];
		System.out.println(f.length());
		//input.read(b);
		/*for(int i=0;i<b.length;i++)
		{
			b[i]=(byte)input.read();
		}*/
		int len=0;
		StringBuilder sb=new StringBuilder();
		int temp=0;
		while((temp=input.read())!=-1)
		{
			b[len]=(byte)temp;
			sb.append(temp+"_"+(byte)temp+"- ");
			len++;
		}
		System.out.println(sb.toString());//�����������ֽڣ��������
		
		System.out.println(new String(b));
		input.close();
		System.out.println("Hello World!");
	}
}
