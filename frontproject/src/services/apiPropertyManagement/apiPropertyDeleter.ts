import {property_path} from "@/config/urls";

export const apiPropertyDeleter = {
    eliminate(){
        const url = process.env.VUE_APP_BASE_URL.concat(property_path);
        const config = {
            method : "DELETE",
        };

        return fetch(url, config)
      .then((response) => {
        if(!response.ok) {
          throw new Error("Ha fallado")
        }
      })
      .catch((error) => {
        throw error
      });
    }

    
}