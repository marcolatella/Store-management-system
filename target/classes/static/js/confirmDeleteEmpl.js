$('#DeleteModal').on('show.bs.modal', function (event) {
    var id_empl = $(event.relatedTarget).data('value');
    var id_store = $(event.relatedTarget).data('store');
    $(this).find(".modal-body").text('Are you sure you want to delete the employee: '+id_empl+'?');
    $('#modalform').attr('action', '/store/'+id_store+'/delete-employee/'+id_empl)
});

