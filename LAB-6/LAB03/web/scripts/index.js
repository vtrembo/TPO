function callback(response) {
    $("#sum").text(response.sum);
}
function ajax_post() {
    $.post(
        "sum",
        {
            component1 : $("#component1").val(),
            component2 : $("#component2").val(),
        },
        callback,
        "json");
}
function ajax_get() {
    $.get(
        "sum",
        {
            component1 : $("#component1").val(),
            component2 : $("#component2").val(),
        },
        callback,
        "json");
}
$("#component1").focusout(ajax_post);
$("#component2").focusout(ajax_get);