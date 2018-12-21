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

let updateMiddleCategory = function(largeId) {
  console.log('updateMiddleCategory() is triggered');

  $.getJSON(`/admin/product/subCategory/${largeId}`,
            function(category) {
              let productMiddleCategorySelect = document.getElementsByName('productMiddleCategoryId')[0];
              // 중분류에 남아있을지 모르는 option 태그 모두 삭제 ('중분류' selected option만 남기고)
              while (productMiddleCategorySelect.length > 1) {
                productMiddleCategorySelect.removeChild(productMiddleCategorySelect.lastChild);
              }

              let productSmallCategorySelect = document.getElementsByName('productSmallCategoryId')[0];
              // 소분류에 남아있을지 모르는 option 태그 모두 삭제 ('소분류' selected option만 남기고)
              while (productSmallCategorySelect.length > 1) {
                productSmallCategorySelect.removeChild(productSmallCategorySelect.lastChild);
              }

              $(category).each(function() {
                let option = document.createElement('option');
                option.text = this.name;
                option.value = this.id;
                productMiddleCategorySelect.appendChild(option);
              });
            });
};

let updateSmallCategory = function(middleId) {
  console.log('updateSmallCategory() is triggered');

  $.getJSON(`/admin/product/subCategory/${middleId}`,
      function(category) {
        let productSmallCategorySelect = document.getElementsByName('productSmallCategoryId')[0];
        // 소분류에 남아있을지 모르는 option 태그 모두 삭제 (selected option만 남기고)
        while (productSmallCategorySelect.length > 1) {
          productSmallCategorySelect.removeChild(productSmallCategorySelect.lastChild);
        }

        $(category).each(function() {
          let option = document.createElement('option');
          option.text = this.name;
          option.value = this.id;
          productSmallCategorySelect.appendChild(option);
        });
      });
};