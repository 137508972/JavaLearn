<%@page import="com.demo.viewModel.QuestionListModel"%>
<%@page import="com.demo.domain.QuestionChoice"%>
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
	List<QuestionChoice> cList = model.getqCList();
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
				for (QuestionChoice q :cList) {
		%>
		<tr>
			<td><%=q.getContent()%></td>
			<td><%=q.getDifficultyPoint()%></td>
			<td><a href='#' onclick="">编辑</a>|
				<a href='#' onclick="">删除</a>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>
<%
		/*--------------分页------------*/
			if (model != null) {
	%><nav>
		<ul class="pagination">
			<%
				for(String key :model.getPageLinkDic().keySet())
						{
						if(model.getPageLinkDic().get(key)!="..."){
						if(!model.getPageLinkDic().get(key).equals(model.getCurrentPage()+""))
						{
			%>
			<li><a href="#" onclick="myPage('questionList?<%=key%>')"><%=model.getPageLinkDic().get(key)%></a>
			</li>
			<%
				}else {
			%>
			<li class='active'><a href="#"><%=model.getCurrentPage()%></a>
			</li>
			<%
				}}
						else
						{
			%>
			<li><a href="#"><%=model.getPageLinkDic().get(key)%></a>
			</li>
			<%
				}
						}
			%>
		</ul>
	</nav>
	<%
		} /*--------------分页------------*/
	%>