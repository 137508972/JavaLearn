class ThreadStart
{
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
		while(true)
		{
/*try{	Thread.sleep(1000);}catch(Exception e){}*/
/*if(!t.isAlive())
			{
System.out.println(t.getState() );
System.out.println(t.isAlive());
break;
			}
		}
		*/
		//t.start();//���start�����쳣 CSDN�ϵĽ��ͣ��߳�����һ������Դ��ʹ�����ͱ����գ��޷����¿�������Ҫʹ��new�����´���Ȼ��start
		System.out.println("Hello World!");
	}
}
class TDemo extends Thread
{
	public  void run() 
	{
		System.out.println("Hello Thread");
	}
	/*���������������е�*/
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
		//t.start();
		System.out.println("Hello World!");
	}
}
