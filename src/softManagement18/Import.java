package softManagement18;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;
import java.util.Scanner;

class Import {
	
	//1.Import Employee
		public static void ImportEmployees () { //change static
			File file = new File("SoftManagement18.txt"); //pass the file name
			Scanner sc;
			try {
				sc = new Scanner (file);
				sc.useDelimiter(";");
				while (sc.hasNext())

				{
					String line = sc.nextLine();
					String [] EmpLine = line.split("[;]");

					if(line.startsWith("Employee")) {
						String name = EmpLine [1];
						String role =EmpLine[2];
						TeamMember emp = new TeamMember(name, role);
						Controller.listOfEmployees.add(emp);
					}
				}
				sc.close();

			} catch(FileNotFoundException FN ) {

				System.out.println("File not found");

			}
		}

		//3.Import Projects
		public static void importProjects () {

			File file = new File("SoftManagement18.txt");
			Scanner sc;
			try {
				sc = new Scanner (file);
				sc.useDelimiter(";");
				while (sc.hasNext())

				{
					String line = sc.nextLine();
					String [] projectL = line.split("[;]");

					if(line.startsWith("Project")) {
						String title = projectL [1];
						String description = projectL [2];
						
						Project project = new Project (title, description);
						Controller.listOfProjects.add(project);
					}

				}

				sc.close();

			} catch(FileNotFoundException FN) {
				System.out.println("File not found");

			}

		}
	


}
