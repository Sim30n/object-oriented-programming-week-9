package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    SmartpostHandler smartposthandler = SmartpostHandler.getInstance();
    Context context = null;
    Spinner smartpostAutomaatit;
    Spinner maa;
    Spinner pv;
    Spinner klo;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        context = MainActivity.this;
        System.out.println("KANSION SIJAINTI " + context.getFilesDir());
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        readXMLSuomi();
        readXMLViro();

        String[] maat = new String[] {
                "Suomi", "Viro"
        };
        maa = (Spinner) findViewById(R.id.maa);
        ArrayAdapter<String> maaAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, maat);
        maaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maa.setAdapter(maaAdapter);

        String[] paivat = new String[] {
                "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai", "Sunnuntai"
        };
        pv = (Spinner) findViewById(R.id.pv);
        ArrayAdapter<String> pvAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, paivat);
        pvAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pv.setAdapter(pvAdapter);

        String[] ajat = new String[] {
                "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14"
                , "15", "16", "17", "18", "19", "20", "21", "22", "23"
        };
        klo = (Spinner) findViewById(R.id.klo);
        ArrayAdapter<String> kloAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ajat);
        kloAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        klo.setAdapter(kloAdapter);
    }

    public void readXMLSuomi(){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "http://iseteenindus.smartpost.ee/api/?request=destinations&country=FI&type=APT";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getElementsByTagName("item");
            for (int i = 0; i<nList.getLength(); i++){
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    String availability = element.getElementsByTagName("availability").item(0).getTextContent();
                    String postalcode = element.getElementsByTagName("postalcode").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String country = element.getElementsByTagName("country").item(0).getTextContent();
                    smartposthandler.addSmartpostSuomi(name, city, availability, postalcode, address, country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("###############DONE#################");
        }
    }

    public void readXMLViro(){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "http://iseteenindus.smartpost.ee/api/?request=destinations&country=EE&type=APT";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getElementsByTagName("item");
            for (int i = 0; i<nList.getLength(); i++){
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    String availability = element.getElementsByTagName("availability").item(0).getTextContent();
                    String postalcode = element.getElementsByTagName("postalcode").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String country = element.getElementsByTagName("country").item(0).getTextContent();
                    smartposthandler.addSmartpostViro(name, city, availability, postalcode, address, country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("###############DONE#################");
        }
    }

    public void smartDropdown(View v){
        ArrayList<String> smartposts =  new ArrayList<String>();
        for (int i = 0; i<smartposthandler.smartpost_array_suomi.size(); i++){
            smartposts.add(smartposthandler.smartpost_array_suomi.get(i).getName());
        }
        smartpostAutomaatit = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> smartpostAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, smartposts);
        smartpostAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smartpostAutomaatit.setAdapter(smartpostAdapter);
    }

    public void moreInfo(View v){
        String name = "";
        String city = "";
        String availability = "";
        String postalcode = "";
        String address = "";
        String country = "";
        String text_value = smartpostAutomaatit.getSelectedItem().toString();
        for (int i = 0; i<smartposthandler.smartpost_array_suomi.size(); i++){
            if(smartposthandler.smartpost_array_suomi.get(i).getName() == text_value){
                name = smartposthandler.smartpost_array_suomi.get(i).getName();
                city = smartposthandler.smartpost_array_suomi.get(i).getCity();
                availability = smartposthandler.smartpost_array_suomi.get(i).getAvailability();
                postalcode = smartposthandler.smartpost_array_suomi.get(i).getPostalcode();
                address = smartposthandler.smartpost_array_suomi.get(i).getAddress();
                country = smartposthandler.smartpost_array_suomi.get(i).getCountry();
            }
        }
        String print_text = name + "\n" + country +"\n" + city  + " " + postalcode + "\n" + address + "\n" +availability;
        text.setText(print_text);
    }
}
