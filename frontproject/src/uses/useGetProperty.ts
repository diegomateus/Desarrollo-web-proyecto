import { onMounted, ref, Ref } from "vue";
import { apiProperties } from "@/services/apiProperties";
import { Property } from "@/types/Property";

export function useGetProperty(id : string) {
  /*let property: Ref<Property> = ref({ propertyId: "", city: "" , address: "", propertyType: "",
        description: "", deliveryDate: "", bathsroomsNumber: 0, bedroomsNumber: 0, privateArea: 0,
        builArea: 0, serviceLevel: 0, condition: "", latitude: 0, longtiude: 0 , images: [],
        questions: [], offers: []
        
        });*/

    const property: Ref<Property[]> = ref([]);

  onMounted(async () => {
    property.value = await apiProperties.getProperty(id);
  });

  
  return { };
}