
package ge.mziuri.daotest.dao;

import ge.mziuri.daotest.exception.DaoTestException;
import ge.mziuri.daotest.model.City;
import ge.mziuri.daotest.model.Country;
import java.util.List;

public interface CountryDAO {
    
    void addCountry(Country country);
    
    void deleteCountry(int countryId);
    
    Country getCountryByName(String countryName) throws DaoTestException;
    
    List<Country> getAllCountry();
    
    long getPopulation(String countryName);
    
    City getCapital(String countryName) throws DaoTestException;
    
    void closeConnection();
    
}
