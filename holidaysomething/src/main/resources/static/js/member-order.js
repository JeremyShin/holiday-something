function validateSearch() {
  const re = /^[가-힣a-zA-Z0-9]{2,20}$/ // 상품이름(문자열)의 데이터 형식이 적합한지 검사할 정규식

  let name = document.getElementById("name");
  let loginId = document.getElementById("loginId");
  let productName = document.getElementById("productName");
  let orderNumber = document.getElementById("orderNumber")
  let startDate = document.getElementById("orderStartDate");
  let endDate = document.getElementById("orderEndDate");

  console.log("startDate.value = " + startDate.value);

  console.log("endDate.value = " + endDate.value);

  // 하나라도 null 이 아니어야 한다.
  if (name.value === "" && loginId.value === "" && productName.value === "" &&
      orderNumber.value === "" && startDate.value === "" && endDate.value
      === "") {
    alert("한개라도 입력 하세요");
    return false;
  }

  if (!check(re, name, "회원 이름 2~20자 입력하셔야 합니다.")) {
    return false;
  }

  if (!check(re, loginId, "회원 로그인 아이디 2~20자 입력하셔야 합니다.")) {
    return false;
  }

  if (!check(re, productName, "상품이름은 2~20자 입력하셔야 합니다.")) {
    return false;
  }

  if (!check(re, orderNumber, "주문번호 2~20자 입력하셔야 합니다.")) {
    return false;
  }

  if (startDate.value !== "" && endDate.value === "") {
    alert("start 입력했으면 end도 입력해야 합니다.");
    endDate.focus();
    return false;
  }

  if (startDate.value === "" && endDate.value !== "") {
    alert("end 입력했으면 start도 입력해야 합니다.");
    startDate.focus();
    return false;
  }

  if (startDate.value !== "" && endDate.value !== "") {
    let diff = checkDate(startDate, endDate);
    // 뒤에서 앞을 뺀다. 음수가 나오면 false!
    console.log(diff);
    if (diff < 0) {
      alert("뒤에 날짜가 더 미래여야 합니다.");
      return false;
    }
  }

}

function check(re, what, message) {
  // 아무것도 입력안했을 경우.
  if (what.value.length == 0) {
    return true;
  }
  if (re.test(what.value)) {
    return true;
  }
  alert(message);
  what.value = "";
  what.focus();
  //return false;
}

// 날짜 차이 구하기.
function checkDate(startDate, endDate) {
  let diffDate_1 = startDate.value instanceof Date ? startDate.value : new Date(
      startDate.value);
  let diffDate_2 = endDate.value instanceof Date ? endDate.value : new Date(
      endDate.value);

  diffDate_1 = new Date(diffDate_1.getFullYear(), diffDate_1.getMonth() + 1,
      diffDate_1.getDate());
  diffDate_2 = new Date(diffDate_2.getFullYear(), diffDate_2.getMonth() + 1,
      diffDate_2.getDate());

  // let diff = Math.abs(diffDate_2.getTime() - diffDate_1.getTime());
  let diff = diffDate_2.getTime() - diffDate_1.getTime();
  // diff = Math.ceil(diff / (1000 * 3600 * 24));

  return diff;

}
