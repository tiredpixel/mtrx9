$(document).ready(function() {
  $('h1, p, li, form input').hide(0, function() {
    $('h1').fadeIn(1000);
    $('p, li, form input').fadeIn(1500);
  });
});
