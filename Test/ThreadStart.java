class ThreadStart
{
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
/*try{	Thread.sleep(1000);}catch(Exception e){}
System.out.println(t.getState() );*/
		//t.start();//���start�����쳣
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
