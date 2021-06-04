import { Employee } from "@/types/Employee";
import { Ref, ref } from "vue";

export function useSearchEmployee(){
    const searchQuery: Ref<string> = ref("");

    function setSearchQuery(search: string){
        searchQuery.value=search;
    }

    function searchByName(employees: Employee[]):Employee[]{
        if (searchQuery.value) {
            return employees.filter((employee) => {
                return employee.name
                  .toLowerCase()
                  .includes(searchQuery.value.toLowerCase()) ||
                  employee.lastName
                  .toLowerCase()
                  .includes(searchQuery.value.toLowerCase())  ;
              });
        }
        return employees;
    }

    return { setSearchQuery, searchByName}
}