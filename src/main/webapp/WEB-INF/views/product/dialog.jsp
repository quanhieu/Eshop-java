<%@ page pageEncoding="utf-8" %>

<!-- Modal -->
<div id="dialog" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Gửi thông tin hàng hóa cho bạn bè/người thân</h4>
      </div>
      <div class="modal-body">
        
        <form action="account/login" method="post">
        	<input type="hidden" name="id">
			<div class="form-group">
				<label>Người gửi</label>
				<input name="sender" class="form-control">
			</div>
			<div class="form-group">
				<label>Người nhận</label>
				<input name="receiver" class="form-control">
			</div>
			<div class="form-group">
				<label>Tiêu đề</label>
				<input name="subject" class="form-control">
			</div>
			<div class="form-group">
				<label>Lời nhắn</label>
				<textarea name="message" class="form-control" rows="3"></textarea>
			</div>
		</form>

      </div>
      <div class="modal-footer">
      	<div class="pull-left nn-sending">
      		<img src="images/loading.gif">
      		Đang gửi mail, vui lòng đợi...
      	</div>
      	<button class="btn btn-default nn-send">
			<span class="glyphicon glyphicon-ok-circle"></span> Send
		</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">
        	<span class="	glyphicon glyphicon-remove-circle"></span> Close
        </button>
      </div>
    </div>

  </div>
</div>