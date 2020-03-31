import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {
	
	VectorHeap<Paciente> vector = new VectorHeap<Paciente>();

	@Test
	void test1() {
		vector.add(new Paciente("Andrei Portales","Dolor de cabeza","C"));
		vector.add(new Paciente("Juan Perez","Alergia","D"));
		vector.add(new Paciente("Luis Gutierrez","Cancer","A"));
		vector.add(new Paciente("Pedro Manolo","Sarampeon","B"));
		
		assertEquals(vector.remove().getNombre(), "Luis Gutierrez");
		assertEquals(vector.remove().getSintoma(), "Sarampeon");
		assertEquals(vector.size(), 2);
	}
	
	
	
	
	

}
