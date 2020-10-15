package br.pb.selenium.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataGenerator {
	
	public static String genNome() {
		return new Faker(new Locale("pt-BR")).name().nameWithMiddle();
	}
	
	public static String genEmail() {
		return new Faker(new Locale("pt-BR")).internet().emailAddress();
	}
	
	public static String genSenha() {
		return new Faker(new Locale("pt-BR")).internet().password();
	}	
}