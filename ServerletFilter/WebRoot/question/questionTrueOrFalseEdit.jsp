<%@page import="com.demo.util.EQuestionAnswer"%>
<%@page import="com.demo.domain.QuestionTrueorfalse"%>
<%@page import="com.demo.util.EQuestionType"%>
<%@page import="com.demo.util.EDifficultyPoint"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<base href="<%=basePath%>">
<%
	QuestionTrueorfalse question = (QuestionTrueorfalse) request
	.getAttribute("model");
	if (question != null) {
%><div class="modal-content">
	<form class="form-horizontal" id="questionEditForm">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">添加判断题</h4>
		</div>
		<div class="modal-body" id="modelContent">
			<div class="form-group">
				<label class="col-sm-2 control-label">题干</label>
				<div class="col-sm-10">
					<input class="form-control" id="" placeholder="题干" name="qContent" value='<%=question.getContent()%>' />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">题干</label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col-md-2">
							<div class="radio">
								<label> <input type="radio" name="qAnswer" value="<%=EQuestionAnswer.write.getKey()%>" checked>
									<%=EQuestionAnswer.write.getValue()%> </label>
							</div>
						</div>
						<div class="col-md-2">
							<div class="radio">
								<label> <input type="radio" name="qAnswer" value="<%=EQuestionAnswer.wrong.getKey()%>"><%=EQuestionAnswer.wrong.getValue()%></label>
							</div>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">难度</label>
				<div class="col-sm-10">
					<select class="form-control" style="width:60%;" id="difficultyPointSel"
						onchange="difficultyPointChange(this.value)">
						<%
							for (EDifficultyPoint et : EDifficultyPoint.values()) {
						%>
						<option value="<%=et.getValue()%>"><%=et.getValue()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<input type="hidden" name="hiloId" value="<%=request.getAttribute("hiloId")%>" /> <input type="hidden"
				value='<%=EDifficultyPoint.Point9.getValue()%>' id="difficultyPoint" name="difficultyPoint" />
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button type="button" class="btn btn-primary" onclick="pageSave('<%=EQuestionType.QTrueOrFalse.getKey()%>')">保存</button>
		</div>
	</form>
</div>
<%
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
		$('#questionEditForm').bootstrapValidator({
			//        live: 'disabled',
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				qContent : {
					validators : {
						notEmpty : {
							message : '题干不能为空'
						}
					}
				}
			}
		});

		$('#resetBtn').click(function() {
			$('#defaultForm').data('bootstrapValidator').resetForm(true);
		});
	});
</script>

