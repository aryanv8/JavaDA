/*
 * This file is the interface for the Organisable class.
 */
package organiser;

import java.util.Date;

public interface OrganisableInterface {

  public String getName();

  public void setName(String name);

  public String getDescription();

  public void setDescription(String description);

  public String getLocation();

  public void setLocation(String location);

  public Date getDate();

  public void setDate(String date);

  public String getTime();

  public void setTime(String time);

  public String getDuration();

  public void setDuration(String duration);
  
}