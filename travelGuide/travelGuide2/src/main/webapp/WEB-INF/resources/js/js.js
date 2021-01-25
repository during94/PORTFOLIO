/**
 * 
 */

function openNav() {
			document.getElementById('mysidenav').style.width = '250px';
		}
function closeNav() {
			document.getElementById('mysidenav').style.width = '0';
		}
/*
$(function(){
	var sBtn = $("ul > li");
	sBtn.find("a").click(function(){
	$("this").parent().addClass("active")
	})
})
*/
/*
var clickTimes = 0;

function upNav() {
	clickTimes++;
	
	if(clickTimes == 1){
			document.getElementById('myareaNav').style.height = '300px';
			
			clickTimes = -1;
		} else {
			document.getElementById('myareaNav').style.height = '50px';
			clickTimes = 0;
		}
}
*/

function upNav(){
	if($("#liList").is(":visible")){
		$("#liList").slideUp();
	} else{
		$("#liList").slideDown();
	}
}

$(function(){
	// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
	$('#carousel-example-generic').carousel({
		// 슬리아딩 자동 순환 지연 시간
		// false면 자동 순환하지 않는다.
		interval: 1000,
		// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
		pause: "hover",
		// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
		wrap: true,
		// 키보드 이벤트 설정 여부(?)
		keyboard : true
	});
});





















