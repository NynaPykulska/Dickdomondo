import java.util.ArrayList;

/**
 * Created by m on 17.04.16.
 */
public class YoloConverter {

    /**
     *  Latitude
     *  1' ~ 1,853km
     *
     *  Longtitude
     *  1' = 1,191km
     */

	/*
		0,0001 - 7,871m
		https://rechneronline.de/geo-coordinates/
	*/

    private final double latRatio = 0.53966;
    private final double longRatio = 0.83963;
    private Preferences preferences;
    //private ArrayList<GeoVector> results;
    private ArrayList<Vector> vectors;

    public YoloConverter(Preferences preferences, ArrayList<Vector> vectors) {
        this.preferences = preferences;
        this.vectors = vectors;
    }

    public void setVectors(ArrayList<Vector> vectors) {
        this.vectors = vectors;
    }

    public ArrayList<GeoVector> getGeoVector() {

        ArrayList<GeoVector> results = convertToGeo();

        return results;
    }

    private ArrayList<GeoVector> convertToGeo() {
        int len = preferences.length;
        double x1, x2, y1, y2;
        double sum = 0;

        ArrayList<GeoVector> results = new ArrayList<>();

        /**
         * Sprawdzanie dlugosci wektorow
         */

        for (int i = 0; i < vectors.size(); i++) {
            x1 = vectors.get(i).getStart().getX();
            x2 = vectors.get(i).getEnd().getX();
            y1 = vectors.get(i).getStart().getY();
            y2 = vectors.get(i).getEnd().getY();
            sum +=Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        }

        double ratio = len/sum;
        double deltaLat, deltaLon;

        for (int i = 0; i < vectors.size(); i++) {
            //y
            deltaLat = (vectors.get(i).getEnd().getY() - vectors.get(i).getStart().getY())*ratio; //[km]
            //x
            deltaLon = (vectors.get(i).getEnd().getX() - vectors.get(i).getStart().getX())*ratio; //[km]

            /**
             *
             * Konwersja na stopnie/minuty
             *
             */

            results.add(new GeoVector(deltaLon*longRatio, deltaLat*latRatio));

        }

        return results;

    }

}
