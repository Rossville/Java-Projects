import java.io.IOException;
import java.util.*;

class studentGradeCalculator{
    void printAllStudentData(Student[] st, int l){
        System.out.println("Name \t\t RollNo \t\t Maths \t\t Science \t\t English \t\t Hindi \t\t History \t\t Geography");
        for(int i=0; i<l; i++){
            System.out.printf("%s \t\t %s \t\t %d \t\t %d \t\t %d \t\t %d \t\t %d \t\t %d %n",st[i].name, st[i].rollno, st[i].math_obj.marks_obtained, st[i].science_obj.marks_obtained, st[i].english_obj.marks_obtained, st[i].hindi_obj.marks_obtained, st[i].history_obj.marks_obtained, st[i].geography_obj.marks_obtained);
        }
    }
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students :");
        int n = sc.nextInt();
        Student[] studentData = new Student[n];
        Student student;
        for(int i=0; i<n; i++){
            student = new Student(sc);
            studentData[i] = student;
        }
        sc.close();
    }
}

class Maths{
    int marks_obtained = 0;
    int marks_total = 100;
}

class Science{
    int marks_obtained = 0;
    int marks_total = 100;
}

class English{
    int marks_obtained = 0;
    int marks_total = 100;
}

class Hindi{
    int marks_obtained = 0;
    int marks_total = 100;
}

class History{
    int marks_obtained = 0;
    int marks_total = 100;
}

class Geography{
    int marks_obtained = 0;
    int marks_total = 100;
}



class Student{
    String name;
    String rollno;
    Maths math_obj = new Maths();
    Science science_obj = new Science();
    English english_obj = new English();
    Hindi hindi_obj = new Hindi();
    History history_obj = new History();
    Geography geography_obj = new Geography();
    float percentageReceived;
    char gradeReceived;
    int totalReceived;
    Student(Scanner sc){
        System.out.println("Enter the name of the student: ");
        name = sc.nextLine();
        System.out.println("Enter the rollNo of the student: ");
        rollno = sc.nextLine();
        System.out.println("Enter marks obtained by student in mathematics");
        math_obj.marks_obtained = sc.nextInt();
        System.out.println("Enter marks obtained by student in science");
        science_obj.marks_obtained = sc.nextInt();
        System.out.println("Enter marks obtained by student in english");
        english_obj.marks_obtained = sc.nextInt();
        System.out.println("Enter marks obtained by student in hindi");
        hindi_obj.marks_obtained = sc.nextInt();
        System.out.println("Enter marks obtained by student in history");
        history_obj.marks_obtained = sc.nextInt();
        System.out.println("Enter marks obtained by student in geography");
        geography_obj.marks_obtained = sc.nextInt();
        totalReceived = totalMarksObtained(math_obj, science_obj, english_obj, hindi_obj, history_obj, geography_obj);
        System.out.println("Total marks received after add the marks of all the subject : " + totalReceived);
        percentageReceived = percentageReceived(totalReceived, 600);
        System.out.println("Percentage Received : "+ percentageReceived);
        gradeReceived = GradeReceived(percentageReceived);
        System.out.println(name+" received : "+gradeReceived);
    }

    int totalMarksObtained(Maths math_obj, Science science_obj, English english_obj, Hindi hindi_obj, History history_obj, Geography geography_obj){
        return (math_obj.marks_obtained+science_obj.marks_obtained+english_obj.marks_obtained+hindi_obj.marks_obtained+history_obj.marks_obtained+geography_obj.marks_obtained);
    }

    float percentageReceived(int totalMarksObtained, int totalMarksReceived){
        return ((float)totalMarksObtained/totalMarksReceived)*100;
    }

    char GradeReceived(float percentage){
        if(percentage >= 85.0) return 'A';
        else if(percentage <= 84.99 && percentage >= 65.0) return 'B';
        return 'C';
    }
}