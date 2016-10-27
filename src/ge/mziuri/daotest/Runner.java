
package ge.mziuri.daotest;

import ge.mziuri.daotest.dao.CityDAO;
import ge.mziuri.daotest.dao.CityDAOImpl;
import ge.mziuri.daotest.dao.CountryDAO;
import ge.mziuri.daotest.dao.CountryDAOImpl;
import ge.mziuri.daotest.exception.DaoTestException;
import ge.mziuri.daotest.metainfo.ProjectMetaInfo;
import ge.mziuri.daotest.model.City;
import ge.mziuri.daotest.model.Country;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

public class Runner {
    
    public static void main(String[] args) throws IOException {
        
        CountryDAO countryDAO = new CountryDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
//        
//        // Test -> addCountry()
//        BufferedImage image1 = ImageIO.read(new File(ProjectMetaInfo.imagesResourcesURL + "georgia_flag.png"));
//        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
//        ImageIO.write(image1, "png", baos1);
//        baos1.flush();
//        byte[] georgiaFlagBytes = baos1.toByteArray();
//        Country c1 = new Country(0, "საქართველო", georgiaFlagBytes);
//        countryDAO.addCountry(c1);
//        
//        BufferedImage image2 = ImageIO.read(new File(ProjectMetaInfo.imagesResourcesURL + "england_flag.png"));
//        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
//        ImageIO.write(image2, "png", baos2);
//        baos2.flush();
//        byte[] englandFlagBytes = baos2.toByteArray();
//        Country c2 = new Country(0, "ინგლისი", englandFlagBytes);
//        countryDAO.addCountry(c2);
//        
//        BufferedImage image3 = ImageIO.read(new File(ProjectMetaInfo.imagesResourcesURL + "turkey_flag.png"));
//        ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
//        ImageIO.write(image3, "png", baos3);
//        baos3.flush();
//        byte[] turkeyFlagBytes = baos3.toByteArray();
//        Country c3 = new Country(0, "თურქეთი", turkeyFlagBytes);
//        countryDAO.addCountry(c3);
//        
//        BufferedImage image4 = ImageIO.read(new File(ProjectMetaInfo.imagesResourcesURL + "german_flag.png"));
//        ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
//        ImageIO.write(image4, "png", baos4);
//        baos4.flush();
//        byte[] germanFlagBytes = baos4.toByteArray();
//        Country c4 = new Country(0, "გერმანია", germanFlagBytes);
//        countryDAO.addCountry(c4);
//        
//        // Test -> deleteCountry()
//        countryDAO.deleteCountry(10);
//        
//        // Test -> getCountryByName()
//        try {
//            Country country = countryDAO.getCountryByName("საქართველო");
//            System.out.println(country);
//        } catch (DaoTestException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            Country country = countryDAO.getCountryByName("სომხეთი");
//            System.out.println(country);
//        } catch (DaoTestException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        // Test getAllCountry()
//        List<Country> countries = countryDAO.getAllCountry();
//        System.out.println(countries);
//        
//        countryDAO.closeConnection();
//        
//        // Test addCity()
//        City city1 = new City(0, "თბილისი", 1_108_000, true, 2);
//        cityDAO.addCity(city1);
//        City city2 = new City(0, "ლონდონი", 8_673_000, true, 3);
//        cityDAO.addCity(city2);
//        City city3 = new City(0, "ქუთაისი", 147_000, false, 2);
//        cityDAO.addCity(city3);
//        City city4 = new City(0, "ბათუმი", 152_000, false, 2);
//        cityDAO.addCity(city4);
//        
//        // Test getPopulation()
//        System.out.println(countryDAO.getPopulation("საქართველო"));
//        
//        // Test getCapital()
//        try {
//            System.out.println(countryDAO.getCapital("ინგლისი"));
//        } catch (DaoTestException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        // Test deleteCity()
//        cityDAO.deleteCity(4);
//        
//        // Test getCityByName()
//        List<City> cities = cityDAO.getCityByName("ქუთაისი");
//        System.out.println(cities);
//        
//        List<City> allCity = cityDAO.getAllCity();
//        System.out.println(allCity);
//        
//        // Test getCityInCountry()
//        try {
//            System.out.println(cityDAO.getCityInCountry("თბილისი", "ინგლისი"));
//        } catch (DaoTestException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        // Test getAllCityInCountry();
//        System.out.println(cityDAO.getAllCityInCountry("საქართველო"));
//        
//        cityDAO.closeConnection();
    }
    
}
