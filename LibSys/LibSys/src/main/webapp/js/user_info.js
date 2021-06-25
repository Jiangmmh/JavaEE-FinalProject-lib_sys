function check(){
    var tip = document.getElementById("tip");
    var psw = document.getElementById("psw").value;
    var pswagain = document.getElementById("pswagain").value;

    if (psw.length === 0 || pswagain.length === 0) {
        tip.innerHTML = "密码不能为空";
        tip.style.visibility = "initial"
    } else if (psw != pswagain) {
        tip.innerHTML = "两次输入不一致";
        tip.style.visibility = "initial"
    } else if (psw.length < 6 || psw.length > 15) {
        tip.innerHTML = "密码长度必须在6~15位之间";
        tip.style.visibility = "initial"
    } else {
        document.getElementById("form").submit();
    }
}

function disappear(){
    var tip = document.getElementById("tip");
    tip.style.visibility = "hidden"
}