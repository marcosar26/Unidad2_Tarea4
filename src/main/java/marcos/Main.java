package marcos;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://rickandmortyapi.com/api/character/?status=alive&species=alien";

        Set<Personaje> personajesVivosAliens = obtenerPersonajes(url);

        personajesVivosAliens.forEach(System.out::println);
        System.out.println("Número de personajes vivos y alienígenas: " + personajesVivosAliens.size());

        url = "https://rickandmortyapi.com/api/character/?gender=female";

        Personaje personajeFemeninoMasEpisodios = Collections.max(obtenerPersonajes(url), Comparator.comparing(personaje -> personaje.getEpisode().length));

        System.out.println(personajeFemeninoMasEpisodios);
    }

    public static Set<Personaje> obtenerPersonajes(String url) {
        Set<Personaje> personajes = new HashSet<>();

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode node = mapper.readTree(new URL(url));
            String next;
            for (; ; ) {
                next = node.path("info").path("next").textValue();

                Personaje[] personajesArray = mapper.treeToValue(node.path("results"), Personaje[].class);

                personajes.addAll(List.of(personajesArray));

                if (next == null || next.isBlank()) break;

                node = mapper.readTree(new URL(next));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personajes;
    }
}
