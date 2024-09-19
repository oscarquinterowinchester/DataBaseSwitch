package com.appchoferes.nomina.operaciones;

import com.appchoferes.nomina.config.DatabaseContextHolder;

public class Utils {

public static void establecerBaseDatos(String baseDatos)
    {
        DatabaseContextHolder.setDatabaseType(baseDatos);   
    }

    
}
