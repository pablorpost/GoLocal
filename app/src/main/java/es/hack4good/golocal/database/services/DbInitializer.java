package es.hack4good.golocal.database.services;

import java.util.Arrays;
import java.util.List;
import es.hack4good.golocal.database.AppDatabase;

import es.hack4good.golocal.database.dao.StoreDAO;
import es.hack4good.golocal.database.entity.Order;
import es.hack4good.golocal.database.entity.Store;
import es.hack4good.golocal.database.entity.User;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.Location;
import es.hack4good.golocal.models.ProductType;

public class DbInitializer {

    public static void initialize(AppDatabase db) {
        if(db.productDAO().getAllProducts().isEmpty()) {
            StoreDAO sdao = db.storeDAO();
            // Insert stores
            List<String> names = Arrays.asList("Bar Pepe", "Ca' Manolo", "Cerveceria El Gustazo", "El Rincon de Rick", "Elite II", "La Tahona", "Granja Antonio", "Las Costuras de Amelia");
            List<String> locations = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            List<String> images = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            List<String> descriptions = Arrays.asList("Bar Pepe description", "Ca' Manolo description", "Cerveceria El Gustazo description", "El Rincon de Rick description", "Elite II description", "La Tahona description", "Granja Antonio description", "Las Costuras de Amelia description");
            List<String> phones = Arrays.asList("Bar Pepe phone", "Ca' Manolo phone", "Cerveceria El Gustazo phone", "El Rincon de Rick phone", "Elite II phone", "La Tahona phone", "Granja Antonio phone", "Las Costuras de Amelia phone");
            List<String> emails = Arrays.asList("Bar Pepe email", "Ca' Manolo email", "Cerveceria El Gustazo email", "El Rincon de Rick email", "Elite II email", "La Tahona email", "Granja Antonio email", "Las Costuras de Amelia email");
            List<String> webs = Arrays.asList("barPepe.es", "caManolo.es", "cerveceriaElGustazo.es", "elRinconDeRick.es", "eliteII.es", "laTahona.es", "granjaAntonio.es", "lasCosturasDeAmelia.es");
            for (int i = 0; i < names.size(); i++) {
                sdao.insert(new Store( names.get(i), locations.get(i), images.get(i), descriptions.get(i), phones.get(i), emails.get(i), webs.get(i)));
            }
            // Insert products
            List<String> productNamesBarPepe = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesCaManolo = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesCerveceriaElGustazo = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesElRinconDeRick = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesEliteII = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesLaTahona = Arrays.asList("Cerveza", "Vino", "Coca Cola", "Fanta", "Papas", "Aceitunas", "Tortilla", "Bocadillo");
            List<String> productNamesGranjaAntonio = Arrays.asList("Jamon", "Queso", "Leche", "Yogur", "Huevos", "Pan", "Mantequilla", "Mermelada");
            List<String> productNamesLasCosturasDeAmelia = Arrays.asList("Camisa", "Pantalon", "Vestido", "Falda", "Jersey", "Chaqueta", "Calcetines", "Zapatos");
            List<String> productDescriptionsBares = Arrays.asList("Cerveza description", "Vino description", "Coca Cola description", "Fanta description", "Papas description", "Aceitunas description", "Tortilla description", "Bocadillo description");
            List<String> productDescriptionsGranjaAntonio = Arrays.asList("Jamon description", "Queso description", "Leche description", "Yogur description", "Huevos description", "Pan description", "Mantequilla description", "Mermelada description");
            List<String> productDescriptionsLasCosturasDeAmelia = Arrays.asList("Camisa description", "Pantalon description", "Vestido description", "Falda description", "Jersey description", "Chaqueta description", "Calcetines description", "Zapatos description");
            List<Double> pricesBarPepe = Arrays.asList(1.0, 2.0, 1.5, 1.5, 1.0, 1.0, 2.0, 3.0);
            List<Double> pricesCaManolo = Arrays.asList(1.2, 2.2, 1.7, 1.7, 1.2, 1.2, 2.2, 3.2);
            List<Double> pricesCerveceriaElGustazo = Arrays.asList(1.3, 2.3, 1.8, 1.8, 1.3, 1.3, 2.3, 3.3);
            List<Double> pricesElRinconDeRick = Arrays.asList(1.4, 2.4, 1.9, 1.9, 1.4, 1.4, 2.4, 3.4);
            List<Double> pricesEliteII = Arrays.asList(1.1, 2.1, 1.6, 1.6, 1.1, 1.1, 2.1, 3.1);
            List<Double> pricesLaTahona = Arrays.asList(1.5, 2.5, 2.0, 2.0, 1.5, 1.5, 2.5, 3.5);
            List<Double> pricesGranjaAntonio = Arrays.asList(4.0, 5.0, 1.0, 1.0, 2.0, 1.0, 2.0, 3.0);
            List<Double> pricesLasCosturasDeAmelia = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0);
            List<ProductType> typesBares = Arrays.asList(ProductType.DRINK, ProductType.DRINK, ProductType.DRINK, ProductType.DRINK, ProductType.FOOD, ProductType.FOOD, ProductType.FOOD, ProductType.FOOD);
            List<ProductType> typesGranjaAntonio = Arrays.asList(ProductType.FOOD, ProductType.FOOD, ProductType.DRINK, ProductType.FOOD, ProductType.FOOD, ProductType.FOOD, ProductType.FOOD, ProductType.FOOD);
            List<ProductType> typesLasCosturasDeAmelia = Arrays.asList(ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING, ProductType.CLOTHING);
            List<String> imagesBares = Arrays.asList(null, null, null, null, null, null, null, null);
            List<String> imagesGranjaAntonio = Arrays.asList(null, null, null, null, null, null, null, null);
            List<String> imagesLasCosturasDeAmelia = Arrays.asList(null, null, null, null, null, null, null, null);
            List<Integer> stocksBares = Arrays.asList(100, 100, 100, 100, 100, 100, 100, 100);
            List<Integer> stocksGranjaAntonio = Arrays.asList(20,40,30,40,50,60,70,80);
            List<Integer> stocksLasCosturasDeAmelia = Arrays.asList(12,21,6,7,8,9,10,11);
            for (int i = 0; i < productNamesBarPepe.size(); i++) {
                db.productDAO().insertProduct(new Product(productNamesBarPepe.get(i), productDescriptionsBares.get(i), pricesBarPepe.get(i), typesBares.get(i), 0, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesCaManolo.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesCaManolo.get(i), productDescriptionsBares.get(i), pricesCaManolo.get(i), typesBares.get(i), 1, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesCerveceriaElGustazo.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesCerveceriaElGustazo.get(i), productDescriptionsBares.get(i), pricesCerveceriaElGustazo.get(i), typesBares.get(i), 2, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesElRinconDeRick.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesElRinconDeRick.get(i), productDescriptionsBares.get(i), pricesElRinconDeRick.get(i), typesBares.get(i), 3, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesEliteII.size(); i++) {
                db.productDAO().insertProduct(new Product(productNamesEliteII.get(i), productDescriptionsBares.get(i), pricesEliteII.get(i), typesBares.get(i), 4, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesLaTahona.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesLaTahona.get(i), productDescriptionsBares.get(i), pricesLaTahona.get(i), typesBares.get(i), 5, imagesBares.get(i), stocksBares.get(i)));
            }
            for (int i = 0; i < productNamesGranjaAntonio.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesGranjaAntonio.get(i), productDescriptionsGranjaAntonio.get(i), pricesGranjaAntonio.get(i), typesGranjaAntonio.get(i), 6, imagesGranjaAntonio.get(i), stocksGranjaAntonio.get(i)));
            }
            for (int i = 0; i < productNamesLasCosturasDeAmelia.size(); i++) {
                db.productDAO().insertProduct(new Product( productNamesLasCosturasDeAmelia.get(i), productDescriptionsLasCosturasDeAmelia.get(i), pricesLasCosturasDeAmelia.get(i), typesLasCosturasDeAmelia.get(i), 7, imagesLasCosturasDeAmelia.get(i), stocksLasCosturasDeAmelia.get(i)));
            }
            // Insert users
            List<String> userNames = Arrays.asList("user1", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9", "user10");
            List<String> userEmails = Arrays.asList("user1@gmail.com", "user2@gmail.com", "user3@gmail.com", "user4@gmail.com", "user5@gmail.com", "user6@gmail.com", "user7@gmail.com", "user8@gmail.com", "user9@gmail.com", "user10@gmail.com");
            List<String> passwords = Arrays.asList("chickenBURGAH1", "chickenBURGAH2", "chickenBURGAH3", "chickenBURGAH4", "chickenBURGAH5", "chickenBURGAH6", "chickenBURGAH7", "chickenBURGAH8", "chickenBURGAH9", "chickenBURGAH10");
            List<String> userPhones = Arrays.asList("user1 phone", "user2 phone", "user3 phone", "user4 phone", "user5 phone", "user6 phone", "user7 phone", "user8 phone", "user9 phone", "user10 phone");
            List<String> userLocations = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            List<String> userImages = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            for (int i = 0; i < userNames.size(); i++) {
                db.userDAO().insertUser(new User( userNames.get(i), userEmails.get(i), passwords.get(i).hashCode(), userPhones.get(i), userLocations.get(i), userImages.get(i)));
            }
            // Insert orders

        }
    }
}
