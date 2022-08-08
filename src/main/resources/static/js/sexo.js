// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#sexo').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {
  const request = await fetch('api/sexo', {
    method: 'GET',
    headers: getHeaders()
  });
  const sexo = await request.json();


  let listadoHtml = '';
  for (let sexo of sexo) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + sexo.sex_id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+sexo.sex_id+'</td><td>' + sexo.sex_nombre + '</td><td>'
                    + botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#sexo tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este sexo?')) {
    return;
  }

 const request = await fetch('api/sexo/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}