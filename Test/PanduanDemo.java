class PanduanDemo 
{
	public static void main(String[] args) 
	{
		Object o1=new Object();
		Object o2=new Object();
		System.out.println("o1==o2?--" + (o1==o2 ));//f Ĭ�ϱȽϵ��ǵ�ַ
		System.out.println("o1 equals o2?--"+o1.equals(o2));//f Object �����Ĭ��equals�����롰==��һ�£����ǱȽϵ�ַ
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		Object o3=new Object();
		Object o4=o3;
		System.out.println(o3.hashCode());
		System.out.println(o4.hashCode());
		System.out.println(o3);		
		System.out.println(o4);

		System.out.println("o3==o4?--" + (o3==o4 ));
		System.out.println("o3 equals o4?--"+o3.equals(o4));
	}
}
