import { Property } from "@/types/Property";

import { properties } from "@/config/urls";

export const apiProperties = {
    getProperties(): Promise<Property[]> {
      console.log("Esto: " +  process.env.VUE_APP_BASE_URL);
      const url = process.env.VUE_APP_BASE_URL.concat(properties);
      const config = {
        method: "GET",
      };
      return fetch(url, config)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Error al cargar las propiedades");
          }
          return response.json();
        })
        .catch((error) => {
          throw error;
        });
    },
    getProperty(id: string): Promise<Property[]> {
      const url = process.env.VUE_APP_BASE_URL.concat(properties).concat(id);
      const config = {
        method: "POST",
      };
      return fetch(url, config)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Error al obtener la propiedad");
          }
          return response.json();
        })
        .catch((error) => {
          throw error;
        });
    },
    
  };