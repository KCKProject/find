var toggleBtn = document.querySelector('.navToggleBtn');
var menu = document.querySelector('.mainMenu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});
