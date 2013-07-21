$(document).ready(function() {
  $('h1, p, li, form input, table').hide(0, function() {
    $('h1').fadeIn(1000);
    $('p, li, form input, table').fadeIn(1500);
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
            
            if ($('#' + streamId).length === 0) {
              $('#matrix').append("<table id='" + streamId + "'><tr><th>" + k.charAt(0) + "</th></tr></table>");
            }
            
            $('#' + streamId).append("<tr><td>" + v.charAt(0) + "</td></tr>");
        });
      }
    };
  }
});
