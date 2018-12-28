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

let modify = function (source) {

  console.log("넘어온 아이디를 찍어보자~");
  console.log(source.parentElement.parentElement.children[1].innerHTML);
  source.parentElement.parentElement.children[1].setAttribute('id', 'modifiedId');

  let nameInput = document.createElement("input");
  let priceInput = document.createElement("input");
  let descInput = document.createElement("input");
  let name;

  /* inputbox 생성 */
  for (let i = 0; i < source.parentElement.parentElement.children.length; i++) {
    if (source.parentElement.parentElement.children[i].id === "optionName") {
      nameInput.setAttribute('type', 'text');
      nameInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      nameInput.setAttribute('id', 'modifiedName');

      /* 이미 존재하던 textNode 삭제 */
      if(source.parentElement.parentElement.children[i].childNodes[0]) {
        let a = source.parentElement.parentElement.children[i];
        let b = a.childNodes[0];
        a.removeChild(b);
      }

      source.parentElement.parentElement.children[i].appendChild(nameInput);
    }

    if (source.parentElement.parentElement.children[i].id === "optionPrice") {
      priceInput.setAttribute('type', 'text');
      priceInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      priceInput.setAttribute('id', 'modifiedPrice');

      if(source.parentElement.parentElement.children[i].childNodes[0]) {
        let a = source.parentElement.parentElement.children[i];
        let b = a.childNodes[0];
        a.removeChild(b);
      }

      source.parentElement.parentElement.children[i].appendChild(priceInput);
    }

    if (source.parentElement.parentElement.children[i].id === "optionDesc") {
      descInput.setAttribute('type', 'text');
      descInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      descInput.setAttribute('id', 'modifiedDesc');

      if(source.parentElement.parentElement.children[i].childNodes[0]) {
        let a = source.parentElement.parentElement.children[i];
        let b = a.childNodes[0];
        a.removeChild(b);
      }

      source.parentElement.parentElement.children[i].appendChild(descInput);
    }


    if (source.parentElement.parentElement.children[i].childNodes[0].id === "modifyBtn") {
      console.log("수정버튼입니다.");
      let btn = source.parentElement.parentElement.children[i].childNodes[0];
      btn.setAttribute("id", "modifiedBtn");
      btn.setAttribute("value", "수정완료");
      console.log("ㅁㅇㅁㄴㅇㅁㅇㅁㄴㅇㅁㄴㅇ");
      console.log(name);
      btn.setAttribute('onclick', 'finMod(this);');
    }
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

let finMod = function (source) {
  console.log("수정완료버튼이 눌렸습니다.");

  let nameElem = document.getElementById('modifiedName');
  let idElem = document.getElementById('modifiedId');
  let priceElem = document.getElementById('modifiedPrice');
  let descElem = document.getElementById('modifiedDesc');

  console.log(nameElem.value);
  console.log(idElem.innerText);
  console.log(priceElem.value);
  console.log(descElem.value);

  let req = new XMLHttpRequest();
  req.open('POST', '/admin/product/product_detail/option/modify', true);
  req.setRequestHeader('Content-type', 'application/json');
  req.send(JSON.stringify({id: idElem.innerText, name: nameElem.value, price: priceElem.value, description: descElem.value}));
  req.onreadystatechange = function () {
    let ok = 200;
    window.location.href = '/admin/product/product_detail';
  }
};