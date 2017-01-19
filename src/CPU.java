
import java.io.File;
import java.io.FileWriter;

public class CPU {
	public static double countNM ;
	public static double countABN ;
	public static boolean checkedTer=true;
	public static double countbusy;
	static LinkedPQ q = new LinkedPQ();

	public static void main(String[] args) {
		
		Operating_System o = new Operating_System();
		int c = o.CPUSecdular().length();
		
		while ((o.CPUSecdular().length() > 0)) {
			PQNodeRAM n;
			n = o.CPUSecdular().serveRAM();

			while(true){
				if (o.terminatesN()) {
					n.data.state = "Terminate Normally";
					countNM++;
					checkedTer = true;
					break;
				} else if (o.terminatesAN()) {
					n.data.state = "Terminate Abnormally";
					countABN++;
					checkedTer = true;
					break;
					}
					else if(!checkedTer){
						
					
					if (o.GenerateInterrupt()) {
							n.data.state = "Interrupt";
							n.data.setCountInter(n.data.getCountInter()+1);
						}
						
						 if (o.IORequest()) 
						{
							n.data.setCountIO(n.data.getCountIO()+1);
							n.data.state = "Busy";
							
							while(!o.IORequest()){
								
								countbusy++;
							}
								
							
						}
						
					}
					else if (o.simulationTerminate()) {
					o.simulation_terminateNm = 1;
					
					break;
					
				}

					
						
					 n.data.setCountCPU(n.data.getCountCPU()+1);

			} 
		
			q.enqueueTORAM(n.data, n.data.ID);
			
			
		
		if (o.simulation_terminateNm == 1) {
			break;

		}
	


		checkedTer=false;
		}// End While loop
	

		File o2 = new File("Simulation OS");
		try{
			FileWriter fw = new FileWriter(o2);
			fw.write("The number of initially generated jobs stored on the H-disk " + o.JOBsecdular().length()+" Jobs");
			fw.write(System.getProperty("line.separator"));
			fw.write(System.getProperty("line.separator"));
			fw.write("The average program size of all jobs: " + o.sizeofallprocess / o.JOBsecdular().length() +"KB");
			fw.write(System.getProperty("line.separator"));
			fw.write(System.getProperty("line.separator"));
			fw.write("The average number of jobs that have completed their execution normally: " + countNM / c+" Jobs");
			fw.write(System.getProperty("line.separator"));
			fw.write(System.getProperty("line.separator"));
			fw.write("The average number of jobs that have completed their execution abnormally: " + countABN / c+" Jobs");
			fw.write(System.getProperty("line.separator"));	
			fw.write(System.getProperty("line.separator"));
			
		
			fw.close();
		}catch(Exception ex){
			System.out.println("Some problem occures");
		}
		
		File o1 = new File("Program Details");


	
			
			try{
				FileWriter fw = new FileWriter(o1);
				PQNodeRAM a;
				
				while(q.length() != 0){
					a= q.serveRAM();
				fw.write("ID of Process is: " + a.data.ID);
				fw.write(System.getProperty("line.separator"));
				fw.write("The state is: " +a.data.state);
				fw.write(System.getProperty("line.separator"));
				fw.write("The program size: " +a.data.Program_Size);
				fw.write(System.getProperty("line.separator"));	
				fw.write("The expected execution time is " + a.data.Exepected_Execution_time);
				fw.write(System.getProperty("line.separator"));
				fw.write("Number of interrupt is: " + a.data.getCountInter());
				fw.write(System.getProperty("line.separator"));	
				fw.write("Number of I/O Request is: " + a.data.getCountIO());
				fw.write(System.getProperty("line.separator"));	
				fw.write("Actual time is: " + a.data.getCountCPU());
				fw.write(System.getProperty("line.separator"));	
				fw.write(System.getProperty("line.separator"));
				fw.write("The average actual time and exepected time   is: " + (a.data.getCountCPU()+a.data.Exepected_Execution_time)/2);
				fw.write(System.getProperty("line.separator"));
				fw.write(System.getProperty("line.separator"));
				fw.write("====================================================================");
				fw.write(System.getProperty("line.separator"));	
				fw.write(System.getProperty("line.separator"));	

				}
				fw.close();
			
			}catch(Exception ex){
				System.out.println("Some problem occures");
			}
			
			
		
	

	}
}
