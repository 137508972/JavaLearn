package com.demo.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.Paper;
import com.demo.service.PaperService;
import com.demo.util.PagerUtil;
import com.demo.viewModel.PaperListModel;
import com.demo.viewModel.UserListModel;

public class PaperList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("paper/paperList.jsp");
		req.setAttribute("model", initModel(req));
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		this.doGet(req, resp);
	}

	private PaperListModel initModel(HttpServletRequest req) {
		// ���÷�ҳ
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(req.getParameter("pageSize").trim());// Ĭ��ÿҳ10��
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage").trim());// Ĭ�ϵ�һҳ
		// ����������ѯ����
		String queryString = "";
		// ��ѯ���
		List<Paper> paperList = new ArrayList<Paper>();
		int pageCount = PaperService.getList(pageSize, currentPage, paperList,
				"Paper", "", null);
		// ��ʼ��ҳ��ģ��
		PaperListModel model = new PaperListModel();
		model.setpList(paperList);
		model.setPageCount(pageCount);
		model.setPageSize(pageSize);
		model.setCurrentPage(currentPage);
		// ���÷�ҳ
		model.setPageLinkDic(PagerUtil.getPagerMap(model.getPageCount(),
				model.getCurrentPage(), model.getPageSize(), queryString));
		return model;
	}
}
