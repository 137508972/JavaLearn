package com.demo.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.UserService;
import com.demo.viewModel.WelComeModel;

public class UserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		// PrintWriter pw = resp.getWriter();
		// pw.write("��ӭ��¼");

		// List<com.demo.domain.User> uList = UserService.GetUserList();
		WelComeModel model = initModel(req);
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/user/userList.jsp");
		dispatcher.forward(req, resp);
	}

	private WelComeModel initModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder();
		List<String> params = new ArrayList<String>();

		WelComeModel model = new WelComeModel();
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(req.getParameter("pageSize").trim());// Ĭ��ÿҳ10��
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage").trim());// Ĭ�ϵ�һҳ
		String queryName = req.getParameter("queryName") == null ? "" : req
				.getParameter("queryName").trim();
		System.out.println(queryName);
		if (!"".equals(queryName)) {
			sBuilder.append(" and name like ? ");
			params.add("%" + queryName + "%");
		}
		if (req.getParameter("queryAge") != null
				&& !"".equals(req.getParameter("queryAge").trim())) {
			int queryAge = Integer
					.parseInt(req.getParameter("queryAge").trim());
			sBuilder.append(" and age=? ");
			params.add(queryAge + "");
		}
		sBuilder.append(" Order by cid desc ");

		List<com.demo.domain.User> uList = new ArrayList<com.demo.domain.User>();
		int pageCount = UserService.GetUserByPage(pageSize, currentPage, uList,
				sBuilder.toString(), params);

		// System.out.println("bussiness ulist hash:" + uList.hashCode());
		model.setuList(uList);

		// System.out.println(model.getuList().hashCode());
		model.setPageCount(pageCount);
		model.setPageSize(pageSize);
		model.setCurrentPage(currentPage);
		// ���÷�ҳ
		if (model.getPageCount() > 0) {
			model.setPageLinkDic(new LinkedHashMap<String, String>());
			model.getPageLinkDic().put("&pageSize=" + model.getPageSize() + "",
					"��ҳ");
			if (pageCount > 5) {
				if (currentPage > 3)
					model.getPageLinkDic().put("<-", "...");
			}
			if (pageCount >= 5) {
				if (currentPage < 3) {
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=1", "1");
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=2", "2");
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=3", "3");
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=4", "4");
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=5", "5");
				} else {
					if (currentPage < pageCount - 2) {
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage="
										+ (model.getCurrentPage() - 2),
								model.getCurrentPage() - 2 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage="
										+ (model.getCurrentPage() - 1),
								model.getCurrentPage() - 1 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage="
										+ (model.getCurrentPage()),
								model.getCurrentPage() + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage="
										+ (model.getCurrentPage() + 1),
								model.getCurrentPage() + 1 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage="
										+ (model.getCurrentPage() + 2),
								model.getCurrentPage() + 2 + "");
					} else {
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage=" + (pageCount - 4),
								pageCount - 4 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage=" + (pageCount - 3),
								pageCount - 3 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage=" + (pageCount - 2),
								pageCount - 2 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage=" + (pageCount - 1),
								pageCount - 1 + "");
						model.getPageLinkDic().put(

								"&pageSize=" + model.getPageSize()
										+ "&currentPage=" + (pageCount),
								pageCount + "");
					}
				}
			} else {
				for (int i = 0; i < pageCount; i++) {
					model.getPageLinkDic().put(
							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (i + 1), (i + 1) + "");
				}
			}
			if (pageCount > 5) {
				System.out.println(pageCount + "-" + currentPage);
				if (model.getPageCount() - model.getCurrentPage() > 2) {
					model.getPageLinkDic().put("->", "...");
				}
			}
			model.getPageLinkDic().put(
					"&pageSize=" + model.getPageSize() + "&currentPage= "
							+ model.getPageCount(), "βҳ");
		}
		return model;
	}
}
