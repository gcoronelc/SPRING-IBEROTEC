
function fnLoadPage(page){
  var n = page.search(".htm");
  if(n > -1){
	  $("#EGCC_CONTENT").load(page);
  } else {
	  var url = "showPage.htm?pagina=" + page;
	  $("#EGCC_CONTENT").load(url);
  }
}

