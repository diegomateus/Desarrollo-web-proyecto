<template>
  <section class="employeesSection">
    <h2 class="title">Empleados</h2>
    <EmployeeFilters 
    v-model:search="search"></EmployeeFilters>
    <div class="collection">
        <EmployeeCard></EmployeeCard>
    </div>
  </section>
  <p>{{ search }}</p>
  <p>Vista de empleados en producción</p>
</template>

<script lang="ts">
import { defineComponent, onMounted, Ref, ref } from "vue";
import EmployeeFilters from "@/components/Employees/EmployeeFilters.vue"
import EmployeeCard from "@/components/Employees/EmployeeCard.vue"
import { Employee } from "@/types/Employee"

export default defineComponent({
  name: "Employees",
  components: {
    EmployeeFilters,
    EmployeeCard
  },
  setup(){
    const employees : Ref<Employee[]> = ref([]);
    const search : Ref<string> = ref("");

    onMounted(async()=>{
      employees.value=await getEMployees();
    })

    async function getEMployees() : Promise<Employee[]>{
      return new Promise(resolve=>{
        resolve([]);
      })
    }
    return { employees, search };
  },
});
</script>

<style scoped>
.employeesSection{
  max-width: 90rem;
  margin: 0 auto;
  padding: 4rem 1rem;
}
.title{
  font-size: 2rem;
}
.collection{
  display: grid;
  gap: 1.5rem;
}
</style>
