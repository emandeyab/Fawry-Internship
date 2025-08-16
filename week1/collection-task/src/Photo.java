import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Photo {
    private int id;
    private String name;
    private LocalDate localDate;
    private String locationName;
    private double latitude;
    private double longitude;
    private Set<String> tags;

    public Photo(int id, String name, LocalDate localDate, String locationName, double latitude, double longitude, Set<String> tags){
        this.id = id;
        this.name = name;
        this.localDate = localDate;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "fileName='" + name + '\'' +
                ", dateTaken=" + localDate +
                ", locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", tags=" + tags +
                '}';
    }

}
