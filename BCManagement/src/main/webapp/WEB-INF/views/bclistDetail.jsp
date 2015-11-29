<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- JQuery 1.11.2 -->
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	
	<script src="<c:url value='/resources/js/bcManagement.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">

<h1>
    명함 정보 수정
</h1>

<div>
	<form action="/bcUpdate" method="post">
		<table border="1">
			<thead>
			    <tr align="center">
			        <th width="100px">회사명</th>
			        <th width="100px">이름</th>
			        <th width="100px">직급</th>
			        <th width="100px">연락처</th>
			        <th width="200px">이메일</th>
			        <th width="200px">회사주소</th>
			        <th width="150px"></th>
			    </tr>
			</thead>
			
			<tbody>
				    <tr align="center">
				        <td><input type="text" class="bcDetailInput" id="upCompany" name="upCompany" value="${seeinfo.company}"></td>
				        <td><input type="text" class="bcDetailInput" id="upName" name="upName" value="${seeinfo.name}"></td>
				        <td><input type="text" class="bcDetailInput" id="upRank" name="upRank" value="${seeinfo.rank}"></td>
				        <td><input type="text" class="bcDetailInput" id="upPhone" name="upPhone" value="${seeinfo.phone}"></td>
				        <td><input type="text" class="bcDetailInput" id="upEmail" name="upEmail" value="${seeinfo.email}"></td>
				        <td><input type="text" class="bcDetailInput" id="upCp_addr" name="upCp_addr" value="${seeinfo.cp_addr}"></td>
				        <td>
				        	<input type="hidden" value="${seeinfo.bc_num}" id="upBcNum" name="upBcNum" class="bcNum">
				        	<input type="submit" class="bc_but" value="수정완료">
				        	<a href="javascript:history.back()"><input type="button" class="bc_but" id="upBack" value="뒤로가기"></a>
				        </td>
				    </tr>
			</tbody>
		</table>
	</form>
</div>

