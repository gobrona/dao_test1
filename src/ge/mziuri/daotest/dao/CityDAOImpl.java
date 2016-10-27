
package ge.mziuri.daotest.dao;

import ge.mziuri.daotest.exception.DaoTestException;
import ge.mziuri.daotest.metainfo.DatabaseMetaInfo;
import ge.mziuri.daotest.metainfo.ProjectMetaInfo;
import ge.mziuri.daotest.model.City;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public CityDAOImpl() {
        try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addCity(City city) {
        try {
            pstmt = con.prepareStatement("INSERT INTO city (name, population, capital, country_id) VALUES (?,?,?,?);");
            pstmt.setString(1, city.getName());
            pstmt.setLong(2, city.getPopulation());
            pstmt.setBoolean(3, city.isCapital());
            pstmt.setInt(4, city.getCountry_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteCity(int cityId) {
        try {
            pstmt = con.prepareStatement("DELETE FROM city WHERE id = ?");
            pstmt.setInt(1, cityId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<City> getCityByName(String cityName) {
        List<City> cities = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM city WHERE name = ?");
            pstmt.setString(1, cityName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_id");
                City city = new City(id, cityName, population, capital, country_id);
                cities.add(city);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cities;
    }

    @Override
    public City getCityInCountry(String countryName, String cityName) throws DaoTestException {
        City city = null;
        try { 
            pstmt = con.prepareCall("SELECT * FROM city WHERE name = ? AND country_id = (SELECT id FROM country WHERE name = ?);");
            pstmt.setString(1, cityName);
            pstmt.setString(2, countryName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_id");
                city = new City(id, cityName, population, capital, country_id);
            } else {
                throw new DaoTestException(ProjectMetaInfo.cantFindCity);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return city;
    }

    @Override
    public List<City> getAllCity() {
        List<City> cities = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM city");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cityName = rs.getString("name");
                long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_id");
                City city = new City(id, cityName, population, capital, country_id);
                cities.add(city);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cities;
    }

    @Override
    public List<City> getAllCityInCountry(String countryName) {
        List<City> cities = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM city WHERE country_id = (SELECT id FROM country WHERE name = ?);");
            pstmt.setString(1, countryName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cityName = rs.getString("name");
                long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_id");
                City city = new City(id, cityName, population, capital, country_id);
                cities.add(city);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cities;
    }
    
    @Override
    public void closeConnection() {
        try {
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
