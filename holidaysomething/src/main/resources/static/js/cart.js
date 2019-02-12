document.addEventListener('DOMContentLoaded', () => {

  let removeBtns = document.querySelectorAll('.btn-remove');
  removeBtns.forEach((button) => {
    button.addEventListener('click', (e) => {
      console.log(`Trying to delete CartProduct(id: ${e.target.id})`);

      // 해당 cartProductId를 데이터베이스에서 삭제하고 cart 페이지로 이동
      let cartProductId = e.target.id;
      fetch(`/api/user/cart/${cartProductId}`, {
        credentials: 'include',
        method: 'DELETE',
      })
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

});