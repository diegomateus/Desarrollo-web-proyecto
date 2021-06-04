import { Property } from "@/types/Property";

import { properties } from "@/config/urls";

export const apiPropertyG = {
    getAssignedAppointments(): Promise<Property[]> {
      console.log("Esto: " +  process.env.VUE_APP_BASE_URL);
      const url = process.env.VUE_APP_BASE_URL.concat(properties);
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