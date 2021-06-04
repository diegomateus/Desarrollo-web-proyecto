<template>
  <section class="Properties">
    <h2 class="products-title">P</h2>
    <div class="products-collection">
      <PropertyCard
        v-for="property in properties"
        :key="property.propertyId"
        :property="property"
      ></PropertyCard>
    </div>
  </section>
  <p>Esta es la vista de productos, en construcción.</p>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, computed } from "vue";
import PropertyCard from "@/components/products/PropertyCard.vue";
import { useProducts } from "@/uses/useProperties";

export default defineComponent({
  name: "Properties",
  components: {

    PropertyCard,
  },
  setup() {
    const { properties } = useProducts();
    
    

   

    return { properties };
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
