var toggleBtn = document.querySelector('.navToggleBtn');
var menu = document.querySelector('.mainMenu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});


var reviewToggleBtn = document.querySelector('.sidebtn7');
var review = document.querySelector('.review');

reviewToggleBtn.addEventListener('click', () => {
    review.classList.toggle('active');
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


document.querySelector(".copy-Phone").addEventListener("click", function(){
  var tempElem = document.createElement('textarea');
  tempElem.value = '010-3214-5324';  
  document.body.appendChild(tempElem);

  tempElem.select();
  document.execCommand("copy");
  document.body.removeChild(tempElem);
  alert("coopied");
});

document.querySelector(".copy-email").addEventListener("click", function(){
  var tempElem = document.createElement('textarea');
  tempElem.value = 'KCK0827@gmail.com';  
  document.body.appendChild(tempElem);

  tempElem.select();
  document.execCommand("copy");
  document.body.removeChild(tempElem);
  alert("coopied");
});

document.querySelector(".copy-address").addEventListener("click", function(){
  var tempElem = document.createElement('textarea');
  tempElem.value = '경기도 수원시 팔달구 매산동 매산로 12-1';  
  document.body.appendChild(tempElem);

  tempElem.select();
  document.execCommand("copy");
  document.body.removeChild(tempElem);
  alert("coopied");
});



	





