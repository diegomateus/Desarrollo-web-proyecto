import { onMounted, ref, Ref } from "vue";
import { Property } from "@/types/Property";
import { apiPropertyG } from "@/services/apiPropertyG";

export function useProducts() {
  const properties: Ref<Property[]> = ref([]);

  onMounted(async () => {
    // products.value = await apiProducts.getProducts();
    properties.value = await apiPropertyG.getProductApi();
  });

  return { properties };
}