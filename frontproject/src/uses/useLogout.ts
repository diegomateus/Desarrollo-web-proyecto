import { useRouter } from "vue-router";

export function useLogout() {
    const router = useRouter()

    function logout() {
        localStorage.removeItem('user');
        router.push("/login");
    }

    return {
        logout
    };
}