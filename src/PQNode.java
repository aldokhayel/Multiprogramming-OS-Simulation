
	
public class PQNode {
	
	public Program data;
	public double Program_SizePRI;
	public PQNode next;
	
	
	
	public PQNode() {
		next = null;
	}
	
  public PQNode(Program e, double Program_SizePRI) {
       data = e;
       this.Program_SizePRI = Program_SizePRI;
  }
  
 
}