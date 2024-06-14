
function editOdontologo(id, nombre, apellido, matricula) {
    // Muestra el formulario de edición y rellénalo con los datos del odontólogo
    const editForm = document.querySelector("#editForm");

    editForm.querySelector("#editId").value = id;
    editForm.querySelector("#editNombre").value = nombre;
    editForm.querySelector("#editApellido").value = apellido;
    editForm.querySelector("#editMatricula").value = matricula;


    editForm.style.display = "block";
}

function updateOdontologo() {
    const editForm = document.querySelector("#editForm");

    const id = editForm.querySelector("#editId").value;
    const nombre = editForm.querySelector("#editNombre").value;
    const apellido = editForm.querySelector("#editApellido").value;
    const matricula = editForm.querySelector("#editMatricula").value;

    fetch(`/odontologo`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({id, nombre, apellido, nroMatricula: matricula }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        fetchOdontologos(); // Actualizar la lista de odontólogos
    })
    .catch((error) => {
        console.error('Error:', error);
    });

    // Ocultar el formulario
    editForm.style.display = "none";
}

// Añadir un listener para el botón de guardar cambios
document.querySelector("#saveChanges").addEventListener("click", updateOdontologo);
