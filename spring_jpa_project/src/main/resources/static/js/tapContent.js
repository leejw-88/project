/**
 * 
 */
 $(function(){
	//마우스클릭시 실행하는 함수
	$(".tap-navi>button").click(showContent);
});
function showContent(){
	$(".content>div").removeClass("show");
	$(".tap-navi>button").css("background-color","#f5f5f5");
	var idx=$(this).index();
	$(".content>div").eq(idx).addClass("show");
	$(".tap-navi>button").eq(idx).css("background-color","#fff");
}
