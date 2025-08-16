import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
    public List<Photo> photoList = new ArrayList<>();
    public Map<String, Location> cityLocations = new HashMap<>();

    public PhotoManager() {
        cityLocations.put("Cairo", new Location(30.0444, 31.2357, 20));
        cityLocations.put("Giza", new Location(29.9870, 31.2118, 15));
        cityLocations.put("Alexandria", new Location(31.2001, 29.9187, 25));
        cityLocations.put("Luxor", new Location(25.6872, 32.6396, 35));
        cityLocations.put("London", new Location(51.5074, -0.1278, 25));
        cityLocations.put("Paris", new Location(48.8566, 2.3522, 22));
        cityLocations.put("Tokyo", new Location(35.6895, 139.6917, 35));
        cityLocations.put("Dubai", new Location(25.2048, 55.2708, 40));
        cityLocations.put("Berlin", new Location(52.5200, 13.4050, 20));
    }

    public void uploadPhoto(Photo photo){
        Location location = cityLocations.get(photo.getLocationName());
        if(location != null){
            photo.setLatitude(location.getLatitude());
            photo.setLongitude(location.getLongitude());
        }
        photoList.add(photo);
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2){
        final double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    public List<Photo> searchByLocation(String locationName){
        List<Photo> result = new ArrayList<>();
        for(Photo photo : photoList){
            if(photo.getLocationName() == locationName){
                result.add(photo);
            }
        }
        return result;
    }

    public List<Photo> searchByLocation(Location location){
        List<Photo> result = new ArrayList<>();
        for(Photo photo : photoList){
            double distance = calculateDistance(location.getLatitude(), location.getLongitude(), photo.getLatitude(), photo.getLongitude());
            if(distance <= location.getRadius()){
                result.add(photo);
            }
        }
        return result;
    }

    public List<Photo> searchByDate(LocalDate localDate){
        List<Photo> result = new ArrayList<>();
        for(Photo photo : photoList){
            if(photo.getLocalDate().isEqual(localDate)){
                result.add(photo);
            }
        }
        return result;
    }

    public List<Photo> searchByTag(String tag){
        List<Photo> result = new ArrayList<>();
         for(Photo photo : photoList){
             if(photo.getTags().contains(tag)){
                 result.add(photo);
             }
         }
         return result;
    }

    public List<Photo> searchByMultipleTags(Set<String> tags){
        List<Photo> result = new ArrayList<>();
        for(Photo photo : photoList){
            for(String tag : tags){
                if(photo.getTags().contains(tag)){
                    result.add(photo);
                    break;
                }
            }
        }
        return result;
    }

}
