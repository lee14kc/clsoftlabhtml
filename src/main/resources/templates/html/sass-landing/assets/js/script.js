/*
Author       : DreamsTechnologies
Template Name: DreamsTour - Bootstrap Template
*/

(function () {
  "use strict";

  // Mobile Menu Js
  $("#mobile-menu").meanmenu({
    meanMenuContainer: ".mobile-menu",
    meanScreenWidth: "991",
    meanExpand: ['<i class="ti ti-plus"></i>'],
  });

  // Sidebar Toggle Js
  $(".offcanvas-close,.offcanvas-overlay").on("click", function () {
    $(".offcanvas-info").removeClass("show");
    $(".offcanvas-overlay").removeClass("overlay-open");
  });
  $(".sidebar-menu").on("click", function () {
    $(".offcanvas-info").addClass("show");
    $(".offcanvas-overlay").addClass("overlay-open");
  });

  // Body Overlay Js
  $(".body-overlay").on("click", function () {
    $(".offcanvas__area").removeClass("offcanvas-opened");
    $(".df-search-area").removeClass("opened");
    $(".body-overlay").removeClass("opened");
  });

  // Sticky Header
  $(window).scroll(function () {
    if ($(this).scrollTop() > 130) {
      $("header").addClass("fixed");
    } else {
      $("header").removeClass("fixed");
    }
  });

  new WOW().init();


  // JQuery counterUp
  if ($(".counter").length > 0) {
    $(".counter").counterUp({
      delay: 10,
      time: 1500,
    });
    $(".counter").addClass("animated fadeInDownBig");
  }

  // Scroll Top
  $(window).scroll(function () {
    var scroll = $(window).scrollTop();
    if (scroll >= 500) {
      $(".back-to-top-icon").addClass("show");
    } else {
      $(".back-to-top-icon").removeClass("show");
    }
  });

  // Accordion class
  if ($('.faq-accordion').length > 0) {
    $('.accordion-item .collapse').on('show.bs.collapse', function () {
      $(this).parent().addClass('show');
    });
    $('.accordion-item .collapse').on('hide.bs.collapse', function () {
      $(this).parent().removeClass('show');
    });
  }

  // Accordion class

  $('.accordion-item .collapse').on('show.bs.collapse', function () {
    $(this).parent().addClass('show');
  });

  $('.accordion-item .collapse').on('hide.bs.collapse', function () {
    $(this).parent().removeClass('show');
  });
})(jQuery);


// Horizontal Slide

document.addEventListener("DOMContentLoaded", function () {
  const scrollers = document.querySelectorAll(".horizontal-slide");
  scrollers.forEach((scroller) => {
    scroller.setAttribute("data-animated", true);
    const scrollerInner = scroller.querySelector(".slide-list");
    const scrollerContent = Array.from(scrollerInner.children);
    scrollerContent.forEach((item) => {
      const duplicatedItem = item.cloneNode(true);
      duplicatedItem.setAttribute("aria-hidden", true);
      scrollerInner.appendChild(duplicatedItem);
    });
  });
  
  if($('.pricing-slider').length > 0 ){
		var owl = $('.pricing-slider');
			owl.owlCarousel({
            margin: 30,
            dots : false,
			nav: true,
			navText: [
				'<i class="fas fa-chevron-left"></i>',
				'<i class="fas fa-chevron-right"></i>'
			],
			loop: true,
			responsive: {
				0: {
					items: 1
				},
				768 : {
					items: 2
				},
				1170: {
					items: 3
				}
			}
		});
	} 

  // home2
  if($('.features-slider').length > 0 ){
		var owl = $('.features-slider');
			owl.owlCarousel({
            margin: 30,
            dots : false,
			nav: true,
			navText: [
				'<i class="fas fa-chevron-left"></i>',
				'<i class="fas fa-chevron-right"></i>'
			],
			loop: true,
			responsive: {
				0: {
					items: 1
				}
			}
		});
	} 
});

if($('.testimonials-slider').length > 0 ){
  var owl = $('.testimonials-slider');
    owl.owlCarousel({
          margin: 30,
          dots : false,
    nav: true,
    navText: [
      '<i class="fas fa-chevron-left"></i>',
      '<i class="fas fa-chevron-right"></i>'
    ],
    loop: true,
    responsive: {
      0: {
        items: 1
      },
      992 : {
        items: 2
      },
      1200: {
        items: 3
      }
    }
  });
} 


if($('.blog-slider').length > 0 ){
  var owl = $('.blog-slider');
    owl.owlCarousel({
          margin: 30,
          dots : false,
    nav: true,
    navText: [
      '<i class="fas fa-chevron-left"></i>',
      '<i class="fas fa-chevron-right"></i>'
    ],
    loop: true,
    responsive: {
      0: {
        items: 1
      },
      768 : {
        items: 2
      },
      992: {
        items: 3
      }
    }
  });
} 
// counter
if($('.counterUp').length > 0) {
  $('.counterUp').counterUp({
          delay: 15,
          time: 1500
      });
}

// aos
AOS.init();
  // home2

if($('.carousel2').length > 0 ){
  var owl = $('.carousel2');
    owl.owlCarousel({
          margin: 30,
          dots : false,
    nav: true,
    navText: [
      '<i class="fas fa-chevron-left"></i>',
      '<i class="fas fa-chevron-right"></i>'
    ],
    loop: true,
    responsive: {
      0: {
        items: 1
      },
      768 : {
        items: 2
      },
      1170: {
        items: 3
      }
    }
  });
} 
