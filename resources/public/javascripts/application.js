$(document).ready(function() {
  $('h1, p, li').hide(400, function() {
    $('h1').fadeIn(1000);
    $('p, li').fadeIn(1500);
  });
});
