class StopThread
{
	public static void main(String[] args) 
	{
		StopThreadDemo obj=new StopThreadDemo();
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		t1.start();
		t2.start();
		try{Thread.sleep(1000);
		}
		catch(Exception e){}
		System.out.println("over");
		t1.interrupt();
		t2.interrupt();
		obj.changeFlag();
	}
}

class StopThreadDemo implements Runnable
{
	private boolean flag= true;
	public void changeFlag()
	{
	flag=false;
	}
	public synchronized void run()
	{
		while(flag)
		{
			try{ 
				wait();
			 }
			catch(InterruptedException e){
		System.out.println(Thread.currentThread().getName()+"�̱߳�ǿ��ֹͣ");
		flag=false;//ǿ�ƽ����̣߳������̵߳�interrupt����
			}
		
			//System.out.println(Thread.currentThread().getName()+"....go");
		}
	}

}