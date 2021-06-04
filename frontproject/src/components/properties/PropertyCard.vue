<template>
  <div v-for="offer of actualProperty.offers" :key="offer.id">
    <article class="card">
      <a href="#">
        <div class="card-info">
            <img :src="actualProperty.images[0].image" alt="" class="card-img" />
            <h3> {{ actualProperty.propertyType }} in {{ actualProperty.city }} {{ actualProperty.address }}</h3>
            <h3>{{ offer.action }} price: {{ offer.price }} </h3>
            <p class="card-lead">  Rooms: {{ actualProperty.bedroomsNumber }} </p>
            <p class="card-lead">  Bathrooms: {{ actualProperty.bathsroomsNumber }} </p>
          </div>
          
      </a>
      <router-link :to="'/properties/' + actualProperty.propertyId"></router-link>
      
    </article>
  </div>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, onBeforeMount } from "vue";
import { Property } from "@/types/Property";
import { Offer } from "@/types/Offer";

export default defineComponent({
  name: "PropertyCard",
  props: {
    property: {
      type: Object as () => Property,
      required: true,
    },
  },
  setup(props) {
    const propertyCard: Ref<Property | null> = ref(null);

    onBeforeMount(() => {
      propertyCard.value = Object.assign({}, props.property);
      //propertyOffers.value = Object.assign({}, props.property.offers[0]);
    });

    return { actualProperty: propertyCard};
  },
});
</script>

<style scoped>
.card {
  min-height: 10rem;
  background: #fff;
  box-shadow: 0 0.2rem 1rem rgba(0, 0, 0, 0.05);
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
}
.card a {
  color: #333;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  padding: 0.5rem;
  height: 100%;
}
.card:hover,
.card:focus {
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
  transform: translateY(-0.5rem);
}
.card:focus {
  outline: 5px solid black;
}
.card-img {
  width: 50%;
}
.card-info {
  padding: 0 1rem 1rem;
  text-align: justify;
}
</style>
