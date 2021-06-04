<template>
    
    <input v-model="nombre" placeholder="Nombre">
    <input v-model="apellido" placeholder="Apellido">
    <input v-model="correo" placeholder="Correo">
    <input v-model="celular" placeholder="Celular">
    <template>
        <v-date-picker v-model="date" mode="dateTime" :minute-increment="5" />
    </template>
    <input
        type="button"
        value="Login"
        :disabled="submitEnabled"
        class="login-button"
        :class="[submitEnabled ? 'disabled' : 'enabled']"
        @click="login"
      />
    <button @click="handleBooking(nombre, apellido, correo, celular, date)">Reservar cita</button>

</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { Calendar, DatePicker } from 'v-calendar';

export default defineComponent({
     name: "Properties",
  components: {
      Calendar,
      DatePicker,
  },
  setup(context) {
   
    function handleBooking(nombre :string, apellido : string, correo : string, celular : string, date : Date){
        //context.emit("book", nombre, apellido, correo, celular, date.toString, date.getMonth, date.getFullYear, date.getDay, date.getHours);
    }

    return(handleBooking);
   
  },
})
</script>

<style scoped>

</style>
