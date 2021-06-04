<template>
    <section class="assigned-appointments">
        <h2 class="assigned-appointments-title">Citas asignadas</h2>
        <AssignedAppointment
            v-for="appointment in assignedAppointments"
            :key="appointment.id"
            :appointment="appointment"
        ></AssignedAppointment>
    </section>

    <section class="unassigned-appointments">
        <h2 class="unassigned-appointments-title">Citas sin asignar</h2>
        <UnassignedAppointment
            v-for="appointment in unassignedAppointments"
            :key="appointment.id"
            :appointment="appointment"
        ></UnassignedAppointment>
    </section>
</template>

<script lang="ts">
    import { defineComponent, Ref, ref, computed} from "vue";
    import UnassignedAppointment from "@/components/appointments/UnassignedAppointment.vue";
    import AssignedAppointment from "@/components/appointments/AssignedAppointment.vue";
    import { useUnassignedAppointments } from "@/uses/useUnassignedAppointments";
    import { useAssignedAppointments } from "@/uses/useAssignedAppointments";

    export default defineComponent({
        name: "Appointments",
        components: {
            AssignedAppointment,
            UnassignedAppointment
        },
        setup(){
            const { assignedAppointments } = useAssignedAppointments();
            const { unassignedAppointments } = useUnassignedAppointments();
            return { assignedAppointments, unassignedAppointments };
        }
    });
</script>

<style lang="scss">

</style>