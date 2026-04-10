package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {
    public CircuitBuilder() {

    }


    public Composant constuireCircuit(String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(pathname ));
        return lireComposant(node);
    }
    private Composant lireComposant(JsonNode node) throws IOException {
        String type = node.get("circuit").get("type").asText();
        switch (type){
            case "resistance":
                return new Resistance(node.get("circuit").get("valeur").asDouble());
            case "serie":
                List<Composant> composantsSerie = new ArrayList<>();
                for(JsonNode b : node.get("circuit").get("composants")){

                    composantsSerie.add(lireComposant(b));
                }
                return new CircuitSerie(composantsSerie);



            case "parallele":
                List<Composant> composantsParallele = new ArrayList<>();
                for(JsonNode b : node.get("circuit").get("composants")){

                    composantsParallele.add(lireComposant(b));
                }
                return new CircuitSerie(composantsParallele);



        }
        throw new IllegalArgumentException();
        }





    }







