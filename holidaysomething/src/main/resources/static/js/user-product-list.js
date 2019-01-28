window.onload = function () {
  let categoryId = document.getElementById("hiddenCategoryId").value;
  let bigCategoryName = document.getElementById("hiddenBigCategoryName").value;

  // 카테고리 id에 따라 banner-title, banner-description 에 다르게 내용을 채워주면 된다.
  console.log("categoryId : " + categoryId);
  console.log("대분류만 나와야함. bigCategoryName : " + bigCategoryName);
  if (categoryId == 4) {
    let bannerTitleDiv = document.getElementById("banner-title");
    let bannerDescriptionDiv = document.getElementById("banner-description");

    let span1 = document.createElement('span');
    let span1Text = document.createTextNode('textNode Title 야!!!!');

    span1.appendChild(span1Text);
    bannerTitleDiv.appendChild(span1);

    let span2 = document.createElement('span');
    let span2Text = document.createTextNode('textNode Description야!!!!');

    span2.appendChild(span2Text);
    bannerDescriptionDiv.appendChild(span2Text);

    bannerTitleDiv.value = "It's FOOD Section!";
    bannerDescriptionDiv.value = "각종 육류, 어류 그리고 디저트까지! 없는게 없는! Holiday Something!";
  }

}