/**
 * 
 */

function go_content_list(){
	location.href="UserContent_list";
}


function check_Area_write(){
	if(document.write.c_title.value == ""){
		alert("제목을 입력 하세요");
		document.write.c_title.focus();
	} else if(document.write.c_content.value == ""){
		alert("내용을 입력 하세요");
		document.write.c_content.focus();
	} else{
		document.write.action="Area_write";
		document.write.submit();
	}
}

// 게시글 작성 부분
function write_content(){
	document.formm.action="go_write";
	document.formm.submit();
}


function cancle_content(){
	alert("취소되었습니다");
	history.go(-1);
}

function back_content(){
	history.go(-1);
}

function check_write(){
	if(document.write.c_title.value == ""){
		alert("제목을 입력 하세요");
		document.write.c_title.focus();
	} else if(document.write.c_content.value == ""){
		alert("내용을 입력 하세요");
		document.write.c_content.focus();
	} else{
		document.write.action="content_write";
		document.write.submit();
	}
}

/*
self.location = "list" + '${pageMaker.makeQuery(1)}' +
 "&searchType=" + $("select option:selected").val()
 + "&keyword=" + encodeURIComponent($('#keywordInput').val());
*/

function update_detail(){
	if(document.write.c_title.value == ""){
		alert("제목을 입력 하세요");
		document.write.c_title.focus();
	} else if(document.write.c_content.value == ""){
		alert("내용을 입력 하세요");
		document.write.c_content.focus();
	} else{
	document.write.action="update_detail";
	alert("저장 되었습니다");
	document.write.submit();
	}
}


function delete_content(){
	if(confirm("정말 삭제하시겠습니까?")){
		document.write.action = "content_detail_form";
		document.write.submit();
	} else {		

	}
	
function go_search(){
	document.formm.action = "UserContent_list";
	document.formm.submit();
	
}

}


function like_up_login(){	
	if(confirm("로그인이 필요한 기능입니다. 로그인 하시겠습니까?")){
		document.frm_read.action = "login_form";
		document.frm_read.submit();
	}
}

function self_like(){
	alert("자신의 게시물에는 추천을 할 수 없습니다");
}

function like_up(){	
		var form = 
			JSON.stringify({num:$('#num').val(), id:$('#id').val()});
		$.ajax({
			url: "like_up",
			type: "POST",
			data: form,
			dataType:"json",
			contentType: "application/json; charset=utf-8;",
			success: function(data){
				if(data.like_check == 0){
					alert("추천을 하셨습니다")
					$('#img_result').attr('src',"upload/full_hart.jpg");
					
				} else if(data.like_check == 1) {
					alert("추천을 취소하셨습니다")
					$('#img_result').attr('src',"upload/no_hart.jpg");
				} else{
					alert("오류발생!!");
				}
				/*
				$('#result').text(data.num);
				$('#result2').text(data.id);
				$('#result3').text(data.like_check);
				*/
				$('#result4').text( "좋아요:"+ data.like_up);
			},
			error: function(){
				alert("id_num arr" + "id" +data.id + "num" + data.num);
			}
		});

}


function go_check(){	
	if(confirm("로그인이 필요한 기능입니다. 로그인 하시겠습니까?")){
		document.recontent.action = "login_form";
		document.recontent.submit();
	}
}


