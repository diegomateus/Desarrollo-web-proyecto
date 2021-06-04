import { onMounted, Ref, ref } from "vue";
import { Employee } from "@/types/Employee";
import { apiEmployees } from "@/services/apiEmployees/apiEmployees"

export function useEmployees(){
    const employees: Ref<Employee[]> = ref([]);
    const employee: Ref<Employee | null> = ref(null);
    const all:Ref<boolean> = ref(true);
    const add:Ref<boolean> = ref(false);
    const edit:Ref<boolean> = ref(false);

    onMounted(async () => {
        employees.value = await apiEmployees.getAllEmployees();
    });

    function allEmployee(){
        all.value=true;
        add.value=false;
        edit.value=false;
    }

    function addEmployee(){
        all.value=false;
        add.value=true;
        edit.value=false;
    }

    function editEmployee(){
        all.value=false;
        add.value=false;
        edit.value=true;
    }

    async function createEmployee(){
        all.value=true;
        add.value=false;
        edit.value=false;
    }

    return { employees, all, add, edit, allEmployee, addEmployee, editEmployee, employee, createEmployee};
}