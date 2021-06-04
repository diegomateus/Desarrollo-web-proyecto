<template>
  <div class="home">
    
      <initial-search>

    </initial-search>
  </div>
 
  
</template>

<script lang="ts">
import { defineComponent } from "vue";
import initialSearch from "@/components/search/InitialSearch.vue";

export default defineComponent({
  name: "Home",
  components: {
    initialSearch,
  },
});
</script>
