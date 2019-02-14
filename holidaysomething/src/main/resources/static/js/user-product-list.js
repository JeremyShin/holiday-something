window.onload = function () {
  let categoryId = document.getElementById("hiddenCategoryId").value;
  let bigCategoryName = document.getElementById("hiddenBigCategoryName").value;

  // 카테고리 id에 따라 banner-title, banner-description 에 다르게 내용을 채워주면 된다.
  console.log("categoryId : " + categoryId);
  console.log("대분류만 나와야함. bigCategoryName : " + bigCategoryName);
  if (categoryId == 4) {
    let banner = document.getElementById("banner");
    banner.setAttribute("style", "background-color: #dff0d8; padding: 20px;");

    let bannerTitleDiv = document.getElementById("banner-title");
    let bannerDescriptionDiv = document.getElementById("banner-description");

    let titleTag = document.createElement('h3');
    let titleTagText = document.createTextNode('It' + '\'s FOOD Section!');

    titleTag.appendChild(titleTagText);
    bannerTitleDiv.appendChild(titleTag);

    let titleTag2 = document.createElement('p');
    let titleTagText2 = document.createTextNode(
        '각종 육류, 어류 그리고 디저트까지! 없는게 없는! Holiday Something!!!!');

    titleTag2.appendChild(titleTagText2);
    bannerDescriptionDiv.appendChild(titleTag2);
  } else if (categoryId == 3) {

    let banner = document.getElementById("banner");
    banner.setAttribute("style", "background-color: #d9edf7; padding: 20px;");

    let bannerTitleDiv = document.getElementById("banner-title");
    let bannerDescriptionDiv = document.getElementById("banner-description");

    let titleTag = document.createElement('h3');
    let titleTagText = document.createTextNode('It' + '\'s FASHION Section!');

    titleTag.appendChild(titleTagText);
    bannerTitleDiv.appendChild(titleTag);

    let titleTag2 = document.createElement('p');
    let titleTagText2 = document.createTextNode(
        'Passion + Fashion! Holiday Something!!!!');

    titleTag2.appendChild(titleTagText2);
    bannerDescriptionDiv.appendChild(titleTagText2);
  } else if (categoryId == 2) {

    let banner = document.getElementById("banner");
    banner.setAttribute("style", "background-color: #fcf8e3; padding: 20px;");

    let bannerTitleDiv = document.getElementById("banner-title");
    let bannerDescriptionDiv = document.getElementById("banner-description");

    let titleTag = document.createElement('h3');
    let titleTagText = document.createTextNode('It' + '\'s D.I.Y Section!');

    titleTag.appendChild(titleTagText);
    bannerTitleDiv.appendChild(titleTag);

    let titleTag2 = document.createElement('p');
    let titleTagText2 = document.createTextNode(
        '뚝딱뚝딱! 가구, 장난감 그리고 가방까지? Holiday Something!!!!');

    titleTag2.appendChild(titleTagText2);
    bannerDescriptionDiv.appendChild(titleTagText2);
  } else if (categoryId == 1) {

    let banner = document.getElementById("banner");
    banner.setAttribute("style", "background-color: #f2dede; padding: 20px;");

    let bannerTitleDiv = document.getElementById("banner-title");
    let bannerDescriptionDiv = document.getElementById("banner-description");

    let titleTag = document.createElement('h3');
    let titleTagText = document.createTextNode(
        'It' + '\'s STATIONERY Section!');

    titleTag.appendChild(titleTagText);
    bannerTitleDiv.appendChild(titleTag);

    let titleTag2 = document.createElement('p');
    let titleTagText2 = document.createTextNode(
        '연필, 노트, 포스트잇까지! 아니? 없는게 뭐지? 지우개 정도...?');

    titleTag2.appendChild(titleTagText2);
    bannerDescriptionDiv.appendChild(titleTagText2);
  }

}