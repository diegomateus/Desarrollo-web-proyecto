<template>
     <section class="search">
    <h2>Encuentra apartamentos y casas</h2>

    
        <select v-model="selectedType" name="pType" class="searchSelect">
            <option disabled value="">Propiedad</option>
            <option>Casa</option>
            <option>Apartamento</option>
        </select>  
    

    
        <select v-model="selectedOffer" name="offerType" class="searchSelect">
            <option disabled value="">Tipo oferta</option>
            <option value="Ambas">RENT</option>
            <option value="Compra">SALE</option>
            
        </select>  
    

     
        <select v-model="selectedCity" name="city" class="searchSelect">
            <option disabled value="">Ciudad</option>
            <option value="Bogota">Bogota</option>
            <option value="Medellin">Medellin</option>
            <option value="Cali">Cali</option>
            <option value="Bucaramanga">Bucaramanga</option>
        </select>  
    
    
     
     <button class="searchSelect" @click="handleSearch(selectedType, selectedOffer, selectedCity)">Buscar</button>
     
  </section>

      

   
   
     
    
</template>

<script lang="ts">
import router from '@/router';
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
        
        function handleSearch(a: string, offer: string, city: string){
           router.push({ path: 'properties', query: { city: city, action: offer, propertyType: a } })
            
        }
        return {handleSearch};
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