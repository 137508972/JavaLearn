class FinalDemo extends Final1
{
	final int a=0;
	public static void main(String[] args) 
	{

		System.out.println("Hello World!");
		new FinalDemo().pri();
		/*final���͵ı����޷��ٴθ�ֵ		new FinalDemo().a=1;*/
	}
	void pri()
	{
		System.out.println("FinalDemo method ");
	}
}
class Final1
{
	private final  void pri()
	{
		System.out.println("a final method ");
	}
    /*����Ǳ��벻ͨ���� ��private��ͬ�����д��private ��ô�����е���ͬ���Ƶķ���Ϊ���൥�������ģ����Ǹ�д���������ǣ�
	final  void pri()
	{
		System.out.println("a final method ");
	}
	*/

}
