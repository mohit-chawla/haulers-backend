package edu.cornell.haulers.entity;

import java.io.Serializable;
import java.util.Objects;

public class LocationEntry implements Serializable {
  private String longitude;
  private String latitude;

  public String getLongitude() {
    return this.longitude;
  }

  public void setLongitude(final String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public void setLatitude(final String latitude) {
    this.latitude = latitude;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    final LocationEntry that = (LocationEntry) o;
    return Objects.equals(this.getLongitude(), that.getLongitude()) &&
      Objects.equals(this.getLatitude(), that.getLatitude());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getLongitude(), this.getLatitude());
  }
}