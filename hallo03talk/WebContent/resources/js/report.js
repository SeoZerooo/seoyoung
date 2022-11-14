
//체크박스 하나만 선택되게
//1번 항목
const example1 = document.querySelector('#page');
const example2 = document.querySelector('#user');
const example3 = document.querySelector('#comment');

function example_1() {
	if(example1.checked == true) {
    example2.checked = false;
    example3.checked = false;
    }
   }
function example_2() {
	if(example2.checked == true) {
    example1.checked = false;
    example3.checked = false;
    }
   }
function example_3() {
	if(example3.checked == true) {
    example1.checked = false;
    example2.checked = false;
    }
   }

//2번 항목
const example4 = document.querySelector('#name');
const example5 = document.querySelector('#curse');
const example6 = document.querySelector('#disgust');
const example7 = document.querySelector('#ad');

function example_4() {
	if(example4.checked == true) {
    example5.checked = false;
    example6.checked = false;
    example7.checked = false;
    }
   }

function example_5() {
if(example5.checked == true) {
    example4.checked = false;
    example6.checked = false;
    example7.checked = false;
}
}

function example_6() {
if(example6.checked == true) {
    example4.checked = false;
    example5.checked = false;
    example7.checked = false;
}
}

function example_7() {
if(example7.checked == true) {
    example4.checked = false;
    example5.checked = false;
    example6.checked = false;
}
}