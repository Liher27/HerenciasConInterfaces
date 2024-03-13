package plantilla.codigo.pojo;

import java.util.Objects;

/**
 * Un Gato de la tabla t_perros
 */
public class Perro extends Mamifero{

	private String vacunado = null;

	public String isVacunado() {
		return vacunado;
	}

	public void setVacunado(String vacunado) {
		this.vacunado = vacunado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(vacunado);
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
		Perro other = (Perro) obj;
		return vacunado == other.vacunado;
	}

	@Override
	public String toString() {
		return "Perro [vacunado=" + vacunado + "]";
	}
}
