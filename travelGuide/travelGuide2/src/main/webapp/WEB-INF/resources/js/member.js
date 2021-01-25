/**
 * 
 */
/*
function check_login(){
	var id = document.getElementById("id");
	var pwd = document.getElementById("pwd");
	
	if(id.value == "" || (id.value.length <= 0 && id.value.length >= 20)){
		alert("아이디를 확인해주세요");
		id.focus();
		return false;
	}
	
	if(pwd.value==""){
		alert("암호를 입력하세요");
		pwd.focus();
		return false;
	} else {
		document.frm.submit();
	}
}
*/

function id_check(){
	
	if (document.newUser.id.value == "") {
		alert("아이디를 입력해 주세요!");
		document.newUser.id.focus();
		return;
	}

	var url = "id_check_box";
	
		window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=230");
}

function check_all(){

	if (document.newUser.id.value=="") {
		alert("아이디를 입력해 주세요");
		document.newUser.id.focus();
	} else if (document.newUser.reid.value="") {
		alert("아이디 중복확인을 실행해주세요");
		document.newUser.id.focus();
	} else if (document.newUser.pwd.value=="") {
		alert("비밀번호를 입력해 주세요");
		document.newUser.pwd.focus();
	} else if (document.newUser.pwd.value != document.newUser.pwd_check.value) {
		alert("비밀번호가 일치하지 않습니다!")
		document.newUser.pwd.focus();
	} else if (document.newUser.name.value=="") {
		alert("이름을 입력해 주세요");
		document.newUser.name.focus();
	} else if (document.newUser.email.value=="") {
		alert("이메일 입력해 주세요");
		document.newUser.email.focus();
	} else if (document.newUser.phone.value=="") {
		alert("핸드폰 번호를 입력해 주세요");
		document.newUser.phone.focus();
	} else {		
		document.newUser.action = "new_join";
		document.newUser.submit();
	}
}


function go_find_login(){
	var url = "find_user";
	
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=350 ");
}

function findMemberId(){
	if(document.findId.name.value==""){
		alert("이름을 입력해주세요");
		document.findId.name.focus();
	} else if(document.findId.email.value==""){
		alert("이메일을 입력해 주세용");
		document.findId.name.focus();
	} else {
		document.findId.action="find_myid";
		document.findId.submit();
	}
}

function resite(){
	history.go(-1);
}


function update_pwd_check(){
	if (document.mypage_update.pwd.value=="") {
		alert("비밀번호를 입력해 주세요");
		document.mypage_update.pwd.focus();
	} else if (document.mypage_update.pwd_check.value=="") {
		alert("비밀번호 확인을 입력해 주세요");
		document.mypage_update.pwd_check.focus();
	} else if (document.mypage_update.pwd.value != document.mypage_update.pwd_check.value) {
		alert("비밀번호가 일치하지 않습니다!")
		document.mypage_update.pwd.focus();
	} else if (document.mypage_update.name.value=="") {
		alert("이름을 입력해 주세요");
		document.mypage_update.name.focus();
	} else if (document.mypage_update.email.value=="") {
		alert("이메일 입력해 주세요");
		document.mypage_update.email.focus();
	} else if (document.mypage_update.phone.value=="") {
		alert("핸드폰 번호를 입력해 주세요");
		document.mypage_update.phone.focus();
	} else {		
		alert("성공적으로 수정되었습니다");
	alert("다시 로그인 해주세요");
		
		document.mypage_update.action = "myinfo_update";
		document.mypage_update.submit();
	}
}

function findPassword(){
	if(document.findPW.id.value==""){
		alert("아이디를 입력해 주세용");
		document.findPW.id.focus();
	} else if(document.findPW.name.value==""){
		alert("이름을 입력해주세요");
		document.findPW.name.focus();
	} else if(document.findPW.email.value==""){
		alert("이메일을 입력해 주세용");
		document.findPW.name.focus();
	}  else {
		document.findPW.action="find_mypwd";
		document.findPW.submit();
	}
}

function changePassword(){
	if (document.formm.pwd.value=="") {
		alert("비밀번호를 입력해 주세요");
		document.formm.pwd.focus();
	} else if (document.formm.pwdCheck.value =="") {
		alert("비밀번호 확인을 입력해주세요")
		document.formm.pwdCheck.focus();
	} else if (document.formm.pwd.value != document.formm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다!")
		document.formm.pwd.focus();
	} else {
		document.formm.action="update_pwd";
		alert("비밀번호가 수정되었습니다.");
		document.formm.submit();
		self.close();
	}
}

function go_main(){
	document.frmm.action="main";
	document.frmm.submit();
}





































