<template>
  <section class="filters">
    <input
      id="search"
      type="search"
      placeholder="Buscar..."
      class="search"
      @input="handleSearch"
    />
    <button id="add" type="add" class="button addButton" @click="handleAdd">
      Agregar Empleado
    </button>
  </section>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "EmployeeSearch",
  setup(props, context) {
    function handleSearch(event: any) {
      context.emit("search", event.target.value);
    }

    function handleAdd(event: any){
      context.emit("add",event.target.value)
    }

    return { handleSearch, handleAdd };
  },
});
</script>

<style scoped>
.filters {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  max-width: 90rem;
  margin: 2rem auto;
}
.search {
  flex-basis: 0;
  flex-grow: 1;
  padding: 0.3rem 0.5rem;
  height: 2rem;
  width: 30rem;
  background: #f2f2f2;
  border: 1px solid #cccccc;
  border-radius: 2rem;
  outline: none;
  font-size: 1.2rem;
  color: #737373;
  letter-spacing: 1px;
  text-indent: 2rem;
}

.button {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 6px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.addButton {
  background-color: white;
  color: black;
  border: 2px solid #008cba;
  border-radius: 28px;
}

.addButton:hover {
  background-color: #008cba;
  color: white;
}
</style>