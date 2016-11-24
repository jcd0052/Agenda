package ubu.lsi.dms.agenda.modelo;

/**
 * Interface para clonar las entidades
 * 
 * @author José Ramón Cuevas Diez
 * 
 * @param <T>
 */
public interface Clonable<T> {
	T copia();
}
