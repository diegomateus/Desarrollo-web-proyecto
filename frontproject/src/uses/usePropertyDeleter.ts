import { apiPropertyDeleter } from "@/services/apiPropertyManagement/apiPropertyDeleter";
import {ref, Ref} from "vue";
import {Property} from "../types/Property";

export function propertyDeleter(){
    async function eliminate(){
        await apiPropertyDeleter.eliminate();  
    }

    return {
        
    }
}