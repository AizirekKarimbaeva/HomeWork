package org.example;

import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {



        Company company = new Company("Anna","Kievskaya");
        Company company2 = new Company("Lena","Zorge");
        Driver  driver = new Driver("Asan",23);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver);
        company.setDrivers(drivers);

        Car car = new Car("MERS","Mersedez");
        driver.setCar(car);



        Farm farm = new Farm("Aizirek","Aizirek");
        Farm farm1 = new Farm("Alan","Alan");
        Animal animal = new Animal();
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        farm.setAnimals(animals);

        Plant plant = new Plant("Monkey","Banana");
        List<Plant> plants = new ArrayList<>();
        plants.add(plant);
        animal.setPlant(plant);

        Shop shop = new Shop("phone","USA");
        Shop shop1 = new Shop("phone","America");
        Phone phone = new Phone("Apple",100000);
        List<Phone>phones = new ArrayList<>();
        phones.add(phone);
        phone.setShop(shop);

        User user = new User("Aizirek",20);
        List<Company>companies = new ArrayList<>();
        companies.add(company);
        user.setC(companies);

        List<Farm> farms = new ArrayList<>();
        farms.add(farm);
        user.setF(farms);

        List<Shop> shops = new ArrayList<>();
        shops.add(shop);
        user.setS(shops);


     create(user);
    }
    public static Long create (User u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(u);
        session.getTransaction().commit();
        session.close();
        return u.getId();
    }
}
