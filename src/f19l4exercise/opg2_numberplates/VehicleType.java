package f19l4exercise.opg2_numberplates;

/**
 * VOP eksamen F2014 Hjaelpe klasse til opgave 2
 *
 * @author erso
 */
public class VehicleType {

    private final String type;
    private final int min;
    private final int max;

    public VehicleType(String type, int min, int max) {
        this.type = type;
        this.min = min;
        this.max = max;
    }

    public boolean isA(int number) {
        return number >= min && number <= max;
    }

    public String getVehicleType() {
        return type;
    }

}
