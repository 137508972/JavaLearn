class ArrayDemo
{
public static void main(String[] args)
{
int na[]=null;//��������Ϊnull
int a[]=new int[2];//Ҳ��������Ϊ��������
int[] a2=new int[2];// a[]��[]a ���ǿ��е�
int a3[]={5,6};//������ʱ��͸�ֵ
int[] a4={7,8};
a[0]=1;
a[1]=2;
a2[0]=3;
a2[1]=4;
String ad[]=new String[2];
String[] ad2=new String[2];
System.out.println(a[0]);
System.out.println(a[1]);
System.out.println(a2[0]);
System.out.println(a2[1]);
System.out.println(a3[0]);
System.out.println(a3[1]);
System.out.println(a4[0]);
System.out.println(a4[1]);
int [][]a5={{1,2}};//��ά����
int a6[][]={{1,2},{4,5,6}};
System.out.println(a6[0][0]);
System.out.println(a6[0][1]);
//a6[0][2]���׳��쳣 ��������
//System.out.println(a6[0][2]);

System.out.println(a6[1][0]);
System.out.println(a6[1][1]);
System.out.println(a6[1][2]);
for(int x:a3)
	{
System.out.println(x+"a3");

}
}
}