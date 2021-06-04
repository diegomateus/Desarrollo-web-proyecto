import { getAll_employees } from "@/config/urls";
import { Employee } from "@/types/Employee";

export const apiGetEmployees={
  getEmployees(employees:Employee[]){
    const url= process.env.VUE_APP_BASE_URL.concat(getAll_employees)
    const config = {
      method: "GET",
      body:""
    }

    return fetch(url,config)
    .then((response)=>response.json())
    .catch((error)=>{throw error});
  }
}