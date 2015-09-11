class InterDemo 
{
	public static void main(String[] args) 
	{
		Computer.print(new Flash());
		Computer.print(new Print());
	}
}

class Computer
{
	public static void print(USB usb)
	{
    	System.out.println("USB ������");
		usb.work();
		System.out.println("USB �ѶϿ�...");
	}
}
interface USB
{
	void work();
}
class Flash implements USB
{
	public void work()
	{
		System.out.println("U �� run ");
	}
}
class Print implements USB
{
	public void work()
	{
		System.out.println("��ӡ�� run ");
	}
}