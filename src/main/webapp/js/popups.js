function showPopup(popup, background) {
	$("#"+popup).css("display",'block');
    $("#"+background).css("display",'block');
    $("#"+background).width($(document).width());
    $("#"+background).height($(document).height());
};
//关闭弹出层
function closePopup(popup, background) {
	$("#"+popup).css("display",'none');
	$("#"+background).css("display",'none');
};


