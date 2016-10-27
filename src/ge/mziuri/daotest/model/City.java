
package ge.mziuri.daotest.model;

public class City {
    
    private int id;
    
    private String name;
    
    private long population;
    
    private boolean capital;
    
    private int country_id;

    public City() {
    }

    public City(int id, String name, long population, boolean capital, int country_id) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.country_id = country_id;
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

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", population=" + population + ", capital=" + capital + ", country_id=" + country_id + '}';
    }
    
}
