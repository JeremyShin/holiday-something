document.addEventListener('DOMContentLoaded', () => {
  let removeBtns = document.querySelectorAll('.btn-remove');
  removeBtns.forEach((button) => {
    button.addEventListener('click', (e) => {
      console.log(e.target.id);


      // 해당 cartProductId를 데이터베이스에서 삭제하고 cart 페이지로 이동

    });
  });
});
