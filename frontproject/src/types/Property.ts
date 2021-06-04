import { Offer } from "./Offer";
import { Image } from "./image";

export interface Property{
    propertyId: string;
    address: string;
    propertyType: string;
    city: string;
    description: string;
    bedroomsNumber: number;
    bathsroomsNumber: number;
    privateArea: number;
    builArea: number;
    serviceLevel: number;
    condition: string;
    deliveryDate: string;
    latitude: number;
    longtiude: number;
    images: Image[];
    questions: string[];
    offers: Offer[];
}