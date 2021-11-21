package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaRegex {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Metacaracteres podem nos ajudar na vereficacao ou na procura de textos, vo falar de alguns que podem ser
		//Usados no dia a dia, mas se quiser procura por mais

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// . - Procura/Verifica qualquer caractere.
		// \d - Procura/Verifica todos os digitos.
		// \D - Procura/Verifica tudo que nao e digito.
		// \s - Procura/Verifica todos os espacos em brancos. Obs.: Os comandos (\n \t \f \r \x0B) tambem contam.
		// \S - Procura/Verifica qualquer caractere sem espaco em branco.
		// \w - Procura/Verifica caracteres de palavras, como a-z, A-Z, digitos e underline ( _ ).
		// \W - Procura/Verifica tudo que nao e caracteres de palavras.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// (?i) - Ignora letras maiusculas e minusculas.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Obs.: Estou colocando "X", porque pode ser qualquer metacaractere nao use o X ._., e o N porque pode ser qualquer
		//Numero
		
		// \X{n} - Define o minimo e o maximo, ou seja, a string precisa ter o numero de caracteres que esta dentro das chaves
		// \X{n,} - Define apenas o minimo e nao tem maximo.
		// \X{n,n} - Define o minimo e o maximo.
		// \X? - Algum metacaractere mas o minimo e 0 e o maximo 1, mesma coisa que X{0,1}, mas digitando menos
		// \X* - 0 ou Mais Vezes.
		// \X+ - 1 Ou mais Vezes.
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// \^ - Sinal de negacao.
		// \$ - Significa o final da string.
		// \| - Significa "ou".

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// [a-z] - Todas as letras minusculas
		// [A-Z] - Todas as letras maiusculas
		// [0-9] - Todos os numeros
		// [a-z][A-Z] - Agrumento de dois grupos, agora aceitamos letras maiusculas e minusculas
		// () Com os parenteses podemos juntar algumas expressoes, como o | (ou), ^(comeco) e $(final).
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Para poder digitar alguma vereficacao precisamos usar outro contra-barra, porque o contra-barra no java e usado
		//Para outras coisas, como o "\n" para ir pra outra linha, ou seja, pro Java reconhecer os metacaracteres precisamos
		//Usar outra contra barra.
		
		//Por exemplo:
		
		while (true) {
			scan.useDelimiter("\r\n");//Para o scanner nao bugar com espaco
			
			System.out.println("Digite um Numero e uma Letra se Quiser: ");
			String string = scan.next();
			if(string.matches("\\d{1}\\D{0,1}")) {//Quando tem as chaves quer dizer o minimo e o maximo, ou seja, quando tem
				//Apenas um numero, aquele e o minimo e o maximo, ou seja, se tiver escrito apenas 10, precisamos digitar
				//10 numeros, mas se tiver "1,2" o minimo digitado e 1 e o maximo 2, mas se tiver "1," quer dizer que o minimo
				//E 1 e nao tem limite.
				
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("Digite um Cpf (Com os pontos e o traco): ");
			String cpf = scan.next();
			if(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {//Assim eu estou obrigando a pessoa a digitar os pontos e os
				//Tracos do CPF, precisamos usar os tracinhos nos pontos, porque se nao o java vai aceitar qualquer caractere
				//Como ta explicado la em cima.
	
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("Test1: ");
			String test1 = scan.next();
			
			if(test1.matches("[a-z]{0,}[0-9]{0,}")) {//Pedindo letras e depois numeros sem limite, mas tem que ser na ordem
				
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("Test2: ");
			String test2 = scan.next();
			
			if(test2.matches("(?i)joao")) {//Podemos escrever joao com maiusculas ou minusculas.
				
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("Digite seu nome (Primeira letra Maiuscula): ");
			String test3 = scan.next();
			
			if(test3.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {//Nome com minimo de 3 letras e apenas a primeira letra maiuscula.
				//Se voce percerber tem um espaco entre o "+ [A-Z]", porque a gente so vai aceitar nomes e sobrenomes com
				//Um espaco entre eles, e eles tem que comecar com a letra maiuscula
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("test4: ");
			String test4 = scan.next();
			
			if(test4.matches("[a-zA-Z0-9]+")) {//Tem como juntar tudo tambem e desse jeito voce pode escrever em qualquer
				//Ordem.
				
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("test5: ");
			String test5 = scan.next();
			
			if(test5.matches("([A-Z][a-z]+\\s{0,1})+")) {//Isso eu uso para vereficar os nomes, ou seja, ele so aceita letras, e
				//A primeira letra depois do espaco tem que ser maiuscula e so aceita apenas um ou nenhum espaco entre elas,
				//mas ai voce me fala, ele permite espaco no final, isso nao seria ruim? E so usar o metodo .trim() que ele tiras 
				//Os espacos :D
				System.out.println("\nTa certo");
				test5.trim();
			} else {
				System.out.println("\nTa errado");
			}
			
			System.out.println("test6: ");
			String test6 = scan.next();
			
			//Vereficador de email
			if(test6.matches("[\\w\\.-]+@[A-Za-z]+(\\.[A-Za-z]+)+")) {//Ou seja, precisamos botar a ultima parte em
				//Paretenses, porque ta escrito assim: obrigatorio ter UM ponto e depois desse ponto e preciso ter letras (Nao
				//Tem limite para o tanto de letra depois do ponto, por causa do "+") tudo isso em parenteses e com um "+" 
				//No final, porque essa repeticao pode acontecer mais de uma vez, ou seja, ".com.ba.br"
				System.out.println("\nTa certo");
			} else {
				System.out.println("\nTa errado");
			}
			
			String regex = "foto[^,]*";//Ou seja, ele vai procurar um texto com "foto" e ele esta aceitando tudo quem vem
			//depois de "foto" MENOS as virgulas, ou seja, quando ele achar uma virgula ele para e vai procurar outro.
			Pattern pattern = Pattern.compile(regex);
			String test7 = "foto, foto1, foto209, foto34, texto1, texto2, arquivo1, arquivo2";
			
			Matcher matcher = pattern.matcher(test7);
			
			while(matcher.find()) {
				System.out.println("Index: " + matcher.start() + ", Texto: " + matcher.group());
			}
		}
	}
}