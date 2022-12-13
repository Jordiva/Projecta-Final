/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;

/**
 *
 * @author isard
 */
public class IR_Producte {

    private static final int BUFFER_SIZE = 4096;
    private static String url ;
    private static String user ;
    private static String password ;
    
    /*
    private IR_Producte() throws GestorBDExceptionTOT {
        this("JSP.properties");
    }

    private IR_Producte(String nomFitxerPropietats) throws GestorBDExceptionTOT {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new GestorBDExceptionTOT("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            url = valors[0];
            user = valors[1];
            password = valors[2];
            
        } catch (IOException ex) {
            throw new GestorBDExceptionTOT("Problemes en recuperar l'arxiu de configuració " + nomFitxerPropietats + "\n" + ex.getMessage());
        
    }}
    
    
    */
    public static void iReport(String actiu , String Tipus , String Titol)throws GestorBDExceptionTOT {

        try {
            String  nomFitxerPropietats = "JSP.properties";
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new GestorBDExceptionTOT("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            url = valors[0];
            user = valors[1];
            password = valors[2];
            
            
        } catch (IOException ex) {
            throw new GestorBDExceptionTOT("Problemes en recuperar l'arxiu de configuració " + "\n" + ex.getMessage());
        
    }
        
        if (Tipus == null) {
            Tipus = "";
        }
        if (actiu == null) {
            actiu = "";
        }
        if (Titol == null) {
            Titol = "";
        }
        try {
            url +="?Tipus="+ Tipus +"&Estat="+actiu + "&Nom="+Titol;
                    
                    
            // Si hagués més paràmetres, cal concatenar-los amb: &nomParàmetre=valor&...
            // Si algun paràmetre és col·lecció i s'hi vol passar varis valors, cal anar
            // repetint &nomParàmetre=valor1&nomParàmetre=valor2&...
//            La documentació diu:
//            One of the following formats: pdf, html, xls, xlsx, rtf, csv, xml, docx, odt, ods,
//            jrprint. As of JasperReports Server 6.0, it is also possible to specify json if your
//            reports are designed for data export.
//            Però alguns dels formats indicats no funcionen.
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            String autenticacio = Base64.
                    getEncoder().
                    encodeToString((user+":"+password).getBytes());
            con.setRequestProperty("Authorization", "Basic " + autenticacio);
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String fileName = "";
                String disposition = con.getHeaderField("Content-Disposition");
                String contentType = con.getContentType();
                int contentLength = con.getContentLength();

                if (disposition != null) {
                    // Obtenir el nom del fitxer a partir de la capçalera (Content-Disposition)
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10,
                                disposition.length() - 1);
                    }
                } else {
                    // Obtenir el nom de la URL
                    int posArguments = url.lastIndexOf("?");
                    if (posArguments == -1) { // No hi ha arguments
                        fileName = url.substring(url.lastIndexOf("/") + 1,
                                url.length());
                    } else { // Hi ha arguments i cal eliminar-los per obtenir el nom del fitxer
                        fileName = url.substring(url.lastIndexOf("/") + 1, posArguments);
                    }
                }

                // Obrim InputStream des de HTTP connection
                InputStream inputStream = con.getInputStream();
                // Obrim OutputStream per enregistrar el fitxer
                FileOutputStream outputStream = new FileOutputStream(fileName);
                // Llegim i escrivim
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();

                System.out.println("Arxiu descarregat");
                // Intentem obrir-lo en alguna aplicació del SO
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(new File(fileName));
                    } catch (IOException ex) {
                        System.out.println("No hi ha aplicacions disponibles per obrir el fitxer");
                    }
                }
            } else {
                System.out.println("Mètode 'GET' : " + url);
                System.out.println("Codi resposta: " + responseCode);
                System.out.println("Cap fitxer a descarregar");
            }
            con.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
