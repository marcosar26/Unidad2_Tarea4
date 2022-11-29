package marcos;

import java.net.URL;
import java.util.Objects;

public class Personaje {
    private int id;
    private String name;
    private String status;
    private String species;
    private URL[] episode;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Personaje {").append(System.lineSeparator());
        sb.append("id: ").append(id).append(System.lineSeparator());
        sb.append("nombre: ").append(name).append(System.lineSeparator());
        sb.append("estado: ").append(status).append(System.lineSeparator());
        sb.append("especie: ").append(species).append(System.lineSeparator());
        if (episode.length > 0) {
            sb.append("episodios: ").append(episode.length).append(System.lineSeparator());
            for (URL url : episode) {
                sb.append("- ").append(url).append(System.lineSeparator());
            }
        }
        sb.append("}").append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return id == personaje.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public URL[] getEpisode() {
        return episode;
    }

    public void setEpisode(URL[] episode) {
        this.episode = episode;
    }
}
