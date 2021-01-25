/**
 * 
 */
function admin_all_list(){
	document.formm.action="all_content";
	document.formm.submit();
}

function event_insert(){
	document.frm.action="event_insert_form";
	document.frm.submit();
}

function festival_insert(){
	document.frm.action="festival_insert_form";
	document.frm.submit();
}

function banner_insert(){
	document.frm.action="banner_insert_form";
	document.frm.submit();
}

function event_delete(){
	if(confirm("정말 삭제 하시겠습니까?")){
		document.frm.action="location.href='event_delete?e_num=${event.e_num}'";
		document.frm.submit();	
	} else{
		alert("취소되었습니다");
	}
}

function event_write(){
	if(document.write.e_link.value == ""){
		alert("링크를 입력해 주세요");
	} else if(document.write.e_main_title.value == ""){
		alert("제목을 입력해 주세요");
	} else if(document.write.e_sub_title.value == ""){
		alert("부제목을 입력해 주세요");
	} else {
		document.write.action="event_insert";
		document.write.submit();
	}
}

function fetival_write(){
	if(document.write.f_link.value == ""){
		alert("링크를 입력해 주세요");
	} else if(document.write.f_main_title.value == ""){
		alert("제목을 입력해 주세요");
	} else if(document.write.f_sub_title.value == ""){
		alert("부제목을 입력해 주세요");
	} else {
		document.write.action="festival_insert";
		document.write.submit();
	}
}

function banner_write(){
	if(document.write.b_link.value == ""){
		alert("링크를 입력해 주세요");
	} else if(document.write.b_main_title.value == ""){
		alert("제목을 입력해 주세요");
	} else if(document.write.b_sub_title.value == ""){
		alert("부제목을 입력해 주세요");
	} else {
		document.write.action="banner_insert";
		document.write.submit();
	}
}
























