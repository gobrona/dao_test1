
package ge.mziuri.daotest.dao;

import ge.mziuri.daotest.exception.DaoTestException;
import ge.mziuri.daotest.metainfo.DatabaseMetaInfo;
import ge.mziuri.daotest.metainfo.ProjectMetaInfo;
import ge.mziuri.daotest.model.City;
import ge.mziuri.daotest.model.Country;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public CountryDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addCountry(Country country) {
        try {
            pstmt = con.prepareStatement("INSERT INTO country (name, flag) VALUES (?,?)");
            pstmt.setString(1, country.getName());
            pstmt.setBytes(2, country.getFlag());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            pstmt = con.prepareStatement("DELETE FROM country WHERE id = ?;");
            pstmt.setInt(1, countryId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Country getCountryByName(String countryName) throws DaoTestException{
        Country country = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM country WHERE name = ?;");
            pstmt.setString(1, countryName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                byte[] flag = rs.getBytes("flag");
                country = new Country(id, countryName, flag);
            } else {
                throw new DaoTestException(ProjectMetaInfo.cantFindCountry);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return country;
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> countries = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM country;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                byte[] flag = rs.getBytes("flag");
                Country country = new Country(id, name, flag);
                countries.add(country);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return countries;
    }

    @Override
    public long getPopulation(String countryName) {
        long population = 0;
        try {
            pstmt = con.prepareStatement("SELECT SUM(population) FROM city WHERE country_id = (SELECT id FROM country WHERE name = ?);");
            pstmt.setString(1, countryName);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            population = rs.getLong(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return population;
    }

    @Override
    public City getCapital(String countryName) throws DaoTestException {
        City city = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM city WHERE country_id = (SELECT id FROM country WHERE name = ?) AND capital = TRUE;");
            pstmt.setString(1, countryName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_id");
                city = new City(id, name, population, capital, country_id);
            } else {
                throw new DaoTestException(ProjectMetaInfo.cantFindCapital);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return city;
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
