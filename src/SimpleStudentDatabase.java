import java.util.*;

class SimpleStudentDatabase{

	/*Variable Declaration*/

	static String[] stName=new String[]{};
	static String[] stId=new String[]{};
	static int[] dbms=new int[]{};
	static int[] pf=new int[]{};
	static int[] totMarks=new int[]{};
	static double[] avgMarks=new double[]{};

	/*Clear Console*/

	public final static void clearConsole(){
	try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	}catch (final Exception e) {
	 e.printStackTrace();
	 // Handle any exceptions.
		}
	}

	/*Best In DBMS Subject*/

	public static void bestDbms(){
		Scanner input=new Scanner(System.in);
		String option1="";
		for(int i=stId.length; i>0;i--){
			String tempId=stId[0];
			String tempName=stName[0];
			int tempPf=pf[0];
			int max=dbms[0];
			int index=0;

			for (int j=1; j<i; j++){
				if(dbms[j]>max){
					max=dbms[j];
					index=j;

					tempId=stId[j];
					tempName=stName[j];
					tempPf=pf[j];
				}
			}
			dbms[index]=dbms[i-1];
			dbms[i-1]=max;

			stId[index]=stId[i-1];
			stId[i-1]=tempId;
			stName[index]=stName[i-1];
			stName[i-1]=tempName;
			pf[index]=pf[i-1];
			pf[i-1]=tempPf;

			int printlength=0;
			L1:for (int k=0; k<stId.length; k++){
				if (pf[k]==0){
					printlength=k;
					{continue L1;}
				}else{
					printlength=stId.length-1;
				}
			}
			System.out.printf("%-6s%-15s%-15s%10s","ID","Name","DBMS Marks","PF Marks");
			System.out.println();
			for(int l=0; l<printlength+1;l++){
				String row=String.format("%-6s%-15s%6d%14d",stId[(stId.length-1)-l],stName[(stName.length-1)-l],dbms[(dbms.length-1)-l],pf[(pf.length-1)-l]);
				System.out.println(row);
			}
			System.out.println();
			System.out.print("Do you want to go back to main menu? (Y/n)");
			option1=input.nextLine();

			if(option1.equalsIgnoreCase("y")){
				clearConsole();
				return;
			}
		}
	}

	/*Best in PF Subject*/

	public static void bestPf(){
		Scanner input=new Scanner(System.in);
		String option1="";
		for(int i=stId.length; i>0;i--){
			String tempId=stId[0];
			String tempName=stName[0];
			int tempDbms=dbms[0];
			int max=pf[0];
			int index=0;

			for (int j=1; j<i; j++){
				if(pf[j]>max){
					max=pf[j];
					index=j;

					tempId=stId[j];
					tempName=stName[j];
					tempDbms=dbms[j];
				}
			}
			pf[index]=pf[i-1];
			pf[i-1]=max;

			stId[index]=stId[i-1];
			stId[i-1]=tempId;
			stName[index]=stName[i-1];
			stName[i-1]=tempName;
			dbms[index]=dbms[i-1];
			dbms[i-1]=tempDbms;

			int printlength=0;
			L1:for (int k=0; k<stId.length; k++){
				if (pf[k]==0){
					printlength=k;
					{continue L1;}
				}else{
					printlength=stId.length-1;
				}
			}
			System.out.printf("%-6s%-15s%-15s%10s","ID","Name","PF Marks","DBMS Marks");
			System.out.println();
			for(int l=0; l<printlength+1;l++){
				String row=String.format("%-6s%-15s%6d%14d",stId[(stId.length-1)-l],stName[(stName.length-1)-l],pf[(pf.length-1)-l],dbms[(dbms.length-1)-l]);
				System.out.println(row);
			}
			System.out.println();
			System.out.print("Do you want to go back to main menu? (Y/n)");
			option1=input.nextLine();

			if(option1.equalsIgnoreCase("y")){
				clearConsole();
				return;
			}
		}
	}

	/*Sorting total Marks*/

	public static void sortTotMarks(){
		for(int i=stId.length; i>0;i--){
			String tempId=stId[0];
			String tempName=stName[0];
			int tempPf=pf[0];
			int tempDbms=dbms[0];
			double tempAvg=avgMarks[0];
			int max=totMarks[0];
			int index=0;
			for (int j=1; j<i; j++){
				if(totMarks[j]>max){
					max=totMarks[j];
					index=j;

					tempId=stId[j];
					tempName=stName[j];
					tempPf=pf[j];
					tempDbms=dbms[j];
					tempAvg=avgMarks[j];

				}
			}
			totMarks[index]=totMarks[i-1];
			totMarks[i-1]=max;

			stId[index]=stId[i-1];
			stId[i-1]=tempId;
			stName[index]=stName[i-1];
			stName[i-1]=tempName;
			pf[index]=pf[i-1];
			pf[i-1]=tempPf;
			dbms[index]=dbms[i-1];
			dbms[i-1]=tempDbms;
			avgMarks[index]=avgMarks[i-1];
			avgMarks[i-1]=tempAvg;
		}
	}

	/*Print Student rank*/

	public static void printStRank(){
		Scanner input=new Scanner(System.in);
		totMarks();
		avgMarks();
		sortTotMarks();
		String option1="";
		int printlength=0;
		L1:for (int i=0; i<stId.length; i++){
			if (pf[i]==0){
				printlength=i;
				{continue L1;}
			}else{
				printlength=stId.length-1;
			}
		}
		System.out.printf("%-5s%-6s%-12s%-15s%-15s","Rank","ID","Name","Total Marks","Avg. Marks");
		System.out.println();
		for(int i=0; i<printlength+1;i++){
			String row=String.format("%-5d%-6s%-12s%11d%,(11.2f",(i+1),stId[(stId.length-1)-i],stName[(stName.length-1)-i],totMarks[(totMarks.length-1)-i],avgMarks[(avgMarks.length-1)-i]);
			System.out.println(row);
		}

		System.out.print("Do you want to go back to main menu? (Y/n)");
		option1=input.nextLine();
		if(option1.equalsIgnoreCase("Y")){
			clearConsole();
		}
	}

	/*Calculating Total Marks*/

	public static void totMarks(){
		int[] temp5=new int[stId.length];
		for (int i=0; i<stId.length ; i++){
			temp5[i]=pf[i]+dbms[i];
		}
		totMarks=temp5;
	}

	/*Calculating Average Marks*/

	public static void avgMarks(){
		double[] temp6=new double[stId.length];
		for(int i=0; i<stId.length; i++){
			temp6[i]=(pf[i]+dbms[i])/2;

		}
		avgMarks=temp6;
	}

	/*print Student Details*/

	public static void printStDet(){
		Scanner input=new Scanner(System.in);
		totMarks();
		avgMarks();
		String tempId="";
		String option1="";
		String option2="";
		int count=0;

		System.out.print("Enter Student ID :");
		tempId=input.nextLine();

		for (int i=0; i<stId.length; i++){
			int k=stId.length-1;

			if (tempId.equals(stId[i])){
				System.out.println("Student Name : "+stName[i]);
				System.out.println();
				if (pf[i]!=0){
					System.out.printf("%-40s%15d%n","Programming Fundamentals Marks",pf[i]);
					System.out.printf("%-40s%15d%n","Database Management System Marks",dbms[i]);
					System.out.printf("%-40s%15d%n","Total Marks",totMarks[i]);
					System.out.printf("%-40s%,(15.2f%n","Avg. Marks",avgMarks[i]);
					if (i==0){
						System.out.printf("%-40s%15d%s%n","Rank",i+1,"(First)");
					}else if(i==1){
						System.out.printf("%-40s%15d%s%n","Rank",i+1,"(Second)");
					}else if(i==2){
						System.out.printf("%-40s%15d%s%n","Rank",i+1,"(Third)");
					}else if(i==(stId.length-1)){
						System.out.printf("%-40s%15d%s%n","Rank",i+1,"(Last)");
					}else{
						System.out.printf("%-40s%15d%n","Rank",i+1);
					}
					System.out.println();
					System.out.print("Do you want to search another student details? (Y/n) ");
					option2=input.nextLine();
					System.out.println();
					if(option2.equalsIgnoreCase("Y")){
						clearConsole();
						printStDet();
					}
					return;
				}
				System.out.print("Marks yet to be added.\nDo you want to search another student details? (Y/n) ");
				option1=input.nextLine();
				System.out.println();
				if(option1.equalsIgnoreCase("Y")){
					clearConsole();
					printStDet();
				}
				return;
			}
			count++;
		}
		if (count==stId.length){
			System.out.print("Invalid ID.Do you want to search again? (Y/n)");
			option2=input.nextLine();
			System.out.println();
		}
		if (option2.equalsIgnoreCase("y")){
			clearConsole();
			printStDet();
		}else{
		}
	}

	/*Deleting a student*/

	public static void delSt(){
		Scanner input=new Scanner(System.in);

		String[] temp1=new String[stName.length-1];
		String[] temp2=new String[stId.length-1];
		int[] temp3=new int[stId.length-1];
		int[] temp4=new int[stId.length-1];
		int count=0;
		String tempId="";
		String option1="";
		String option2="";

		System.out.print("Enter Student ID :");
		tempId=input.nextLine();

		for (int i=0; i<stId.length; i++){
			if (tempId.equals(stId[i])){
				for (int j=i; j<stId.length-1; j++){
					stId[i]=stId[i+1];
					stName[i]=stName[i+1];
					pf[i]=pf[i+1];
					dbms[i]=dbms[i+1];
				}
				for (int k=0; k<stId.length-1; k++){
					temp1[k]=stId[k];
					temp2[k]=stName[k];
					temp3[k]=pf[k];
					temp4[k]=dbms[k];

				}
				stId=temp1;
				stName=temp2;
				pf=temp3;
				dbms=temp4;

				System.out.println("Student has been deleted successfully.");
				System.out.print("Do you want to delete another student? (Y/n) ");
				option1=input.nextLine();
				System.out.println();
				if(option1.equalsIgnoreCase("Y")){
					clearConsole();
					delSt();
				}
				return;

			}
			count++;
		}
		if (count==stId.length){
			System.out.print("Invalid ID.Do you want to search again? (Y/n)");
			option2=input.nextLine();
			System.out.println();
		}
		if (option2.equalsIgnoreCase("y")){
			clearConsole();
			delSt();
		}else{
		}
	}

	/*Update only Marks*/

	public static void upMarks(){
		Scanner input=new Scanner(System.in);
		String tempId="";
		int count=0;
		String option1="";
		String option2="";

		do{
			System.out.print("Enter Student ID :");
			tempId=input.nextLine();
			for (int i=0; i<stId.length; i++){
				if (tempId.equals(stId[i])){
					if(dbms[i]!=0){
						System.out.println("Student Name : "+stName[i]);
						System.out.println();
						System.out.println("Programming Fundamentals Marks :"+pf[i]);
						System.out.println("Database Management System Marks :"+dbms[i]);
						System.out.println();

						do{
							System.out.print("Enter New Programming Fundamentals Marks :");
							pf[i]=input.nextInt();
							if (pf[i]<0 | pf[i]>100){
								System.out.println("Invalid marks,Please enter correct marks :");
							System.out.println();
							}
						}while(pf[i]<0 | pf[i]>100);

						do{
							System.out.print("Enter New Database Management System Marks :");
							dbms[i]=input.nextInt();
							if (dbms[i]<0 | dbms[i]>100){
								System.out.println("Invalid marks,Please enter correct marks :");
							}
							System.out.println();
						}while(dbms[i]<0 | dbms[i]>100);
						System.out.println("Marks have been updated successfully.");
						System.out.print("Do you want to update marks for another student? (Y/n) ");
						input.nextLine();
						option1=input.nextLine();
						System.out.println();
						if(option1.equalsIgnoreCase("Y")){
							clearConsole();
							upMarks();
						}
						return;

					}
					System.out.print("This student's marks yet to be added.\nDo you want to update the marks of another student? (Y/n) ");
					option1=input.nextLine();
					System.out.println();
					if(option1.equalsIgnoreCase("Y")){
						clearConsole();
						upMarks();
					}
					return;
				}
				count++;
			}
			if (count==stId.length){
				System.out.print("Invalid ID.Do you want to search again? (Y/n)");
				option2=input.nextLine();
				System.out.println();
			}
			if (option2.equalsIgnoreCase("y")){
				clearConsole();
				upMarks();
			}else{
				return;
			}
		}while(true);
	}

	/*update student details*/

	public static void upStDet(){
		Scanner input=new Scanner(System.in);
		String tempId="";
		int count=0;
		String option1="";
		String option2="";

		do{
			System.out.print("Enter Student ID :");
			tempId=input.nextLine();
			for (int i=0; i<stId.length; i++){
				if (tempId.equals(stId[i])){
					System.out.println("Student Name : "+stName[i]);
					System.out.println();
					System.out.print("Enter the new student name : ");
					stName[i]=input.nextLine();
					System.out.print("Student details updated successfully.\nDo you want to update another student details? (Y/n) ");
					option1=input.nextLine();
					System.out.println();
					if(option1.equalsIgnoreCase("Y")){
						clearConsole();
						upStDet();
					}
					return;
				}
				count++;
			}
			if (count==stId.length){
				System.out.print("Invalid ID.Do you want to search again? (Y/n)");
				option2=input.nextLine();
				System.out.println();
			}
			if (option2.equalsIgnoreCase("y")){
				clearConsole();
				upStDet();
			}else{
				return;
			}
		}while(true);
	}

	/*Add student Marks*/

	public static void addMarks(){
		Scanner input=new Scanner(System.in);
		String tempId="";
		String option1="";
		String option2="";
		String option3="";
		do {
			System.out.print("Enter Student ID :");
			tempId = input.nextLine();
			int count = 0;
			for (int i = 0; i < stId.length; i++) {
				if (tempId.equals(stId[i])) {
					if (pf[i] == 0) {
						System.out.println("Student Name : " + stName[i]);
						do {
							System.out.print("Programming Fundamentals Marks :");
							pf[i] = input.nextInt();
							if (pf[i] < 0 | pf[i] > 100) {
								System.out.println("Invalid marks,Please enter correct marks :");
								System.out.println();
							}
						} while (pf[i] < 0 | pf[i] > 100);

						do {
							System.out.print("Database Management System Marks :");
							dbms[i] = input.nextInt();
							if (dbms[i] < 0 | dbms[i] > 100) {
								System.out.println("Invalid marks,Please enter correct marks :");
							}
							System.out.println();
						} while (dbms[i] < 0 | dbms[i] > 100);

						System.out.println("Marks have been added.");
						System.out.print("Do you want to add marks for another student? (Y/n) ");
						input.nextLine();
						option1 = input.nextLine();
						if (option1.equalsIgnoreCase("Y")) {
							clearConsole();
							addMarks();
						}
						return;

					}
					System.out.print("This student's marks have been already added.\nIf you want to update the marks, please use [4] Update Marks option.\n\nDo you want add marks for another student? (y/n) ");
					option3 = input.nextLine();
					if (option3.equalsIgnoreCase("Y")) {
						clearConsole();
						addMarks();
					}
					return;
				}
				count++;

			}
			if (count == stId.length) {
				System.out.print("Invalid ID.Do you want to search again? (Y/n)");
				option2 = input.nextLine();
				System.out.println();
			}
			if (option2.equalsIgnoreCase("y")) {
				clearConsole();
				addMarks();
			} else {
				return;
			}

		} while (true);

	}

	/*Add New Student with Makrs*/

	public static void addNewStWithMarks(){
		Scanner input=new Scanner(System.in);
		String option1="";
		do {

			String[] temp1 = new String[stName.length + 1];
			String[] temp2 = new String[stId.length + 1];
			int[] temp3 = new int[stId.length + 1];
			int[] temp4 = new int[stId.length + 1];

			if (stId.length >= 1) {
				for (int i = 0; i < stName.length; i++) {
					temp1[i] = stId[i];
					temp2[i] = stName[i];
					temp3[i] = pf[i];
					temp4[i] = dbms[i];
				}
			}
			for (int i = stName.length; i < temp1.length; i++) {
				System.out.print("Input Student ID :");
				temp1[i] = input.nextLine();
				if (stId.length >= 1) {
					for (int j = 0; j < stName.length; j++) {
						if (temp1[i].equals(stId[j])) {
							System.out.print("The Student ID is already exist.\n\nDo you want to add another student? (Y/n) ");
							option1 = input.nextLine();
							if (option1.equalsIgnoreCase("Y")) {
								clearConsole();
								addNewStWithMarks();
							}
							clearConsole();
							return;
						}
					}
				}
				System.out.print("Input Student Name :");
				temp2[i] = input.nextLine();

				do {
					System.out.print("Programming Fundamentals Marks :");
					temp3[i] = input.nextInt();
					if (temp3[i] < 0 | temp3[i] > 100) {
						System.out.println("Invalid marks,Please enter corret marks :");
						System.out.println();
					}
				} while (temp3[i] < 0 | temp3[i] > 100);


				do {
					System.out.print("Database Management System Marks :");
					temp4[i] = input.nextInt();
					if (temp4[i] < 0 | temp4[i] > 100) {
						System.out.println("Invalid marks,Please enter corret marks :");
					}
					System.out.println();
				} while (temp4[i] < 0 | temp4[i] > 100);

			}
			System.out.println();
			stId = temp1;
			stName = temp2;
			pf = temp3;
			dbms = temp4;


			System.out.print("Student has been added succesfully.Do you want to add a new student (Y/n) :");
			input.nextLine();
			option1 = input.nextLine();
			System.out.println();
			if (option1.equalsIgnoreCase("Y")) {
				clearConsole();
				addNewStWithMarks();
			}
			return;
		} while (option1.equalsIgnoreCase("y"));
	}

	/*Add new Student*/

	public static void addNewSt(){
		Scanner input=new Scanner(System.in);
		String option1="";
		do {

			String[] temp1 = new String[stName.length + 1];
			String[] temp2 = new String[stId.length + 1];
			int[] temp3 = new int[stId.length + 1];
			int[] temp4 = new int[stId.length + 1];

			if (stId.length >= 1) {
				for (int i = 0; i < stName.length; i++) {
					temp1[i] = stId[i];
					temp2[i] = stName[i];
					temp3[i] = pf[i];
					temp4[i] = dbms[i];
				}
			}
			for (int i = stName.length; i < temp1.length; i++) {
				System.out.print("Input Student ID :");
				temp1[i] = input.nextLine();
				if (stId.length >= 1) {
					for (int j = 0; j < stName.length; j++) {
						if (temp1[i].equals(stId[j])) {
							System.out.println("The Student ID is already exist.");
							System.out.println();
							addNewSt();
							/*option1=input.nextLine();
							System.out.println();
							if(option1.equalsIgnoreCase("Y")){
								addNewSt();
							}
							return;*/
						}
					}
				}
				System.out.print("Input Student Name :");
				temp2[i] = input.nextLine();
			}
			System.out.println();
			stId = temp1;
			stName = temp2;
			pf = temp3;
			dbms = temp4;

			System.out.print("Student has been added succesfully.Do you want to add a new student (Y/n) :");
			option1 = input.nextLine();
			System.out.println();
			if (option1.equalsIgnoreCase("Y")) {
				clearConsole();
				addNewSt();
			}
			return;
		} while (option1.equalsIgnoreCase("Y"));
	}

	/*Main Menu*/

	public static void main(String[] args){
			Scanner input=new Scanner(System.in);

			do{
				clearConsole();
				String[] home={"Add New Student","Add New Student With Marks","Add Marks","Update Student Details","Update Marks","Delete Student","Print Student Details","Print Student Ranks","Best In Programming Fundamentals","Best In Database Management System"};
				for(int i=0; i<10; i+=2){
					String row=String.format("%-40s%-40s","["+(i+1)+"] "+home[i],"["+(i+2)+"] "+home[i+1]);
					System.out.println(row);
				}
				System.out.println();

				String option;
				System.out.print("Enter an option to continue > ");
				option=input.nextLine();
				switch(option){
					case "1" : clearConsole();addNewSt();break;
					case "2" : clearConsole();addNewStWithMarks();break;
					case "3" : clearConsole();addMarks();break;
					case "4" : clearConsole();upStDet();break;
					case "5" : clearConsole();upMarks();break;
					case "6" : clearConsole();delSt();break;
					case "7" : clearConsole();printStDet();break;
					case "8" : clearConsole();printStRank();break;
					case "9" : clearConsole();bestPf();break;
					case "10": clearConsole();bestDbms();break;
					case "y" : return;

				}
			}while(true);
	}
}
