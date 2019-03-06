package f19l4exercise.opg2_numberplates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    private final Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds

    private final VehicleType[] vehicleTypes = { // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre", 50000, 84999)
    };

    public NumberPlates() {
        districtMap = new HashMap<>();
        readFile();
    }

    public void readFile() {
        File file = new File("src\\f19l4exercise\\Nummerplader.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(":");
                districtMap.put(split[0], split[1]);
            }
        } catch (FileNotFoundException ignored) {
        }
    }

    public String validate(String plate) {
        try {
            return plate.length() == LENGTH ? validateVehicleType(Integer.parseInt(plate.substring(2))) + " fra " + validateDistrict(plate.substring(0, 2)) : "Illegal length!";
        } catch (NumberFormatException e) {
            return "Illegal length!";
        }
    }

    private String validateDistrict(String districtCode) {
        return districtMap.getOrDefault(districtCode.toUpperCase(), "Kreds findes ikke");
    }

    private String validateVehicleType(int number) {
        Optional<VehicleType> vehicle = Stream.of(vehicleTypes).filter(vehicleType -> vehicleType.isA(number)).findFirst();
        return vehicle.isPresent() ? vehicle.get().getVehicleType() : "Illegalt nummer: " + number;
    }
}
