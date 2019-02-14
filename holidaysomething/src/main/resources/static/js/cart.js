document.addEventListener('DOMContentLoaded', () => {

  // 개별 상품 'X' 버튼 (삭제)
  let removeBtns = document.querySelectorAll('.btn-remove');
  removeBtns.forEach((button) => {
    button.addEventListener('click', (e) => {

      // 해당 cartProductId를 데이터베이스에서 삭제하고 cart 페이지로 이동
      let cartProductId = e.target.id;
      fetch(`/api/user/cart/${cartProductId}`, {
        redirect: 'follow',
        credentials: 'include',
        method: 'DELETE',
      })
      // .then(response => redirect(`/user/cart?id=2`))
      .then(window.location.href = `/user/cart?id=2`)
      // .catch(err => console.error(err));
    });
  });

  // CONTINUE SHOPPING 버튼 클릭 => 메인페이지로 이동
  let continueShopppingBtn = document.querySelector('.btn-shopping');
  continueShopppingBtn.addEventListener('click', () => {
    window.location.href = '/';
  });

  // 카트 페이지에서 각 상품 수량 '-' / '+' 버튼 클릭 시 수량 변경
  // TODO: 우측 '주문금액', 하단 '총 주문금액', '총 결제금액'에도 반영해야 함
  let quantityMinusBtn = document.querySelectorAll('.quantity-minus');
  quantityMinusBtn.forEach((btn) => {
    btn.addEventListener('click', () => {
      let plusBtn = btn.nextElementSibling;
      if (plusBtn.value > 0)
        plusBtn.setAttribute('value', parseInt(plusBtn.value) - 1);
    });
  });
  let quantityPlusBtn = document.querySelectorAll('.quantity-plus');
  quantityPlusBtn.forEach((btn) => {
    btn.addEventListener('click', () => {
      let minusBtn = btn.previousElementSibling;
      minusBtn.setAttribute('value', parseInt(minusBtn.value) + 1);
    });
  });

  // 선택상품 삭제
  // TODO: refresh해야 화면에 반영 됨
  let removeProductsBtn = document.querySelector('.remove-selected-products');
  removeProductsBtn.addEventListener('click', () => {
    let ids = [];
    let trs = document.querySelectorAll('.tr-checkbox');
    trs.forEach((tr) => {
      let input = tr.getElementsByTagName('input')[0];
      if (input.checked)  ids.push(input.id);
    });

    // fetch();
  });

  // 개별 상품 checkbox toggle
  let trCheckboxes = document.querySelectorAll('.tr-checkbox');
  trCheckboxes.forEach((trCheckbox) => {
    let label = trCheckbox.getElementsByTagName('label')[0];
    label.addEventListener('click', (e) => {
      e.preventDefault();
      let input = label.previousElementSibling;
      if (input.checked)
        input.removeAttribute('checked');
      else
        input.setAttribute('checked', true);
    });
  });

  // 전체 선택 checkbox toggle
  // TODO: 최초 선택 시 반응 없음
  let allCheckLabel = document.querySelector('#checkbox-all-label');
  allCheckLabel.addEventListener('click', () => {
    let allCheckboxInput = allCheckLabel.previousElementSibling;
    let currFlag = allCheckboxInput.checked;
    console.log('allCheckboxInput is clicked');

    let trCheckboxes = document.querySelectorAll('.tr-checkbox');
    trCheckboxes.forEach((trCheckbox) => {
      let input = trCheckbox.getElementsByTagName('input')[0];
      if (currFlag)
        input.removeAttribute('checked');
      else
        input.setAttribute('checked', 'checked');
    });

    if (currFlag)
      allCheckboxInput.removeAttribute('checked');
    else
      allCheckboxInput.setAttribute('checked', 'checked');
  });
});





