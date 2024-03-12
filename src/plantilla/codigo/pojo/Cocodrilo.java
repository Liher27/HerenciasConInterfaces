package plantilla.codigo.pojo;

import java.util.Objects;

public class Cocodrilo extends Reptil {

	public int numeroDientes = 0;

	@Override
	public String toString() {
		return "Cocodrilo [numeroDientes=" + numeroDientes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroDientes);
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
		Cocodrilo other = (Cocodrilo) obj;
		return numeroDientes == other.numeroDientes;
	}

	public int getNumeroDientes() {
		return numeroDientes;
	}

	public void setNumeroDientes(int numeroDientes) {
		this.numeroDientes = numeroDientes;
	}

}
