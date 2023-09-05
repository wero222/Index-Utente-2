package it.corso.service;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService
{
	@Override
	public void registrazioneUtente(String nome, String username, String password)
	{
		Utente utente = new Utente();
		utente.setNome(nome);
		utente.setUsername(username);
		utente.setPassword(password);
		// ... passare l'oggetto Utente al componente del Data Layer per l'archiviazione
		System.out.println("Utente " + utente.getNome() + " registrato");
	}

	@Override
	public boolean controlloDatiUtente(String... dati)
	{
		return 
				Pattern.matches(REGEX_NOME, dati[0]) &&
				Pattern.matches(REGEX_USERNAME, dati[1]) &&
				Pattern.matches(REGEX_PASSWORD, dati[2]);
	}
}