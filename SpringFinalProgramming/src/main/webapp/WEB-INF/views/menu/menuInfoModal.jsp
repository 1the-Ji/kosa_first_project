<%@ page contentType="text/html;charset=UTF-8" %>
<div id="menuInfoModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:800px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu Information</b></h4>
      </div>
      <div class="modal-body">
		 <div class="left-panel">
	        
			<div class="panel panel-default">
   		    	<div class="panel-body">
   					<div class="thumbnail">
   						<img style="width:300; height:400px" src="menu/showPhoto?msavedfile=' + menu.mid + '"/>
   					</div>
   					<div class="icerik-bilgi">
   						<h2>${menu.mname} ${menu.hot_ice}</h2>
   						<p></p>
   						<div>
   							가격: ${menu.mprice}
   						</div>
   						<div>
   							${menu.mcontents}
   						</div>
   						<div>
   							<div>
   								<button type="button" class="btn btn-primary">
	   								수정
	   							</button>
   							</div>
	   						<div>
	   							<button type="button" class="btn btn-info">
	   								삭제
	   							</button>
	   						</div>
   						</div>
   					</div>
   				</div>
			</div>
    	 </div>
       </div>
     </div>
      
      
     <div class="modal-footer">
			<button type="button" class="btn btn-default">수정</button>
     </div>
    
  </div>
</div> 
      


