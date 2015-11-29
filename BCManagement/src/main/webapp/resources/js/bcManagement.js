/**
 * bcManagement script
 */
function bcUp(num){
		location.href="/bcSeeView?num="+num;
}

$(document).ready(function(){
	$("#bcDelete").click(function() {
		var bcNum = document.getElementById("bcNum").value;
//		alert("bcNum 값 : " + bcNum);
			$.ajax({
				type : "POST",
				url : "/bcDelete",
				data : {
					id : bcNum
				},
				success : function(data) {
					alert("삭제 처리가 완료되었습니다.")
					location.href="/";
				}
			}).fail(function() {
				alert("삭제 처리가 실패 하였습니다.");
			});				
		});
	
});