package utility;

import model.User;

public class CityValidator {

    public static boolean isFanCodeCity(User user)
    {
        double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
        double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
        return lat>-40 && lat<5 && lng>5 && lng<100;
    }
}
