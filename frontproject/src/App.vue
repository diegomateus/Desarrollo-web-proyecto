<template>
  <div id="nav">
    <router-link to="/">Inicio</router-link> 
    <router-link v-if="!authenticated" to="/login"> Iniciar sesion </router-link> 
    <router-link v-if="authenticated" to="/appointments"> Citas </router-link> 
    <button v-if="authenticated" @click="handleLogout"> Cerrar sesion </button>
  </div>
  <router-view @authenticate="handleLogin"/>
</template>

<script lang="ts">
import { defineComponent, ref, Ref } from "vue";
import { useLogout } from "@/uses/useLogout";

export default defineComponent({
  setup() {
    const authenticated: Ref<boolean> = ref(false);
    const { logout } = useLogout();

    function handleLogout(){
      authenticated.value = false;
      logout();
    }

    function handleLogin(){
      authenticated.value = true;
    }

    return {handleLogout,handleLogin,authenticated};
  },
})
</script>


<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
