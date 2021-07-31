var toggleBtn = document.querySelector('.navToggleBtn');
var menu = document.querySelector('.mainMenu');
toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});


function goTop(){
	document.documentElement.scrollTop = 0;
};


var upBtnQa = document.querySelectorAll('.upBtnQa');
var dnBtnQa = document.querySelectorAll('.dnBtnQa');

console.log(dnBtnQa)

dnBtnQa.forEach(el => {
	el.addEventListener('click', function() {
		this.parentNode
			.parentNode
			.nextElementSibling
			.classList.toggle('active')
	})
})