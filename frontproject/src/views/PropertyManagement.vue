<template>
<update></update>
<eliminate></eliminate>
</template>

<script lang = "ts">
import { defineComponent } from 'vue';
import update from '@/components/PropertyManagement/update.vue';
import eliminate from '@/components/PropertyManagement/eliminate.vue';

export default defineComponent ({
    name: "PropertyMangement",
    components: {
        update,
        eliminate,
    },
});
</script>

<style>

</style>