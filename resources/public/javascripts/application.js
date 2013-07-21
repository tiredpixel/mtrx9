$(document).ready(function () {
  'use strict';
  
  var matrixSettings,
    socket;
  
  matrixSettings = {
    id : $('#matrix-id').text()
  };
  
  $('h1, p, li, form input, table').hide(0, function () {
    $('h1').fadeIn(1000);
    $('p, li, form input, table').fadeIn(1500);
  });
  
  if ($('#matrix-id').length > 0) {
    socket = new WebSocket(
      window.location.href.replace("http://", "ws://") + "/websocket"
    );
    
    socket.onmessage = function (e) {
      var data = $.parseJSON(e.data);
      
      if (data.streams) {
        $('.placeholder').hide();
        
        $.each(data.streams, function (k, v) {
          var streamId,
            streamTailPrev,
            streamTail,
            streamChars;
          
          streamId  = 'stream-' + k.charCodeAt(0);
          
          if ($('#' + streamId).length === 0) {
            $('#matrix').append("<table id='" + streamId + "'><thead><tr><th>" + k.charAt(0) + "</th></tr></thead><tbody></tbody></table>");
          }
          
          streamTailPrev = $('#' + streamId + ' tbody tr.tail').removeClass('tail');
          
          streamTail = $("<tr class='tail'><td>" + v.charAt(0) + "</td></tr>");
          
          if (streamTailPrev.length > 0) {
            streamTail.insertAfter(streamTailPrev);
          } else {
            streamTail.appendTo($('#' + streamId));
          }
          
          streamChars = $('#' + streamId + ' tbody tr');
          
          if (streamTail[0] === streamChars.last()[0] &&
              $('#' + streamId).height() > $(window).height()) {
            streamChars.first().replaceWith(streamTail);
          } else {
            streamTail.next().remove();
          }
        });
      }
    };
  }
});
