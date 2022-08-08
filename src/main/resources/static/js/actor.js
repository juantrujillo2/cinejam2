// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#actores').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {
  const request = await fetch('api/actor', {
    method: 'GET',
    headers: getHeaders()
  });
  const actor = await request.json();


  let listadoHtml = '';
  for (let actores of actor) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + actores.act_id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+actores.act_id+'</td><td>' + actores.sex_id + '</td><td>' + actores.act_nombre + '</td><td>'+ botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#actores tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este actor?')) {
    return;
  }

 const request = await fetch('api/actor/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}