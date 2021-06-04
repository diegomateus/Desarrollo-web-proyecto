import { onMounted, ref, Ref } from "vue";
import { apiAppointments } from "@/services/apiAppointments/apiAppointments";
import { Appointment } from "@/types/Appointment";

export function useAssignedAppointments() {
  const assignedAppointments: Ref<Appointment[]> = ref([]);

  onMounted(async () => {
    assignedAppointments.value = await apiAppointments.getAssignedAppointments();
  });

  function removeAssignedAppointment(selectedAppointment: Appointment){
    apiAppointments.deleteAppointment(selectedAppointment.id);
    assignedAppointments.value = assignedAppointments.value.filter(a => a.id !== selectedAppointment.id);
  }

  function addAssignedAppointment(selectedAppointment: Appointment){
    apiAppointments.assignAppointment(selectedAppointment.id);
    assignedAppointments.value.push(selectedAppointment);
  }

  return { assignedAppointments, removeAssignedAppointment, addAssignedAppointment};
}