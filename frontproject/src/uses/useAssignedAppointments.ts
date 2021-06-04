import { onMounted, ref, Ref } from "vue";
import { apiAppointments } from "@/services/apiAppointments/apiAppointments";
import { Appointment } from "@/types/Appointment";

export function useAssignedAppointments() {
  const assignedAppointments: Ref<Appointment[]> = ref([]);

  onMounted(async () => {
    assignedAppointments.value = await apiAppointments.getAssignedAppointments();
  });

  return { assignedAppointments };
}