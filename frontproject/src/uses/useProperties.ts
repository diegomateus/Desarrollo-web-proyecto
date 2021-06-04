import { onMounted, ref, Ref } from "vue";
import { Property } from "@/types/Property";
import { Offer } from "@/types/Offer";
import { apiProperties } from "@/services/apiProperties";

export function useProducts() {
  const properties: Ref<Property[]> = ref([]);
  const offers: Ref<Offer[]> = ref([]);

  onMounted(async () => {
    // products.value = await apiProducts.getProducts();
    properties.value = await apiProperties.getProperties();
    offers.value = properties.value[0].offers;

    console.log(properties.value);
    
    
    //properties.value.forEach(property=>console.log(property));
  });
  
  return { properties };
}