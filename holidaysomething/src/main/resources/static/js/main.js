let toggle = function (source) {
  let productOptionTrs = document.querySelectorAll('.productOptionTr');
  for (let i = 0; i < productOptionTrs.length; i++) {
    let productOptionCheckboxInput = productOptionTrs[i].getElementsByTagName(
        'input')[0];
    if (productOptionCheckboxInput !== source) {
      productOptionCheckboxInput.checked = source.checked;
    }
  }
};

let modify = function (source){
  // let existingValue = {
  //
  //   id : source.getElementById('.optionId'),
  //   name : source.getElementById('.optionName'),
  //   price : source.getElementById('.optionPrice'),
  //   description : source.getElementById('.optionDesc'),
  //   code : source.getElementById('.optionCode'),
  //   productName : source.getElementById('.optionProductName')
  // };

  //console.log("부모는");
  //console.log(document.getElementsByClassName('#modBtn'));


  let productOptionTrs = document.querySelector('.productOptionTr');
  console.log(source.parentNode.parentNode.childNodes[0]);
  console.log(source.parentNode.parentNode.childNodes[1]);
  console.log(source.parentNode.parentNode.childNodes[2]);
  console.log(source.parentNode.parentNode.childNodes[3]);
  console.log(source.parentNode.parentNode.childNodes[4]);

  console.log("16");
  console.log(source.parentNode.parentNode.childNodes[16]);

  console.log("17");
  console.log(source.parentNode.parentNode.childNodes[17]);

  console.log("18");
  console.log(source.parentNode.parentNode.childNodes[18]);


  console.log("length" +source.parentNode.parentNode.childNodes.length);



  //console.log(source.parentNode.parentNode.childNodes[2].innerText);

  //let ex = productOptionTrs.getElementsByTagName('td');
  //console.log(ex.parentElement.innerText);

  console.log('----------');

  //productOptionTrs

  //숫자로 짜기보다는, id가 무엇인 아이를 찾자 0부터 돌면
  for ( let i = 5; i < source.parentNode.parentNode.childNodes.length - 4; i+=2 ){
    let modInput = document.createElement('input');
    modInput.setAttribute('type', 'text');
    modInput.setAttribute('value', 'ㅋㅋㅋㅋ');
    source.parentNode.parentNode.childNodes[i].appendChild(modInput);
  }



  for (let i = 0; i < productOptionTrs.length - 2; i++){
    let tds = productOptionTrs[i].getElementsByTagName('td');
    //console.log(tds.text);
    console.log(tds[i].parentElement.innerText);
    console.log(tds[i].innerHTML);

    // console.log("existingValue");
    // console.log(existingValue.name);
    // console.log("/");
    // console.log(existingValue[i]);

    //tds[i] = existingValue[i];

    //console.log("테이블 row의 text가져오기");
    //console.log(tds[3].text());

    //
    // let modInput = document.createElement('input');
    // modInput.setAttribute('type', 'text');
    // modInput.setAttribute('value', )
    //
    // tds[i].appendChild(modInput);
  }


};

let productOptionFormSubmitBtn = document.querySelector(
    '#productOptionForm').querySelector('#productOptionFormSubmit');
productOptionFormSubmitBtn.addEventListener('click', (event) => {
  let productOptionCheckboxInput = document.getElementsByName(
      'productOptionId');

  // productOptionCheckboxInput이 하나도 체크되어 있지 않을 경우 submit 버튼 비활성화
  let allBtnUnchecked = true;
  for (let i = 0; i < productOptionCheckboxInput.length; i++) {
    if (productOptionCheckboxInput[i].checked === true) {
      allBtnUnchecked = false;
      break;
    }
  }
  if (allBtnUnchecked === true) {
    event.preventDefault();
    alert('적용할 옵션이 없습니다.');
  }
});

let validateProductOptionForm = function (form) {
  if (confirm('체크된 옵션을 모두 삭제하시겠습니까?')) {
    form.submit();
  } else {
    return false;
  }
};