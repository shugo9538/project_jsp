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
    var url = "editName.gu?id=" + name;
    window.open(url, "confirm", "menu=no, width=300, height=100");
}

function checkAlert() {
    var checkBox = document.getElementById("checkAlert");
    if (checkBox.value == true) checkBox.checked;
}

function changeVal(check) {
    if (check.checked == true) {
        document.getElementById("checkAlert").value="1";
        document.getElementById("aaa").innerHTML= document.getElementById("checkAlert").value;
        
    } else {
        document.getElementById("checkAlert").value="0";
        document.getElementById("aaa").innerHTML= document.getElementById("checkAlert").value;
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

function setName() {
    var name = document.editNameForm.reName.value
    opener.document.editForm.name.value = name;
    opener.alert("성공적으로 수정했습니다.");
    self.close();
}

//function formChk() {
//    if () {
//        
//        return false;
//    }
//    
//    window.location='withdrawalSurbey.gu'
//}