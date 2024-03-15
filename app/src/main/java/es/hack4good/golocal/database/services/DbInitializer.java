package es.hack4good.golocal.database.services;

import java.util.Arrays;
import java.util.List;
import es.hack4good.golocal.database.AppDatabase;

import es.hack4good.golocal.database.entity.Order;
import es.hack4good.golocal.database.entity.Store;
import es.hack4good.golocal.models.Location;

public class DbInitializer {

    public void initialize(AppDatabase db) {
        if(db.productDAO().getAllProducts().isEmpty()) {
            // Insert stores
            List<String> names = Arrays.asList("Carrefour", "Mercadona", "Lidl", "Aldi", "Dia", "El Corte Inglés", "Alcampo", "Eroski", "Consum", "Caprabo");
            List<Location> locations = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            List<String> images = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
            List<String> descriptions = Arrays.asList("Carrefour description", "Mercadona description", "Lidl description", "Aldi description", "Dia description", "El Corte Inglés description", "Alcampo description", "Eroski description", "Consum description", "Caprabo description");
            List<String> phones = Arrays.asList("Carrefour phone", "Mercadona phone", "Lidl phone", "Aldi phone", "Dia phone", "El Corte Inglés phone", "Alcampo phone", "Eroski phone", "Consum phone", "Caprabo phone");
            List<String> emails = Arrays.asList("Carrefour email", "Mercadona email", "Lidl email", "Aldi email", "Dia email", "El Corte Inglés email", "Alcampo email", "Eroski email", "Consum email", "Caprabo email");
            List<String> webs = Arrays.asList("Carrefour web", "Mercadona web", "Lidl web", "Aldi web", "Dia web", "El Corte Inglés web", "Alcampo web", "Eroski web", "Consum web", "Caprabo web");
            for (int i = 0; i < names.size(); i++) {
                db.storeDAO().insertStore(new Store(i, names.get(i), locations.get(i), images.get(i), descriptions.get(i), phones.get(i), emails.get(i), webs.get(i)));
            }
            // Insert products

            // Insert users

            // Insert orders

        }
    }
}
