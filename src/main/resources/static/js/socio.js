// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#socios').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {
  const request = await fetch('api/socio', {
    method: 'GET',
    headers: getHeaders()
  });
  const socio = await request.json();


  let listadoHtml = '';
  for (let socios of socio) {
    let botonGuardar = '<a href="#" class="btn btn-success btn-circle btn-sm"><i class="fas fa-check"></i></a>';
    let botonEditar = '<a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-edit"></i></a>';
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + socios.soc_id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+socios.soc_id+'</td><td>' + socios.soc_cedula + '</td><td>' + socios.soc_nombre + '</td><td>' + socios.soc_direccion + '</td><td>'
                    +socios.soc_telefono+'</td><td>'+socios.soc_correo+'</td><td>'+ botonGuardar + '    ' + botonEditar + '    ' + botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#socios tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este socio?')) {
    return;
  }

 const request = await fetch('api/socio/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}