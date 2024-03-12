package plantilla.codigo.pojo;

import java.util.Objects;

public abstract class Animal {

	private int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Animales [id=" + id + "]";
	}

}
