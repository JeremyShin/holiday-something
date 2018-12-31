let updateMiddleCategory = function (option) {
  let largeId = option.value;
  console.log(`updateMiddleCategory(${largeId}) is triggered`);

  $.getJSON(`/admin/product/subcategory/${largeId}`,
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

  $.getJSON(`/admin/product/subcategory/${middleId}`,
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
