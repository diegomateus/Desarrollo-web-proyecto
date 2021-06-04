<template>
  <form class="formulario">
    <div>
      <label>Dirección: </label>
      <input type="text" v-model="property.address" />
    </div>
    <div>
      <label>Tipo de propiedad: </label>
      <select name="tipo" v-model="property.propertyType">
        <option value="Casa">Casa</option>
        <option value="Apartamento">Apartamento</option>
      </select>
    </div>
    <div>
      <label>Ciudad: </label>
      <input type="text" v-model="property.city" />
    </div>
    <div>
      <label>Numero de habitaciones: </label>
      <input type="number" v-model="property.bedroomsNumber" /> 
    </div>
    <div>
      <label>Numero de baños: </label>
      <input type="number" v-model="property.bathroomsNumber" />
    </div>
    <div>
      <label>Area privada: </label>
      <input type="number" v-model="property.privateArea" />
    </div>
    <div>
      <label>Area construida: </label>
      <input type="number" v-model="property.builtArea" />
    </div>
    <div>
      <label>Estrato: </label>
      <select name="estrato" v-model="property.serviceLevel">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
      </select>
    </div>
    <div>
      <label>Condición: </label>
      <select name="condition" v-model="property.condition">
        <option value="nuevo">Nuevo</option>
        <option value="usado">Usado</option>
        <option value="remodelado">Remodelado</option>
      </select>
    </div>
    <div>
      <label>Fecha de entrega: </label>
      <input
        type="date"
        id="start"
        name="trip-start"
        min="2021-01-01"
        max="3000-12-31"
        v-model="property.deliveryDate"
      />
    </div>
    <div>
      <label>Latitud: </label>
      <input type="number" v-model="property.latitude" />
    </div>
    <div>
      <label>Longitud: </label>
      <input type="number" v-model="property.longitude" />
    </div>
    <input type="button" value="Modificar" :disabled="submitEneable"
      :class="[submitEneable ? 'uno' : 'dos']"
      @click="update"/>
  </form>
</template>

<script lang = "ts">
import {propertyModifier} from "@/uses/propertyModifier";
import { computed,defineComponent, Ref, ref } from 'vue';
import {Property} from "@/types/Property";

export default defineComponent( {
  name: "update",

  setup(){
    const {property,update} = propertyModifier();
    const submitEneable = computed(()=>{
      let validate = property.value.address !== null && property.value.address !== "";
      return !(validate)
    });
    return{property,update,submitEneable}
  }
});
</script>

<style scoped>
.formulario {
  display: flex;
  flex-direction: column;
}

</style>