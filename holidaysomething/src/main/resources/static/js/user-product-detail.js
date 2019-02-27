// 옵션 변경 이벤트(order-index-tbody 에 값 저장, root-info min-height 50씩 증가, 총 금액 변경)
let num = 0;
let root_info_min_height = 520;

function selectOptionChange(optionValue, productId, productPrice) {
    document.getElementById("order-index-result").setAttribute('style', 'display:block');

    let optionJson = JSON.parse(optionValue);

    if (optionIdDuplicateCheck(optionJson) === false) {
        return false;
    }

    optionAdd(optionJson, productId, productPrice);

    changeTotalPrice();
    rootInfoMinHeight();
    document.getElementById('option-selector').selectedIndex = 0;
}

// 중복 옵션 체크
function optionIdDuplicateCheck(source) {
    let size = document.getElementsByClassName('order-index-hidden-option-id').length;

    if (source === 0) {
        for (let i = 0; i < size; i++) {
            if (document.getElementsByClassName('order-index-hidden-option-id')[i].value === '0') {
                alert("중복된 옵션은 선택할 수 없습니다.");
                document.getElementById('option-selector').selectedIndex = 0;
                return false;
            }
        }

    } else {
        for (let i = 0; i < size; i++) {
            if (document.getElementsByClassName('order-index-hidden-option-id')[i].value === source.id) {
                alert("중복된 옵션은 선택할 수 없습니다.");
                document.getElementById('option-selector').selectedIndex = 0;
                return false;
            }
        }
    }
}

// root-info 의 최소 크기를 증가시키는 함수
function rootInfoMinHeight() {
    root_info_min_height += 50;
    document.getElementById('root-info').setAttribute('style', 'min-height: ' + root_info_min_height + 'px');
}

function optionAdd(option, defaultId, defaultPrice) {
    productId = parseInt(defaultId);
    productPrice = parseInt(defaultPrice);

    let my_table = document.getElementById('order-index-table');

    // tbody를 얻어와 style을 설정한다.
    let my_tbody = document.createElement('tbody');
    my_tbody.setAttribute('style', 'border-bottom: 1px solid #d3d3d3;');

    // 선택한 옵션의 이름 td
    let td1 = document.createElement('td');
    td1.setAttribute('class', 'order-index-table-option');
    td1.innerText = option.name;

    // hidden td
    let td2 = document.createElement('input');
    td2.setAttribute('type', 'hidden');
    td2.setAttribute('class', 'order-index-hidden-price');
    td2.setAttribute('value', productPrice + option.price);

    // quantity 를 위한 td
    let td3 = document.createElement('td');
    td3.setAttribute('class', 'order-index-table-quantity');
    let minusButton = document.createElement('button');
    minusButton.setAttribute('type', 'button');
    minusButton.setAttribute('class', 'order-index-button');
    minusButton.setAttribute('onclick', 'minusQuantity(this)');
    minusButton.innerText = '-';
    let plusButton = document.createElement('button');
    plusButton.setAttribute('type', 'button');
    plusButton.setAttribute('class', 'order-index-button');
    plusButton.setAttribute('onclick', 'plusQuantity(this)');
    plusButton.innerText = '+';
    // productId 값을 보내기 위한 hidden type 의 input
    let productIdInput = document.createElement('input');
    productIdInput.setAttribute('type', 'hidden');
    productIdInput.setAttribute('name', 'ProductOrderInfoDtos[' + num + '].productId');
    productIdInput.setAttribute('form', 'orderForm');
    productIdInput.setAttribute('value', productId);  // productId 를 설정
    // optionId 값을 보내기 위한 hidden type 의 input
    let optionIdInput = document.createElement('input');
    optionIdInput.setAttribute('type', 'hidden');
    optionIdInput.setAttribute('name', 'ProductOrderInfoDtos[' + num + '].optionId');
    optionIdInput.setAttribute('form', 'orderForm');
    optionIdInput.setAttribute('class', 'order-index-hidden-option-id');
    optionIdInput.setAttribute('value', option.id);    // 해당 optionId 값을 설정
    // quantity 값을 설정하는 input
    let orderQuantityInput = document.createElement('input');
    orderQuantityInput.setAttribute('type', 'text');
    orderQuantityInput.setAttribute('name', 'ProductOrderInfoDtos[' + num + '].quantity');
    orderQuantityInput.setAttribute('class', 'option-order-quantity');
    orderQuantityInput.setAttribute('form', 'orderForm');
    orderQuantityInput.setAttribute('value', '1');      // 해당 값이 변경되면 총 금액이 변경됨
    orderQuantityInput.setAttribute('onkeyup', 'changeTotalPrice();');
    orderQuantityInput.setAttribute('onKeypress', 'if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;');

    td3.appendChild(productIdInput);
    td3.appendChild(optionIdInput);
    td3.appendChild(minusButton);
    td3.appendChild(orderQuantityInput);
    td3.appendChild(plusButton);

    // 옵션 가격을 알려주는 td
    let td4 = document.createElement('td');
    td4.setAttribute('class', 'order-index-table-price');
    td4.innerText = (productPrice + option.price).toLocaleString() + '원';

    // 삭제 버튼을 위한 td
    let td5 = document.createElement('td');
    td5.setAttribute('class', 'order-index-table-delete');
    let deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('class', 'order-option-delete-button');
    deleteButton.setAttribute('onclick', 'deleteOption(this)');
    deleteButton.innerText = 'x';
    td5.appendChild(deleteButton);

    my_tbody.appendChild(td1);
    my_tbody.appendChild(td2);
    my_tbody.appendChild(td3);
    my_tbody.appendChild(td4);
    my_tbody.appendChild(td5);

    my_table.appendChild(my_tbody);
    num += 1;

}

