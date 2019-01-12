function validate() {
  const re = /^[가-힣a-zA-Z0-9]{2,20}$/ // 상품이름을 검사할 정규식

  let name = document.getElementById("inputName");
  let categoryId = document.getElementById("categoryId2");
  let inputManufacturer = document.getElementById("inputManufacturer");
  let inputCode = document.getElementById("inputCode");
  let inputOriginalPrice = document.getElementById("inputOriginalPrice");
  let inputSellingPrice = document.getElementById("inputSellingPrice");
  let inputManufacturingPrice = document.getElementById(
      "inputManufacturingPrice");
  let inputShippingPrice = document.getElementById("inputShippingPrice");
  let inputDescription = document.getElementById("inputDescription");
  let inputDate1 = document.getElementById("inputDate1");
  let inputDate2 = document.getElementById("inputDate2");
  let inputQuantity = document.getElementById("inputQuantity");

  // Product 도메인에서 notnull인 것은 필수로 입력해줘야 한다.
  if (name.value === "") {
    console.log("name size 0");

  }

  if (!check(re, name, "상품이름은 2~20자  입력")) {
    return false;
  }

  //alert("상품등록이 완료되었습니다.");
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