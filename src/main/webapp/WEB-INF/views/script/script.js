var toggleBtn = document.querySelector('.navToggleBtn');
var menu = document.querySelector('.mainMenu');
var search = document.querySelector('.search');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    search.classList.toggle('active');
});