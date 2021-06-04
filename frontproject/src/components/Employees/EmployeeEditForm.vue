<template>
  <div class="container">
    <form>
      <label for="fname">Nombre</label>
      <input
        type="text"
        id="name"
        name="firstname"
        placeholder="Nombre.."
      />

      <label for="lname">Apellido</label>
      <input
        type="text"
        id="lastName"
        name="lastname"
        placeholder="Apellido.."
      />

      <label for="lname">Email</label>
      <input
        type="text"
        id="email"
        name="lastname"
        placeholder="Correo electronico.."
      />

      <label for="lname">Contraseña</label>
      <input
        type="text"
        id="password"
        name="lastname"
        placeholder="Contraseña.."
      />

      <label for="country">Rol</label>
      <select id="rol" name="country">
        <option value="admin">Administrador</option>
        <option value="employee">Empleado</option>
      </select>

    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
export default defineComponent({
  name: "EditEmployee",
  
});
</script>

<style scoped>
body {
  font-family: Arial, Helvetica, sans-serif;
}
* {
  box-sizing: border-box;
}

input[type="text"],
select,
textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type="submit"] {
  background-color: #04aa6d;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>