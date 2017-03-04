package elections.dao.service;

import elections.dao.entities.ElectionsException;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.nio.file.OpenOption;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.Option;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import elections.dao.entities.ListeElectorale;

public class IoUtil{
	
		
	public static boolean saveListesToFile(List<ListeElectorale> listesElectorales, String logFile, String outFile){
		
		boolean saved = false;
		List<ListeElectorale> listes = new ArrayList<ListeElectorale>();
		
			
		
		//On convertit le tableau de listes en XML
		String listesStr = convertToXml(listes);
		Path path = Paths.get(outFile);
		Charset charset = Charset.forName("UTF-8");
		
		//Ecriture des listes 
		try(BufferedWriter writer = Files.newBufferedWriter(path, charset, StandardOpenOption.CREATE_NEW)){
			
			writer.write(listesStr, 0, listesStr.length());
			saved = true;
			
		}catch(IOException e){
			e.printStackTrace();
			
			try {
				Path pathLog = Paths.get(logFile);
				BufferedWriter logWriter = Files.newBufferedWriter(pathLog, StandardOpenOption.APPEND);
				logWriter.write(LocalDateTime.now() + " "+ e.getMessage()+"\n");
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return saved;
	}
	
	public static List<ListeElectorale> getListesFromFile(String fileName){
		
		List<ListeElectorale> listes = new ArrayList<ListeElectorale>();
		String str = getStringFromFile(fileName);
		listes = convertFromXml(str);
		
		return listes;
	}
	
	public static String getStringFromFile(String fileName){
		
		String str = null;
		try{
			
			str = new String(Files.readAllBytes(Paths.get(fileName)));
		}catch(IOException e){
			
			e.getMessage();
			e.printStackTrace();
		}
		return str;
	}
	
	public static List getInitDataFromFile(String fileName) throws IOException{
		
		ArrayList initList = new ArrayList();
		
		//Chaque ligne du fichier est copiée dans un emplacement de la liste initList
		
		initList = (ArrayList)Files.readAllLines(FileSystems.getDefault().getPath(fileName));
		
		if((initList.get(0) instanceof Integer) && (initList.get(1) instanceof Double)) {
			for(int i = 2; i < initList.size(); i++){
				if(!(initList.get(i) instanceof String)){
					throw new ElectionsException(1,"Les données dans le fichier ne sont pas valides");
				}
			}
		}else 
			throw new ElectionsException(1, "Les données dans le fichier ne sont pas valides");
		
		return initList;
	}
	
	public static String convertToXml(List<ListeElectorale> listes){
		
		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(listes);
		return xml;
	}
	
	
	public static List<ListeElectorale> convertFromXml(String xml){
		
		List<ListeElectorale> listes = new ArrayList<ListeElectorale>();
		XStream stream = new XStream(new DomDriver());
		listes = (List)stream.fromXML(xml);
		return listes;
	}
}
