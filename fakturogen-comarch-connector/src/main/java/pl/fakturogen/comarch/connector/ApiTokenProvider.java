package pl.fakturogen.comarch.connector;

public class ApiTokenProvider {
    // ta klasa łączy się z aplikacją Comarchu
    // tutaj opis procedury uzyskiwania danych:
    // https://pomoc.erpxt.pl/dokumentacja/api-autoryzacja/
    // wykorzystuje dane zarejestrowane dla Usera, tzn. Client ID i Client Secret, w celu pozyskania tokenu
    // token jest ważny 10 minut, musi być przechowywany i przekazany do klas Uploader i Downloader dla każdego żądania
    // tzn. klasy wysyłające zapytania do Comarchu muszą mieć token, aby Comarch przyjął request
    // trzeba wymyślić sposób, jak przechowywać token przez 10 min

    public Token getToken(){
        Token token = new Token();
        return token;
    }
}
