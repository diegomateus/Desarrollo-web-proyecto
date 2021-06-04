<template>
  <section class="filters">
    <input
      id="search"
      type="search"
      placeholder="Buscar..."
      class="search"
      @input="handleSearch"
    />
  </section>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "EmployeeSearch",
  setup(props, context) {
    function handleSearch(event: any) {
      context.emit("update:search", event.target.value);
    }
    return { handleSearch };
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
</style>