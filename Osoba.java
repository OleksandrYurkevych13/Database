public class Osoba implements Comparable<Osoba>{ 
    private String name; 
    private String surname; 
    private long pesel; 
    Osoba(String name, String surname, long pesel) { 
        setName(name); 
        setSurname(surname); 
        setPesel(pesel); 
    } 
    void show() { 
        System.out.printf("IMIE -> %s\nNAZWISKO -> %s\nPESEL -> %ld\n", this.name, this.surname, this.pesel); 
    } 
    void setName(String name) { this.name = toRightFormat(name); } 
    void setSurname(String surname) { this.surname = toRightFormat(surname); } 
    void setPesel(long pesel) { 
        this.pesel = pesel; 
    } 
    String getName() { 
        return name; 
    } 
    String getSurname() { 
        return surname; 
    } 
    long getPesel() { 
        return pesel; 
    } 
    private static String toRightFormat(String str) { 
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase(); 
    } 
    @Override 
    public int compareTo(Osoba os) { 
        return (int)(getPesel() - os.getPesel()); 
    } 
} 
