class TicketDemo 
{
	public static void main(String[] args) 
	{
		Ticket2 t=new Ticket2();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);

		t1.start();
		t2.start();
		t3.start();

	}
}
/*
ͬ����ǰ�᣺
1.�����������������ϵ��߳�
2.����߳�ʹ��ͬһ����

*/
class Ticket implements Runnable
{
	private int count=100;
	Object obj=new Object();
	public  void run()
	{
	while(count>0){
		synchronized(obj)
		{
			//if(!Thread.currentThread().getName().equals("Thread-0"))
			{
		if(count>0){
			try{Thread.sleep(1);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	}}
		}
	}
}
class Ticket2 implements Runnable
{
	private int count=100;
	public  void run()
	{
	while(count>0){
		method();//����ע�⣬ͬ������ͬ�������ݣ���Ҫ�ϸ��ж�
		}
	}
	private synchronized  void method()
	{
		
		if(count>0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	
	}
}
