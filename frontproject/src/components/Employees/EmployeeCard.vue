<template>
  <article class="card" @click="handleAssign(selectEmployee)">
    <div class="container">
      <h2><b>{{ actualEmployee.name }} {{ actualEmployee.lastName }}</b></h2>
    </div>
    <div class="card-info">
      <p>{{ actualEmployee.email }}</p>
      <p>{{ actualEmployee.is_Administrator }}</p>
      <p v-if="admin">Administrador</p>
      <p v-else>Empleado</p>
    </div>
  </article>
</template>

<script lang="ts">
import { defineComponent, onBeforeMount, Ref, ref } from "vue";
import { Employee } from "@/types/Employee";

export default defineComponent({
  name: "EmployeeCard",
  props: {
    employee: {
      type: Object as () => Employee,
      required: true,
    },
  },

  setup(props) {
    const employee: Ref<Employee | null> = ref(null);
    const admin: Ref<boolean>=ref(false);

    onBeforeMount(()=>{
      employee.value=Object.assign({},props.employee);
      if(employee.value.is_admin=="true"){
        admin.value=true;
      }
    });



    return { admin,actualEmployee: employee };
  },
});
</script>

<style scoped>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  width: 30%;
  border-radius: 5px;
  color: #333;
  flex-direction: column;
  align-content: center;
  justify-items: center;
  justify-content: space-evenly;
  padding: 0.5rem;
  height: 100%;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
  transform: translateY(-0.5rem);
}

.container {
  padding: 2px 16px;
}

.card-info {
  padding: 0 1rem 1rem;
}
</style>
