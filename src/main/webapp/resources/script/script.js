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


var changeMyInfodToggle = document.querySelector('.changeMyInfodToggle');
var wrapMyInfoDetail = document.querySelector('.wrapMyInfoDetail');

if (changeMyInfodToggle != null) {
	changeMyInfodToggle.addEventListener('click', () => {
	    wrapMyInfoDetail.classList.toggle('active');
	    document.documentElement.scrollTop = 300;
	});
}


var exitchangePasswordBtn = document.querySelector('.exitchangePasswordBtn');
var changePassword = document.querySelector('.changePassword');

if (exitchangePasswordBtn != null) {
	exitchangePasswordBtn.addEventListener('click', () => {
	    changePassword.classList.toggle('active');
	    document.documentElement.scrollTop = 200;
	});
}








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
  tempElem.value = '????????? ????????? ????????? ????????? ????????? 12-1';  
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
            rbyte += 2;                                         //??????2Byte
        }
        else {
            rbyte++;                                            //?????? ??? ????????? 1Byte
        }


        if (rbyte <= maxByte) {
            rlen = i + 1;                                          //return??? ????????? ??????
        }
    }


    if (rbyte > maxByte) {
        // alert("?????? "+(maxByte/2)+"??? / ?????? "+maxByte+"?????? ?????? ????????? ??? ????????????.");
        alert("?????? " + maxByte + "byte??? ????????? ??? ????????????.")
        str2 = str.substr(0, rlen);                                  //????????? ?????????
        obj.value = str2;
        fnChkByte(obj, maxByte);
    }
    else {
      document.getElementById('byteInfo').innerText = rbyte;
    }
}

function fnChkByte2(obj, maxByte) {
    var str = obj.value;
    var str_len = str.length;


    var rbyte = 0;
    var rlen = 0;
    var one_char = "";
    var str2 = "";


    for (var i = 0; i < str_len; i++) {
        one_char = str.charAt(i);
        if (escape(one_char).length > 4) {
            rbyte += 2;                                         //??????2Byte
        }
        else {
            rbyte++;                                            //?????? ??? ????????? 1Byte
        }


        if (rbyte <= maxByte) {
            rlen = i + 1;                                          //return??? ????????? ??????
        }
    }


    if (rbyte > maxByte) {
        // alert("?????? "+(maxByte/2)+"??? / ?????? "+maxByte+"?????? ?????? ????????? ??? ????????????.");
        alert("?????? " + maxByte + "byte??? ????????? ??? ????????????.")
        str2 = str.substr(0, rlen);                                  //????????? ?????????
        obj.value = str2;
        fnChkByte(obj, maxByte);
    }
    else {
     // document.getElementById('byteInfo').innerText = rbyte;
    }
}


function goTop(){
	document.documentElement.scrollTop = 0;
};