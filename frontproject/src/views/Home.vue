<template>
  <div class="home">
    
      <initial-search>

    </initial-search>
  </div>
 
  
</template>

<script lang="ts">
import { defineComponent } from "vue";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src
//import InitialSearch from "@/components/search/InitialSearch.vue";
import initialSearch from "@/components/search/InitialSearch.vue";

export default defineComponent({
  name: "Home",
  components: {
    HelloWorld,
    initialSearch,
  },
});
</script>
