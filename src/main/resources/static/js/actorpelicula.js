// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#actoresPeliculas').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {
  const request = await fetch('api/actorPelicula', {
    method: 'GET',
    headers: getHeaders()
  });
  const actorPelicula = await request.json();


  let listadoHtml = '';
  for (let actoresPeliculas of actorPelicula) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + actoresPeliculas.apl_id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+actoresPeliculas.apl_id+'</td><td>' + actoresPeliculas.act_id + '</td><td>' + actoresPeliculas.pel_id + '</td><td>' + actoresPeliculas.apl_papel + '</td><td>'
                    + botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#actoresPeliculas tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este actor de pelicula?')) {
    return;
  }

 const request = await fetch('api/actorPelicula/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}