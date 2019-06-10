$('#shippingtable').hide();
$('#shipping').click(function () {
    alert("aaa");
    if($(this).prop("checked")){
        $('#shippingtable').fadeIn(100);
    }
    else{
        $('#shippingtable').hide();
    }
});