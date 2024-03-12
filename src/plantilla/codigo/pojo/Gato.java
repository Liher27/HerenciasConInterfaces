package plantilla.codigo.pojo;

import java.util.Objects;

/**
 * Un Gato de la tabla t_gatos
 */
public class Gato extends Mamifero{

	private String color = null;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(color);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gato other = (Gato) obj;
		return Objects.equals(color, other.color);
	}

	@Override
	public String toString() {
		return "Gato [color=" + color + "]";
	}

}
