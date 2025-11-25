public class InterfazUsuario {

    public void iniciarMenu(){
        String nombreProyecto = "CONVERSOR DE MONEDAS";
        String autorProyecto = "ALDO ANTONIO SERRANO RAMIREZ \n";
        String menu = """
                "-----MENU PRINCIPAL-----"
                ---OPCIONES---
                PESO MEXICANO (MXN) A...
                1: (USD) DOLAR ESTADOUNIDENSE
                2: (EUR) EURO
                3: (GBP) LIBRA ESTERLINA
                
                DOLAR ESTADOUNIDENSE (USD) A...
                4: (MXN) PESO MEXICANO
                5: (BRL) REAL BRASILEÑO
                6: (COP) PESO COLOMBIANO
                
                7: SALIR
                
                SELECCIONE UN OPCION DEL 1 AL 7.
                """;

        System.out.println("PROYECTO: " + nombreProyecto);
        System.out.println("AUTOR: " + autorProyecto);
        System.out.println(menu);
    }
}