// 총 금액이 변경돼야 하면 호출되는 함수
function changeTotalPrice() {
    let size = document.getElementsByClassName('option-order-quantity').length;
    let totalPrice = 0;

    for (let i = 0; i < size; i++) {
        totalPrice += document.getElementsByClassName('option-order-quantity')[i].value * document.getElementsByClassName('order-index-hidden-price')[i].value;
    }

    document.getElementById("order-index-total-price").innerText = totalPrice.toLocaleString();
}

// quantity 값 증가, 감소
function minusQuantity(source) {
    let quantity = parseInt(source.nextElementSibling.value);

    if (quantity <= 1) {
        false;
    } else {
        quantity = quantity - 1;
    }
    source.nextElementSibling.setAttribute('value', quantity);

    changeTotalPrice()
}

function plusQuantity(source) {
    let quantity = parseInt(source.previousElementSibling.value);
    quantity = quantity + 1;
    source.previousElementSibling.setAttribute('value', quantity);

    changeTotalPrice()
}

// shopping bag 버튼 클릭 이벤트
function cart(loginCheck) {

    if(loginCheck === "false") {
        alert("로그인이 필요한 서비스입니다.");
        return false;
    }

    let value = document.getElementById('orderForm');
    let check = document.getElementsByClassName('option-order-quantity');

    let size = check.length;
    for (let i = 0; i < size; i++) {
        if (document.getElementsByClassName('option-order-quantity')[i].value < 1) {
            return false;
        }
    }

    if (check.length === 0) {
        alert("상품 옵션을 선택해주세요.");
        return false
    } else {
        alert("장바구니에 상품이 담겼습니다.");
        value.action = "/user/cart";
        value.submit();
    }
}

// buy now 버튼 클릭 이벤트
function buyNow(loginCheck) {
    if(loginCheck === "false") {
        alert("로그인이 필요한 서비스입니다.");
        return false;
    }

    let value = document.getElementById('orderForm');
    let check = document.getElementsByClassName('option-order-quantity');

    let size = check.length;
    for (let i = 0; i < size; i++) {
        if (document.getElementsByClassName('option-order-quantity')[i].value < 1) {
            return false;
        }
    }

    if (check.length === 0) {
        alert("상품 옵션을 선택해주세요.");
        return false
    } else {
        let buy = confirm("구매하시겠습니까?");
        if (buy === true) {
            value.action = "/user/product/order";
            value.submit();
        }
        else if (buy === false) {
            return false;
        }
    }
}

// 선택 옵션 삭제
function deleteOption(source) {
    root_info_min_height -= 50;
    document.getElementById('root-info').setAttribute('style', 'min-height: ' + root_info_min_height + 'px');
    source.parentElement.parentElement.remove();

    if (document.getElementById('order-index-table').firstElementChild === null) {
        document.getElementById('order-index-result').setAttribute('style', 'display:none;');
        document.getElementById('order-index-result').setAttribute('innerText', '0');
    }

    changeTotalPrice();
}

// 콤마 제거
function removeComma(str) {
    n = parseInt(str.replace(/,/g, ""));
    return n;
}