let createRowBtn = document.querySelector('#createRow');

/* 옵션 추가 버튼 누를 시, 행 생성 */
createRowBtn.addEventListener('click', () => {
    let tr = document.createElement('tr');
    tr.setAttribute('id', 'optionCheckTr');

    let td1 = document.createElement('td');
    let input1 = document.createElement('input');
    //let textNodeDelete = document.createTextNode('삭제');
    //textNodeDelete.setAttribute('class', 'option_value_rows');
    //td1.appendChild(textNodeDelete);
    input1.setAttribute('type', 'checkbox');
    input1.setAttribute('name','checkRow');
    input1.setAttribute('class', 'optionCheckFrame');
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
    button1.appendChild(span1);
    td2.appendChild(button1);

    let div1 = document.createElement('div');
    let textNode2 = document.createTextNode('추가금액: ');
    div1.appendChild(textNode2);
    let input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'price');
    input3.setAttribute('style', 'width:70px;');
    div1.appendChild(input3);
    let span2 = document.createElement('span');
    div1.appendChild(span2);
    td2.appendChild(div1);
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

    let div2 = document.createElement('div');
    let textNode4 = document.createTextNode('옵션설명: ');
    div2.appendChild(textNode4);
    let input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'description');
    input4.setAttribute('size', '70');
    input4.setAttribute('style', 'height:30px;');

    div2.appendChild(input4);
    td2.appendChild(div2);

    tr.appendChild(td2);



    let optionValueRows = document.querySelector('#option_value_rows');
    optionValueRows.appendChild(tr);
});

/* checkbox 전체 선택 */
let toggle = function(source) {
    let optionCheckTrs = document.querySelectorAll('#optionCheckTr');
    for (let i = 0; i < optionCheckTrs.length; i++) {
        let OptionCheckboxInput = optionCheckTrs[i].getElementsByTagName('input')[0];
        if (OptionCheckboxInput !== source)
            OptionCheckboxInput.checked = source.checked;
    }
};

/* checked 된 행 삭제 */
// let delRow = function () {
//     let my_tbody = document.getElementById('option_value_rows');
// //element의 parent
//     for (let i = 0; i < my_tbody.rows.length; i++){
//         //let OptionCheckboxInput = my_tbody.rows[i].getElementsByTagName('input')[0];
//         let OptionCheckboxInput = my_tbody.rows[i].getElementsByClassName('optionCheckFrame');
//         my_tbody
//
//         if(OptionCheckboxInput.checked)
//             my_tbody.deleteRow(i);
//     }
// };


let delRow = function (source) {
    let my_tbody = document.getElementById('option_value_rows');
    console.log("Row index is: " + source.rowIndex);
    my_tbody.deleteRow(source.rowIndex);

};