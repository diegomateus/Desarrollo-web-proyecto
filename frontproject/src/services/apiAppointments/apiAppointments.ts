import { Appointment } from "@/types/Appointment";
import { assigned_appointments, unassigned_appointments } from "@/config/urls";

export const apiAppointments = {
  getAssignedAppointments(): Promise<Appointment[]> {
    console.log("Esto: " +  process.env.VUE_APP_BASE_URL);
    const url = process.env.VUE_APP_BASE_URL.concat(assigned_appointments);
    const config = {
      method: "GET",
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
    const config = {
      method: "GET",
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
};