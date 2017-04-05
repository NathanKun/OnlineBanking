<<<<<<< HEAD
$('.nav-tabs-dropdown').each(function(i, elm) {
=======
﻿$('.nav-tabs-dropdown').each(function(i, elm) {
>>>>>>> 257839360dcd3726db3c5bc35eaf419676048332
    
    $(elm).text($(elm).next('ul').find('li.active a').text());
    
});
  
$('.nav-tabs-dropdown').on('click', function(e) {

    e.preventDefault();
    
    $(e.target).toggleClass('open').next('ul').slideToggle();
    
});

$('#nav-tabs-wrapper a[data-toggle="tab"]').on('click', function(e) {

    e.preventDefault();
    
    $(e.target).closest('ul').hide().prev('a').removeClass('open').text($(this).text());
      
});