class TicketDemo3 
{
	public static void main(String[] args) 
	{
		Ticket2 t=new Ticket2();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);

		t1.start();
			try{Thread.sleep(10);}catch(Exception e){}
			t.flag=false;
		t2.start();

	}
}
/*
����߳�ʹ��ͬһ����
������ʾһ�������ʾ��

��̬��ͬ��������ʹ�õ�������������ֽ����ļ�����--����.class 
*/

class Ticket2 implements Runnable
{
	private static int count=100;
	boolean flag=true;
	Object obj=new Object();
	public  void run()
	{
		if(flag)
		{
		while(count>0){
			synchronized(this)//synchronized(Ticket2.class) ��� this �ĳ� Ticket2.class �Ϳ��Ա�֤�̵߳İ�ȫ����Ϊ��̬synchronized ͬ������ʹ�õĶ���Ϊclass����
			{
			if(count>0){
				try{Thread.sleep(10);}catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+"..."+count--);
			}
			}
		}
		}
		else
		{
			while(count>0){
				method();//����ע�⣬ͬ������ͬ�������ݣ���Ҫ�ϸ��ж�
			}
		}
	
	}
	private static synchronized  void method()
	{
		
		if(count>0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	
	}
}
