
package ge.mziuri.daotest.dao;

import ge.mziuri.daotest.exception.DaoTestException;
import ge.mziuri.daotest.model.City;
import java.util.List;

public interface CityDAO {
    
    void addCity(City city);
    
    void deleteCity(int cityId);
    
    List<City> getCityByName(String cityName);
    
    City getCityInCountry(String countryName, String cityName) throws DaoTestException;
    
    List<City> getAllCity();
    
    List<City> getAllCityInCountry(String countryName);
    
    void closeConnection();
    
}
