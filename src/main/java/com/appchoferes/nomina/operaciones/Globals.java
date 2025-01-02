package com.appchoferes.nomina.operaciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
final public class Globals {



   final static double  MAX_DISTANCIA = 4000;

   @Value("${file.storage.base-path}")
   private static String BASE_PATH;

   @Value("${file.storage.image-extension}")
   private static String IMG_EXTENSION;

   public static String gatBasePath(){

      return BASE_PATH;
   }

   public static String gatImageExtension(){

      return IMG_EXTENSION;
   }

}
