import { onMounted, Ref, ref } from "vue";
import { Employee } from "@/types/Employee";
import { apiEmployees } from "@/services/apiEmployees/apiEmployees"

export function useGetAllEmployees(){
    const employees: Ref<Employee[]> = ref([]);
    onMounted(async () => {
        employees.value = await apiEmployees.getAllEmployees();
    });

    return { employees };
}