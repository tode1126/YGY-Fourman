/**
 * 
 */
//$(window).bind("beforeunload",function(e){
//	return logout();
//});
$(window).on("beforeunload", function(){
    return console.log("1234");
});

$(window).on("unload",function(){
	logout();
});


function logout() {
	var path = '';
	path = getContextPath();
	window.location.href = path + '/user/logout.do';

}

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}