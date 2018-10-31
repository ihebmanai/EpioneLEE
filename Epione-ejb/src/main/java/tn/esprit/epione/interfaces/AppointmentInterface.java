package tn.esprit.epione.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.epione.persistance.Appointment;
@Local
public interface AppointmentInterface {
	//interfces
	public List<Appointment> GetAppointmentByDoc(int idDoc);
	public void AcceptAppointment(int idApp);
	public void RefuseAppointment(int idApp);
	public List<Appointment> DailyProgram(int idDoc);
	public List<Appointment> GetAppointmentRequest(int idDoc);
	

}
