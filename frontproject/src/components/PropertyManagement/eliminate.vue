<template>
    <button @click="eliminate">Eliminar</button>  
</template>

<script lang = "ts">
import { defineComponent } from 'vue'
import {propertyDeleter} from "@/uses/usePropertyDeleter";
export default defineComponent( {
  name: "eliminate",

  setup(){
    const eliminate = propertyDeleter();
    return eliminate;
  }
});
</script>


<style scoped>

</style>