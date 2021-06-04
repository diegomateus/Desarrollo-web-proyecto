export interface Property {
    address: string,
    propertyType: string,
    city: string,
    description: string,
    bedroomsNumber: number,
    bathroomsNumber: number,
    privateArea: number,
    builtArea: number,
    serviceLevel: number,
    condition: string,
    deliveryDate: string,
    latitude: number,
    longitude: number,
    images : string[],
    serializedQuestions : string[],
    serializedOffers: string[]
}