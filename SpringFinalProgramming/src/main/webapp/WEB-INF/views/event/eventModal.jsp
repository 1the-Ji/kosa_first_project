<%@ page contentType="text/html;charset=UTF-8" %>

<div id="eventModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Event</b></h4>
      </div>
      <div class="modal-body">
	    <table class="table table-striped custab">
		    <thead>
		    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
		        <tr>
		            <th>No.</th>
		            <th>Title</th>
		            <th>time</th>
		            <th>content</th>
		            <th class="text-center">Action</th>
		        </tr>
		    </thead>
	         <tr>
	             <td>1</td>
	             <td>News</td>
	             <td>News Cate</td>
	             <td>new content</td>
	             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
	         </tr>
	         <tr>
	             <td>2</td>
	             <td>Products</td>
	             <td>Main Products</td>
	             <td>new content</td>
	             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
	         </tr>
	         <tr>
	             <td>3</td>
	             <td>Blogs</td>
	             <td>Parent Blogs</td>
	             <td>new content</td>
	             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
	         </tr>
	    </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button> 
      </div>
    </div>
  </div>
</div> 