function list_recontent(){
	var form =
		{re_num:$('#re_num').val()};
	var loginUser = 
		{re_id:$('#re_id').val()};
	$.ajax({
		url: "list_recontent",
		type:"GET",
		data: form,
		dataType: "json",
		contentType: "application/json; charset=utf-8;",
		success : function(data){
			var a = "";
			var textArea = "";
			$.each(data, function(idx, val) {
				
				var re_id = val.re_id;
				var re_regdate = val.re_regdate;
				var re_content = val.re_content;
				var re_number = val.re_number;
				
				if(idx == 0){
					if( $('#re_id').val() == re_id){ 
						a += "<div>";
						a += "____________________________________" + "<br>";
						a += re_id+" / ";
						a += re_regdate;
						a += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						a += "<a onclick='re_recontent("+re_number+");'>수정</a>&nbsp;";
						a += "<a onclick='re_delete();'>삭제</a><br>";
						a += "<div id='re_content_textArea_"+re_number+"'>";
						a += re_content+"<br>";
						a += "</div>"
						a += "____________________________________";
						a += "</div>";
					} else{
						a += "<div>";
						a += "____________________________________" + "<br>";
						a += re_id+" / ";
						a += re_regdate;
						a += "<div id='re_content_textArea_"+re_number+"'>";
						a += re_content+"<br>";
						a += "</div>"
						a += "____________________________________";
						a += "</div>";
					}
				} else {
					if($('#re_id').val() == re_id){
						a += "<div>";
						a += re_id+" / ";
						a += re_regdate;
						a += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						a += "<a onclick='re_recontent("+re_number+");'>수정</a>&nbsp;";
						a += "<a onclick='re_delete();'>삭제</a><br>";
						a += "<div id='re_content_textArea_"+re_number+"'>";
						a += re_content+"<br>";
						a += "</div>"
						a += "____________________________________";
						a += "</div>";
					}else{
						a += "<div>";
						a += re_id+" / ";
						a += re_regdate;
						a += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						a += "<div id='re_content_textArea_"+re_number+"'>";
						a += re_content+"<br>";
						a += "</div>"
						a += "____________________________________";
						a += "</div>";
					}
				}

				//alert(val.re_id+ " " + val.re_content + " " +val.re_num);
				
			});
			
			textArea += "<textarea name='re_content' id='re_content' rows='30' cols='20' style='width: 1000px; height: 200px; resize: none;'></textarea>"

			
			$('#text_Area').html(textArea);
			$('#ajax_re_id').html(a);
			alert("list 함수 호출");
			
          //alert(data.re_id);
		}
	});
}


function go_insert(){
	if(document.recontent.re_content.value == ""){
		alert("글을 입력해 주세요");
	} else{}
	var form =
		JSON.stringify({re_num:$('#re_num').val(), re_id:$('#re_id').val(), re_content:$('#re_content').val()});
	$.ajax({
		url: "insert_recontent",
		type:"POST",
		data: form,
		dataType: "json",
		contentType: "application/json; charset=utf-8;",
		success: function(data){
			if(data != null){
				alert("댓글이 등록되었습니다");
			}
			
			list_recontent();
		}
	});
}

function re_delete(){
	if(confirm("정말 삭제하시겠습니까?")){
		var form =
			{re_number:$('#re_number').val()};
		
		$.ajax({
			url: "delete_recontent",
			type: "POST",
			data: form,
			success: function(data){
				if(data == 1){
					alert("삭제되었습니다");
					
					list_recontent();
				} else {
					alert("오류가 발생했습니다. 잠시후 다시 시도해 주세요");
				}
			},
			error:function(data){
				alert("오류가 발생했습니다. 잠시후 다시 시도해 주세요");
			}
		});
	}
}

function re_recontent(re_number){

		var form =
		{re_number: re_number};
	$.ajax({
		url:"re_recontent",
		type: "POST",
		data: form,
		dataType: "json",
		success: function(data){
			
			var re_content = data.re_content;
			var re_number = data.re_number;
			var re_content_textArea = "";
			
			re_content_textArea += "<textarea name='re_recontent' id='re_recontent' rows='30' cols='20' style='width: 400px; height: 100px; resize: none;'>"+re_content+"</textarea>";
			re_content_textArea += "<input type='button' style='position: relative; top:10px; left: 80px;' onclick='update_recontent("+re_number+");' value='수정하기'>";
			re_content_textArea += "<input type='button' style='position: relative; top:10px; left: 100px;' onclick='list_recontent();' value='취소'>";
			
			$('#re_content_textArea_'+re_number).html(re_content_textArea);
			alert("ajax 함수 호출");
			
			
		},
		error:function(data){
			alert("오류가 발생했습니다. 잠시후 다시 시도해 주세요");
		}
	});
	
}

function update_recontent(re_number){
	
	var form =
		{re_number:re_number, re_content:$('#re_recontent').val()};
		
	$.ajax({
		url: "update_recontent",
		type: "POST",
		data: form,
		success: function(data){
			alert("수정되었습니다");
			if(data == 1){
				list_recontent();
			} else {
				alert("실패");
			}
			
		},
		error:function(data){
			alert("오류가 발생했습니다. 잠시후 다시 시도해 주세요");
		}
	});
}













