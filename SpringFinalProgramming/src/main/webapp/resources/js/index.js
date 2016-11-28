$(function() {
   $("#btnLogin").on("click", function() {
      $("#loginModal").modal("show");
   });
   
   $("#btnStore").on("click", function () {
      $("#storeModal").modal("show");
   });
   
   function menuList(sid){
	   $("$menuModal").modal("show");
	   
   };
   
   
   $("#btnMenu").on("click", function menuList(sid) {
	   $("#menuModal").modal("show");
	   var data = $("#menuModal").mListAjax(sid);
	   $("#menuModal #photo").val(data.photo);
	   $("#menuModal #mname").val(data.mname);
	   $("#menuModal #hot_ice").val(data.hot_ice);
	   $("#menuModal #mprice").val(data.mprice);
		 
   });
   
   function mListAjax(sid){
	   $.ajax({
			url: "../menu/list",
			data: {"sid": sid},
			success: function(data){
				parent.menuList(data);
			}
		});	   
   };
   

   
   
   $("#btnEvent").on("click", function() {
      $("#eventModal").modal("show");
   });
   
   $("#btnOrder").on("click", function () {
      $("#orderModal").modal("show");
   });
});
