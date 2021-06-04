import { Appointment } from "@/types/Appointment";
import { assigned_appointments, unassigned_appointments, assign_appointment } from "@/config/urls";
import axios from "axios";

export const apiAppointments = {
  getAssignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(assigned_appointments);
    const config = {
      method: "GET",
    };
    return axios.get(url, {
      headers: {
        'Authorization': `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MDgyODIsImV4cCI6MTYyMjgxMDA4Mn0.OgD06l2cKp6kT-aDKWKlqR2seYA9_zDEZ7y3HDtwQsi-LU7KoxQiMtcmsV6mn0MRtb7kF1P4OP3WryNxmxY1nQ`
      }
    })
    .then((res) => {
      return res.data;
    });
    // return fetch(url, config)
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error("Error al cargar las citas");
    //     }
    //     return response.json();
    //   })
    //   .catch((error) => {
    //     throw error;
    //   });
  },
  getUnassignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(unassigned_appointments);
    const config = {
      method: "GET",
    };
    return axios.get(url, {
      headers: {
        'Authorization': `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MDgyODIsImV4cCI6MTYyMjgxMDA4Mn0.OgD06l2cKp6kT-aDKWKlqR2seYA9_zDEZ7y3HDtwQsi-LU7KoxQiMtcmsV6mn0MRtb7kF1P4OP3WryNxmxY1nQ`
      }
    })
    .then((res) => {
      return res.data;
    });
    // return fetch(url, config)
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error("Error al cargar las citas");
    //     }
    //     return response.json();
    //   })
    //   .catch((error) => {
    //     throw error;
    //   });
  },
  assignAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const config = {
      method: "PUT",
    };
    console.log(axios.put(url, {},  {
      headers: {
        'Authorization': `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MDgyODIsImV4cCI6MTYyMjgxMDA4Mn0.OgD06l2cKp6kT-aDKWKlqR2seYA9_zDEZ7y3HDtwQsi-LU7KoxQiMtcmsV6mn0MRtb7kF1P4OP3WryNxmxY1nQ`
      }
    }));
    // return fetch(url, config)
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error("Error al asignar la cita");
    //     }
    //     return response.json();
    //   })
    //   .catch((error) => {
    //     throw error;
    //   });
  },
  deleteAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const config = {
      method: "DELETE",
    };
    console.log(axios.delete(url, {
      headers: {
        'Authorization': `Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFsRXN0YXRlQXBwVG9rZW4iLCJzdWIiOiJkZTdmZDgzMi04NWMzLTRlMDgtYTVmZC00NWI5ZGQxMDYzODkiLCJhdXRob3JpdGllcyI6WyJST0xFX0VNUExPWUVFIiwiUk9MRV9BRE1JTiJdLCJpYXQiOjE2MjI4MDgyODIsImV4cCI6MTYyMjgxMDA4Mn0.OgD06l2cKp6kT-aDKWKlqR2seYA9_zDEZ7y3HDtwQsi-LU7KoxQiMtcmsV6mn0MRtb7kF1P4OP3WryNxmxY1nQ`
      }
    }));
    // return fetch(url, config)
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error("Error al cancelar la cita");
    //     }
    //     return response.json();
    //   })
    //   .catch((error) => {
    //     throw error;
    //   });
  },
};