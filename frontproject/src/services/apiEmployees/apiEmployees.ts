import { getAll_employees } from "@/config/urls";
import { Employee } from "@/types/Employee";

export const apiEmployees = {
  getAllEmployees(): Promise<Employee[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(getAll_employees)
    const headers = new Headers();
    headers.append('Authorization', `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiIzMDIzNDc2Yy00Yjk4LTQ2NTktODNhZC05ZDkwM2QxMjI0ZGQiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MjUwMDAsImV4cCI6MTYyMjgyNjgwMH0.SMTXPJKr15xvo7n6VifO6C5zX2-I0dpitYB2LiRGcGvUEVLtvE9ynYopxJswM6uWPNE3w4JmVifwqbr7s7j3WA`);
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