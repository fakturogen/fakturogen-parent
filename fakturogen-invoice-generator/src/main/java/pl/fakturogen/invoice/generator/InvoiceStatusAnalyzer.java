package pl.fakturogen.invoice.generator;

class InvoiceStatusAnalyzer {

    // 1) metoda, która sprawdza aktualną listę faktur w bazie naszej, czy zgadza się z listą faktur w Comarchu
    // m.in. sprawdza czy faktury, które mamy jaki mają status w Comarchu (zatwierdzony, czy w buforze)
    // sprawdza po id dokumentu Comarchowym i statusie
    // jeżeli w Comarchu są faktury o danym id ale o innym statusie, to aktualizuje status u nas

    boolean updateStatus() {
        return false;
    }

}
