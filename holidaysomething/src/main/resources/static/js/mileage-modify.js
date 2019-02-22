document.getElementById("mileageSearch").onclick = function () {
    if(document.getElementById("mileageSearchKeyword").value === ""){
        alert("값을 입력하세요");
        return false;
    }
};

document.getElementById("mileageModifyBtn").onclick = function () {
    let mileage = parseInt(document.getElementById("mileage").innerText);
    let mileageModify = document.getElementById("mileageModify").value;
    let mileagePlusMinus = document.getElementById("mileagePlusMinus").value;

    if(mileageModify === ""){
        alert("값을 입력하세요");
        return false;
    } else if(mileagePlusMinus === "-" && mileageModify > mileage){
        alert("기존의 마일리지보다 값이 작습니다.");
        return false;
    } else {
        return confirm("수정하시겠습니까?");
    }
};