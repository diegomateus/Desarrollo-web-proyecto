<template>
  <div class="container">
    <form>
      <label for="fname">Nombre</label>
      <input
        type="text"
        v-model="name"
        name="firstname"
        placeholder="Nombre.."
      />

      <label for="lname">Apellido</label>
      <input
        type="text"
        v-model="lastName"
        name="lastname"
        placeholder="Apellido.."
      />

      <label for="lname">Email</label>
      <input
        type="text"
        v-model="email"
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
      <select v-model="rol" name="country">
        <option value="admin">Administrador</option>
        <option value="employee">Empleado</option>
      </select>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
export default defineComponent({
  name: "AddEmployee",
   setup(props, context) {
    
    function handleReturn(event: any){
      context.emit("all",event.target.value)
    }

    return { handleReturn};
  },
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

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}
</style>