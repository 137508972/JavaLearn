import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;

import sun.launcher.resources.launcher;

import com.demo.domain.*;
import com.demo.util.DifficultyPoint;
import com.demo.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		// Session session = HibernateUtil.getCurrentSession();
		// System.out.println(session);
		// List<String> arr=new ArrayList<String>();
		// method(arr);
		// System.out.println(arr.hashCode());
		// MyRegex_3("");
		Session session = HibernateUtil.getCurrentSession();
		QuestionChoice cq = new QuestionChoice();
		//cq.setHiloId(234);
		cq.setContent("�ĸ����Ǳ���������");
		cq.setOptionA("java");
		cq.setOptionB("C#");
		cq.setOptionC("C++");
		cq.setOptionD("JavaScript");
		cq.setAnswer("D");
		cq.setDifficultyPonit(DifficultyPoint.Point9.getPoint());
		session.beginTransaction();
		session.save(cq);
		QuestionCompletion qc=new QuestionCompletion();
		qc.setContent(".NET���������ͷ��ڴ�����Ϊ()");
		qc.setAnswer("GC|�������ջ���");
		qc.setDifficultyPonit(DifficultyPoint.Point8.getPoint());
		session.save(qc);
		session.getTransaction().commit();
	}

	static void method(List<String> arr) {

		System.out.println(arr.hashCode());
	}

	static void MyRegex_3(String regexRule) {

		Pattern pattern = Pattern.compile("pageSize=[0-9]&?");
		Matcher matcher = pattern
				.matcher("myPage('userList?&pageSize=5&currentPage= 4");
		// �滻��һ���������������
		String string = matcher.replaceAll("");
		pattern = Pattern.compile("&currentPage=[/s]?[0-9]?");
		matcher = pattern.matcher(string);
		// �滻��һ���������������
		string = matcher.replaceAll("");
		System.out.println(string);
	}
}
