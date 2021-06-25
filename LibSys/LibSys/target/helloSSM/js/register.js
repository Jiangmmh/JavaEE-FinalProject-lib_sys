function clear() {
    document.getElementById("tip").innerText = "";
}

function check() {
    var p1 = document.getElementById("password").value;
    var p2 = document.getElementById("passwordagain").value;
    var error = document.getElementById("tip");

    if (p1 != p2){
        error.innerText = "两次输入的密码不一致。";
        error.style.visibility="initial";
    } else{
        if (p1.length < 6 || p1.length > 15) {
            error.innerText = "密码请保持在6位到15位之间。";
            error.style.visibility="initial";
        }
        else {
            document.getElementById("form").submit();
        }
    }
}