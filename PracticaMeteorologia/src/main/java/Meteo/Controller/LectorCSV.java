package Meteo.Controller;

import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LectorCSV {

    private static LectorCSV controller;
    private String uri;
    private Document data = null;
    private BufferedReader lector = null;

    private final List<Element> listaMediciones = new ArrayList<>();
    /**
     * Constructor del Lector
     * @param uri
     */
    private LectorCSV(String uri) {
        this.uri = uri;
    }

    /**
     *Es un singleton
     * @param uri
     * @return controller
     */
    public static LectorCSV getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new LectorCSV(uri);
        return controller;
    }

    /**
     * Metodo lector del CSV con el uso de BufferedReader
     * @throws IOException
     */
    public void leerCSV() throws IOException {
        this.data = new Document();
        this.data.setRootElement(new Element("mediciones"));
        try {
            this.lector = new BufferedReader(new FileReader(this.uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que transformara las lineas leidas del CSV en tokens leidos linea a linea que pasaran a ser los nuevos elementos del XML
     * @throws IOException
     */
    public void transformarCSV() throws IOException {
        leerCSV();
        String line;

        try {
            while ((line = this.lector.readLine()) != null) {
                if (!line.contains("provincia")) {
                    line = line.replaceAll(";;", ";0;");
                    StringTokenizer tokens = new StringTokenizer(line, ";");
                    while (tokens.hasMoreTokens()) {
                        Element medici = new Element("medicion");
                        medici.addContent(new Element("provincia").setText(tokens.nextToken()));
                        medici.addContent(new Element("municipio").setText(tokens.nextToken()));
                        medici.addContent(new Element("estacion").setText(tokens.nextToken()));
                        medici.addContent(new Element("magnitud").setText(tokens.nextToken()));
                        medici.addContent(new Element("puntoMuestreo").setText(tokens.nextToken()));
                        medici.addContent(new Element("anio").setText(tokens.nextToken()));
                        medici.addContent(new Element("mes").setText(tokens.nextToken()));
                        medici.addContent(new Element("dia").setText(tokens.nextToken()));
                        int contador = 01;
                        while (tokens.hasMoreTokens()) {
                            medici.addContent(new Element("h" + contador).setText(tokens.nextToken()));
                            medici.addContent(new Element("v" + contador).setText(tokens.nextToken()));
                            contador++;
                        }
                        listaMediciones.add(medici);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = this.data.getRootElement();
        root.addContent(listaMediciones);
    }

    /**
     *
     * Metodo para dar formato al XML a crear
     * @return xmlOutput
     */
    private XMLOutputter preProcess() {
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        return xmlOutput;
    }

    /**
     * Metodo que generará un nuevo XML
     * @param uri
     * @throws IOException
     */
    public void writeXMLFile(String uri) throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, new FileWriter(uri));
        System.out.println("Fichero XML generado con éxito");
        controller = null;
    }


    /*public static List<Contaminantes> getContaminantes() throws IOException {
        String DATA_FILE = "calidad_aire_datos_meteo_mes.csv";
        String WORKING_DIRECTORY = System.getProperty("user.dir");
        Path path = Paths.get(WORKING_DIRECTORY + File.separator + "src" + File.separator+ "main" + File.separator+ "java" + File.separator+ "Datos" + File.separator + DATA_FILE);
        final List<String> lines = Files.readAllLines(path,StandardCharsets.UTF_8);
        // lines.forEach(System.out::println);
        List<Contaminantes> listacontaminantes = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            // System.out.println("Proceso la linea: " + (i-1));

            StringTokenizer tokenizer = new StringTokenizer(lines.get(i),";");
            Contaminantes cont = new Contaminantes();

            cont.setProvincia(Integer.parseInt(tokenizer.nextToken()));
            cont.setMunicipio(Integer.parseInt(tokenizer.nextToken()));
            cont.setEstacion(Integer.parseInt(tokenizer.nextToken()));
            cont.setMagnitud(Integer.parseInt(tokenizer.nextToken()));
            cont.setPuntoMuestreo(tokenizer.nextToken());
            cont.setAno(Integer.parseInt(tokenizer.nextToken()));
            cont.setMes(Integer.parseInt(tokenizer.nextToken()));
            cont.setDia(Integer.parseInt(tokenizer.nextToken()));
            cont.setH1(Double.parseDouble(tokenizer.nextToken()));
            cont.setV1(tokenizer.nextToken());


            listacontaminantes.add(cont);
        }
        return listacontaminantes;
    }


    public static List<Temperatura> getTemperaturas() throws IOException {
        String DATA_FILE = "calidad_aire_datos_mes.csv";
        String WORKING_DIRECTORY = System.getProperty("user.dir");
        Path path = Paths.get(WORKING_DIRECTORY + File.separator + "src" + File.separator+ "main" + File.separator+ "java" + File.separator+ "Datos" + File.separator + DATA_FILE);
        List<String> lines = Files.readAllLines(path,StandardCharsets.UTF_8);

        List<Temperatura> listatemperaturas = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            // System.out.println("Proceso la linea: " + (i-1));
            StringTokenizer tokenizer = new StringTokenizer(lines.get(i), ";");
            Temperatura temp = new Temperatura();

            temp.setProvincia(Integer.parseInt(tokenizer.nextToken()));
            temp.setMunicipio(Integer.parseInt(tokenizer.nextToken()));
            temp.setEstacion(Integer.parseInt(tokenizer.nextToken()));
            temp.setMagnitud(Integer.parseInt(tokenizer.nextToken()));
            temp.setPuntoMuestreo(tokenizer.nextToken());
            temp.setAño(Integer.parseInt(tokenizer.nextToken()));
            temp.setMes(Integer.parseInt(tokenizer.nextToken()));
            temp.setDia(Integer.parseInt(tokenizer.nextToken()));
            temp.setH1(Double.parseDouble(tokenizer.nextToken()));
            temp.setV1(tokenizer.nextToken());

            listatemperaturas.add(temp);
        }
        return listatemperaturas;
    }
*/

    /*public static List<Contaminantes> contaminantesCSV(String uri) throws IOException {

        try (Stream<String> stream = Files.lines(Path.of(uri), StandardCharsets.UTF_8)) {
            return stream
                    .map(i -> i.replaceAll(",", ".").replaceAll(";;", ";0;"))
                    .map(q -> q.split(";"))
                    .skip(1)
                    .map(splitted -> {
                        int provincia = Integer.parseInt(splitted[0]);
                        int municipio = Integer.parseInt(splitted[1]);
                        int estacion = Integer.parseInt(splitted[2]);
                        int magnitud = Integer.parseInt(splitted[3]);
                        String puntoMuestreo = (splitted[4]);
                        int ano = Integer.parseInt(splitted[5]);
                        int mes = Integer.parseInt(splitted[6]);
                        int dia = Integer.parseInt(splitted[7]);
                        double h1 = Double.parseDouble(splitted[8]);
                        String v1 = splitted[9];
                        double h2 = Double.parseDouble(splitted[10]);
                        String v2 = splitted[11];
                        double h3 = Double.parseDouble(splitted[12]);
                        String v3 = splitted[13];
                        double h4 = Double.parseDouble(splitted[14]);
                        String v4 = splitted[15];
                        double h5 = Double.parseDouble(splitted[16]);
                        String v5 = splitted[17];
                        double h6 = Double.parseDouble(splitted[18]);
                        String v6 = splitted[19];
                        double h7 = Double.parseDouble(splitted[20]);
                        String v7 = splitted[21];
                        double h8 = Double.parseDouble(splitted[22]);
                        String v8 = splitted[23];
                        double h9 = Double.parseDouble(splitted[24]);
                        String v9 = splitted[25];
                        double h10 = Double.parseDouble(splitted[26]);
                        String v10 = splitted[27];
                        double h11 = Double.parseDouble(splitted[28]);
                        String v11 = splitted[29];
                        double h12 = Double.parseDouble(splitted[30]);
                        String v12 = splitted[31];
                        double h13 = Double.parseDouble(splitted[32]);
                        String v13 = splitted[33];
                        double h14 = Double.parseDouble(splitted[34]);
                        String v14 = splitted[35];
                        double h15 = Double.parseDouble(splitted[36]);
                        String v15 = splitted[37];
                        double h16 = Double.parseDouble(splitted[38]);
                        String v16 = splitted[39];
                        double h17 = Double.parseDouble(splitted[40]);
                        String v17 = splitted[41];
                        double h18 = Double.parseDouble(splitted[42]);
                        String v18 = splitted[43];
                        double h19 = Double.parseDouble(splitted[44]);
                        String v19 = splitted[45];
                        double h20 = Double.parseDouble(splitted[46]);
                        String v20 = splitted[47];
                        double h21 = Double.parseDouble(splitted[48]);
                        String v21 = splitted[49];
                        double h22 = Double.parseDouble(splitted[50]);
                        String v22 = splitted[51];
                        double h23 = Double.parseDouble(splitted[52]);
                        String v23 = splitted[53];
                        double h24 = Double.parseDouble(splitted[54]);
                        String v24 = splitted[55];
                        return new Contaminantes(provincia, municipio, estacion, magnitud, puntoMuestreo, ano, mes, dia, h1, v1, h2, v2, h3, v3, h4, v4, h5, v5, h6, v6, h7, v7, h8, v8, h9, v9, h10, v10, h11, v11, h12, v12, h13, v13, h14, v14, h15, v15, h16, v16, h17, v17, h18, v18, h19, v19, h20, v20, h21, v21, h22, v22, h23, v23, h24, v24);
                    }).collect(Collectors.toList());
        }
    }

    //----------------------------------------------------------------------------------------


    public static List<Temperatura> temperaturasCSV(String uri) throws IOException {
        try (Stream<String> stream = Files.lines(Path.of(uri), StandardCharsets.UTF_8)) {
            return stream
                    .map(v -> v.replaceAll(";;", ";0;"))
                    .map(s -> s.split(";"))
                    .skip(1)
                    .map(splitted -> {
                        int provincia = Integer.parseInt(splitted[0]);
                        int municipio = Integer.parseInt(splitted[1]);
                        int estacion = Integer.parseInt(splitted[2]);
                        int magnitud = Integer.parseInt(splitted[3]);
                        String puntoMuestreo = (splitted[4]);
                        int ano = Integer.parseInt(splitted[5]);
                        int mes = Integer.parseInt(splitted[6]);
                        int dia = Integer.parseInt(splitted[7]);
                        double h1 = Double.parseDouble(splitted[8]);
                        String v1 = splitted[9];
                        double h2 = Double.parseDouble(splitted[10]);
                        String v2 = splitted[11];
                        double h3 = Double.parseDouble(splitted[12]);
                        String v3 = splitted[13];
                        double h4 = Double.parseDouble(splitted[14]);
                        String v4 = splitted[15];
                        double h5 = Double.parseDouble(splitted[16]);
                        String v5 = splitted[17];
                        double h6 = Double.parseDouble(splitted[18]);
                        String v6 = splitted[19];
                        double h7 = Double.parseDouble(splitted[20]);
                        String v7 = splitted[21];
                        double h8 = Double.parseDouble(splitted[22]);
                        String v8 = splitted[23];
                        double h9 = Double.parseDouble(splitted[24]);
                        String v9 = splitted[25];
                        double h10 = Double.parseDouble(splitted[26]);
                        String v10 = splitted[27];
                        double h11 = Double.parseDouble(splitted[28]);
                        String v11 = splitted[29];
                        double h12 = Double.parseDouble(splitted[30]);
                        String v12 = splitted[31];
                        double h13 = Double.parseDouble(splitted[32]);
                        String v13 = splitted[33];
                        double h14 = Double.parseDouble(splitted[34]);
                        String v14 = splitted[35];
                        double h15 = Double.parseDouble(splitted[36]);
                        String v15 = splitted[37];
                        double h16 = Double.parseDouble(splitted[38]);
                        String v16 = splitted[39];
                        double h17 = Double.parseDouble(splitted[40]);
                        String v17 = splitted[41];
                        double h18 = Double.parseDouble(splitted[42]);
                        String v18 = splitted[43];
                        double h19 = Double.parseDouble(splitted[44]);
                        String v19 = splitted[45];
                        double h20 = Double.parseDouble(splitted[46]);
                        String v20 = splitted[47];
                        double h21 = Double.parseDouble(splitted[48]);
                        String v21 = splitted[49];
                        double h22 = Double.parseDouble(splitted[50]);
                        String v22 = splitted[51];
                        double h23 = Double.parseDouble(splitted[52]);
                        String v23 = splitted[53];
                        double h24 = Double.parseDouble(splitted[54]);
                        String v24 = splitted[55];
                        return new Temperatura(provincia, municipio, estacion, magnitud, puntoMuestreo, ano, mes, dia, h1, v1, h2, v2, h3, v3, h4, v4, h5, v5, h6, v6, h7, v7, h8, v8, h9, v9, h10, v10, h11, v11, h12, v12, h13, v13, h14, v14, h15, v15, h16, v16, h17, v17, h18, v18, h19, v19, h20, v20, h21, v21, h22, v22, h23, v23, h24, v24);
                    }).collect(Collectors.toList());
        }
    }*/
}





