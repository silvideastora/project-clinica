
function editOdontologo(id, nombre, apellido, matricula) {
    // Muestra el formulario de edición y rellénalo con los datos del odontólogo

    const editForm = document.querySelector("#editForm");

          editForm.querySelector("#editId").value = id;
          editForm.querySelector("#editNombre").value = nombre;
          editForm.querySelector("#editApellido").value = apellido;
          editForm.querySelector("#editMatricula").value = matricula;

          // Mostrar el modal usando Bootstrap modal API
          const editModal = new bootstrap.Modal(document.getElementById('editModal'));
          editModal.show();
}

function updateOdontologo() {
    const editForm = document.querySelector("#editForm");

    const id = editForm.querySelector("#editId").value;
    const nombre = editForm.querySelector("#editNombre").value;
    const apellido = editForm.querySelector("#editApellido").value;
    const matricula = editForm.querySelector("#editMatricula").value;
    const mensaje = document.getElementById("mensaje")

    fetch(`/odontologo`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({id, nombre, apellido, nroMatricula: matricula }),
    })
    .then(response => response.json())
    .then(data => {
       console.log('Exito:', data);
               // Mostrar la alerta
               mensaje.textContent = "Odontólogo modificado exitosamente";
               mensaje.classList.add("alert-success");
               mensaje.style.display = "block";
               // Ocultar la alerta después de 3 segundos
               setTimeout(() => {
                   mensaje.textContent = "";
                   mensaje.classList.remove("alert-success");
                   mensaje.style.display = "none";
               }, 3000);
               // Ocultar el modal
               const editModal = bootstrap.Modal.getInstance(document.getElementById('editModal'));
               editModal.hide();
               // Limpiar el formulario
               editForm.reset();
               // Actualizar la lista de odontólogos
               fetchOdontologos();
    })
    .catch((error) => {
        console.error('Error:', error);
                // Mostrar la alerta de error si falla la modificación
                mensaje.textContent = "Error al modificar el odontólogo";
                mensaje.classList.add("alert-danger");
                mensaje.style.display = "block";
                // Ocultar la alerta de error después de 3 segundos
                setTimeout(() => {
                    mensaje.textContent = "";
                    mensaje.classList.remove("alert-danger");
                    mensaje.style.display = "none";
                }, 3000);
                const editModal = new bootstrap.Modal(document.getElementById('editModal'));
                        editModal.hide();
    });

    // Ocultar el formulario
    editForm.style.display = "none";
}

// Añadir un listener para el botón de guardar cambios
document.querySelector("#saveChanges").addEventListener("click", updateOdontologo);
function deleteOdontologo(id) {
    // Mostrar el modal de confirmación
        const confirmDeleteModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
        confirmDeleteModal.show();

        // Manejar el clic en el botón "Eliminar" del modal de confirmación
        const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');
        confirmDeleteBtn.addEventListener('click', function() {
            // Aquí se realiza la eliminación del odontólogo si el usuario confirma
            const mensaje = document.getElementById("mensaje");

            fetch(`/odontologo/${id}`, {
                method: 'DELETE',
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('La response no esta OK');
                }
                return response.json();
            })
            .then(data => {
                console.log('Borrado:', data);
                            // Mostrar la alerta de éxito
                            mensaje.textContent = "Odontólogo eliminado exitosamente";
                            mensaje.classList.add("alert-success");
                            mensaje.style.display = "block";
                            // Ocultar la alerta después de 3 segundos
                            setTimeout(() => {
                                mensaje.textContent = "";
                                mensaje.classList.remove("alert-success");
                                mensaje.style.display = "none";
                            }, 3000);
                            // Actualizar la lista de odontólogos
                            fetchOdontologos();
            })
            .catch((error) => {
                console.error('Error borrando odontologo:', error);
                            // Mostrar la alerta de error si falla la eliminación
                            mensaje.textContent = "Error al eliminar el odontólogo";
                            mensaje.classList.add("alert-danger");
                            mensaje.style.display = "block";
                            // Ocultar la alerta de error después de 3 segundos
                            setTimeout(() => {
                                mensaje.textContent = "";
                                mensaje.classList.remove("alert-danger");
                                mensaje.style.display = "none";
                            }, 3000);
                        })
                        .finally(() => {
                            // Ocultar el modal de confirmación después de procesar la eliminación
                            confirmDeleteModal.hide();
            });

            // Ocultar el modal de confirmación después de procesar la eliminación
            confirmDeleteModal.hide();
        });
}

