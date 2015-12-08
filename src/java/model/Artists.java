
package model;

public class Artists {
  
    private int artistID;
    private String firstName;
    private String lastName;
    private String stageName;
    private int age;
    
    public Artists() {
        this.artistID = 0;
        this.firstName = "";
        this.lastName = "";
        this.stageName = "";
        this.age = 0;
    
    }

    public Artists(int artistID, String firstName, String lastName, String stageName, int age) {
        this.artistID = artistID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.age = age;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getFirsttName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Artists{" + "artistID=" + artistID + ", firstName=" + firstName + ", lastName=" + lastName + ", stageName=" + stageName + ", age=" + age + '}';
    }
    
    
    
    
}
