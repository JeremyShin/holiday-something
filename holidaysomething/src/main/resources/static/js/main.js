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

let productOptionForm = document.querySelector('#productOptionForm');
if (productOptionForm !== null) {
  let productOptionFormSubmitBtn = productOptionForm.querySelector(
      '#productOptionFormSubmit');
  if (productOptionFormSubmitBtn !== null) {
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
}

let validateProductOptionForm = function (form) {
  if (confirm('체크된 옵션을 모두 삭제하시겠습니까?')) {
    form.submit();
  } else {
    return false;
  }
};

let updateMiddleCategory = function(largerId) {
  console.log('updateMiddleCategory is triggered');
  let option = '';

  $.getJSON(`/admin/product/subCategory/${largerId}`,
            function(category) {
              $(category).each(
                  function() {
                    option += `<option value=${this.id}>${this.name}</option>`;
                  }
              );
              let productCategorySelects = document.querySelectorAll('.product-category-select');
              productCategorySelects[1].appendChild(option);
            });
};

let updateSmallCategory = function(middleId) {
  console.log('updateSmallCategory is triggered');
  // let option = '';
  //
  // $.getJSON(`/admin/product/subCategory/${middleId}`,
  //     function(category) {
  //       $(category).each(
  //           function() {
  //             option += `<option value=${this.id}>${this.name}</option>`;
  //           }
  //       );
  //       // let productCategorySelects = document.querySelectorAll('.product-category-select');
  //       // productCategorySelects[1].appendChild(option);
  //     });
};