
public class Program {
	double Program_Size;
	double Exepected_Execution_time;
	int ID ;
	public String state;
	private int countInter;
	private int countIO;
	private int countCPU;



	public Program(int iD ) {
		Program_Size = (Math.random() * (16384 - 16) + 16) ;
		Exepected_Execution_time =Math.random() * (512 - 16) + 16 ;
		this.ID = iD;
		state ="New" ;
		countInter=0;
		countIO=0;
		countCPU=1;
	}



	public int getCountInter() {
		return countInter;
	}



	public void setCountInter(int countInter) {
		this.countInter = countInter;
	}



	public int getCountIO() {
		return countIO;
	}



	public void setCountIO(int countIO) {
		this.countIO = countIO;
	}



	public int getCountCPU() {
		return countCPU;
	}



	public void setCountCPU(int countCPU) {
		this.countCPU = countCPU;
	}
	
	
	
	


}
