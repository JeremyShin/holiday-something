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
});