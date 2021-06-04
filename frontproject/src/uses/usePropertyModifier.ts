import { apiPropertyModifier } from "@/services/apiPropertyManagement/apiPropertyModifier";
import {ref, Ref} from "vue";
import {Property} from "../types/Property";

export function propertyModifier(){
    const property: Ref<Property> = ref({address: "",
        propertyType: "",
        city: "",
        description: "",
        bedroomsNumber: 0,
        bathroomsNumber: 0,
        privateArea: 0,
        builtArea: 0,
        serviceLevel: 0,
        condition: "",
        deliveryDate: "",
        latitude: 0,
        longitude: 0,
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