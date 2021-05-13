package w15;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Repository {

    private static String FILE_PATH = "w15/repo.txt";

    public LineSolver[] getLines() {
        
        HashMap<String, Double> map = parseJson();
        if (map == null) {
            return null;
        }

        Double a_min = map.getOrDefault("a_min", 0D);
        Double b_min = map.getOrDefault("b_min", 0D);
        Double a_max = map.getOrDefault("a_max", 0D);
        Double b_max = map.getOrDefault("b_max", 0D);

        LineSolver min, max;
        if (b_min == 0) { // double compare OK
            min = new HomogenousLine(a_min);
        } else {
            min = new Line(a_min, b_min);
        }

        if (b_max == 0) { // double compare OK
            max = new HomogenousLine(a_max);
        } else {
            max = new Line(a_max, b_max);
        }

        LineSolver[] out = {min, max};

        return out;
    }

    private HashMap<String, Double> parseJson() {
        List<String> lines = readFile();
        LineSolver[] out = new LineSolver[2];

        if (lines.size() == 0) {
            return null;
        }

        String json = lines.get(0);
        String[] keyValues = json.replace("{", "").replace("}", "").split(",");
        HashMap<String, Double> map = new HashMap<>();

        for (String each : keyValues) {
            String[] inter = each.split(":");
            if (inter.length == 2) {
                map.put(inter[0].trim().replaceAll("\"", ""), Double.parseDouble(inter[1]));
            }
        }
        return map;
    }

    private List<String> readFile() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(FILE_PATH));

        } catch (IOException e) {
            System.err.println(e);
        }
        return lines;
    }


}


/**
* Koosta liides joone y-i väärtuse leidmiseks vastavalt x-i väärtusele. 
Koosta automaattestid kontrollimaks mitut punkti sirgel y=3x. Koosta realiseeriv 
klass, millele antakse konstruktoris ette x-i kordaja. Kontrolli klassi 
eksemplari oskuste vastavust testidele.

* Loo teine realiseeriv klass, millele saab ette anda kordaja ja vabaliikme. 
Kontrolli selle klassi tööd liidese kaudu testidega joontele y=3x ning y=3x+2. 
Koosta funktsioon, mis saab parameetriks x-ide massiivi ning liidesele vastava 
y-koordinaate arvutava klassi ning tagastab vastavate y-ite massiivi. Kontrolli 
klasside ja funktsiooni tööd automaattestidega.

* Sisend loetakse failist, kuhu sisestatakse a, b ja x-i vähim ja suurim 
väärtus. Tulemuste arvutamiseks kasutatakse eelnevalt loodud ja testitud 
funktsiooni, realiseeriv klass valitakse vastavalt b väärtusele - nulli puhul 
esimene lihtsam variant. Koosta faili lugeva rakenduse väljundi kontrolliks 
automaattest.


 */
