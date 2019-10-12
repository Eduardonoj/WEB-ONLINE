$.ajax({
    url: "http://localhost:9200/api/v1/categorias",
    data: {format: 'json'},
    type: 'GET',
    error: function () {
        console.log("Error al consumir el API");
    },
    success: function (data) {
        segmento = $("#datos");
        $.each(data, function (index, value) {
            console.log(value.descripcion);
            segmento.append(
                    '<tr>' +
                    '<td>' + value.descripcion + '</td>' +
                    '<td>' + '<button class="btn btn-warning">Editar</button>' + '</td>' +
                    '<td>' + '<button class="btn btn-danger">Eliminar</button>' + '</td>' +
                    '</tr>');
        });
    }
});

