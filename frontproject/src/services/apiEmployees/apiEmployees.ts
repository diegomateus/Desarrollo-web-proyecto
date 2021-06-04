import { getAll_employees } from "@/config/urls";
import { Employee } from "@/types/Employee";

export const apiEmployees = {
  getAllEmployees(): Promise<Employee[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(getAll_employees)
    const headers = new Headers();
    if (localStorage.getItem('user') != null) {
      const token: string = '' + localStorage.getItem('user');
      headers.append('Authorization', token);
    }
    const config = {
      method: "GET",
      headers: headers
    }   
    console.log(config);
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar las citas");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  }
}