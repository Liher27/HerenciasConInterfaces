package plantilla.codigo.pojo;

import java.util.Objects;

public class Reptil extends Animal{

	public boolean aguaDulce = false;
	public String especie = null;

	public boolean isAguaDulce() {
		return aguaDulce;
	}

	public void setAguaDulce(boolean aguaDulce) {
		this.aguaDulce = aguaDulce;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aguaDulce, especie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reptil other = (Reptil) obj;
		return aguaDulce == other.aguaDulce && Objects.equals(especie, other.especie);
	}

	@Override
	public String toString() {
		return "Reptil [aguaDulce=" + aguaDulce + ", especie=" + especie + "]";
	}

}
