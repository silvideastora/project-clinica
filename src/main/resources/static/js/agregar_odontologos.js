const form = document.getElementById("agregarForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const nombre = document.getElementById("nombre").value;
  const apellido = document.getElementById("apellido").value;
  const matricula = document.getElementById("matricula").value;
  const mensaje = document.getElementById("mensaje");

  // llamando al endpoint de agregar

  fetch(`/odontologo`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nombre, apellido, nroMatricula: matricula }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
            mensaje.textContent = "Odontólogo agregado con éxito";
            mensaje.classList.add("alert-success");
            mensaje.style.display = "block";
            setTimeout(() => {
              mensaje.textContent = "";
              mensaje.classList.remove("alert-success");
              mensaje.style.display = "none";
            }, 3000);
            form.reset();
    })
    .catch((error) => {
      console.error("Error agregando odontólogo:", error);
            mensaje.textContent = "Error al agregar odontólogo";
            mensaje.classList.add("alert-danger");
            mensaje.style.display = "block";
            setTimeout(() => {
              mensaje.textContent = "";
              mensaje.classList.remove("alert-danger");
              mensaje.style.display = "none";
            }, 3000);
    });
});