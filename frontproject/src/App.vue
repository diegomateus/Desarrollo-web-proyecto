<template>
  <div id="nav">
      <router-link to="/">Inicio</router-link> |
      <router-link to="/login">Iniciar sesion</router-link> |
      <router-link to="/appointments">Citas</router-link> | 
      <button v-on:click="handleLogout"> Cerrar sesion </button>
    </div>
  <router-view />
  
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useLogout } from "@/uses/useLogout";

export default defineComponent({
  setup() {
    const { logout } = useLogout();
    function handleLogout(){
      logout();
    }
    return {handleLogout};
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
