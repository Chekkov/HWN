package converter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.tree.ExpandVetoException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

/**
 * @author D057673
 *
 */
public class HwnXml2CsvConverter {
	public static void main(String[] args) {
		String file2read1 = "D:\\Eclipse_Luna\\bp_ws\\HWN\\hwn_persdata.xml";
		String file2write1 = "Bernd_hwn_persdata.csv";
		String file2read2 = "Moni_hwn_persdata.xml";
		String file2write2 = "Moni_hwn_persdata.csv";

		try {
			List<Stempel> stempelList = xml2StempelList(file2read1);
			
			// // Kontrollausgabe
//			 for (Stempel stempel : stempelList) {
//			 System.out.println(stempel.getNumber().toString() + " :: " +
//			 stempel.getFound().toString());
//			 }
			// Stempelliste 1 in einer Map Speichern
			// Key = Stempelstellennummer, Value= Stempel
			// (found,nummer,rating,stamptime)
			Map<Integer, Stempel> stempelMap = new HashMap<>(222);
			for (Stempel stempel : stempelList) {
				stempelMap.put(new Integer(stempel.getNumber()), stempel);
			}
			write2csv(stempelList, file2write1);
			// Stempelliste 2
			// xmlFile = new File(file2read2);
			// hwn = (HWNObject) unmarshaller.unmarshal(xmlFile);
			//
			// stempelList = hwn.achievements.getStempelList();
			// // Stempelstellen ergänzen
			// stempelList = hwn.achievements.expandStempelList(stempelList);
			// Collections.sort(stempelList);
			// csvFile = new File(file2write2);
			// FileUtils.write(csvFile, Stempel.getHeader());
			// }
			// Kontrollausgabe
//			for (Entry<Integer, Stempel> stempelEntry : stempelMap.entrySet()) {
//				System.out.println(stempelEntry.getKey() + " :: "
//						+ stempelEntry.getValue().toString());
//
//			}
			// Stempelliste 2
			 stempelList = xml2StempelList (file2read2);
			 Collections.sort(stempelList);
			 // Kontrollausgabe
//			 for (Stempel stempel : stempelList) {
//			 System.out.println(stempel.getNumber().toString() + " :: " +
//			 stempel.getFound().toString());
//			 }
			 write2csv(stempelList, file2write2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void write2csv(List<Stempel> stempelList, String file2write)
			throws IOException {

		File csvFile = new File(file2write);
		FileUtils.write(csvFile, Stempel.getHeader());
		for (Stempel stempel : stempelList) {

			FileUtils.write(csvFile, stempel.toString() + "\n", true);
		}
	}

	private static List<Stempel> xml2StempelList(String file2read) {

		JAXBContext context;
		List<Stempel> stempelList = null;

		try {
			context = JAXBContext.newInstance(HWNObject.class);
			final Unmarshaller unmarshaller = context.createUnmarshaller();;
			//unmarshaller = context.createUnmarshaller();
			File xmlFile = new File(file2read);
			final HWNObject hwn = (HWNObject) unmarshaller.unmarshal(xmlFile);
			stempelList = hwn.achievements.getStempelList();
			stempelList = HWNAchievements.expandStempelList(stempelList);
			Collections.sort(stempelList);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stempelList;

	}
	


	/**
	 * 
	 */
	void thingsToLearn() {
		Collections.disjoint(null, null);
		List<Stempel> list = new ArrayList<>();
		list.retainAll(null);
		list.containsAll(null);
	}
}