package it.corso.service;

public interface UtenteService
{
	String REGEX_NOME = "[a-zA-Z\\s']{1,50}";
	String REGEX_USERNAME = "[a-zA-Z.]{1,20}";
	String REGEX_PASSWORD = "[a-zA-Z0-9]{1,10}";
	void registrazioneUtente(String nome, String username, String password);
	boolean controlloDatiUtente(String... dati);
}