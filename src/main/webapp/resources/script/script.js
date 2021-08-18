var toggleBtn = document.querySelector('.navToggleBtn');
var menu = document.querySelector('.mainMenu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});


var reviewToggleBtn = document.querySelector('.reviewToggleBtn');
var review = document.querySelector('.review');

if (reviewToggleBtn != null ) {
	reviewToggleBtn.addEventListener('click', () => {
	    review.classList.toggle('active');
	}); 
}


var changeMyInfodBtn = document.querySelector('.changeMyInfodBtn');
var wrapMyInfoDetail = document.querySelector('.wrapMyInfoDetail');

changeMyInfodBtn.addEventListener('click', () => {
    wrapMyInfoDetail.classList.toggle('active');
    document.documentElement.scrollTop = 300;
});


var changePasswordToggle = document.querySelector('.changePasswordToggle');
var changePassword = document.querySelector('.changePassword');

changePasswordToggle.addEventListener('click', () => {
    changePassword.classList.toggle('active');
    document.documentElement.scrollTop = 400;
});

var exitchangePasswordBtn = document.querySelector('.exitchangePasswordBtn');
var changePassword = document.querySelector('.changePassword');

exitchangePasswordBtn.addEventListener('click', () => {
    changePassword.classList.toggle('active');
    document.documentElement.scrollTop = 200;
});



var changePhoneToggle = document.querySelector('.changePhoneToggle');
var changePhone = document.querySelector('.changePhone');
var changePhoneBtn = document.querySelector('.changePhoneBtn');
var currentPhone = document.querySelector('.currentPhone');

changePhoneToggle.addEventListener('click', () => {
    changePhone.classList.toggle('active');
    changePhoneBtn.classList.toggle('active');
    currentPhone.classList.toggle('active');
});

var changeEmailToggle = document.querySelector('.changeEmailToggle');
var changeEmail = document.querySelector('.changeEmail');
var changeEmailBtn = document.querySelector('.changeEmailBtn');
var currentEmail = document.querySelector('.currentEmail');

changeEmailToggle.addEventListener('click', () => {
    changeEmail.classList.toggle('active');
    changeEmailBtn.classList.toggle('active');
    currentEmail.classList.toggle('active');
});






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
  alert("copied");
});

document.querySelector(".copy-email").addEventListener("click", function(){
  var tempElem = document.createElement('textarea');
  tempElem.value = 'KCK0827@gmail.com';  
  document.body.appendChild(tempElem);

  tempElem.select();
  document.execCommand("copy");
  document.body.removeChild(tempElem);
  alert("copied");
});

document.querySelector(".copy-address").addEventListener("click", function(){
  var tempElem = document.createElement('textarea');
  tempElem.value = '경기도 수원시 팔달구 매산동 매산로 12-1';  
  document.body.appendChild(tempElem);

  tempElem.select();
  document.execCommand("copy");
  document.body.removeChild(tempElem);
  alert("copied");
});




function fnChkByte(obj, maxByte) {
    var str = obj.value;
    var str_len = str.length;


    var rbyte = 0;
    var rlen = 0;
    var one_char = "";
    var str2 = "";


    for (var i = 0; i < str_len; i++) {
        one_char = str.charAt(i);
        if (escape(one_char).length > 4) {
            rbyte += 2;                                         //한글2Byte
        }
        else {
            rbyte++;                                            //영문 등 나머지 1Byte
        }


        if (rbyte <= maxByte) {
            rlen = i + 1;                                          //return할 문자열 갯수
        }
    }


    if (rbyte > maxByte) {
        // alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
        alert("상세내용는 최대 " + maxByte + "byte를 초과할 수 없습니다.")
        str2 = str.substr(0, rlen);                                  //문자열 자르기
        obj.value = str2;
        fnChkByte(obj, maxByte);
    }
    else {
        document.getElementById('byteInfo').innerText = rbyte;
    }
}

function goTop(){
	document.documentElement.scrollTop = 0;
};