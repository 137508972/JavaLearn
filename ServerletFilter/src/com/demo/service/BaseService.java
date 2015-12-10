package com.demo.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.domain.QuestionChoice;
import com.demo.util.EDataOption;
import com.demo.util.HibernateUtil;

public class BaseService {

	public static int getList(int pageSize, int currentPage, List modelList,
			String tableName, String hqlWhere, List<String> params) {
		Session session = HibernateUtil.openSession();

		Query queryCount = session.createQuery(" select count(*) from "
				+ tableName + " where 1=1 " + hqlWhere);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				queryCount.setParameter(i, params.get(i));
			}
		}
		int rowCount = Integer.parseInt(queryCount.uniqueResult().toString());
		int pageCount = (rowCount - 1) / pageSize + 1;
		Query query = session
				.createQuery(" from " + tableName + " where 1=1 " + hqlWhere)
				.setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize);
		// System.out.println( paramS.size());
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		modelList.addAll(query.list());
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeSession(session);
		}
		return pageCount;
	}

	public static Object getObject(Class clst, Serializable id) {
		Object object = null;
		Session session = HibernateUtil.getCurrentSession();
		object = session.get(clst, id);
		return object;
	}

	/**
	 * ���»����������ݵ����ݿ�
	 * 
	 * @param object
	 * @param option
	 * @return
	 */
	public static boolean updateOrSave(Object object, EDataOption option) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// ��������
			if (option.equals(EDataOption.update)) {
				// System.out.println("update data");
				session.update(object);
			}
			// ��������
			else if (option.equals(EDataOption.save)) {
				// System.out.println("save data");
				// System.out.println(object.getClass());
				session.save(object);
			}
			// System.out.println(((QuestionChoice) object).getHiloId());
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			closeSession(session);
		}
	}

	private static void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
	}
}
