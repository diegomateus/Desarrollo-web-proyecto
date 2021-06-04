import { apiPropertyModifier } from "@/services/apiPropertyManagement/apiPropertyModifier";
import {ref, Ref} from "vue";
import {Property} from "../types/Property";

export function propertyModifier(){
    const property: Ref<Property> = ref({
        address: "",
        propertyId: "",    
        propertyType: "",
        city: "",
        description: "",
        bedroomsNumber: 0,
        bathsroomsNumber: 0,
        privateArea: 0,
        builArea: 0,
        serviceLevel: 0,
        condition: "",
        deliveryDate: "",
        latitude: 0,
        longtiude: 0,
        images : [],
        serializedQuestions : [],
        serializedOffers: []});

    async function update(){
        if(property.value!= null){
            await apiPropertyModifier.update(property.value);
        }
        
    }

    return {
        property,
        update
    }
}