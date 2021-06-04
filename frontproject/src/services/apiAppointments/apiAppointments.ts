import { Appointment } from "@/types/Appointment";
import { assigned_appointments, unassigned_appointments, assign_appointment } from "@/config/urls";

export const apiAppointments = {
  getAssignedAppointments(): Promise<Appointment[]> {
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
  assignAppointment(id: string): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const config = {
      method: "PUT",
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al asignar la cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  deleteAppointment(id: string): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const config = {
      method: "DELETE",
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cancelar la cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
};