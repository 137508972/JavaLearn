class ThreadDemo 
{
	public static void main(String[] args) 
	{
	MyThread t=new MyThread();
//	t.run(); ��start����������:run��˳��ִ�У�start����һ���߳�ִ��
t.start();
	for(int i=0;i<500;i++)
		System.out.println("Hello main"+i);
	}
}
class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<500;i++)
		System.out.println("Hello World!"+i);
	}
}