$('#DeleteModal').on('show.bs.modal', function (event) {
    var id_pd = $(event.relatedTarget).data('value');
    var id_prod = $(event.relatedTarget).data('val');
    var id_store = $(event.relatedTarget).data('store');
    $(this).find(".modal-body").text('Are you sure you want to delete the product: '+id_prod+'?');
    $('#modalform').attr('action', '/store/'+id_store+'/delete-product/'+id_pd)
    $('#p-val-id').attr('value', id_prod)
});

