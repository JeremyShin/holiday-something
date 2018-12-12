let toggle = function(source) {
    let productOptionTrs = document.querySelectorAll('#productOptionTr');
    for (let i = 0; i < productOptionTrs.length; i++) {
        let checkboxInput = productOptionTrs[i].getElementsByTagName('input')[0];
        if (checkboxInput !== source)
            checkboxInput.checked = source.checked;
    }
};
