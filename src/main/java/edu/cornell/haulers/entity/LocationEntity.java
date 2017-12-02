package edu.cornell.haulers.entity;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.cornell.haulers.constants.DatabaseMappings;

@Document(collection = DatabaseMappings.DB_LOCATIONS)
public class LocationEntity implements Serializable{
	private String id;
	private String subject;

	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private double[] location;

	public LocationEntity(final String subject, final double[] location) {
		this.subject = subject;
		this.location = location;
	}

	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", subject=" + subject + ", location=" + Arrays.toString(location) + "]";
	}

}
