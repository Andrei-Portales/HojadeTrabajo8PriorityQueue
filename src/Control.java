

public class Control {
	
	private PriorityQueue<Paciente> data;
	private Paciente PacienteActual;
	
	
	public Control(String factory) {
		Factory<Paciente> fact = new Factory<Paciente>();
		data = fact.getPriority(factory);
	}
	
	/**
	 * Metodo para agregar pacientes
	 */
	public void addPacientes() {
		Object[] data = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
		for (Object a : data) {
			this.data.add(((Paciente)a));
		}
	}
	
	/**
	 * Metodo para transferir paciente
	 */
	public void transferir() {
		PacienteActual = data.remove();
	}
	
	/**
	 * Metodo para retornar el paciente actual
	 * @return
	 */
	public Paciente getPaciente() {
		return PacienteActual;
	}
	
	/**
	 * Metodo para atender al paciente
	 * @return
	 */
	public boolean atender() {
		PacienteActual = null;
		return true;
	}
	
	/**
	 * metodo que devuelve a todos los pacientes
	 * @return
	 */
	public PriorityQueue<Paciente> getPacientes(){
		return data.clone();
	}
	
	/**
	 * Metodo que devulve el size 
	 * @return
	 */
	public int size() {
		return data.size();
	}
	
	
	
	
}
