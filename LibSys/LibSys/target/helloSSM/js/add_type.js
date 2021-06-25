function check(){
    var tip = document.getElementById("tip");
    var type = document.getElementById("type").value;

    if (type.length == 0) {
        tip.innerHTML = "类型名不能为空";
        tip.style.visibility = "initial"
    } else {
        document.getElementById("form").submit();
    }
}

function disappear(){
    var tip = document.getElementById("tip");
    tip.style.visibility = "hidden"
}