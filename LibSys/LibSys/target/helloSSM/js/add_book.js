function check() {
    var tip = document.getElementById("tip");
    var name = document.getElementById("name").value;
    var author = document.getElementById("author").value;
    var quantity = document.getElementById("quantity").value;
    var quantity_int = parseInt(quantity);

    if (name.length === 0) {
        tip.innerHTML = "书名不能为空";
        tip.style.visibility = "initial";
    } else if (author.length === 0) {
        tip.innerHTML = "作者名不能为空";
        tip.style.visibility = "initial";
    } else if (quantity.length === 0 || quantity_int < 1) {
        tip.innerHTML = "书籍数量不能小于1";
        tip.style.visibility = "initial";
    } else {
        document.getElementById("form").submit();
    }
}

function disappear() {
    var tip = document.getElementById("tip");
    tip.style.visibility = "hidden"
}