/* ============================================
   INTERNATIONAL AFFAIRS — Main JavaScript
   Lightweight, no dependencies
   ============================================ */

(function () {
  'use strict';

  /* --- Mobile Navigation --- */
  const navToggle = document.querySelector('.nav__toggle');
  const navMenu = document.querySelector('.nav__menu');

  if (navToggle && navMenu) {
    navToggle.addEventListener('click', function () {
      const isOpen = navMenu.classList.toggle('open');
      navToggle.classList.toggle('active');
      navToggle.setAttribute('aria-expanded', isOpen);
      navToggle.setAttribute('aria-label', isOpen ? 'Close menu' : 'Open menu');
      document.body.style.overflow = isOpen ? 'hidden' : '';
    });

    // Close menu when a link is clicked
    navMenu.querySelectorAll('a').forEach(function (link) {
      link.addEventListener('click', function () {
        navMenu.classList.remove('open');
        navToggle.classList.remove('active');
        navToggle.setAttribute('aria-expanded', 'false');
        navToggle.setAttribute('aria-label', 'Open menu');
        document.body.style.overflow = '';
      });
    });
  }

  /* --- Navbar scroll effect --- */
  var nav = document.querySelector('.nav');
  if (nav) {
    var scrollThreshold = 50;
    window.addEventListener('scroll', function () {
      if (window.scrollY > scrollThreshold) {
        nav.classList.add('scrolled');
      } else {
        nav.classList.remove('scrolled');
      }
    }, { passive: true });
  }

  /* --- Scroll fade-in animation --- */
  var fadeElements = document.querySelectorAll('.fade-in');
  if (fadeElements.length > 0 && 'IntersectionObserver' in window) {
    var fadeObserver = new IntersectionObserver(function (entries) {
      entries.forEach(function (entry) {
        if (entry.isIntersecting) {
          entry.target.classList.add('visible');
          fadeObserver.unobserve(entry.target);
        }
      });
    }, {
      threshold: 0.15,
      rootMargin: '0px 0px -40px 0px'
    });

    fadeElements.forEach(function (el) {
      fadeObserver.observe(el);
    });
  } else {
    // Fallback: show all elements immediately
    fadeElements.forEach(function (el) {
      el.classList.add('visible');
    });
  }

  /* --- Email capture popup (30 second delay) --- */
  var popup = document.getElementById('emailPopup');
  var popupClose = document.getElementById('popupClose');
  var popupOverlay = document.getElementById('popupOverlay');

  function showPopup() {
    if (popup && !sessionStorage.getItem('ia_popup_closed')) {
      popup.classList.add('visible');
      // Trap focus inside popup
      var firstInput = popup.querySelector('input');
      if (firstInput) firstInput.focus();
    }
  }

  function closePopup() {
    if (popup) {
      popup.classList.remove('visible');
      sessionStorage.setItem('ia_popup_closed', 'true');
    }
  }

  if (popup) {
    setTimeout(showPopup, 30000);

    if (popupClose) popupClose.addEventListener('click', closePopup);
    if (popupOverlay) popupOverlay.addEventListener('click', closePopup);

    // Close on Escape key
    document.addEventListener('keydown', function (e) {
      if (e.key === 'Escape' && popup.classList.contains('visible')) {
        closePopup();
      }
    });
  }

  /* --- Cookie consent banner --- */
  var cookieBanner = document.getElementById('cookieBanner');
  var cookieAccept = document.getElementById('cookieAccept');
  var cookieDecline = document.getElementById('cookieDecline');

  if (cookieBanner && !localStorage.getItem('ia_cookie_consent')) {
    // Show after a brief delay so it doesn't compete with page load
    setTimeout(function () {
      cookieBanner.classList.add('visible');
    }, 1500);
  }

  function setCookieConsent(accepted) {
    localStorage.setItem('ia_cookie_consent', accepted ? 'accepted' : 'declined');
    if (cookieBanner) cookieBanner.classList.remove('visible');
  }

  if (cookieAccept) cookieAccept.addEventListener('click', function () { setCookieConsent(true); });
  if (cookieDecline) cookieDecline.addEventListener('click', function () { setCookieConsent(false); });

  /* --- Active nav link highlight --- */
  var currentPage = window.location.pathname.split('/').pop() || 'index.html';
  document.querySelectorAll('.nav__menu a').forEach(function (link) {
    var href = link.getAttribute('href');
    if (href === currentPage) {
      link.classList.add('active');
    } else {
      link.classList.remove('active');
    }
  });

})();
