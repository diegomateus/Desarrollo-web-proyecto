import {Property} from "../types/Property";
import {update_property_path} from "../config/urls";

export const apiPropertyModifier = {
    update(property: Property){
        const url = process.env.VUE_APP_BASE_URL.concat(update_property_path);
        const config = {
            method : "PUT",
            body : JSON.stringify(property)
        };

        return fetch(url, config)
      .then((response) => {
        if(!response.ok) {
          throw new Error("Ha fallado sus credenciales")
        }
      })
      .catch((error) => {
        throw error
      });
    }

    
}