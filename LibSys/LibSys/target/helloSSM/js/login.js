function login() {
    var tip = document.getElementById("tip");
    var name = document.getElementById("name").value;
    var psw = document.getElementById("psw").value;

    if (name.length == 0) {
        tip.innerHTML = "用户名不能为空";
        tip.style.visibility = "initial"
    } else if (name != "admin" && psw.length < 6 || psw.length > 15) {
        tip.innerHTML = "密码长度必须在6~15位之间";
        tip.style.visibility = "initial"
    } else {
        document.getElementById("loginForm").submit();
    }
}

function register() {
    window.location.href="/register"
}

function disappear() {
    var tip = document.getElementById("tip");
    tip.style.visibility = "hidden"
}