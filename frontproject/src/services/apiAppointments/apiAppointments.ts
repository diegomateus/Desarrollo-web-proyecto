import { Appointment } from "@/types/Appointment";
import { assigned_appointments, unassigned_appointments, assign_appointment , book_appointment } from "@/config/urls";

export const apiAppointments = {
  getAssignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(assigned_appointments);
    const headers = new Headers();
    if (localStorage.getItem('user') != null) {
      const token: string = '' + localStorage.getItem('user');
      headers.append('Authorization', token);
    }
    const config = {
      method: "GET",
      headers: headers
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar las citas");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  getUnassignedAppointments(): Promise<Appointment[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(unassigned_appointments);
    const headers = new Headers();
    if (localStorage.getItem('user') != null) {
      const token: string = '' + localStorage.getItem('user');
      headers.append('Authorization', token);
    }
    const config = {
      method: "GET",
      headers: headers
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar las citas");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  assignAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const headers = new Headers();
    if (localStorage.getItem('user') != null) {
      const token: string = '' + localStorage.getItem('user');
      headers.append('Authorization', token);
    }
    const config = {
      method: "PUT",
      headers: headers
    };
    fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al asignar cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  deleteAppointment(id: string): void {
    const url = process.env.VUE_APP_BASE_URL.concat(assign_appointment).concat(id);
    const headers = new Headers();
    if (localStorage.getItem('user') != null) {
      const token: string = '' + localStorage.getItem('user');
      headers.append('Authorization', token);
    }
    const config = {
      method: "DELETE",
      headers: headers
    };
    fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cancelar cita");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
  book(appointment: Appointment) {
    const url = process.env.VUE_APP_BASE_URL.concat(book_appointment)
    const config = {
      method: "POST",
      body: JSON.stringify(appointment)
    };

    return fetch(url, config)
      .then((response) => {
        if(!response.ok) {
          throw new Error("Ha fallado la reservación")
        }
      })
      .catch((error) => {
        throw error
      });
  }
};