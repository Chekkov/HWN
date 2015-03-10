package converter;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "stempel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stempel implements Comparable<Stempel> {

	private final static String DELIMITER = ";";
	private final static String CRLF = "\n";
	//private enum CompareResult {none,s1,s2,both};

	public static String getHeader() {
		return "Stempelnummer" + DELIMITER + "found" + DELIMITER + "rating"
				+ DELIMITER + "stamptime" + DELIMITER + "Comparison" + DELIMITER + "Description" + DELIMITER + "Coordinates" + CRLF;
	}

	private Boolean found = false;
	private Integer nummer = -1;
	private String rating = "0.0";
	private Date stamptime = null;
	private Integer comp = 0;
	//private CompareResult compareResult = 3;
	private String description = "";
	private String coordinates = "";
	public Stempel() {
	}

	
	@ConstructorProperties("number")
	public Stempel(int i) {
		nummer = i;
	}

	@Override
	public int compareTo(Stempel stempel) {

		if (nummer.intValue() < stempel.getNumber().intValue()) {
			return -1;
		} else if (nummer.intValue() > stempel.getNumber().intValue()) {
			return 1;
		} else {
			return 0;
		}

		// return nummer.compareTo(stempel.getNummer());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stempel other = (Stempel) obj;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		return true;
	}

	public Boolean getFound() {
		return found;
	}

	public Integer getNumber() {
		return nummer;
	}

	public String getRating() {
		return rating;
	}

	public Date getStamptime() {
		return stamptime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		return result;
	}

	public void setFound(Boolean found) {
		this.found = found;
	}

	public void setNummer(Integer nummer) {
		this.nummer = nummer;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setStamptime(Date stamptime) {
		this.stamptime = stamptime;
	}
	
	public void setComp(Integer comp){
		this.comp = comp;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	

	public void setCoordinates(String coordinates){
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		// return "Stempel [nummer=" + nummer + ", found=" + found + ", rating="
		// + rating + ", stamptime=" + stamptime + "]";
		return nummer + DELIMITER + found + DELIMITER + rating + DELIMITER
				+ stamptime + DELIMITER + comp + DELIMITER + description + DELIMITER + coordinates;
	}

}