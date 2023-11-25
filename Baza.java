import java.util.Scanner; 
class Baza { 
    int lelem; 
    int tabSize; 
    Osoba[] osobaArr; 
    public Baza(int size) { 
 
        System.out.println("Konstruktor baza, size: " + size); 
        tabSize = size; 
        osobaArr = new Osoba[size]; 
        lelem = 0; 
    } 
    public void add() { 
        String name, surname; 
        long pesel; 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Podaj imie"); 
        name = sc.nextLine(); 
        System.out.println("Podaj nazwisko"); 
        surname = sc.nextLine(); 
        System.out.println("Podaj PESEL"); 
        pesel = sc.nextLong(); 
        if ((long)-1 != _find(pesel)) { 
            System.out.println("Person with this PESEL is already exist"); 
            return; 
        } 
        Osoba newOsoba = new Osoba(name, surname, pesel); 
        if (lelem == tabSize) 
            resize(); 
        Dodaj(newOsoba); 
    } 
    public void find(long pesel) { 
        int idx = _find(pesel); 
        if (-1 == idx) { 
            System.out.println("nie ma osoby o takim pesel"); 
            return; 
        } 
        System.out.println("Name: " + osobaArr[idx].getName() + "; Surname: " + osobaArr[idx].getSurname() 
                + "; PESEL: " + osobaArr[idx].getPesel()); 
    } 
    public void lista () { 
        for (int i = 0; i < lelem; i++) { 
            if (osobaArr[i] != null) 
                System.out.println(i + " Name: " + osobaArr[i].getName() + "; Surname: " + osobaArr[i].getSurname() 
                        + "; PESEL: " + osobaArr[i].getPesel()); 
        } 
    } 
    public int usun(long pesel) { 
        int idx = _find(pesel); 
        if (-1 == idx) 
            return -1; 
        osobaArr[idx] = null; 
        for (int i = idx; i < lelem; i++) 
            osobaArr[i] = osobaArr[i+1]; 
        osobaArr[lelem] = null; 
        lelem--; 
        return idx; 
    } 
    public void sort() { 
        boolean isSorted = false; 
        Osoba buf; 
        while(!isSorted) { 
            isSorted = true; 
            for (int i = 0; i < lelem - 1; i++) { 
                if(osobaArr[i].compareTo(osobaArr[i+1]) > 0){ 
                    isSorted = false; 
                    buf = osobaArr[i]; 
                    osobaArr[i] = osobaArr[i+1]; 
                    osobaArr[i+1] = buf; 
                } 
            } 
        } 
    } 
    private int _find(long pesel) { 
        for (int i = 0; i < lelem; i++) { 
            if (osobaArr[i] != null && osobaArr[i].getPesel() == pesel) { 
                return i; 
            } 
        } 
        return -1; 
    } 
    private void resize() { 
        int newSize = tabSize * 2; 
        Osoba[] newArray = new Osoba[newSize]; 
        for (int i = 0; i < tabSize; i++) 
            newArray[i] = osobaArr[i]; 
        osobaArr = newArray; 
        tabSize = newSize; 
    } 
    private void insertTo(int idx, Osoba os) { 
        for (int i = lelem; i > idx; i--) 
            osobaArr[i] = osobaArr[i - 1]; 
        osobaArr[idx] = os; 
        lelem++; 
    } 
    private void Append(Osoba os) { 
        osobaArr[lelem] = os; 
        lelem++; 
    } 
    private void Dodaj(Osoba os) { 
        int idx = 0; 
        for (int i = 0; i < lelem; i++) { 
            idx = i; 
            if (osobaArr[i].getPesel() > os.getPesel()) { 
                insertTo(idx, os); 
                return; 
            } 
        } 
        Append(os); 
    } 
}
