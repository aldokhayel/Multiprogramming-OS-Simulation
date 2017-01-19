


public class PQNodeRAM {
	
	public Program data;
	public double Exepected_Execution_time;
	public PQNodeRAM next;
	
	
	
	public PQNodeRAM() {
		next = null;
	}
	
  public PQNodeRAM(Program e, double Exepected_Execution_time) {
       data = e;
       this.Exepected_Execution_time = e.Exepected_Execution_time;
  }
  
 
}