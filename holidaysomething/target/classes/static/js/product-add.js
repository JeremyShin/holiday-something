function validate() {
  const re = /^[가-힣a-zA-Z0-9]{2,20}$/ // 문자열 검사할 정규식
  const reInteger = /^[0-9]{1,20}$/ // 숫자를 검사할 정규식

  let name = document.getElementById("inputName");
  let categoryId = document.getElementById("categoryId2");
  let inputManufacturer = document.getElementById("inputManufacturer");
  let inputCode = document.getElementById("inputCode");
  let inputOriginalPrice = document.getElementById("inputOriginalPrice");
  let inputSellingPrice = document.getElementById("inputSellingPrice");
  let inputManufacturingPrice = document.getElementById(
      "inputManufacturingPrice");
  let inputShippingPrice = document.getElementById("inputShippingPrice");
  // let inputDescription = document.getElementById("inputDescription");
  let inputDate1 = document.getElementById("inputDate1");
  let inputDate2 = document.getElementById("inputDate2");
  let inputQuantity = document.getElementById("inputQuantity");

  // Product 도메인에서 notnull인 것은 필수로 입력해줘야 한다.
  if (!check(re, name, "상품이름은 2~20자  입력")) {
    return false;
  }
  if (!check(re, inputManufacturer, "제조사 2~20자  입력")) {
    return false;
  }
  if (!check(re, inputCode, "상품코드 2~20자  입력")) {
    return false;
  }
  // if (!check(re, inputDescription, "상품설명은 2~20자  입력")) {
  //   return false;
  // }
  if (!checkInteger(reInteger, inputOriginalPrice, "원가는 숫자로 입력")) {
    return false;
  }
  if (!checkInteger(reInteger, inputSellingPrice, "판매가 숫자  입력")) {
    return false;
  }
  if (!checkInteger(reInteger, inputManufacturingPrice, "제조가 숫자  입력")) {
    return false;
  }
  if (!checkInteger(reInteger, inputShippingPrice, "배송비 숫자  입력")) {
    return false;
  }
  if (!checkInteger(reInteger, inputQuantity, "재고 숫자 입력")) {
    return false;
  }
  console.log("date1 : " + inputDate1.value);

  if (inputDate1.value === "") {
    alert("제조일 선택해주세요.");
    inputDate1.value = "";
    inputDate1.focus();
    return false;
  }
  if (inputDate2.value === "") {
    alert("출시일 선택해주세요.");
    inputDate2.value = "";
    inputDate2.focus();
    return false;
  }
  if (categoryId.value === "") {
    alert("카테고리를 선택해주세요.");
    return false;
  }


}

function check(re, what, message) {
  if (re.test(what.value)) {
    return true;
  }
  alert(message);
  what.value = "";
  what.focus();
  //return false;
}

function checkInteger(reInteger, what, message) {
  if (reInteger.test(what.value)) {
    return true;
  }
  alert(message);
  what.value = "";
  what.focus();
  //return false;
}

// 대분류 불러오기.
window.onload = function () {
  var html = '';
  var method = "onclick='getCategoryList(";
  $.getJSON("/admin/product/add/subcategories/" + 0,
      function (list) {
        $(list).each(
            function () {
              html += "<li><span data-categoryid=" + this.id + " class='span' "
                  + method
                  + this.id
                  + ")')>" + this.name + "</span></li> ";
            }
        );
        $("#firstCategoryUl").html('');
        $("#firstCategoryUl").html(html);
      });
}

function getCategoryList(parentId) {
  var html = '';
  var method = "onclick='getCategoryBrandList(";

  $.getJSON("/admin/product/add/subcategories/" + parentId,
      function (list) {
        $(list).each(
            function () {
              html += "<li><span data-categoryid=" + this.id + " class='span' "
                  + method
                  + this.id
                  + ")')>" + this.name + "</span></li> ";
            }
        );
        $("#secondCategoryUl").html('');
        $("#thirdCategoryUl").html('');
        $("#secondCategoryUl").html(html);

      });
}

function getCategoryBrandList(parentId) {
  var html = '';
  var method = "onclick='getCategoryList(";

  $.getJSON("/admin/product/add/subcategories/" + parentId,
      function (list) {
        // $("#currentCategory").html("<label>"+ this.id + "</label>");
        $(list).each(
            function () {
              html += "<li><span data-categoryid=" + this.id + " class='span'> "
                  + this.name
                  + "</span></li> ";
            }
        );
        $("#thirdCategoryUl").html('');
        $("#thirdCategoryUl").html(html);
      });
}

$(document).ready(function () {
  $(document).on('click', '.span', function () {
    var name = $(this).text();
    var id = $(this).attr("data-categoryid");
    console.log(name);
    console.log(id);
    $("#categoryName").text(name);
    $("#categoryId").text(id);
    $("#categoryId2").val(id);
  });
});