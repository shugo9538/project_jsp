function formCheck() {
    // 비밀번호 확인
    if (document.signInForm.pw.value != document.signInForm.repw.value) {
        alert("비밀번호를 확인해주세요");
        document.signInForm.repw.focus();

        return false;

    // 전화번호 양식 확인
    } else if (document.signInForm.telChecker.value == "0") {
        alert("전화번호를 확인해주세요");
        document.signInForm.repw.focus();

        return false;
    }
}

function telCheck() {
    var reg = /^(010|011|017|070|080)\d{3,4}\d{4}$/;
    var telChecker = document.getElementById("telChecker");
    var tel = document.signInForm.tel.value;

    var result = reg.test(tel);
    
    if (!result) {
        telChecker.style.visibility = "visible";
        telChecker.value = "0";

    } else {
        telChecker.style.visibility = "hidden";
        telChecker.value = "1";

    }
}

function editName() {
    var name = document.editForm.reName.value;
    var url = "editName.do?id=" + name;
    window.open(url, "confirm", "menu=no, width=500, height=400");
}

function changeVal(check) {
    if (check.checked == true) {
        check.value=true;
    } else {
        check.value=false;
    }
}

function editFormCheck() {
    // 비밀번호 확인
    if (document.editForm.rePw1.value != document.editForm.rePw2.value) {
        alert("비밀번호를 확인해주세요");
        document.editForm.rePw2.focus();

        return false;

    // 전화번호 양식 확인
    } else if (document.editForm.reTelChk.value == "0") {
        alert("전화번호를 확인해주세요");
        document.editForm.reTel.focus();

        return false;
    }
}

function editTelCheck() {
    var reg = /^(010|011|017|070|080)\d{3,4}\d{4}$/;
    var telChecker = document.getElementById("telChecker");
    var tel = document.editForm.reTel.value;

    var result = reg.test(tel);
    
    if (!result) {
        telChecker.style.visibility = "visible";
        telChecker.value = "0";

    } else {
        telChecker.style.visibility = "hidden";
        telChecker.value = "1";

    }
}