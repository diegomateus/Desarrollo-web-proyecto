import { Appointment } from "@/types/Appointment";
import { assigned_appointments, unassigned_appointments, assign_appointment } from "@/config/urls";

export const apiAppointments = {
  getAssignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(assigned_appointments);
    const headers = new Headers();
    headers.append('Authorization', `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MTEzODIsImV4cCI6MTYyMjgxMzE4Mn0.1JOaNQrr-4UyiX1PFdumv48oEUV-Lgf3zjpjxlgSiiQ3g5cGTxOARWs73zwxotIn6E5j3EhBNMLQPslEmBEiWg`);
    const config = {
      method: "GET",
      headers: headers
    };
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
  },
  getUnassignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(unassigned_appointments);
    const headers = new Headers();
    headers.append('Authorization', `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MTEzODIsImV4cCI6MTYyMjgxMzE4Mn0.1JOaNQrr-4UyiX1PFdumv48oEUV-Lgf3zjpjxlgSiiQ3g5cGTxOARWs73zwxotIn6E5j3EhBNMLQPslEmBEiWg`);    const config = {
      method: "GET",
      headers: headers
    };
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
  },
  assignAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const headers = new Headers();
    headers.append('Authorization', `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MTEzODIsImV4cCI6MTYyMjgxMzE4Mn0.1JOaNQrr-4UyiX1PFdumv48oEUV-Lgf3zjpjxlgSiiQ3g5cGTxOARWs73zwxotIn6E5j3EhBNMLQPslEmBEiWg`);    const config = {
      method: "PUT",
      headers: headers
    };
    fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al asignar cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  deleteAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const headers = new Headers();
    headers.append('Authorization', `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MTEzODIsImV4cCI6MTYyMjgxMzE4Mn0.1JOaNQrr-4UyiX1PFdumv48oEUV-Lgf3zjpjxlgSiiQ3g5cGTxOARWs73zwxotIn6E5j3EhBNMLQPslEmBEiWg`);    const config = {
      method: "DELETE",
      headers: headers
    };
    fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cancelar cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
};