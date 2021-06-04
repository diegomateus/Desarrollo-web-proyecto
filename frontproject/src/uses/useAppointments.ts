import { ref, Ref } from "vue";
import { Appointment } from "@/types/Appointment";
import { apiAppointments } from "@/services/apiAppointments/apiAppointments";


export function useAppointment() {
  const appointment: Ref<Appointment> = ref({ appointmentId: "", propertyId: "" , dateTime: "",
        day: "", month: "", year: "", hour: "", minute: "", customerFirstName: "",
        customerLastName: "", customerEmail:"", customerPhoneNumber:""

        });
  

  async function book() {
    await apiAppointments.book(appointment.value);
    
  }

  return {
    appointment
  };
}