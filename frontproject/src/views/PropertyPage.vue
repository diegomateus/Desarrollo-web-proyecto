<template>
  <section class="Properties">
    <h2 class="products-title"></h2>
    <div class="products-collection">
        <Property-desc>
            :Property="property"
        </Property-desc>
        <book-appointment>
          
        </book-appointment>
      
    </div>
  </section>
  <p>Esta es la vista de propiedades.</p>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, computed } from "vue";
import PropertyCard from "@/components/properties/PropertyCard.vue";
import { useGetProperty } from "@/uses/useGetProperty";
import PropertyDesc from "@/components/properties/PropertyDesc.vue"
import { useRoute } from "vue-router"
import bookAppointment from "@/components/appointments/bookAppointment.vue";

export default defineComponent({
  name: "PropertyPage",
  components: {
    bookAppointment,
    PropertyDesc,
  },
  setup() {
      const{
          params: { propertyId },
          } =useRoute()


    //const { property } = useGetProperty("dd");
    
    return {  };
  },
});
</script>

<style scoped>
.products {
  max-width: 90rem;
  margin: 0 auto;
  padding: 4rem 1rem;
}

.products-title {
  font-size: 2rem;
}

.products-collection {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(18rem, 1fr));
  gap: 1.5rem;
}
</style>


