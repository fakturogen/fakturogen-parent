package pl.fakturogen.comarch.connector;

public class ApiConnector {

    // ta klasa zawiera listę adresów, pod które są wysyłane zapytania do Comarchu
    // udostępnia metody, które przyjmują typ np. Product i działa na request i response,
    // wysyła na zewnąrz request i otrzymuje response, w którym jest JSON z odpowiedzią z Comarchu, odpowiedź przekazuje
    // do odpowiedniego serwisu, który wywołał tą klasę i serwis przerabia JSONa (wykorzystuje Converter) i serwis wysyła
    // dalej odpowiedź do ComarchDataProvider i ten do ExternalApiDataProvider

}
