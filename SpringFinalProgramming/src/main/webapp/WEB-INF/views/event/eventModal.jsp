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
		    <a href="#" id="btnRegEvent" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
		        <tr>
		            <th>No.</th>
		            <th>Title</th>
		            <th>time</th>
		            <th>content</th>
		            <th class="text-center">Action</th>
		        </tr>
		    </thead>
		    <tbody id="eventTbody">
	         </tbody>
	         
	    </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button> 
      </div>
    </div>
  </div>
</div> 
