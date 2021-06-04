<template>
  <section class="employeesSection">
    <h2 class="title">Empleados</h2>
    <div id="all" v-if="all">
      <EmployeeSearch
        @search="setSearchQuery"
        @add="addEmployee"
      ></EmployeeSearch>
      <div class="collection">
        <EmployeeCard
          v-for="employee in filteredEmployees"
          :key="employee.id"
          :employee="employee"
          @click="editEmployee(employee.id)"
        ></EmployeeCard>
      </div>
    </div>
    <div id="add" v-if="add">
      <AddEmployee></AddEmployee>
      <button class="button button1">Aceptar</button>
      <button class="button button3" @click="allEmployee">Cancelar</button>
    </div>
    <div id="edit" v-if="edit">
      <EditEmployee></EditEmployee>
      <button class="button button1">Guardar</button>
      <button class="button button3" @click="allEmployee">Cancelar</button>
      <button class="button button4" >Eliminar</button>
    </div>
  </section>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";
import EmployeeSearch from "@/components/Employees/EmployeeSearch.vue";
import EmployeeCard from "@/components/Employees/EmployeeCard.vue";
import { useEmployees } from "@/uses/Employees/useEmployees";
import { useSearchEmployee } from "@/uses/Employees/useSearchEmployee";
import AddEmployee from "@/components/Employees/EmployeeAddForm.vue";
import EditEmployee from "@/components/Employees/EmployeeEditForm.vue";

export default defineComponent({
  name: "Employees",
  components: {
    EmployeeSearch,
    EmployeeCard,
    AddEmployee,
    EditEmployee,
  },
  setup() {
    const {
      employees,
      all,
      add,
      edit,
      allEmployee,
      addEmployee,
      editEmployee,
    } = useEmployees();
    const { setSearchQuery, searchByName } = useSearchEmployee();

    const filteredEmployees = computed(() => {
      let finalEmployees = searchByName(employees.value);
      return finalEmployees;
    });

    return {
      all,
      add,
      edit,
      setSearchQuery,
      filteredEmployees,
      allEmployee,
      addEmployee,
      editEmployee,
    };
  },
});
</script>

<style scoped>
.employeesSection {
  max-width: 90rem;
  margin: 0 auto;
  padding: 4rem 1rem;
}
.title {
  font-size: 2rem;
}
.collection {
  display: grid;
  gap: 1.5rem;
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

.button4 {
  background-color: white; 
  color: black; 
  border: 2px solid #660066;
}

.button4:hover {
  background-color: #660066;
  color: white;
}
</style>
