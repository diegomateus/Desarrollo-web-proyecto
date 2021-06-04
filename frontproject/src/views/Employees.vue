<template>
  <section class="employeesSection">
    <h2 class="title">Empleados</h2>
    <EmployeeSearch v-model:search="search"></EmployeeSearch>
    <div class="collection">
      <EmployeeCard v-for="employee in filteredEmployees" :key="employee.id" :employee="employee"></EmployeeCard>
    </div>
  </section>
  <p>{{ search }}</p>
  <p>Vista de empleados en producción</p>
</template>

<script lang="ts">
import { defineComponent, onMounted, Ref, ref, computed } from "vue";
import EmployeeSearch from "@/components/Employees/EmployeeSearch.vue";
import EmployeeCard from "@/components/Employees/EmployeeCard.vue";
import { Employee } from "@/types/Employee";
import { useGetAllEmployees } from "@/uses/useGetAllEmployees"

export default defineComponent({
  name: "Employees",
  components: {
    EmployeeSearch,
    EmployeeCard,
  },
  setup() {
    const { employees } = useGetAllEmployees();
    const search: Ref<string> = ref("");

    const filteredEmployees = computed(() => {
      let finalEmployees = employees.value;
      if (search.value !== "") {
        finalEmployees = finalEmployees.filter((employee) => {
          return employee.employeeFirstName
            .toLowerCase()
            .includes(search.value);
        });
      }

      return finalEmployees;
    });

    async function getEmployees(): Promise<Employee[]> {
      return new Promise((resolve) => {
        resolve([]);
      });
    }
    return { search, filteredEmployees };
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
