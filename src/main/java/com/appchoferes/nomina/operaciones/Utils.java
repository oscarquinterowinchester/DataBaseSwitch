package com.appchoferes.nomina.operaciones;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.config.FileStorageProperties;

@Component
public class Utils {

    @Autowired
    FileStorageProperties imageProps;

public void establecerBaseDatos(String baseDatos)
    {
        DatabaseContextHolder.setDatabaseType(baseDatos);   
    }

    public static String toStr(float valor)
    {

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public static String toStr(int valor)
    {

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public void throwRunTimeException(String mensaje){

        throw new RuntimeException(mensaje);
    }

    public static String toStr(Object valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }
    

    public static String toStr(Double valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public String saveBase64Image(String base64Image, String fileName)  {
        
        
        File file = null;
        
        // Divide el string Base64 para separar el encabezado del contenido
        String[] parts = null;
        
        try{
        parts = base64Image.split(",");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Formato Base64 inválido");
        }

        String data = parts[1];

        // Decodifica el contenido Base64
        byte[] decodedBytes = Base64.getDecoder().decode(data);

        // Define la ruta completa del archivo
         file = new File(imageProps.getBasePath() + fileName);
        
         System.out.println("RUTA: "+imageProps.getBasePath() + fileName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // Guarda los bytes decodificados en el archivo
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(decodedBytes);
        }

    }catch(IOException e){
        return "";
    }
    // catch(NullPointerException e){
    //     return "";
    // }
        // Retorna la ruta relativa o absoluta

        String relativePath = fileName;
    
        return relativePath;
    }
    
}
