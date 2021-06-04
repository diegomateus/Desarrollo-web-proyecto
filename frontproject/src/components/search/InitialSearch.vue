<template>
     <section class="search">
    <h2>Encuentra apartamentos y casas</h2>

    <div id="v-model-select" class="demo">
        <select v-model="selected">
            <option disabled value="">Please select one</option>
            <option>A</option>
            <option>B</option>
            <option>C</option>
        </select>
        <span>Selected: {{ selected }}</span>
        </div>


        

<select name="tipoOferta" class="searchSelect">
      <option value="Ambas">Arriendo</option>
      <option value="Compra">Compra nuevo</option>
      <option value="Arriendo">Compra usado</option>
      <option value="Arriendo">Compra nuevo y usado</option>
    </select>

    <select name="ciudad" class="searchSelect">
      <option value="Bogota">Bogotá</option>
      <option value="Medellin">Medellin</option>
      <option value="Cali">Cali</option>
      <option value="Bucaramanga">Bucaramanga</option>
    </select>

    
     
     <button class="searchSelect" @click="handleSearch(selected)">Buscar</button>
     
  </section>

      

   
   
     
    
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
    name: "InitialSearch",
    props: {
        type: {
        type: Array as () => string[],
        required: true,
        },
        offerType: {
        type: Array as () => string[],
        required: true,
    }
    },
    
    setup(props, context) {
        const foo: string[] = ['can','us','ok'];
        
        function handleSearch(a: string){
            window.alert(a);
        }
        return "";
    },
})
</script>


<style scoped>

.searchSelect{
  margin-left: 1rem;
  margin-right: 1rem;
  height: 3rem;
  width: 12rem;
}

.searchElement{
  height: 3rem;
  width: 30rem;
}

</style>