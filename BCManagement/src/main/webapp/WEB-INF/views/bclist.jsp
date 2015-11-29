<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- JQuery 1.11.2 -->
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	
	<script src="<c:url value='/resources/js/bcManagement.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">

<h1>
    명함관리 프로그램  
</h1>

<div>
	<form action="/bcInsert" method="post">
		<div>
			<label>회사명 : <input type="text" name="company" id="company"></label>
			<label>이름 : <input type="text" name="name" id="name"></label> 
			<label>직급 : <input type="text" placeholder="ex)과장" name="rank" id="rank"></label>
			<label>연락처 : <input type="text" placeholder="02-000-0000" name="phone" id="phone"></label>
		</div>
		
		<div>
			<label>이메일 : <input type="text" placeholder="email@example.com" name="email" id="email"></label>
			<label>회사주소 : <input type="text" name="cp_addr" id="cp_addr"></label>
		</div>
		
		<div>
			<input type="submit" value="추가">
			<input type="reset" value="지우기">
		</div>	
	</form>	
</div>

<div>
	<table border="1">
		<thead>
		    <tr align="center">
		        <th width="100px">번호</th>
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
			<c:forEach var="book" items="${bsList}">
			    <tr align="center">
			        <td>${book.bc_num}</td>
			        <td>${book.company}</td>
			        <td>${book.name}</td>
			        <td>${book.rank}</td>
			        <td>${book.phone}</td>
			        <td>${book.email}</td>
			        <td>${book.cp_addr}</td>
			        <td>
			        	<input type="hidden" value="${book.bc_num}" id="bcNum" name="bcNum" class="bcNum">
			        	<input type="button" class="bc_but bcUpdate" value="수정"
			        		 id="bcUpdate" onclick="bcUp(${book.bc_num})">
			        	<input type="button" value="삭제" class="bc_but bcDelete" id="bcDelete">
			        </td>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>

