let createRowBtn = document.querySelector('#createRow');
let num = 1;

/* 옵션 추가 버튼 누를 시, 행 생성 */
if (createRowBtn !== null) {
  createRowBtn.addEventListener('click', () => {
    let tr = document.createElement('tr');
    tr.setAttribute('id', 'optionCheckTr');

    let td1 = document.createElement('td');

    let delInput = document.createElement('input');
    delInput.setAttribute('type', 'button');
    delInput.setAttribute('value', '삭제');
    delInput.setAttribute('onclick', 'deleteRow(this);');
    td1.appendChild(delInput);

    tr.appendChild(td1);

    let td2 = document.createElement('td');
    let div1 = document.createElement('div');
    let textNode1 = document.createTextNode('옵션명:   ');
    div1.appendChild(textNode1);
    let input2 = document.createElement('input');
    input2.setAttribute('type', 'text');
    input2.setAttribute('name', 'productOptions[' + num + '].name');
    input2.setAttribute('placeholder', '예시) 옵션명을 입력하시오');
    input2.setAttribute('maxlength', '50');
    input2.setAttribute('size', '70');
    div1.appendChild(input2);
    let span1 = document.createElement('span');
    div1.appendChild(span1);
    td2.appendChild(div1);
    tr.appendChild(td2);

    let div2 = document.createElement('div');
    let textNode2 = document.createTextNode('추가금액: ');
    div2.appendChild(textNode2);
    let input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'productOptions[' + num + '].price');
    input3.setAttribute('size', '70');
    div2.appendChild(input3);
    let span2 = document.createElement('span');
    div2.appendChild(span2);
    td2.appendChild(div2);
    tr.appendChild(td2);

    let div3 = document.createElement('div');
    let textNode4 = document.createTextNode('옵션설명: ');
    div3.appendChild(textNode4);
    let input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'productOptions[' + num + '].description');
    input4.setAttribute('size', '70');
    input4.setAttribute('style', 'height:30px;');

    div3.appendChild(input4);
    td2.appendChild(div3);

    tr.appendChild(td2);

    let optionValueRows = document.querySelector('#option_value_rows');
    optionValueRows.appendChild(tr);
    num = num + 1;
  });
}

/* 선택한 row 삭제 */
let deleteRow = function (source) {
  let my_tbody = document.getElementById('option_value_rows');
  console.log(
      "Row index is: " + source.parentElement.parentElement.rowIndex - 1);
  my_tbody.deleteRow(source.parentElement.parentElement.rowIndex - 1);
};

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

/* 수정버튼 클릭 */
let modify = function (source) {
  let nameInput = document.createElement("input");
  let priceInput = document.createElement("input");
  let descInput = document.createElement("input");

  /* 현재 클릭한 row의 옵션 id를 사용하기 위해, id값 부여 */
  source.parentElement.parentElement.children[1].setAttribute('id',
      'modifiedId');

  /* inputbox 생성 */
  for (let i = 0; i < source.parentElement.parentElement.children.length; i++) {
    if (source.parentElement.parentElement.children[i].id === "optionName") {
      nameInput.setAttribute('type', 'text');
      nameInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      nameInput.setAttribute('id', 'modifiedName');

      /* 이미 존재하던 textNode 삭제 */
      if (source.parentElement.parentElement.children[i].childNodes[0]) {
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

      if (source.parentElement.parentElement.children[i].childNodes[0]) {
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

      if (source.parentElement.parentElement.children[i].childNodes[0]) {
        let a = source.parentElement.parentElement.children[i];
        let b = a.childNodes[0];
        a.removeChild(b);
      }
      source.parentElement.parentElement.children[i].appendChild(descInput);
    }

    if (source.parentElement.parentElement.children[i].childNodes[0].id
        === "modifyBtn") {
      console.log("수정버튼입니다.");
      let btn = source.parentElement.parentElement.children[i].childNodes[0];
      btn.setAttribute("id", "modifiedBtn");
      btn.setAttribute("value", "수정완료");
      btn.setAttribute('onclick', 'finishModify(this);');
    }
  }
};

/* 수정완료 버튼 클릭 */
let finishModify = function (source) {
  console.log("수정완료버튼이 눌렸습니다.");

  let name = document.getElementById('modifiedName');
  let id = document.getElementById('modifiedId');
  let price = document.getElementById('modifiedPrice');
  let desc = document.getElementById('modifiedDesc');

  let req = new XMLHttpRequest();
  req.open('PATCH', '/api/admin/product/option', true);
  req.setRequestHeader('Content-type', 'application/json');
  req.setRequestHeader('X-CSRF-Token', $('input[name="_csrf"]').val());
  req.send(JSON.stringify({
    id: id.innerText,
    name: name.value,
    price: price.value,
    description: desc.value
  }));
  req.onreadystatechange = function () {
    let ok = 200;
    window.location.href = '/admin/product/option';
  }
};

let productOptionFormSubmit = document.querySelector('#productOptionForm');
if (productOptionFormSubmit !== null) {
  let productOptionFormSubmitBtn = productOptionFormSubmit.querySelector(
      '#productOptionFormSubmit');
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
}

let validateProductOptionForm = function (form) {
  if (confirm('체크된 옵션을 모두 삭제하시겠습니까?')) {
    form.submit();
  } else {
    return false;
  }
};