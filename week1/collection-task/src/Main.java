import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        PhotoManager manager = new PhotoManager();

        // Upload some photos
        manager.uploadPhoto(new Photo(1, "pyramids.jpg", LocalDate.of(2023, 3, 10),
                "Giza", 0, 0, Set.of("pyramids", "history", "egypt", "tourism")));
        manager.uploadPhoto(new Photo(2, "nile.jpg", LocalDate.of(2023, 4, 22),
                "Cairo", 0, 0, Set.of("nile", "river", "sunset", "egypt")));

        manager.uploadPhoto(new Photo(3, "mosque.jpg", LocalDate.of(2023, 4, 22),
                "Cairo", 0, 0, Set.of("mosque", "islamic", "architecture", "egypt")));

        manager.uploadPhoto(new Photo(4, "museum.jpg", LocalDate.of(2023, 5, 15),
                "Cairo", 0, 0, Set.of("museum", "antiquities", "egypt", "pharaohs")));

        // Search by single tag
        System.out.println("Photos with tag 'egypt':");
        manager.searchByTag("egypt").forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();

        // Search by date
        System.out.println("Photos taken on 2023-04-22:");
        manager.searchByDate(LocalDate.of(2023, 4, 22)).forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();

        // Search by location Name
        System.out.println("Photos taken in Giza:");
        manager.searchByLocation("Giza").forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();

        // Search by location Cordinates
        System.out.println("Photos taken in Locatin (30.0, 31.2, 20):");
        manager.searchByLocation(new Location(30.0, 31.2, 20)).forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();

        // Search by multiple tags
        System.out.println("Photos with tags [egypt, museum]:");
        manager.searchByMultipleTags(Set.of("egypt", "museum")).forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println();
    }
}