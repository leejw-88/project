/**
 * 
 */
/*텝메뉴 페이지 이동*/
$(function(){
	//마우스 오버시 실행하는 함수
	$(".tap-wrap>li>.tap-tit").hover(hoverMenu,removeMenu);
	//마우스클릭시 실행하는 함수
	$("button[name=tap1]").click(tapButton1);
	$("button[name=tap2]").click(tapButton2);
	$("button[name=tap3]").click(tapButton3);
	$("button[name=tap4]").click(tapButton4);
});
function hoverMenu(){
	$(this).addClass("hover-tit");
}
function removeMenu(){
 	$(".tap-wrap>li>.tap-tit").removeClass("hover-tit");
}
function tapButton1(){
	$(location).attr("href", "/board/information");
}
function tapButton2(){
	$(location).attr("href", "/board/material");
}
function tapButton3(){
	$(location).attr("href", "/board/open");
}
function tapButton4(){
	$(location).attr("href", "/board/mymenu");
}