package f19l4exercise.opg2_numberplates;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import l4c.L4c;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates
{

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    private final Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds

    private final VehicleType[] vehicleTypes =
    {      // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates()
    {
        districtMap = new TreeMap<>();
        readFile();
    }

    public void readFile()
    {
        new Scanner(L4c.class.getResourceAsStream("Nummerplader.txt")).useDelimiter("\r\n").forEachRemaining(t -> districtMap.put(t.split(":")[0], t.split(":")[1])); //My inspiration is from Benzaboi #OneLineForEverything
    }

    public String validate(String plate)
    {
        return plate.length() != LENGTH ? "ERROR: Invalid plate length" : !(validateVehicleType(Integer.decode(plate.substring(2))) + " fra " + validateDistrict(plate.substring(0, 2))).contains("ERROR:") ? validateVehicleType(Integer.decode(plate.substring(2))) + " fra " + validateDistrict(plate.substring(0, 2)) : validateVehicleType(Integer.decode(plate.substring(2))).contains("ERROR:") ? validateVehicleType(Integer.decode(plate.substring(2))) : validateDistrict(plate.substring(0, 2)); //My inspiration is from Benzaboi #OneLineForEverything #TernaryIsLife
    }

    private String validateDistrict(String districtCode)
    {
        return districtMap.getOrDefault(districtCode.toUpperCase(), "ERROR: Invalid districtcode");
    }

    private String validateVehicleType(int number)
    {
        final StringBuilder s = new StringBuilder();
        Arrays.stream(vehicleTypes).forEach(v -> {if(v.isA(number)){s.append(v.getVehicleType());}});
        return s.length() == 0 ? "ERROR: Invalid number" : s.toString();
    }
}
