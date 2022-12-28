// 메뉴 클릭
function clickMenu(url){
	
  let form = document.createElement('form');

  	 form.method = 'POST';
	 form.action = url;
 
	 document.body.append(form);
	 form.submit();
}