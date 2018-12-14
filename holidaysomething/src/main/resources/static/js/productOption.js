let createRowBtn = document.querySelector('#createRow');

createRowBtn.addEventListener('click', () => {
    let tr = document.createElement('tr');

    let td1 = document.createElement('td');
    let input1 = document.createElement('input');
    input1.setAttribute('type', 'checkbox');
    td1.appendChild(input1);
    tr.appendChild(td1);

    let td2 = document.createElement('td');
    let input2 = document.createElement('input');
    input2.setAttribute('type', 'text');
    input2.setAttribute('name', 'name');
    input2.setAttribute('placeholder', '예시) 옵션명을 입력하시오');
    input2.setAttribute('style', 'width:110px;');
    input2.setAttribute('maxlength', 50);
    td2.appendChild(input2);
    let button1 = document.createElement('button');
    button1.setAttribute('type', 'button');
    button1.setAttribute('style', 'display: inline-block;');
    let span1 = document.createElement('span');
    let textNode1 = document.createTextNode('삭제');
    span1.appendChild(textNode1);
    button1.appendChild(span1);
    td2.appendChild(button1);

    let div1 = document.createElement('div');
    let textNode2 = document.createTextNode('추가금액: ');
    div.appendChild(textNode2);
    let input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'price');
    input3.setAttribute('style', 'width:70px;');
    div1.appendChild(input3);
    let span2 = document.createElement('span');
    let textNode3 = document.createTextNode('KRW');
    span2.appendChild(textNode3);
    div1.appendChild(span2);
    td2.appendChild(div);
    tr.appendChild(td2);

    let td3 = document.createElement('td');
    let select = document.createElement('select');
    select.setAttribute('name', 'productId');
    select.setAttribute('class', 'productId');

    let productOptionSelect = document.querySelectorAll('.productId')[0];
    let productOptionSelectOptions = productOptionSelect.children;
    for (let i = 0; i < productOptionSelectOptions.length; i++) {
        let cln = productOptionSelectOptions[i].cloneNode(true);
        select.appendChild(cln);
    }

    td3.appendChild(select);
    tr.appendChild(td3);

    let td4 = document.createElement('td');
    let input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'description');
    input4.setAttribute('size', '70');
    input4.setAttribute('style', 'height:30px;');
    td4.appendChild(input4);




    let optionValueRows = document.querySelector('#option_value_rows');
    optionValueRows.appendChild(tr);
});