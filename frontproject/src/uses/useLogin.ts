import { TokenResponse } from "@/types/TokenResponse";
import { User } from "@/types/User";
import { ref, Ref } from "vue";
import { useRouter } from "vue-router";
import { apiAuthentication } from "@/services/apiAuthentication/apiAuthentication";

export function useLogin() {
    const user: Ref<User> = ref({ email: "", password: "" });
    const router = useRouter()

    async function login() {
        const token: TokenResponse = await apiAuthentication.authenticate(user.value);
        console.log('token ' + token.token);
        if (token.token != 'error') {
            localStorage.setItem('user', token.token);
            router.push('/appointments');
        }
    }

    return {
        user,
        login,
    };
}