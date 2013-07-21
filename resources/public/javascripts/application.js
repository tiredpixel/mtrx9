$(document).ready(function() {
  $('h1, p, li, form input, dl').hide(0, function() {
    $('h1').fadeIn(1000);
    $('p, li, form input, dl').fadeIn(1500);
  });
  
  if ($('#matrix-id').length > 0) {
    var socket = new WebSocket(
      window.location.href.replace("http://", "ws://") + "/websocket"
    );
    
    socket.onmessage = function (e) {
      var data = $.parseJSON(e.data);
      
      if (data.chars) {
        $.each(data.chars, function(k, v) {
            var streamId  = 'stream-' + k.charCodeAt(0);
            var streamIdK = streamId + '-k';
            var streamIdV = streamId + '-v';
            
            if ($('#' + streamIdK).length === 0) {
              $('#matrix dl').append("<dt id='" + streamIdK + "'>" + k.charAt(0) + "</dt><dd id='" + streamIdV + "'></dd>");
            }
            
            $('#' + streamIdV).append("<span>" + v.charAt(0) + "</span>");
        });
      }
    };
  }
});
