import java.io.File;
class  FileDemo
{
	public static void main(String[] args) 
	{
		File f=new File("D:\\TEST.TXT");
		try{
		f.createNewFile();
		}
		catch(Exception e){
			System.out.println("Some exception happened");
		}
		System.out.println("Hello World!");
		System.out.println("�ò���ϵͳ���ļ���·���ָ���:"+File.separator);
		//File f2=new File("D:\\TEST");
		System.out.println(f.mkdir());//�ļ��д����Ƿ�ɹ�
		File f3=new File("D:\\");
		/*String str[]=f3.list();//��ȡ�ļ����µ��������ݣ��ļ��� + �ļ� �����ƣ�
		for(int i =0;i<str.length;i++)
		{System.out.println(str[i]);//
		}*/
		/*File str[]=f3.listFiles();//��ȡ�ļ����µ��������ݣ��ļ��� + �ļ� �� File.toString ����Ϊ File.getPath()
		for(int i =0;i<str.length;i++)
		{System.out.println(str[i]);//
		}*/
	}
}
