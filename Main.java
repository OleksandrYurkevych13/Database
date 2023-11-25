import java.util.Scanner; 
public class Main { 
    public static void main(String[] args) { 
        int wybor, i; 
        long pes; 
        int MaxTab = 10; 
        Baza myBaza = new Baza(MaxTab); 
        Scanner scan = new Scanner(System.in); 
        do { 
            System.out.println("1 dodaj, 2 lista, 3 szukaj, 4 usun, 5 sortuj, 6 koniec"); 
            wybor = scan.nextInt(); 
            System.out.println("wybor = " + wybor); 
            switch(wybor) { 
                case 1: System.out.println("dodaj"); 
                    myBaza.add(); 
                    break; 
                case 2: System.out.println("lista"); 
                    myBaza.lista(); 
                    break; 
                case 3: System.out.println("szukaj"); 
                    System.out.println("Podaj pesel: "); 
                    pes = scan.nextLong(); 
                    myBaza.find(pes); 
                    break; 
                case 4: System.out.println("usun"); 
                    System.out.println("Podaj pesel: "); 
                    pes = scan.nextLong(); 
                    myBaza.usun(pes); 
                    break; 
                case 5: System.out.println("Sortuj"); 
                    myBaza.sort(); 
                    break; 
            } 
        } while(wybor != 6); 
        System.out.println("Koniec"); 
    } 
} 
