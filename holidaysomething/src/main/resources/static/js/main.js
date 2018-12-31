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
    if (source.parentElement.parentElement.children[i].id === "optionName") {
      nameInput.setAttribute('type', 'text');
      nameInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(nameInput);
    }

    if (source.parentElement.parentElement.children[i].id === "optionPrice") {
      priceInput.setAttribute('type', 'text');
      priceInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(priceInput);
    }

    if (source.parentElement.parentElement.children[i].id === "optionDesc") {
      descInput.setAttribute('type', 'text');
      descInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(descInput);
    }

    if (source.parentElement.parentElement.children[i].id === "optioCode") {
      codeInput.setAttribute('type', 'text');
      codeInput.setAttribute('value',
          source.parentElement.parentElement.children[i].innerText);
      source.parentElement.parentElement.children[i].appendChild(codeInput);
    }

    if (source.parentElement.parentElement.children[i].childNodes[0].id
        === "modifyBtn") {
      console.log("수정버튼입니다.");
      let btn = source.parentElement.parentElement.children[i].childNodes[0];
      btn.setAttribute("value", "수정완료");
    }
  }

  let name = document.getElementById("optionName").innerText;

  let req = new XMLHttpRequest();
  console.log("포스트 매핑으로 보낼 옵션의 이름은 ");
  console.log(name);

  req.open('POST', '/admin/product/product_detail/option/modify', true);
  req.setRequestHeader('Content-type', 'application/json');
  req.send(JSON.stringify({name: name}));

};

let productOptionFormSubmit = document.querySelector('#productOptionForm');
if (productOptionFormSubmit !== null) {
  let productOptionFormSubmitBtn = productOptionFormSubmit.querySelector('#productOptionFormSubmit');
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

let updateMiddleCategory = function (option) {
  let largeId = option.value;
  console.log(`updateMiddleCategory(${largeId}) is triggered`);

  $.getJSON(`/admin/product/subCategory/${largeId}`,
      function (category) {
        let productMiddleCategorySelect = document.getElementsByName(
            'productMiddleCategoryId')[0];
        // 중분류에 남아있을지 모르는 option 태그 모두 삭제 ('중분류' selected option만 남기고)
        while (productMiddleCategorySelect.length > 1) {
          productMiddleCategorySelect.removeChild(
              productMiddleCategorySelect.lastChild);
        }

        let productSmallCategorySelect = document.getElementsByName(
            'productSmallCategoryId')[0];
        // 소분류에 남아있을지 모르는 option 태그 모두 삭제 ('소분류' selected option만 남기고)
        while (productSmallCategorySelect.length > 1) {
          productSmallCategorySelect.removeChild(
              productSmallCategorySelect.lastChild);
        }

        $(category).each(function () {
          let option = document.createElement('option');
          option.text = this.name;
          option.value = this.id;
          productMiddleCategorySelect.appendChild(option);
        });
      });
};

let updateSmallCategory = function (option) {
  let middleId = option.value;
  console.log(`updateMiddleCategory(${middleId}) is triggered`);

  $.getJSON(`/admin/product/subCategory/${middleId}`,
      function (category) {
        let productSmallCategorySelect = document.getElementsByName(
            'productSmallCategoryId')[0];
        // 소분류에 남아있을지 모르는 option 태그 모두 삭제 (selected option만 남기고)
        while (productSmallCategorySelect.length > 1) {
          productSmallCategorySelect.removeChild(
              productSmallCategorySelect.lastChild);
        }

        $(category).each(function () {
          let option = document.createElement('option');
          option.text = this.name;
          option.value = this.id;
          productSmallCategorySelect.appendChild(option);
        });
      });
};