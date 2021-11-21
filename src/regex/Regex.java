package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		//Chegamo em regex, famosamente conhecido como coisa do demo. So vamo
		
		//Mas o que e regex? Basicamente quando voce quer definir um padrao ou achar um padrao em algum texto, Regex
		//Sao muito boas para vereficacao de cpf, nome, telefone etc.
		
		//Primeiro temos que criar um objeto da classe padrao
		
		String regex = "[0-9]{10}";//Ou seja, nosso padrao sao 10 numeros de 0 a 9. o primeiro parametro e os tipos 
		//De dados que vamos aceitar e o segundo e a quantidade.
		String texto = "0123456789";
		
		Pattern pattern = Pattern.compile(regex);//precisamos compilar, porque primeiramente precisamos de um objeto
		//Pattern para criar um objeto Matcher e o unico jeito de criar e usando o compile, e segundamente se a gente usar
		//Esse mesmo padrao em varios lugares, vamos deixar o sistema muito mais rapido do que so fazer isso:
		
		if(texto.matches(regex)) {
			System.out.println("TOP");
		}
		
		//Esse comando abaixo e examente equivalente ao de cima, ou seja, toda vez que fizermos uma comparacao sem
		//Fazer um compile igual o comando acima, o codigo vai criar pra gente, ou seja, imagine ter varias comparacoes
		//Iguais, o java vai fazer varios comandos compile, sendo que a gente pode fazer apenas 1 e resolver o problema,
		//Mas claro, se voce for usar um regex apenas pra uma vereficacao e melhor usar o comando de cima.
		if(Pattern.compile(regex).matcher(texto).matches()) {
			System.out.println("TOP²");
	    }
		
		//Fazendo do jeito que e melhor caso a gente use a regex em varios lugares:
		
		Matcher matcher = pattern.matcher(texto); //Criamos um objeto Matcher com a Pattern la em cima.
		
		if(matcher.matches()) {//Aqui ele ta comparando a regex com o texto que criamos.
			System.out.println("Top");
		}
		
		//Mas se eu quiser comparar a mesma regex com outro texto?
		
		String texto2 = "abc"; //Outro texto
		
		//Vamos usar o metodo reset(), ou seja, vamos resetar o Matcher para ele trabalhar com outro texto
		
		System.out.println(matcher.reset(texto2).matches()); //Como podemos ver e false, porque a regex ta usando
		//Padroes de numeros e aqui o texto usa letras
		
		//Aqui usamos o mesmo objeto matcher e a mesma regex em outro lugar, ou seja, se for usar a regex em 
		//Varios lugares use o compile para o codigo ficar rapidin e limpo. Por exemplo em um loop for, se a gente nao fizer
		//Um compile antes ele vai fazer dentro do loop for VARIAS VEZES, por exemplo:
		
		String[] array = new String[4];
		array[0] = "0547892561";
		array[1] = "abcdefghi";
		array[2] = "0000000000";
		array[3] = "aaaaaaaaaa";
		
		int i = 0;
		for(String s : array) {
			System.out.println("Array (" + i + "): " + matcher.reset(s).matches());//Precisamos resetar toda hora porque
			//Como e um array, vamos trabalhar cada vez com um texto diferente.
			i++;
		}
		//Como podemos ver o codigo funcionou perfeitamente e usamos apenas um compile, imagina se a gente tem um
		//Loop grandizinho, quantos compile o java vai usar? A gente vai correr o risco do sistema ficar lento, ou seja, cria
		//A porra de um objeto Pattern e Matcher quando for usar pra mais de um lugar :D, se for pra so um lugar ta de boa
		//Fazer esse comando:
		
//		if(texto.matches(regex)) {
//			System.out.println("TOP");
//		}
		
		//Obs.: Criamos um objeto Pattern e Matcher para usar seus metodos interessantes, como o...
		
		//Metodo find()...
		
		//Metodo find, e usado para achar algum padrao em um texto, tipo apertar o ctrl+f, testa ai pra vc ver
		
		String regexFind = "bonito";
		String textoFind = "Mano eu achei um cavalo muito bonito cara, combina comigo porque eu tambem sou bonito";
		
		Pattern patternFind = Pattern.compile(regexFind);
		Matcher matcherFind = patternFind.matcher(textoFind);
		
		System.out.println(matcherFind.find());//Se agente fazer isso, ele so vai retornar um boolean pra gente.
		
		System.out.println(matcherFind.start());//Para retornar o index pra gente a gente usa o metodo start(), mas porque
		//So retornou apenas um index se eu tenho dois bonito no texto? Poque quando ele acha o primeiro ele para, mas
		//Podemos fazer isso:
		
		while(matcherFind.find()) {//Ou seja, enquanto o matcher conseguir achar a palavra "Bonito" no texto, ele vai
			//Executar o codigo abaixo
			
			System.out.println(matcherFind.start() + " ");//Mas porque ele so retornou o ultimo agora? Porque o matcher
			//Ja procurou em cima e achou um, ou seja, ele foi em busca de outro, mas se voce quiser que ele mostre todos,
			//E so reseta-lo sem usar parametros
		}
		
		matcherFind.reset(); //Apenas isso
		System.out.println("===============");
		while(matcherFind.find()) {
			System.out.println(matcherFind.start() + " ");//Agora sim ele retornou todos os index onde tem a palavra
			//"Bonito" no texto
		}
		
		//Ok, mas se eu quiser retornar o valor, ou talvez colocar o valor que ele ache em uma variavel?
		
		//Metedo group()
		
		//o metodo group, ele retorna pra gente o valor.
		
		matcherFind.reset();
		System.out.println("===============");
		while(matcherFind.find()) {
			System.out.println(matcherFind.start() + " " + matcherFind.group());
		}
		
		StringBuilder sb = new StringBuilder();
		
		//Botando dentro de uma String/StringBuilder...
		
		matcherFind.reset();
		System.out.println("===============");
		while(matcherFind.find()) {
			int index = matcherFind.start();
			String string = matcherFind.group(); //Ele vai colocar todos os valores que bater com a Pattern do matcherFind
			sb.append(matcherFind.group() + " ");
			System.out.println("Index: " + index + ", StringNormal: " + string);
		}
		System.out.println("\nStringBuilder: " + sb);
		
		//Teste 1
		
		String regexTest1 = "aba";
		String textoTest1 = "abababa";
		
		//Se a gente perceber vamos conseguir achar "3" aba: abababa, um no comeco, um no meio e um no final, mas se
		//A gente apertar o ctrl+f no eclipse, vamos ver que ele so vai retornar 2 e e a mesma coisa com as Expressoes
		//Regulares (regex), por isso eu acho que eles usam regex na pesquisa do ctrl+f.
		
		Pattern patternTest1 = Pattern.compile(regexTest1);
		Matcher matcherTest1 = patternTest1.matcher(textoTest1);
		
		int iTest1 = 1;
		while(matcherTest1.find()) {
			System.out.println("Achei " + iTest1 + ". No index: " + matcherTest1.start());
			iTest1++;
		}
	}
}