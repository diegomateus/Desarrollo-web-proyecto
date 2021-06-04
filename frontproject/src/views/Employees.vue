<template>
  <section class="employeesSection">
    <h2 class="title">Empleados</h2>
    <EmployeeSearch @search="setSearchQuery"></EmployeeSearch>
    <div class="collection">
      <EmployeeCard
        v-for="employee in filteredEmployees"
        :key="employee.id"
        :employee="employee"
      ></EmployeeCard>
    </div>
  </section>
  <p>{{ search }}</p>
  <p>Vista de empleados en producción</p>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";
import EmployeeSearch from "@/components/Employees/EmployeeSearch.vue";
import EmployeeCard from "@/components/Employees/EmployeeCard.vue";
import { Employee } from "@/types/Employee";
import { useGetAllEmployees } from "@/uses/Employees/useGetAllEmployees";
import { useSearchEmployee } from "@/uses/Employees/useSearchEmployee";

export default defineComponent({
  name: "Employees",
  components: {
    EmployeeSearch,
    EmployeeCard,
  },
  setup() {
    const { employees } = useGetAllEmployees();
    const { setSearchQuery, searchByName } = useSearchEmployee();

    const filteredEmployees = computed(() => {
      let finalEmployees = searchByName(employees.value);
      return finalEmployees;
    });

    async function getEmployees(): Promise<Employee[]> {
      return new Promise((resolve) => {
        resolve([]);
      });
    }
    return { setSearchQuery, filteredEmployees };
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
