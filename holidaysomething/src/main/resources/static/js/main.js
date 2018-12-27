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

let nameInput = document.createElement("input");
let priceInput = document.createElement("input");
let descInput = document.createElement("input");
let codeInput = document.createElement("input");

let modify = function (source) {
  /* inputbox 생성 */
  for (let i = 0; i < source.parentElement.parentElement.children.length; i++) {
    if (source.parentElement.parentElement.children[i].id == "optionName") {
      nameInput.setAttribute('type', 'text');
      nameInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(nameInput);
    }

    if (source.parentElement.parentElement.children[i].id == "optionPrice") {
      priceInput.setAttribute('type', 'text');
      priceInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(priceInput);
    }

    if (source.parentElement.parentElement.children[i].id == "optionDesc") {
      descInput.setAttribute('type', 'text');
      descInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(descInput);
    }

    if (source.parentElement.parentElement.children[i].id == "optioCode") {
      codeInput.setAttribute('type', 'text');
      codeInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(codeInput);
    }

    if (source.parentElement.parentElement.children[i].childNodes[0].id == "modifyBtn") {
      console.log("수정버튼입니다.");
      let btn = source.parentElement.parentElement.children[i].childNodes[0];
      btn.setAttribute("value", "수정완료");
    }
  }

  // let req = new XMLHttpRequest();
  // let name = document.getElementById("optionName").innerText;
  //
  // console.log("포스트 매핑으로 보낼 옵션의 이름은 ");
  // console.log(name);
  //
  // req.open("POST", "/admin/product/product_detail/option/modify", true);
  // req.setRequestHeader("content-type", "application/json");
  // //req.send("name=" + encodeURIComponent(name));
  // req.send(dojo.toJson(name));

  let name = document.getElementById("optionName").innerText;

  // let data = new FormData();
  // data.append('name', name);

  let req = new XMLHttpRequest();
  console.log("포스트 매핑으로 보낼 옵션의 이름은 ");
  console.log(name);

  req.open('POST', '/admin/product/product_detail/option/modify', true);
  req.setRequestHeader('Content-type', 'application/json');
  //req.setRequestHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
  //req.send("name=" + encodeURIComponent(name));
  req.send(JSON.stringify({name: name}));

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