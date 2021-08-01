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

dnBtnQa.forEach(el => {
	el.addEventListener('click', function() {
		this.parentNode
			.parentNode
			.nextElementSibling
			.classList.toggle('active')
	})
	el.addEventListener('click', function() {
   		this.nextElementSibling
   			.classList.toggle('active')
	})
	el.addEventListener('click', function() {
   		el.classList.toggle('active')
	})
})

upBtnQa.forEach(el => {
	el.addEventListener('click', function() {
		this.parentNode
			.parentNode
			.nextElementSibling
			.classList.toggle('active')
	})
	el.addEventListener('click', function() {
   		this.previousElementSibling
   			.classList.toggle('active')
	})
	el.addEventListener('click', function() {
   		el.classList.toggle('active')
	})
})






