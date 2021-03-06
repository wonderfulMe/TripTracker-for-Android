package eu.wonderfulme.triptracker.database;

import android.content.Context;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import eu.wonderfulme.triptracker.R;

@Entity
public class LocationData implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String timestamp;

    @ColumnInfo(name = "item_key")
    private int itemKey;

    private double latitude;
    private double longitude;
    private double altitude;
    private float speed;

    @ColumnInfo(name = "route_name")
    private String routeName;

    /**
     * this function is used to return the headers for CSV file.
     */
    public static String[] getDbHeaders(Context context) {
        return new String[] {
                context.getResources().getString(R.string.table_header_timestamp),
                context.getResources().getString(R.string.table_header_latitude),
                context.getResources().getString(R.string.table_header_longitude),
                context.getResources().getString(R.string.table_header_altitude),
                context.getResources().getString(R.string.table_header_speed)};
    }

    public static String[] locationCsvRowBuilder(final String timestamp, final double latitude, final double longitude, final double altitude, final float speed) {
        return new String[] {timestamp, String.valueOf(latitude), String.valueOf(longitude),
                String.valueOf(altitude), String.valueOf(speed)};

    }

    //https://stackoverflow.com/a/48088702/6072457
    @Ignore
    public LocationData(@NonNull String timestamp, int itemKey, double latitude, double longitude, double altitude, float speed, String routeName) {
        this.timestamp = timestamp;
        this.itemKey = itemKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
        this.routeName = routeName;
    }

    public LocationData(@NonNull String timestamp, int itemKey, double latitude, double longitude, double altitude, float speed) {
        this.timestamp = timestamp;
        this.itemKey = itemKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @NonNull
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull String timestamp) {
        this.timestamp = timestamp;
    }

    public int getItemKey() { return itemKey; }

    public void setItemKey(int itemKey) { this.itemKey = itemKey; }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getRouteName() { return routeName; }

    public void setRouteName(String routeName) { this.routeName = routeName; }
}
