<template>
  <div id="all" v-if="all">
  <section class="employeesSection">
    <h2 class="title">Empleados</h2>
    <EmployeeSearch @search="setSearchQuery" @add="addEmployee"></EmployeeSearch>
    <div class="collection">
      <EmployeeCard
        v-for="employee in filteredEmployees"
        :key="employee.id"
        :employee="employee"
      ></EmployeeCard>
    </div>
  </section>
  </div>
  <div id="add" v-if="add">
  </div>
  <div id="edit" v-if="edit">
  </div>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";
import EmployeeSearch from "@/components/Employees/EmployeeSearch.vue";
import EmployeeCard from "@/components/Employees/EmployeeCard.vue";
import { useEmployees } from "@/uses/Employees/useEmployees";
import { useSearchEmployee } from "@/uses/Employees/useSearchEmployee";

export default defineComponent({
  name: "Employees",
  components: {
    EmployeeSearch,
    EmployeeCard,
  },
  setup() {
    const { employees, all, add, edit, allEmployee, addEmployee, editEmployee } = useEmployees();
    const { setSearchQuery, searchByName } = useSearchEmployee();

    const filteredEmployees = computed(() => {
      let finalEmployees = searchByName(employees.value);
      return finalEmployees;
    });

    return { all, add, edit, setSearchQuery, filteredEmployees, addEmployee };
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
</style>
