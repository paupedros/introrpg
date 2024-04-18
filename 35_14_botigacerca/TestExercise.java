import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class TestExercise {

    /* ************************************************************************* *
     *  Test de UtilString                                                       *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests de UtilString.normalitzaString()")
    class SobreUtilString {
        @ParameterizedTest
        @CsvSource(value={
        "'   nom',nom",
        "'nom   ',nom",
        "'nom   cognom1   cognom2', 'nom cognom1 cognom2'",
        "'nom cognom1 cognom2', 'nom cognom1 cognom2'",
        "'  Nom  Cognom1 Cognom2 ', 'Nom Cognom1 Cognom2'",
        "null,null",
        "'', null",
        "'   ', null"
        }, nullValues={"null"})
        @DisplayName("test normalitzaString()")
        public void normalitzaString(String nom, String esperat) {
            String obtingut = UtilString.normalitzaString(nom);
            String msg = String.format("UtilString.normalitzaString(\"%s\") s'esperava \"%s\" però s'ha trobat \"%s\"", nom, esperat, obtingut);
            assertEquals(esperat, obtingut, msg);
        }

        @ParameterizedTest
        @CsvSource(value={
        "nom,nom,true",
        "no,nom,true",
        "n,nom,true",
        "'',nom,true",
        "'  ',nom,true",
        "null,nom,true",
        "nome,nom,false",
        "na,nom,false",
        }, nullValues={"null"})
        @DisplayName("test esPlantillaDeText()")
        public void coincideix(String plantilla, String text, boolean esperat) {
            boolean obtingut = UtilString.esPlantillaDeText(plantilla, text);
            String msg = String.format("UtilString.esPlantillaDeText(\"%s\", \"%s\") s'esperava \"%b\" però s'ha trobat \"%b\"", plantilla, text, esperat, obtingut);
            assertEquals(esperat, obtingut, msg);
        }
    }


    /* ************************************************************************* *
     *  Test de Vi                                                               *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests de Vi")
    class SobreVi {

        @Test
        @DisplayName("test Vi(String, int) normalitza nom")
        public void constructorNormalitzaValors() {
            String ref = "      ROURABLA20200232           ";
            String nom = "    Supervi     superbe          ";
            int preu = -23;
            int estoc = -54;
            String lloc = "   P02E45N55D    ";
            Origen origen = Origen.fromString("    Pla    de    Bages          ");
            Tipus tipus = Tipus.fromString("    blanc      ");
            String collita = "    2022          ";
            Vi vi = new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);

            String refEsperat = "ROURABLA20200232";
            String nomEsperat = "Supervi superbe";
            int preuEsperat = -1;
            int estocEsperat = -1;
            String llocEsperat = "P02E45N55D";
            Origen origenEsperat = Origen.PLA_DE_BAGES;
            Tipus tipusEsperat = Tipus.BLANC;
            String collitaEsperat = "2022";
            Vi viEsperat = new Vi(refEsperat, nomEsperat, preuEsperat, estocEsperat, llocEsperat, origenEsperat, tipusEsperat, collitaEsperat);
            assertVinsIguals(viEsperat, vi, "Vi() ha de normalitzar els valors");
        }

        @ParameterizedTest
        @CsvSource(value={
        "1,1",
        "10,10",
        "-1,1012",
        "-10,1012"
        })
        @DisplayName("test Vi.setPreu(int) controla preu")
        public void setPreu(int preu, int esperat) {
            Vi vi = unViValid();
            vi.setPreu(preu);
            String msg = String.format("setPreu(%d) s'esperava preu \"%d\" però s'ha trobat \"%d\"", preu, esperat, vi.getPreu());
            assertEquals(esperat, vi.getPreu(), msg);
        }

        @ParameterizedTest
        @CsvSource(value={
        "1,1",
        "10,10",
        "-1,42",
        "-10,42"
        })
        @DisplayName("test Vi.setEstoc(int) controla estoc")
        public void setEstoc(int estoc, int esperat) {
            Vi vi = unViValid();
            vi.setEstoc(estoc);
            String msg = String.format("setEstoc(%d) s'esperava estoc \"%d\" però s'ha trobat \"%d\"", estoc, esperat, vi.getEstoc());
            assertEquals(esperat, vi.getEstoc(), msg);
        }

        @ParameterizedTest
        @CsvSource(value={
        "unlloc,unlloc",
        "'  un  lloc ','un lloc'",
        "'',P21E45N55E",
        "'  ',P21E45N55E",
        "null,P21E45N55E",
        }, nullValues={"null"})
        @DisplayName("test Vi.setLloc(String) controla lloc")
        public void setLloc(String entrat, String esperat) {
            Vi vi = unViValid();
            vi.setLloc(entrat);
            String msg = String.format("setLloc(%s) s'esperava lloc \"%s\" però s'ha trobat \"%s\"", entrat, esperat, vi.getLloc());
            assertEquals(esperat, vi.getLloc(), msg);
        }

        // esValid()
        @Test
        @DisplayName("test esValid() quan tot vàlid")
        public void esValidQuanValid() {
            assertTrue(unViValid().esValid(), "esValid() ha de retornar true quan tots els valors són vàlids");
        }

        @ParameterizedTest
        @CsvSource(value={
        "'','Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,2019,ref,''",
        "'   ','Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,2019,ref,'   '",
        "null,'Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,2019,ref,null",
        "MATISNEG20190011,'',1325,12,P20E01N12E,'Pla de Bages',negre,2019,nom,''",
        "MATISNEG20190011,'   ',1325,12,P20E01N12E,'Pla de Bages',negre,2019,nom,'    '",
        "MATISNEG20190011,null,1325,12,P20E01N12E,'Pla de Bages',negre,2019,nom,null",
        "MATISNEG20190011,'Matís Negre',-1325,12,P20E01N12E,'Pla de Bages',negre,2019,preu,'-1325'",
        "MATISNEG20190011,'Matís Negre',1325,-12,P20E01N12E,'Pla de Bages',negre,2019,estoc,'-12'",
        "MATISNEG20190011,'Matís Negre',1325,12,'','Pla de Bages',negre,2019,lloc,''",
        "MATISNEG20190011,'Matís Negre',1325,12,'    ','Pla de Bages',negre,2019,lloc,'   '",
        "MATISNEG20190011,'Matís Negre',1325,12,null,'Pla de Bages',negre,2019,lloc,null",
        "MATISNEG20190011,'Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,'',collita,'   '",
        "MATISNEG20190011,'Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,'   ',collita,'   '",
        "MATISNEG20190011,'Matís Negre',1325,12,P20E01N12E,'Pla de Bages',negre,null,collita,'   '",
        }, nullValues={"null"})
        @DisplayName("test esValid() quan valor no vàlid")
        public void esValidQuanValorNoValid(
                String ref, String nom,
                int preu, int estoc,
                String lloc, String origenStr,
                String tipusStr, String collita,
                String atribut, String valor) {
            Origen origen = Origen.fromString(origenStr);
            Tipus tipus = Tipus.fromString(tipusStr);
            Vi vi = new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);
            String msg = String.format("esValid() ha de retornar false quan l'atribut %s té valor %s",
                    atribut, valor);
            assertFalse(vi.esValid(), msg);
        }
    }

    /* ************************************************************************* *
     *  Test de serialització de Vi                                              *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests de serialització de Vi")
    class SobreSerialitzacioVi {

        // aArrayString()
        @Test
        @DisplayName("test vi.aArrayString()")
        public void viAArrayString() {
            Vi vi = unViValid();
            String[] esperat = {
                "ROURABLA20200232", "Roura blanc",
                "1012", "42", "P21E45N55E", "Alella",
                "blanc", "2020"};
            String[] obtingut = vi.aArrayString();
            assertArrayEquals(esperat, obtingut, "revisa vi.aArrayString()");
        }

        // deArrayString()
        @Test
        @DisplayName("test vi.deArrayString() quan se li passa una línia vàlida")
        public void viDeArrayStringQuanCorrecte() {
            String[] entrada = {
                "ROURABLA20200232", "Roura blanc",
                "1012", "42", "P21E45N55E", "Alella",
                "blanc", "2020"};
            Vi vi = Vi.deArrayString(entrada);
            Vi viEsperat = unViValid();
            assertVinsIguals(viEsperat, vi, "deArrayString() no converteix adequadament");
        }


        @ParameterizedTest
        @CsvSource(value={
        "'','línia buida'",
        "'Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;2019','massa pocs elements'",
        "'MATISNEG20190011;Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;2019;un extra','massa elements'",
        "';Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;2019','referència buida'",
        "'   ;Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;2019','referència en blanc'",
        "'MATISNEG20190011;;1325;12;P20E01N12E;Pla de Bages;negre;2019','nom buit'",
        "'MATISNEG20190011;   ;1325;12;P20E01N12E;Pla de Bages;negre;2019','nom en blanc'",
        "'MATISNEG20190011;Matís Negre;;12;P20E01N12E;Pla de Bages;negre;2019','preu en blanc'",
        "'MATISNEG20190011;Matís Negre;car;12;P20E01N12E;Pla de Bages;negre;2019','preu no numèric'",
        "'MATISNEG20190011;Matís Negre;-13;12;P20E01N12E;Pla de Bages;negre;2019','preu negatiu'",
        "'MATISNEG20190011;Matís Negre;1223;;P20E01N12E;Pla de Bages;negre;2019','estoc en blanc'",
        "'MATISNEG20190011;Matís Negre;1223;poc;P20E01N12E;Pla de Bages;negre;2019','estoc no numèric'",
        "'MATISNEG20190011;Matís Negre;1234;-12;P20E01N12E;Pla de Bages;negre;2019','estoc negatiu'",
        "'MATISNEG20190011;Matís Negre;1325;12;;Pla de Bages;negre;2019','lloc buit'",
        "'MATISNEG20190011;Matís Negre;1325;12;    ;Pla de Bages;negre;2019','lloc en blanc'",
        "'MATISNEG20190011;Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;','collita buida'",
        "'MATISNEG20190011;Matís Negre;1325;12;P20E01N12E;Pla de Bages;negre;    ','collita en blanc'"
        })
        @DisplayName("test Vi.deArrayString() quan se li passa una línia no vàlida")
        public void viDeArrayStringIncorrecte(String linia, String missatge) {
            String msg = "deArrayString() ha de retornar null quan rep: " + missatge;
            assertNull(Vi.deArrayString(linia.split(";")), msg);
        }

        // toString()
        @Test
        @DisplayName("test Vi.toString()")
        public void ViToString() {
            Vi vi = unViValid();
            String esperat = String.format(
                    "%n    Ref: ROURABLA20200232" +
                    "%n    Nom: Roura blanc" +
                    "%n    Preu: 1012" +
                    "%n    Estoc: 42" +
                    "%n    Lloc: P21E45N55E" +
                    "%n    D.O.: Alella" +
                    "%n    Tipus: blanc" +
                    "%n    Collita: 2020%n");
            assertEquals(esperat, vi.toString(), "Revisa el mètode toString()");
        }

    }
    /* ************************************************************************* *
     *  Test d'enumerats                                                         *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests d'enumerats")
    class SobreEnumerats {

        // origen
        @ParameterizedTest
        @CsvSource(value={
        "Penedès",
        "penedès",
        "  penedès  ",
        "pened",
        "pe",
        "p",
        "  p  "
        })
        @DisplayName("test Origen.fromString()")
        public void origenPenedes(String cadena) {
            Origen esperat = Origen.PENEDES;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }

        @ParameterizedTest
        @CsvSource(value={
        "Terra Alta",
        "terra alta",
        "  terra   alta  ",
        "terra",
        "TERRA",
        "te"
        })
        @DisplayName("test Origen.TERRA_ALTA")
        public void origenTerraAlta(String cadena) {
            Origen esperat = Origen.TERRA_ALTA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Catalunya",
        "Cat",
        "cat",
        "c",
        })
        @DisplayName("test Origen.CATALUNYA")
        public void origenCatalunya(String cadena) {
            Origen esperat = Origen.CATALUNYA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Tarragona",
        "tarragona",
        "  Tarragona",
        "   Tarrago  "
        })
        @DisplayName("test Origen.TARRAGONA")
        public void origenTarragona(String cadena) {
            Origen esperat = Origen.TARRAGONA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Conca de Barberà",
        "conca de barberà",
        "   Conca   de   Barberà  ",
        "Conca",
        "conca",
        "co"
        })
        @DisplayName("test Origen.CONCA_DE_BARBERA")
        public void origenConcaDeBarbera(String cadena) {
            Origen esperat = Origen.CONCA_DE_BARBERA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Costers del Segre",
        "Costers",
        "costers",
        "cost",
        })
        @DisplayName("test Origen.COSTERS_DEL_SEGRE")
        public void origenCostersDelSegre(String cadena) {
            Origen esperat = Origen.COSTERS_DEL_SEGRE;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Empordà",
        "E",
        "e",
        })
        @DisplayName("test Origen.EMPORDA")
        public void origenEmporda(String cadena) {
            Origen esperat = Origen.EMPORDA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Montsant",
        "montsant",
        "m",
        })
        @DisplayName("test Origen.MONTSANT")
        public void origenMontsant(String cadena) {
            Origen esperat = Origen.MONTSANT;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Priorat",
        "prior"
        })
        @DisplayName("test Origen.PRIORAT")
        public void origenPriorat(String cadena) {
            Origen esperat = Origen.PRIORAT;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Alella",
        "a"
        })
        @DisplayName("test Origen.ALELLA")
        public void origenAlella(String cadena) {
            Origen esperat = Origen.ALELLA;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "Pla de Bages",
        "pla"
        })
        @DisplayName("test Origen.PLA_DE_BAGES")
        public void origenPlaDeBages(String cadena) {
            Origen esperat = Origen.PLA_DE_BAGES;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "altre",
        "Pla d'Urgell",
        "Alta Ribagorça",
        })
        @DisplayName("test Origen.ALTRE")
        public void origenAltre(String cadena) {
            Origen esperat = Origen.ALTRE;
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera %s",
                    cadena, esperat.toString(), trobat.toString());
            assertEquals(esperat, Origen.fromString(cadena), msg);
        }
        @ParameterizedTest
        @CsvSource(value={
        "''",
        "'   '",
        "null"
        }, nullValues={"null"})
        @DisplayName("test Origen.fromString() nullable")
        public void origenNull(String cadena) {
            Origen trobat = Origen.fromString(cadena);
            String msg = String.format("Origen.fromString(%s) retorna %s quan s'espera null",
                    cadena, trobat);
            assertNull(Origen.fromString(cadena), msg);
        }


        @Test
        @DisplayName("test Tipus.fromString()")
        public void tipusEnum() {
            assertAll(
                    () -> assertEquals(Tipus.BLANC, Tipus.fromString("blanc"), "Tipus.toString(\"blanc\") ha de trobar BLANC"),
                    () -> assertEquals(Tipus.NEGRE, Tipus.fromString("negre"), "Tipus.toString(\"negre\") ha de trobar NEGRE"),
                    () -> assertEquals(Tipus.ROSAT, Tipus.fromString("rosat"), "Tipus.toString(\"rosat\") ha de trobar ROSAT"),
                    () -> assertEquals(Tipus.BLANC, Tipus.fromString("b"), "Tipus.toString(\"b\") ha de trobar BLANC"),
                    () -> assertEquals(Tipus.NEGRE, Tipus.fromString("n"), "Tipus.toString(\"n\") ha de trobar NEGRE"),
                    () -> assertEquals(Tipus.ROSAT, Tipus.fromString("r"), "Tipus.toString(\"r\") ha de trobar ROSAT"),
                    () -> assertEquals(Tipus.ALTRE, Tipus.fromString("tèrvol"), "Tipus.toString(\"tèrvol\") ha de trobar ALTRE"),
                    () -> assertNull(Tipus.fromString("  "), "Tipus.toString(\"  \") ha de retornar null"),
                    () -> assertNull(Tipus.fromString(""), "Tipus.toString(\"\") ha de retornar null"),
                    () -> assertNull(Tipus.fromString(null), "Tipus.toString(null) ha de retornar null")
                    );
        }
    }


    /* ************************************************************************* *
     *  Test de Botiga                                                           *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests de Botiga")
    class SobreBotiga {

        // afegeix()
        @Test
        @DisplayName("test botiga afegeix nou vi")
        public void testAfegeix() {
            Vi vi = unViValid();
            Vi trobat = new Botiga().afegeix(vi);
            assertVinsIguals(vi, trobat, "afegeix() ha de retornar el vi afegit");
        }


        // cerca(String)
        @Test
        @DisplayName("test botiga.cerca(string) troba vi per ref")
        public void trobavidirecteperref() {
            Vi[] vins = vinsValids();
            Vi esperat = vins[3];
            Botiga botiga = botigaPlena(vins);
            String valorexacte = "SAOROSAT20180001";
            String valoranormalitzar = "    SAOROSAT20180001   ";
            String valorcase = "saorosat20180001";
            String valorinnexistent = "capvicomaquest";
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(valorexacte), 
                                           "cerca(string) no troba un vi existent amb la referència exacta"),
                    () -> assertVinsIguals(esperat, botiga.cerca(valoranormalitzar), 
                                           "cerca(string) no troba un vi existent amb la referència no normalitzada"),
                    () -> assertVinsIguals(esperat, botiga.cerca(valorcase), 
                                           "cerca(string) no troba un vi existent amb la referència amb canvis majúscules/minúscules"),
                    () -> assertNull(botiga.cerca(valorinnexistent),
                                           "cerca(string) ha de retornar una llista buida quan no es troba cap vi amb la referència demanada")
                    );
        }

        // cerca(Vi)
        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per ref")
        public void trobaViPerRef() {
            Vi[] vins = vinsValids();
            List<Vi> esperat = List.of(vins[6]);
            Botiga botiga = botigaPlena(vins);
            String clau = "ref";
            String valorExacte = "CERCIUMX20170002";
            String valorANormalitzar = "    CERCIUMX20170002   ";
            String valorCase = "cerciumx20170002";
            String valorInnexistent = "Capvicomaquest";
            Vi plantillaExacte = new Vi(valorExacte, null, -1, -1, null, null, null, null);
            Vi plantillaNormalitzable = new Vi(valorANormalitzar, null, -1, -1, null, null, null, null);
            Vi plantillaCase = new Vi(valorCase, null, -1, -1, null, null, null, null);
            Vi plantillaInnexistent = new Vi(valorInnexistent, null, -1, -1, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaExacte), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor exacte", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaNormalitzable), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor no normalitzat", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaCase), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor canviat majúscules/minúscules", clau)),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaInnexistent), 
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb les característiques demanades")
                    );
        }
        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per nom")
        public void trobaViPerNom() {
            Vi[] vins = vinsValids();
            List<Vi> esperat = List.of(vins[4], vins[5]);
            Botiga botiga = botigaPlena(vins);
            String clau = "nom";
            String valorExacte = "Roura blanc";
            String valorANormalitzar = "    Roura    blanc   ";
            String valorCase = "ROURA BLANC";
            String valorInnexistent = "Capvicomaquest";
            Vi plantillaExacte = new Vi(null, valorExacte, -1, -1, null, null, null, null);
            Vi plantillaNormalitzable = new Vi(null, valorANormalitzar, -1, -1, null, null, null, null);
            Vi plantillaCase = new Vi(null, valorCase, -1, -1, null, null, null, null);
            Vi plantillaInnexistent = new Vi(valorInnexistent, null, -1, -1, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaExacte), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor exacte", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaNormalitzable), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor no normalitzat", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaCase), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor canviat majúscules/minúscules", clau)),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaInnexistent),
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb les característiques demanades")
                    );
        }

        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per lloc")
        public void trobaViPerLloc() {
            Vi[] vins = vinsValids();
            List<Vi> esperat = List.of(vins[7]);
            Botiga botiga = botigaPlena(vins);
            String clau = "lloc";
            String valorExacte = "P02E02N55E";
            String valorANormalitzar = "    P02E02N55E   ";
            String valorCase = "P02E02N55E";
            String valorInnexistent = "Capvicomaquest";
            Vi plantillaExacte        = new Vi(null, null, -1, -1, valorExacte, null, null, null);
            Vi plantillaNormalitzable = new Vi(null, null, -1, -1, valorANormalitzar, null, null, null);
            Vi plantillaCase          = new Vi(null, null, -1, -1, valorCase, null, null, null);
            Vi plantillaInnexistent = new Vi(valorInnexistent, null, -1, -1, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaExacte), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor exacte", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaNormalitzable), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor no normalitzat", clau)),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaCase), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor canviat majúscules/minúscules", clau)),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaInnexistent),
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb les característiques demanades")
                    );
        }

        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per origen")
        public void trobaViPerOrigen() {
            Vi[] vins = vinsValids();
            List<Vi> esperat = List.of(vins[2]);
            Botiga botiga = botigaPlena(vins);
            String clau = "origen";
            Origen origen = Origen.fromString("Pla de Bages");
            String valorInnexistent = "Capvicomaquest";
            Vi plantillaExacte        = new Vi(null, null, -1, -1, null, origen, null, null);
            Vi plantillaInnexistent = new Vi(valorInnexistent, null, -1, -1, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaExacte), 
                                           String.format("cerca() no troba els vins quan es cerca per %s especificant el valor exacte", clau)),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaInnexistent),
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb les característiques demanades")
                    );
        }

        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per preu")
        public void trobaViPerPreu() {
            Vi[] vins = vinsValids();
            Botiga botiga = botigaPlena(vins);
            int valorExacte = 906;
            int valorSuperior = 910;
            int valorBaratissim = 1;
            Vi plantillaExacte     = new Vi(null, null, valorExacte, -1, null, null, null, null);
            Vi plantillaSuperior   = new Vi(null, null, valorSuperior, -1, null, null, null, null);
            Vi plantillaBaratissim = new Vi(null, null, valorBaratissim, -1, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(List.of(vins[5], vins[6]), botiga.cerca(plantillaExacte), 
                                           "cerca() no troba els vins quan es cerca per preu màxim i s'especifica el valor exacte"),
                    () -> assertVinsIguals(List.of(vins[5], vins[6]), botiga.cerca(plantillaSuperior), 
                                           "cerca() no troba els vins quan es cerca per preu màxim i s'especifica una mica per sobre"),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaBaratissim),
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb el preu demanat")
                    );
        }

        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per estoc")
        public void trobaViPerEstoc() {
            Vi[] vins = vinsValids();
            List<Vi> esperat = List.of(vins[4]);
            Botiga botiga = botigaPlena(vins);
            int valorExacte = 42;
            int valorInferior = 40;
            int valorExcessiu = 1000;
            Vi plantillaExacte   = new Vi(null, null, -1, valorExacte, null, null, null, null);
            Vi plantillaInferior = new Vi(null, null, -1, valorInferior, null, null, null, null);
            Vi plantillaExcessiu = new Vi(null, null, -1, valorExcessiu, null, null, null, null);
            assertAll(
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaExacte), 
                                           "cerca() no troba els vins quan es cerca per estoc mínim i s'especifica el valor exacte"),
                    () -> assertVinsIguals(esperat, botiga.cerca(plantillaInferior), 
                                           "cerca() no troba els vins quan es cerca per estoc mínim i s'especifica una mica per sota"),
                    () -> assertVinsIguals(List.of(), botiga.cerca(plantillaExcessiu),
                                           "cerca() ha de retornar una llista buida quan no es troba cap vi amb l'estoc el demanat")
                    );
        }

        @Test
        @DisplayName("test Botiga.cerca(Vi) troba vi per múltiples claus")
        public void trobaViPerMultiplesClaus() {
            Vi[] vins = vinsValids();
            Botiga botiga = botigaPlena(vins);
            Vi plantilla = new Vi(null, null, -1, 20, null, null, Tipus.NEGRE, "2018");
            assertVinsIguals(List.of(vins[3]), botiga.cerca(plantilla),
                    "cerca() no troba el vi quan es cerca per múltiples claus");
        }


        @Test
        @DisplayName("test botiga.cerca() retorna tots els vins quan no s'especifica res")
        public void trobaTotsQuanNoEspecificaRes() {
            Vi[] vins = vinsValids();
            Botiga botiga = botigaPlena(vins);
            Vi plantilla = new Vi(null, null, -1, -1, null, null, null, null);
            assertVinsIguals(Arrays.asList(vins), botiga.cerca(plantilla),
                    "cerca() no troba el vi quan es cerca per múltiples claus");
        }

        // elimina(String)
        @Test
        @DisplayName("test botiga elimina vi conegut")
        public void testEliminaConegut() {
            Vi[] vins = vinsValids();
            Vi escollit = vins[3];
            escollit.setEstoc(0);
            Botiga botiga = botigaPlena(vins);
            String ref = "SAOROSAT20180001";
            Vi trobat = botiga.elimina(ref);
            Vi cercat = botiga.cerca(ref);
            assertAll(
                    () -> assertVinsIguals(escollit, trobat, "elimina() ha de retornar el vi eliminat"),
                    () -> assertNull(cercat, "elimina() ha d'eliminar el vi a partir de la referència")
                    );
        }
        @Test
        @DisplayName("test botiga elimina vi amb nom normalitzat")
        public void testEliminaNormalitzant() {
            Vi[] vins = vinsValids();
            Vi escollit = vins[5];
            escollit.setEstoc(0);
            Botiga botiga = botigaPlena(vins);
            String ref = "   ROURABLA20200201    ";
            Vi trobat = botiga.elimina(ref);
            Vi cercat = botiga.cerca(ref);
            assertAll(
                    () -> assertVinsIguals(escollit, trobat, "elimina() ha de retornar el vi eliminat"),
                    () -> assertNull(cercat, "elimina() ha d'eliminar el vi a partir de la referència no normalitzada")
                    );
        }
        @Test
        @DisplayName("test botiga elimina vi ignorant majúscules/minúscules")
        public void testEliminaCaseInsensitive() {
            Vi[] vins = vinsValids();
            Vi escollit = vins[0];
            escollit.setEstoc(0);
            Botiga botiga = botigaPlena(vins);
            String ref = "llumalba20200001";
            Vi trobat = botiga.elimina(ref);
            Vi cercat = botiga.cerca(ref);
            assertAll(
                    () -> assertVinsIguals(escollit, trobat, "elimina() ha de retornar el vi eliminat"),
                    () -> assertNull(cercat, "elimina() ha d'eliminar el vi a partir de la referència amb canvis majúscules/minúscules")
                    );
        }

        // membres
        @Test
        @DisplayName("test Botiga té propietat privada vins de tipus List<Vi>")
        public void vinsEsList() {
            assertTrue(Arrays.stream(Botiga.class.getDeclaredFields())
                    .anyMatch(p -> p.getName().equals("vins") &&
                        Modifier.isPrivate(p.getModifiers()) &&
                        p.getGenericType().toString().equals("java.util.List<Vi>")),
                    "Botiga ha de tenir una propietat privada de tipus List<Vi>");
        }


        // excepcions
        @Test
        @DisplayName("test Botiga.afegeix() llença excepció quan rep null")
        public void afegeixViAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().afegeix(null);
            }, "Revisa què fa Botiga.afegeix() quan rep null");
            assertEquals("El vi no pot ser null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.afegeix() quan rep un vi null");
        }

        @Test
        @DisplayName("test Botiga.afegeix() llença excepció quan rep no valid")
        public void afegeixViNoValid() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().afegeix(new Vi(null, null, -1, -1, null, null, null, null));
            }, "Revisa què fa Botiga.afegeix() quan rep vi no vàlid");
            assertEquals("El vi ha de ser vàlid", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.afegeix() quan rep un vi no vàlid");
        }

        @Test
        @DisplayName("test Botiga.afegeix() llença excepció quan rep vi repetit")
        public void afegeixViRepetit() {
            Botiga botiga = botigaPlena(vinsValids());
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                botiga.afegeix(unViValid());
            }, "Revisa què fa Botiga.afegeix() quan rep un vi repetit");
            assertEquals("Referència de vi repetida", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.afegeix() quan rep un vi repetit");
        }


        @Test
        @DisplayName("test Botiga.elimina() llença excepció quan rep null")
        public void eliminaViAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().elimina(null);
            }, "Revisa què fa Botiga.elimina() quan rep null");
            assertEquals("La referència no pot ser null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.elimina()");
        }

        @Test
        @DisplayName("test Botiga.elimina() llença excepció quan vi amb estoc")
        public void eliminaViAmbEstoc() {
            Botiga botiga = botigaPlena(vinsValids());
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                botiga.elimina(unViValid().getRef());
            }, "Revisa què fa Botiga.elimina() quan vi amb estoc");
            assertEquals("El vi a eliminar no pot tenir estoc", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.elimina() quan el vi té estoc");
        }

        @Test
        @DisplayName("test Botiga.elimina() llença excepció quan rep referència desconeguda")
        public void eliminaViDesconegut() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().elimina("ROURABLA20200232");
            }, "Revisa què fa Botiga.elimina() quan rep instància desconeguda");
            assertEquals("La instància a eliminar ha d'estar present", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.elimina()");
        }

        @Test
        @DisplayName("test Botiga.cerca(String) llença excepció quan rep referència null")
        public void cercaViPerRefAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().cerca((String)null);
            }, "Revisa què fa Botiga.cerca(String) quan rep null");
            assertEquals("La referència no pot ser null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.cerca()");
        }
        @Test
        @DisplayName("test Botiga.cerca(Vi) llença excepció quan rep instància desconeguda")
        public void cercaViAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().cerca((Vi)null);
            }, "Revisa què fa Botiga.cerca(Vi) quan rep null");
            assertEquals("La plantilla no pot ser null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.cerca()");
        }
    }

    /* ************************************************************************* *
     *  Test de llistes retornades per Botiga                                    *
     * ************************************************************************* */
    @Nested
    @DisplayName("Tests llistes retornades per Botiga")
    class SobreLlistesDeBotiga {

        @Test
        @DisplayName("test Botiga.afegeix() afegeix al final de la llista")
        public void afegeixAraAfegeixAlFinal() {
            Vi[] vins = vinsValids();
            vins[0].setEstoc(0);
            vins[2].setEstoc(0);
            vins[4].setEstoc(0);
            vins[6].setEstoc(0);
            Botiga botiga = botigaPlena(vins);
            botiga.elimina(vins[0].getRef());
            botiga.elimina(vins[2].getRef());
            botiga.elimina(vins[4].getRef());
            botiga.elimina(vins[6].getRef());
            Vi nouVi = unViValid();
            botiga.afegeix(nouVi);
            List<Vi> trobats = botiga.getVins();
            assertVinsIguals(List.of(vins[1], vins[3], vins[5], vins[7], nouVi),
                    trobats,
                    "Ara que Botiga.vins és una llista, en afegir un nou vi sempre es coŀloca al final");
        }

        @Test
        @DisplayName("Test Botiga.getVins() retorna una llista immutable")
        public void getVinsRetornaImmutable() {
            Botiga botiga = botigaPlena(vinsValids());
            Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
                botiga.getVins().clear();
            }, "Revisa què Botiga.getVins() retorni una llista no modificable");
        }

        @Test
        @DisplayName("Test Botiga.cerca() retorna una llista immutable")
        public void cercaRetornaImmutable() {
            Botiga botiga = botigaPlena(vinsValids());
            Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
                botiga.cerca(unViValid()).add(unViValid());
            }, "Revisa què Botiga.cerca() retorni una llista no modificable");
        }
    }

    /* ************************************************************************* *
     *  Utilitats                                                                *
     * ************************************************************************* */
    private static void assertVinsIguals(List<Vi> un, List<Vi> dos, String msg) {
        assertNotNull(dos, msg);
        assertEquals(un.size(), dos.size(), String.format("%s. Nombre de vins esperats %d. Nombre de vins trobats %d",
                    msg, un.size(), dos.size()));
        for (int i=0; i< un.size(); i++) {
            assertVinsIguals(un.get(i), dos.get(i), msg);
        }
    }

    private static void assertVinsIguals(Vi un, Vi dos, String msg) {
        assertNotNull(dos, msg);
        assertAll(
            () -> assertEquals(un.getRef(), dos.getRef(), msg + ". Revisa atribut ref"),
            () -> assertEquals(un.getNom(), dos.getNom(), msg + ". Revisa atribut nom"),
            () -> assertEquals(un.getPreu(), dos.getPreu(), msg + ". Revisa atribut preu"),
            () -> assertEquals(un.getEstoc(), dos.getEstoc(), msg + ". Revisa atribut estoc"),
            () -> assertEquals(un.getLloc(), dos.getLloc(), msg + ". Revisa atribut lloc"),
            () -> assertEquals(un.getOrigen(), dos.getOrigen(), msg + ". Revisa atribut origen"),
            () -> assertEquals(un.getTipus(), dos.getTipus(), msg + ". Revisa atribut tipus"),
            () -> assertEquals(un.getCollita(), dos.getCollita(), msg + ". Revisa atribut collita")
        );
    }

    private static Vi unViValid() {
        return new Vi("ROURABLA20200232", "Roura blanc", 1012, 42, "P21E45N55E", Origen.ALELLA, Tipus.BLANC, "2020");
    }

    private static Vi[] vinsValids() {
        return new Vi[] {
            new Vi("LLUMALBA20200001", "Llum d'Alba Blanc", 1750, 12, "P02E03N55D", Origen.PRIORAT, Tipus.BLANC, "2020"),
            new Vi("CARPATHI20180021", "Carpathia Negre"  , 3450,  6, "P23E01N43D", Origen.MONTSANT, Tipus.NEGRE, "2018"),
            new Vi("MATISNEG20190011", "Matís Negre"      , 1325, 12, "P20E01N12E", Origen.PLA_DE_BAGES, Tipus.NEGRE, "2019"),
            new Vi("SAOROSAT20180001", "Saó Rosat"        , 1040, 24, "P02E45N55D", Origen.COSTERS_DEL_SEGRE, Tipus.NEGRE, "2018"),
            new Vi("ROURABLA20200232", "Roura blanc"      , 1012, 42, "P21E45N55E", Origen.ALELLA, Tipus.BLANC, "2020"),
            new Vi("ROURABLA20200201", "Roura blanc"      ,  906,  3, "P21E45N55E", Origen.ALELLA, Tipus.BLANC, "2018"),
            new Vi("CERCIUMX20170002", "Cercium"          ,  565, 30, "P23E01N55D", Origen.EMPORDA, Tipus.NEGRE, "2017"),
            new Vi("MASIASER20200001", "Masia Serra"      , 1350, 12, "P02E02N55E", Origen.EMPORDA, Tipus.NEGRE, "2020")
        };
    }

    private static Botiga botigaPlena(Vi[] vins) {
        Botiga botiga = new Botiga();
        Arrays.stream(vins).forEach(botiga::afegeix);
        return botiga;
    }

}
