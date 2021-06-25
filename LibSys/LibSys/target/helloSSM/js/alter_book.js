function check() {
    var tip = document.getElementById("tip");
    const name = document.getElementById("name").value;
    const author = document.getElementById("author").value;
    const total = parseInt(document.getElementById("total").value);
    const rem = parseInt(document.getElementById("rem").value);

    if (name.length === 0
        || author.length === 0) {
        tip.innerHTML = "请检查内容是否为空";
        tip.style.visibility = "initial"
    } else if (total < rem) {
        tip.innerHTML = "总量不能小于剩余量";
        tip.style.visibility = "initial"
    } else {
        document.getElementById("form").submit();
    }
}

function disappear() {
    var tip = document.getElementById("tip");
    tip.style.visibility = "hidden"
}