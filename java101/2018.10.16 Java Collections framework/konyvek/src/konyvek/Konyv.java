package konyvek;

import java.util.Objects;

public class Konyv {
    private String szerzo;
    private String cim;
    
    public Konyv(String szerzo, String cim) {
        this.szerzo = szerzo;
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getCim() {
        return cim;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    @Override
    public String toString() {
        return "Konyv{" + "szerzo=" + szerzo + ", cim=" + cim + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.szerzo);
        hash = 11 * hash + Objects.hashCode(this.cim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Konyv other = (Konyv) obj;
        if (!Objects.equals(this.szerzo, other.szerzo)) {
            return false;
        }
        return true;
    }
}
