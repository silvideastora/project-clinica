const tableBody = document.querySelector("#odontologosTable tbody")

function fetchOdontologos() {
  fetch("http://localhost:8080/odontologo")
  .then(response => response.json())
  .then((data) => {
    // limpiar el contenido de la tabla
    tableBody.innerHTML= ""

    //Inserta los atos en la tabla
    data.forEach((odontologo , index) => {
      const row = document.createElement("tr")

      row.innerHTML = `
        <td>${odontologo.id}</td>
        <td>${odontologo.nombre}</td>
        <td>${odontologo.apellido}</td>
        <td>${odontologo.nroMatricula}</td>
        <td>
        <button class="btn btn-primary btn-sm" onclick="editOdontologo(${odontologo.id}, '${odontologo.nombre}', '${odontologo.apellido}', '${odontologo.nroMatricula}')">Modificar</button>
        <button class="btn btn-danger btn-sm" onclick="deleteOdontologo(${odontologo.id})">Eliminar</button> 
        </td>
      `;
      tableBody.appendChild(row);
      });
    })
    .catch((error) => {
      console.error("Error fetching data:", error);
    });

  // modificar un odontologo

  // eliminar un odontologo

}

fetchOdontologos()