package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * 
 * @author brantansp
 *
 */

public class XMLHelper {
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

    public XMLHelper(){
        try{
            this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
            this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException pce){
            //log error
        }
    }
    
    public static void writeRequestToText(String req) throws FileNotFoundException
    {
        XMLHelper xmlHelper = new XMLHelper();
        
        Properties prop = new Properties();
        Object nu = new Object();
        File dir = new File(".\\Requests");
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    	}
    	String savestr = "requests.properties"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;//new PrintWriter(file);
    	StringBuilder sb = new StringBuilder();
    	if(file.exists() )
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
            try {
          	  
           	 //String xmlDoc = "<UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF48</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI>";
           	  String xmlDoc = "<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><ListRegPayee xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req><LastRec i:type=\"d:string\">1</LastRec><TypeInd i:type=\"d:string\">VIR</TypeInd><RecCount i:type=\"d:string\">1</RecCount><UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF48</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI></req></ListRegPayee></v:Body></v:Envelope>";
             // String xmlDoc = req;  
           	  String transactionName = xmlDoc.substring(xmlDoc.lastIndexOf("<v:Body><")+9, xmlDoc.lastIndexOf(" xmlns="));
                 sb.append("#");
                 sb.append(transactionName);
                 sb.append('\n');
                 sb.append("Request");
                 sb.append("=");
                 sb.append(transactionName);
                 sb.append('\n');
                 xmlDoc = xmlDoc.substring(xmlDoc.lastIndexOf("<UPI>"), xmlDoc.lastIndexOf("</UPI>")+6);
           	  
                // String xmlDoc = "<?xml version="1.0"?><flatFields><java>6.0</java><xml>yes</xml><tags>given tags</tags><doc /><multipleRow /></flatFields>";
                 Document doc = xmlHelper.getDocumentBuilder().parse(
                         xmlHelper.getInputStream(xmlDoc));
                 NodeList nodeLst = doc.getDocumentElement().getChildNodes();
                 Map<String, String> elemen = xmlHelper.getElementKeyValue(nodeLst);
                 Iterator<?> it = elemen.entrySet().iterator();
                 while (it.hasNext()) {
                     Map.Entry pairs = (Map.Entry)it.next();
                     	System.out.println(pairs.getKey() +"=" + pairs.getValue());
                     	sb.append(pairs.getKey());
                     	sb.append("=");
                     	sb.append(pairs.getValue());
                     	sb.append('\n');
                 }
               } catch (SAXParseException e) {
                  //log error
               } catch (SAXException e) {
                      //log error
               } catch (IOException e) {
                      //log error
               }
    	}else{
    		System.out.println("Not");
    		pw = new PrintWriter(file);
    	}
    	sb.append('\n');
        pw.write(sb.toString());
        pw.close();
    
    }

    //Simple test
    public static void main(String argv[]) throws IOException {
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\xmlrequests"))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	//System.out.println(line);
    	    	writeRequestToText(line);
    	    }
    	}
      
    }

    public NodeList getNodeListByTag(Document doc, String tagname){
        NodeList nodeList = null;
        if (doc !=null && !tagname.isEmpty()){
            nodeList = doc.getElementsByTagName(tagname);
        }
        return nodeList;
    }

    public Map<String, String> getElementKeyValue(NodeList nodeList){
        Map<String, String> elements = new HashMap<String, String>();
        if (nodeList!=null && nodeList.getLength()>0 ){
            for(int i=0 ; i < nodeList.getLength() ; i++){
                Node node = nodeList.item(i); //Take the node from the list
                NodeList valueNode = node.getChildNodes(); // get the children of the node
                String value = (valueNode.item(0)!=null) ? valueNode.item(0).getNodeValue() : "";
                elements.put(node.getNodeName(), value);
            }
        }
        return elements;
    }

    public InputStream getInputStream(String string){
        InputStream inputStream = null;
        if (!string.isEmpty()){
            try{
                inputStream = new ByteArrayInputStream(string.getBytes("UTF-8"));
            }
            catch(UnsupportedEncodingException uee){
            }
        }
        return inputStream;
    }

    public DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }
    public void setDocumentBuilderFactory(
            DocumentBuilderFactory documentBuilderFactory) {
        this.documentBuilderFactory = documentBuilderFactory;
    }
    public DocumentBuilder getDocumentBuilder() {
        return documentBuilder;
    }
    public void setDocumentBuilder(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }
}