import { User } from "@/types/User";
import { authenticate } from "@/config/urls";
import { TokenResponse } from "@/types/TokenResponse";

export const apiAuthentication = {
  async authenticate(user: User): Promise<TokenResponse> {
    const url = process.env.VUE_APP_BASE_URL.concat(authenticate);
    const headers = {
        'Content-Type': 'application/json'
    }
    const config = {
        headers,
        method: "POST",
        body: JSON.stringify(user)
    };
    const result: TokenResponse = (await fetch(url, config)
      .then((response) => {
        if (response.ok) {
            return response.json();
        }
      })) || {
        token: 'error'
    };
      return  result;
  }
};