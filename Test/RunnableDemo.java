class  RunnableDemo
{
	public static void main(String[] args) 
	{
		Thread t=new Thread(Ticket.getInstance());
		Thread t2=new Thread(Ticket.getInstance());
		Thread t3=new Thread(Ticket.getInstance());
		t.start();
		t3.start();
		t2.start();
		System.out.println("Hello World!");
	}
}
class Ticket implements Runnable
{
	private int count=100;
	private Ticket(){}//˽�л����캯������������ʽ��������
	private static Ticket t=new Ticket();//��ʽ����
	public static Ticket getInstance(){
		return t;
	}
	public void  run()
	{
		while(count>0)
		{
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(count--);
		}
	}
}