<%@page import="com.demo.domain.QuestionTrueorfalse"%>
<%@page import="com.demo.viewModel.QuestionListModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	QuestionListModel model = (QuestionListModel) request
			.getAttribute("model");
	List<QuestionTrueorfalse> cList = model.getqTList();
%>
<div class="table-responsive">
	<table class="table table-striped table-bordered">
		<tr>
			<td>题干</td>
			<td>难度系数</td>
			<td>操作</td>
		</tr>
		<%
			if (model != null) {
				for (QuestionTrueorfalse q : cList) {
		%>
		<tr>
			<td><%=q.getContent()%></td>
			<td><%=q.getDifficultyPoint()%></td>
			<td><a href='#'
				onclick="myLoad('userEdit?cid=<%=q.getHiloId()%>')">编辑</a>| <a
				href='#' onclick="del('userDel?cid=<%=q.getHiloId()%>');">删除</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>