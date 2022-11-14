// index로 문자열 변경하기
String.prototype.replaceAt = function (index, word) {
  console.log(this.substring(0,index) + word + this.substring(index+1));
  if (index >= this.length) {
    return this.valueOf();
  }
  return this.substring(0,index) + word + this.substring(index+1);
}


function clickCategory(x) {
  const nowURL = location.href.substring(21);
  let changeURL =  nowURL.replaceAt(nowURL.indexOf('&cityNo=')-1,x);
  location.href = changeURL;
}

function clickCity(x) {
  const nowURL = location.href;
  let changeURL =  nowURL.replaceAt(nowURL.indexOf('&insideNo=')-1,x);
  location.href = changeURL;
}

function clickInside(x) {
  const nowURL = location.href.substring(21);
  let changeURL =  nowURL.replaceAt(nowURL.indexOf('insideNo=')+9,x);
  location.href = changeURL;
}

const makePointer = document.querySelectorAll('.makePo');
makePointer.forEach((item) => {
  item.style.cursor = 'pointer';
})