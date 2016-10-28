
package ge.mziuri.daotest.model;

public class Country {
   
    private int id;
    
    private String name;
    
    private byte[] flag;

    public Country() {
    }

    public Country(int id, String name, byte[] flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + '}';
    }
    
}
