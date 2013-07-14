$(document).ready(function() {
  $('h1, p, li').hide(0, function() {
    $('h1').fadeIn(1000);
    $('p, li').fadeIn(1500);
  });
});
