package com.demo.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.Question;
import com.demo.domain.QuestionChoice;
import com.demo.domain.QuestionCompletion;
import com.demo.domain.QuestionShortanswer;
import com.demo.domain.QuestionTrueorfalse;
import com.demo.service.BaseService;
import com.demo.service.PaperService;
import com.demo.service.UserService;
import com.demo.util.EDataOption;
import com.demo.util.EQuestionType;
import com.demo.viewModel.ShortAnswerQuestionModel;

public class QuestionEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		Object model = GetModel(req);
		req.setAttribute("model", model);
		Integer hiloId = req.getParameter("hiloId") == null ? -1 : Integer
				.parseInt(req.getParameter("hiloId").trim());
		req.setAttribute("hiloId", hiloId);
		req.setAttribute("backUrl", req.getParameter("backUrl"));
		//System.out.println("backUrl-------------------------------"+req.getAttribute("backUrl"));
		RequestDispatcher dispatcher = getDispatcher(req);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		postHandler(req);
		resp.sendRedirect("questionList?questionType="
				+ req.getParameter("questionType").trim());

	}

	/**
	 * ǰ̨POST�������ݴ���
	 * 
	 * @param req
	 * @return
	 */
	private boolean postHandler(HttpServletRequest req) {
		String questionType = req.getParameter("questionType").trim();
		if (null == questionType)
			return false;

		Object model = getQuestionChoiceModel(req);
		// ѡ����
		if (questionType.equals(EQuestionType.QChoice.getKey())) {
			model = getQuestionChoiceModel(req);
		}
		// �����
		else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
			// System.out.println("��ʼ�������");
			model = getQuestionCompletionModel(req);

		}
		// �ж���
		else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
			model = getQuestionTrueOrFalseModel(req);
		}
		// �����
		else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
			model = getQuestionSAQModel(req);
		}
		// ���ݱ���
		boolean dataOptionResult = false;
		int hiloId = Integer.parseInt(req.getParameter("hiloId"));
		if (hiloId == -1)
			dataOptionResult = BaseService
					.updateOrSave(model, EDataOption.save);
		else if (hiloId > 0)
			dataOptionResult = BaseService.updateOrSave(model,
					EDataOption.update);
		return dataOptionResult;
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	private Object getQuestionSAQModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		ShortAnswerQuestionModel shortAnswerQuestionModel = new ShortAnswerQuestionModel();
		return null;
	}

	/**
	 * ����request��ȡ�ж������
	 * 
	 * @param req
	 * @return
	 */
	private Object getQuestionTrueOrFalseModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		QuestionTrueorfalse questionTrueorfalse = new QuestionTrueorfalse();
		questionTrueorfalse.setHiloId(Integer.parseInt(req
				.getParameter("hiloId")));
		questionTrueorfalse.setContent(req.getParameter("qContent"));
		questionTrueorfalse.setAnswer(req.getParameter("qAnswer"));
		questionTrueorfalse.setDifficultyPoint(req
				.getParameter("difficultyPoint"));

		return questionTrueorfalse;
	}

	/**
	 * ����request��ȡ��������
	 * 
	 * @param req
	 * @return
	 */
	private Object getQuestionCompletionModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		QuestionCompletion questionCompletion = new QuestionCompletion();
		questionCompletion.setHiloId(Integer.parseInt(req
				.getParameter("hiloId")));
		questionCompletion.setContent(req.getParameter("qContent"));
		questionCompletion.setAnswer(req.getParameter("qAnswer"));
		questionCompletion.setDifficultyPoint(req
				.getParameter("difficultyPoint"));

		return questionCompletion;
	}

	/**
	 * ����request��ȡѡ�������
	 * 
	 * @param req
	 * @return
	 */
	private QuestionChoice getQuestionChoiceModel(HttpServletRequest req) {
		QuestionChoice questionChoice = new QuestionChoice();
		questionChoice.setHiloId(Integer.parseInt(req.getParameter("hiloId")));
		questionChoice.setContent(req.getParameter("qContent"));
		questionChoice.setOptionA(req.getParameter("optionA"));
		questionChoice.setOptionB(req.getParameter("optionB"));
		questionChoice.setOptionC(req.getParameter("optionC"));
		questionChoice.setOptionD(req.getParameter("optionD"));
		questionChoice.setOptionE(req.getParameter("optionE"));
		questionChoice.setDifficultyPoint(req.getParameter("difficultyPoint"));
		questionChoice.setAnswer(req.getParameter("qAnswer"));

		return questionChoice;
	}

	/**
	 * ����request��ȡRequestDispatcher����
	 * 
	 * @param req
	 * @return
	 */
	private RequestDispatcher getDispatcher(HttpServletRequest req) {
		String questionType = req.getParameter("questionType") == null ? EQuestionType.QChoice
				.getKey() : req.getParameter("questionType").trim();
		req.setAttribute("questionType", questionType);
		if (questionType.equals(EQuestionType.QChoice.getKey())) {
			return req.getRequestDispatcher("/question/questionChoiceEdit.jsp");
		}
		// �����
		else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
			return req
					.getRequestDispatcher("/question/questionCompletionEdit.jsp");
		}
		// �ж���
		else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
			return req
					.getRequestDispatcher("/question/questionTrueOrFalseEdit.jsp");
		}
		// �����
		else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
			return req.getRequestDispatcher("/question/questionSAQEdit.jsp");
		}
		return req.getRequestDispatcher("/question/questionErr.jsp");
	}

	/**
	 * ����request��ȡ�������
	 * 
	 * @param req
	 * @return
	 */
	private Object GetModel(HttpServletRequest req) {
		Object object = null;
		String questionType = req.getParameter("questionType") == null ? EQuestionType.QChoice
				.getKey() : req.getParameter("questionType").trim();
		Integer hiloId = req.getParameter("hiloId") == null ? -1 : Integer
				.parseInt(req.getParameter("hiloId").trim());

		if (questionType != null) {
			// ѡ����
			if (questionType.equals(EQuestionType.QChoice.getKey())) {
				if (hiloId != -1)
					object = PaperService.getObject(QuestionChoice.class,
							hiloId);
				else
					object = new QuestionChoice("", "", "", "", "", "", "", "");
			}
			// �����
			else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
				if (hiloId != -1)
					object = PaperService.getObject(QuestionCompletion.class,
							hiloId);
				else
					object = new QuestionCompletion("", "", "");
			}
			// �ж���
			else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
				if (hiloId != -1)
					object = PaperService.getObject(QuestionTrueorfalse.class,
							hiloId);
				else
					object = new QuestionTrueorfalse("", "", "");
			}
			// �����
			else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
				// object=PaperService.getObject(QuestionTrueorfalse.class,
				// hiloId);
				QuestionShortanswer questionShortanswer = new QuestionShortanswer();
				if (hiloId != -1) {

					questionShortanswer = (QuestionShortanswer) PaperService
							.getObject(QuestionShortanswer.class, hiloId);
					List<Question> qList = (List<Question>) PaperService
							.getList(" Question ", "", null);
				} else
					object = new ShortAnswerQuestionModel(questionShortanswer,
							(List<Question>) new ArrayList<Question>());
			}
		} else {
			object = PaperService.getObject(QuestionChoice.class, hiloId);

		}
		return object;
	}
}
