
$('#homeViewSelect').change(function (){
    var value = $('#homeViewSelect').val();
    $("#search-store").attr('href', '/store/'+value+'/products');
});


