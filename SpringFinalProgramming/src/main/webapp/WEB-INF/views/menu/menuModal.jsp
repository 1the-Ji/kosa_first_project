<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:800px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h1 class="modal-title" align="center"><b>Menu List</b></h1>
       
      </div>
      <div class="modal-body" align="center">
      	<div class="btn-group">
      		<button onclick="btnMgroup('전체')" type="button" class="btn btn-info btn-filter">All</button>
			<button onclick="btnMgroup('커피')" type="button" class="btn btn-info btn-filter">Coffee</button>
			<button onclick="btnMgroup('차')" type="button" class="btn btn-info btn-filter">Tea</button>
			<button onclick="btnMgroup('디저트')" type="button" class="btn btn-info btn-filter">Dessert</button>
			<button onclick="btnMgroup('기타')" type="button" class="btn btn-info btn-filter">Etc</button>
		</div>
		<hr/>
     		
   		<table style="width:100%">
   			<tr>
				<td id="menuListTd">
				
				</td>
   			</tr>
  		</table>
      </div>
      
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div> 
