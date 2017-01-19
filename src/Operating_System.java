

public class Operating_System {
	public int CID=0;
	double RAM_Size = 160000;
	double SSD = 2000000;
	double IO ;
	public int Interrupt;
	public int simulation_terminateNm;
	public double sizeofallprocess  ;
	LinkedPQ q = new LinkedPQ();
	LinkedPQ q2 = new LinkedPQ();

	//================================================================ 	To Fill The RAM from The SSD by JOB Scedeular 
	public LinkedPQ CPUSecdular() {
		PQNode Q1;
		while (RAM_Size > 0 && JOBsecdular().length() != 0) {
			double e;
			Q1 = JOBsecdular().serve();
			e = Q1.data.Exepected_Execution_time;
			Q1.data.state = "Ready";
			q2.enqueueTORAM(Q1.data, e);
			RAM_Size = RAM_Size - (Q1.data.Program_Size);
			
		}

		return q2;
	}

	//================================================================== To Fill The SSD by Program 
	public LinkedPQ JOBsecdular() {
		while (SSD > 0) {
			Program p1 = fillbyprogram();
			q.enqueueTOSSD(p1, p1.Program_Size); 
			sizeofallprocess += p1.Program_Size;
			SSD = SSD - p1.Program_Size ;

		}
		return q;
		
	}
	//================================================================== To Create Program 
	public Program fillbyprogram() {
		Program p = new Program(CID);
		CID++;
		return p;
	}
	//========================================================= To Generate an Interrupt                                                              
	public boolean GenerateInterrupt(){
		IO = Math.random()*5;
		if(IO>0 && IO <0.9999999999) {
			Interrupt++;
			return true;
		}
		return false;
	}
	//========================================================= To Generate an I/O Request                                                               

	public boolean IORequest(){
		IO = Math.random()*5;
		if(IO>0 && IO <0.9999999999) {
			Interrupt++;
			return true;
		}
		return false;
	}
	//========================================================= Process is Terminate Normally                                                                
	public boolean terminatesN(){
		IO = Math.random()*50;
		if(IO>0 && IO <0.9999999999) {
			Interrupt++;

			return true;
		}
		return false;
	}
	//========================================================= Process is Terminate Abnormally                                                                
	public boolean terminatesAN(){
		IO = Math.random()*100;
		if(IO>0 && IO <0.9999999999) {
			Interrupt++;

			return true;
		}
		return false;
	}
	//========================================================= Simulation is Terminate                                                                
	public boolean simulationTerminate(){
		IO = Math.random()*1000;
		if(IO>0 && IO <0.9999999999) {
			simulation_terminateNm++;
			Interrupt++;

			return true;
		}
		return false;
	}
}
