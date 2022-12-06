
$('#homeViewSelect').change(function (){
    var value = $('#homeViewSelect').val();
    $("#search-store-empl").attr('href', '/store/'+value+'/employees');
});
