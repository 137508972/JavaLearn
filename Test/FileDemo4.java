import java.io.Writer;
import java.io.FileWriter;
import java.io.File;

class FileDemo4 
{
	public static void main(String[] args)  throws Exception
	{
		File f=new File("D:"+File.separator+"useWriter.txt");
		Writer writer=null;
		//writer=new FileWriter(f);
		writer=new FileWriter(f,true);//����׷��
		writer.write("\r\nʹ��writerд���ݣ��ַ���");//\r\nռ�����ֽڣ����ĵġ��������ţ�Ҳռ�����ֽ�
		writer.close();
		System.out.println("Hello World!");
	}
}
