<template>
    <div>
        <h3> {{ actualAppointment.day }}/{{ actualAppointment.month }}/{{ actualAppointment.year }} - {{ actualAppointment.hour }}:{{ actualAppointment.minute }}</h3>
        <h4> {{actualAppointment.propertyCity}}, {{actualAppointment.propertyAddress}} </h4>
        <button @click="handleCancel(actualAppointment)"> Cancelar </button>
    </div>
</template>

<script lang="ts">
import { defineComponent, onBeforeMount, ref, Ref } from "vue";
import { Appointment } from "@/types/Appointment";

export default defineComponent({
    name: "AssignedAppointment",
    props: {
        appointment: {
            type: Object as () => Appointment,
            required: true,
        },
    },
    setup(props, context) {
        const appointment: Ref<Appointment | null> = ref(null);

        onBeforeMount(() => {
            appointment.value = Object.assign({}, props.appointment);
        });

        function handleCancel(selectedAppointment: Appointment) {
            context.emit("cancel", selectedAppointment);
        }

        return { actualAppointment: appointment, handleCancel};
    },
});
</script>


<style scoped>

</style>