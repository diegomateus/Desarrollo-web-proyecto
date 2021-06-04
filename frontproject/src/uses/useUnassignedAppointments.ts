import { onMounted, ref, Ref } from "vue";
import { apiAppointments } from "@/services/apiAppointments/apiAppointments";
import { Appointment } from "@/types/Appointment";

export function useUnassignedAppointments() {
  const unassignedAppointments: Ref<Appointment[]> = ref([]);

  onMounted(async () => {
    unassignedAppointments.value = await apiAppointments.getUnassignedAppointments();
  });

  return { unassignedAppointments };
}