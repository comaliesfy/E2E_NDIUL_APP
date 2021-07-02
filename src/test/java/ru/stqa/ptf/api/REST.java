package ru.stqa.ptf.api;

import Configs.ClientConfigs;
import Configs.UserConfigRoles;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static Configs.ClientConfigs.*;
import static Configs.URLPages.STAND;
import static Configs.URLPages.URL_endpoint;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class REST {

    //Логин
    public java.lang.Object loginGetCookie() {
        RequestSpecification request = given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.body("username=" + UserConfigRoles.USR_CREATOR_FOR_REST);
        Response response = request.post(STAND + "tax-sunr/sbr-ndkn/login.html");
        assertEquals(response.getStatusCode(), 200);
        return response.getCookies().toString().substring(1, 42);
    }

    //Клиенты
    public String createClient() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": -1,\n" +
                        "    \"clientName\": \"\",\n" +
                        "    \"latinName\": \"" + CLIENT_NAME + "\",\n" +
                        "    \"inn\": \"" + CLIENT_INN + "\",\n" +
                        "    \"russianInn\": \"\",\n" +
                        "    \"swift\": \"\",\n" +
                        "    \"kio\": null,\n" +
                        "    \"kpp\": \"\",\n" +
                        "    \"address\": \"\",\n" +
                        "    \"kind\": 1,\n" +
                        "    \"country\": {\n" +
                        "        \"id\": 73,\n" +
                        "        \"free\": true,\n" +
                        "        \"active\": true\n" +
                        "    },\n" +
                        "    \"phoneNumber\": \"\",\n" +
                        "    \"addressZip\": \"\",\n" +
                        "    \"region\": \"\",\n" +
                        "    \"city\": \"\",\n" +
                        "    \"district\": \"\",\n" +
                        "    \"street\": \"\",\n" +
                        "    \"house\": \"\",\n" +
                        "    \"building\": \"\",\n" +
                        "    \"apartment\": \"\",\n" +
                        "    \"place\": false,\n" +
                        "    \"almanac\": false,\n" +
                        "    \"status\": false,\n" +
                        "    \"prove\": false,\n" +
                        "    \"foreignDepartment\": false,\n" +
                        "    \"activities\": []\n" +
                        "}")
                .post(URL_endpoint + "crud/client/");
        assertEquals(200, response.getStatusCode());
        return (response.getBody().jsonPath().getString("id"));
    }

    //создание клиента дубликата
    public String createClientDedub() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": -1,\n" +
                        "    \"clientName\": \"\",\n" +
                        "    \"latinName\": \"" + ClientConfigs.DEDUB_CLIENT_NAME + "\",\n" +
                        "    \"inn\": \"" + ClientConfigs.DEDUB_CLIENT_INN + "\",\n" +
                        "    \"russianInn\": \"\",\n" +
                        "    \"swift\": \"" + ClientConfigs.DEDUB_CLIENT_SWIFT + "\",\n" +
                        "    \"kio\": null,\n" +
                        "    \"kpp\": \"\",\n" +
                        "    \"address\": \"\",\n" +
                        "    \"kind\": 1,\n" +
                        "    \"country\": {\n" +
                        "        \"id\": 18,\n" +
                        "        \"cntCode\": \"BD\",\n" +
                        "        \"cntNum3\": \"744\",\n" +
                        "        \"cntName\": \"" + ClientConfigs.DEDUB_CLIENT_COUNTRY + "\",\n" +
                        "        \"cntFdate\": null,\n" +
                        "        \"cntCdate\": null,\n" +
                        "        \"cntFusrId\": null,\n" +
                        "        \"cntCusrId\": null,\n" +
                        "        \"free\": true,\n" +
                        "        \"active\": true\n" +
                        "    },\n" +
                        "    \"phoneNumber\": \"\",\n" +
                        "    \"addressZip\": \"\",\n" +
                        "    \"region\": \"\",\n" +
                        "    \"city\": \"\",\n" +
                        "    \"district\": \"\",\n" +
                        "    \"street\": \"\",\n" +
                        "    \"house\": \"\",\n" +
                        "    \"building\": \"\",\n" +
                        "    \"apartment\": \"\",\n" +
                        "    \"place\": false,\n" +
                        "    \"almanac\": true,\n" +
                        "    \"status\": false,\n" +
                        "    \"prove\": true,\n" +
                        "    \"foreignDepartment\": false,\n" +
                        "    \"activities\": []\n" +
                        "}")
                .post(URL_endpoint + "crud/client/");
        assertEquals(200, response.getStatusCode());
        return (response.getBody().jsonPath().getString("id"));
    }

    //поиск клиента
    public String findClient() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .get(URL_endpoint + "client/list?page=1&rowsOnPage=30&clName=" + CLIENT_NAME + "&inn=" + CLIENT_INN + "&type=0&place=0&fDept=0&state=0&status=0&prove=0");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getJsonObject("responseRecordsList.id").toString().substring(1, 6);
    }

    //поиск клиента дубликата
    public String findClientDedub() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .get(URL_endpoint + "client/list?page=1&rowsOnPage=30&clName=" + DEDUB_CLIENT_NAME + "&type=0&place=0&fDept=0&state=0&status=0&prove=0");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getJsonObject("responseRecordsList.id").toString().substring(1, 6);
    }

    //удаление клиента
    public void deleteClient(String id) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .delete(URL_endpoint + "client/" + id);
        assertEquals(200, response.getStatusCode());
    }

    //Первичные документы
    public String createPDClient(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"crtFactRight\":{\"id\":1,\"value\":\"Неизвестен\",\"description\":\"Налоговому агенту неизвестна информация о фактическом праве иностранной организации или иного третьего лица на доход.\",\"code\":0,\"boolValue\":false},\"crtFaceCode\":{\"id\":1,\"value\":\"Неопределено\",\"boolValue\":false},\"showMessage\":false,\"clientId\":" + clientId + ",\"clientName\":\"" + CLIENT_NAMEdrop + "\",\"clientKindId\":1,\"clientCountryId\":73,\"crtNum\":\"20752\",\"crtIncomeMarkId\":1,\"currencyId\":112575,\"statusId\":1,\"crtSide\":0,\"rates\":[{\"freetypes\":[{\"id\":1,\"value\":\"Соглашение об освобождении\",\"boolValue\":false,\"code\":1},{\"id\":2,\"value\":\"Подтверждение местонахождения\",\"boolValue\":false,\"code\":2},{\"id\":3,\"value\":\"Подтверждение инф. источников\",\"boolValue\":false,\"code\":3},{\"id\":4,\"value\":\"Особый налоговый статус\",\"boolValue\":false,\"code\":4},{\"id\":5,\"value\":\"Нотариально заверен. копия свидетельства\",\"boolValue\":false,\"code\":5},{\"id\":6,\"value\":\"Уведомл. о доходе пост. пред-ства\",\"boolValue\":false,\"code\":6},{\"id\":7,\"value\":\"Внешнеторговый контракт\",\"boolValue\":false,\"code\":7},{\"id\":8,\"value\":\"Оказание услуг и выполнение работ за рубежом\",\"boolValue\":false,\"code\":8},{\"id\":9,\"value\":\"Оказ. услуг на нерегулярной (разо\",\"boolValue\":false,\"code\":9},{\"id\":10,\"value\":\"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\"boolValue\":false,\"code\":10},{\"id\":11,\"value\":\"Реализация обращающихся акций\",\"boolValue\":false,\"code\":11},{\"id\":12,\"value\":\"Вложение в уставный капитал больше пороговой суммы\",\"boolValue\":false,\"code\":12},{\"id\":13,\"value\":\"Подтверждение фактического права\",\"boolValue\":false,\"code\":13}],\"rtStatus\":\"Действующий\",\"incomeId\":40421,\"rtRate\":\"10\",\"rtDepoRate\":{},\"rtFacility\":\"\",\"autoFilled\":false,\"incFull\":\"Тестовый\",\"incCode\":\"01\",\"incSymbol\":\"14101\",\"index\":0}],\"crtRLetter\":0,\"docTypeId\":3678,\"departId\":108672,\"crtDate\":1578646800000}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&currencyId=112575&number=20752&date=1578646800000&pdType=3678");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    public String createPDContract(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"crtFactRight\":{\"id\":1,\"value\":\"Неизвестен\",\"description\":\"Налоговому агенту неизвестна информация о фактическом праве иностранной организации или иного третьего лица на доход.\",\"code\":0,\"boolValue\":false},\"crtFaceCode\":{\"id\":1,\"value\":\"Неопределено\",\"boolValue\":false},\"showMessage\":false,\"clientId\":" + clientId + ",\"clientName\":\"" + CLIENT_NAMEdrop + "\",\"clientKindId\":1,\"clientCountryId\":73,\"crtNum\":\"20852\",\"crtIncomeMarkId\":1,\"currencyId\":112575,\"statusId\":1,\"crtSide\":1,\"rates\":[{\"freetypes\":[{\"id\":1,\"value\":\"Соглашение об освобождении\",\"boolValue\":false,\"code\":1},{\"id\":2,\"value\":\"Подтверждение местонахождения\",\"boolValue\":false,\"code\":2},{\"id\":3,\"value\":\"Подтверждение инф. источников\",\"boolValue\":false,\"code\":3},{\"id\":4,\"value\":\"Особый налоговый статус\",\"boolValue\":false,\"code\":4},{\"id\":5,\"value\":\"Нотариально заверен. копия свидетельства\",\"boolValue\":false,\"code\":5},{\"id\":6,\"value\":\"Уведомл. о доходе пост. пред-ства\",\"boolValue\":false,\"code\":6},{\"id\":7,\"value\":\"Внешнеторговый контракт\",\"boolValue\":false,\"code\":7},{\"id\":8,\"value\":\"Оказание услуг и выполнение работ за рубежом\",\"boolValue\":false,\"code\":8},{\"id\":9,\"value\":\"Оказ. услуг на нерегулярной (разо\",\"boolValue\":false,\"code\":9},{\"id\":10,\"value\":\"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\"boolValue\":false,\"code\":10},{\"id\":11,\"value\":\"Реализация обращающихся акций\",\"boolValue\":false,\"code\":11},{\"id\":12,\"value\":\"Вложение в уставный капитал больше пороговой суммы\",\"boolValue\":false,\"code\":12},{\"id\":13,\"value\":\"Подтверждение фактического права\",\"boolValue\":false,\"code\":13}],\"rtStatus\":\"Действующий\",\"incomeId\":10147,\"rtRate\":\"20\",\"rtDepoRate\":{},\"rtFacility\":\"\",\"autoFilled\":false,\"incFull\":\"Доход контрагентов\",\"incCode\":\"20000\",\"incSymbol\":\"12345\",\"index\":0}],\"crtRLetter\":0,\"docTypeId\":3678,\"departId\":108672,\"crtDate\":1578646800000}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&currencyId=112575&number=20852&date=1578646800000&pdType=3678");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    public String createPDDepository(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"crtFactRight\":{\"id\":1,\"value\":\"Неизвестен\",\"description\":\"Налоговому агенту неизвестна информация о фактическом праве иностранной организации или иного третьего лица на доход.\",\"code\":0,\"boolValue\":false},\"crtFaceCode\":{\"id\":1,\"value\":\"Неопределено\",\"boolValue\":false},\"showMessage\":false,\"clientId\":" + clientId + ",\"clientName\":\"" + CLIENT_NAMEdrop + "\",\"clientKindId\":1,\"clientCountryId\":73,\"crtNum\":\"20952\",\"crtIncomeMarkId\":1,\"currencyId\":112575,\"statusId\":1,\"crtSide\":0,\"rates\":[{\"freetypes\":[{\"id\":1,\"value\":\"Соглашение об освобождении\",\"boolValue\":false,\"code\":1},{\"id\":2,\"value\":\"Подтверждение местонахождения\",\"boolValue\":false,\"code\":2},{\"id\":3,\"value\":\"Подтверждение инф. источников\",\"boolValue\":false,\"code\":3},{\"id\":4,\"value\":\"Особый налоговый статус\",\"boolValue\":false,\"code\":4},{\"id\":5,\"value\":\"Нотариально заверен. копия свидетельства\",\"boolValue\":false,\"code\":5},{\"id\":6,\"value\":\"Уведомл. о доходе пост. пред-ства\",\"boolValue\":false,\"code\":6},{\"id\":7,\"value\":\"Внешнеторговый контракт\",\"boolValue\":false,\"code\":7},{\"id\":8,\"value\":\"Оказание услуг и выполнение работ за рубежом\",\"boolValue\":false,\"code\":8},{\"id\":9,\"value\":\"Оказ. услуг на нерегулярной (разо\",\"boolValue\":false,\"code\":9},{\"id\":10,\"value\":\"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\"boolValue\":false,\"code\":10},{\"id\":11,\"value\":\"Реализация обращающихся акций\",\"boolValue\":false,\"code\":11},{\"id\":12,\"value\":\"Вложение в уставный капитал больше пороговой суммы\",\"boolValue\":false,\"code\":12},{\"id\":13,\"value\":\"Подтверждение фактического права\",\"boolValue\":false,\"code\":13}],\"rtStatus\":\"Действующий\",\"incomeId\":40920,\"rtRate\":\"30\",\"rtDepoRate\":{},\"rtFacility\":\"\",\"autoFilled\":false,\"incFull\":\"Дивиденды Депозитария \",\"incCode\":\"04\",\"incSymbol\":\"14585\",\"index\":0}],\"crtRLetter\":0,\"docTypeId\":1,\"departId\":\"70\",\"source\":\"DEPO\",\"departName\":\"Депозитарий\",\"docTypeName\":\"Договор\",\"crtDate\":1578646800000}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&currencyId=112575&number=20952&date=1578646800000&pdType=1");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    public String createPDDepositoryCon(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"crtFactRight\":{\"value\":\"\",\"description\":\"\",\"code\":5},\"showMessage\":false,\"clientId\":" + clientId + ",\"clientKindId\":1,\"clientCountryId\":73,\"crtNum\":\"21052\",\"crtIncomeMarkId\":1,\"statusId\":1,\"crtSide\":0,\"rates\":[],\"crtRLetter\":0,\"docTypeId\":\"5\",\"departId\":\"70\",\"source\":\"DEPO\",\"departName\":\"Депозитарий\",\"statusName\":\"Действующий\",\"freetypes\":[{\"id\":1,\"value\":\"Соглашение об освобождении\",\"boolValue\":false},{\"id\":2,\"value\":\"Подтверждение местонахождения\",\"boolValue\":false},{\"id\":3,\"value\":\"Подтверждение инф. источников\",\"boolValue\":false},{\"id\":4,\"value\":\"Особый налоговый статус\",\"boolValue\":false},{\"id\":5,\"value\":\"Нотариально заверен. копия свидетельства\",\"boolValue\":false},{\"id\":6,\"value\":\"Уведомл. о доходе пост. пред-ства\",\"boolValue\":false},{\"id\":7,\"value\":\"Внешнеторговый контракт\",\"boolValue\":false},{\"id\":8,\"value\":\"Оказание услуг и выполнение работ за рубежом\",\"boolValue\":false},{\"id\":9,\"value\":\"Оказ. услуг на нерегулярной (разо\",\"boolValue\":false},{\"id\":10,\"value\":\"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\"boolValue\":false},{\"id\":11,\"value\":\"Реализация обращающихся акций\",\"boolValue\":false},{\"id\":12,\"value\":\"Вложение в уставный капитал больше пороговой суммы\",\"boolValue\":false},{\"id\":13,\"value\":\"Подтверждение фактического права\",\"boolValue\":false}],\"deporates\":[],\"docTypeName\":\"Договоры Депозитария\",\"crtDate\":1578646800000}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&number=21052&date=1578646800000&pdType=5");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    //Операции
    public String createOperClient(String contractID) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": null,\n" +
                        "    \"userId\": 129175,\n" +
                        "    \"incomeId\": 40421,\n" +
                        "    \"incCurrencyId\": 112575,\n" +
                        "    \"incCurrencyRate\": 63.459,\n" +
                        "    \"contractId\": " + contractID + ",\n" +
                        "    \"incDate\": 1579078800000,\n" +
                        "    \"taxRate\": 10,\n" +
                        "    \"taxSum\": 635,\n" +
                        "    \"taxCurrencySum\": 10.01,\n" +
                        "    \"taxCurrencyId\": 112583,\n" +
                        "    \"incSum\": \"100.10\",\n" +
                        "    \"taxDate\": 1579510800000,\n" +
                        "    \"calcDate\": 1579078800000,\n" +
                        "    \"budgDate\": 1579165200000,\n" +
                        "    \"repoSum\": null,\n" +
                        "    \"messageNumber\": \"\"\n" +
                        "}")
                .post(URL_endpoint + "operation/");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    public String createOperContractor(String contractID) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": null,\n" +
                        "    \"userId\": 129175,\n" +
                        "    \"incomeId\": 10147,\n" +
                        "    \"incCurrencyId\": 112575,\n" +
                        "    \"incCurrencyRate\": 61.459,\n" +
                        "    \"contractId\": " + contractID + ",\n" +
                        "    \"incDate\": 1579078800000,\n" +
                        "    \"taxRate\": 20,\n" +
                        "    \"taxSum\": 1910.11,\n" +
                        "    \"taxId\": \"112746\",\n" +
                        "    \"taxCurrencySum\": 0,\n" +
                        "    \"taxCurrencyId\": 112575,\n" +
                        "    \"incSum\": \"150.50\",\n" +
                        "    \"taxDate\": 1579510800000,\n" +
                        "    \"budgDate\": 1579122000000\n" +
                        "}")
                .post(URL_endpoint + "operation/");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    public String createOperDepo(String contractID) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": null,\n" +
                        "    \"userId\": 129175,\n" +
                        "    \"incomeId\": 40920,\n" +
                        "    \"incCurrencyId\": 112575,\n" +
                        "    \"incCurrencyRate\": 63.459,\n" +
                        "    \"contractId\": " + contractID + ",\n" +
                        "    \"incDate\": 1579078800000,\n" +
                        "    \"taxRate\": 30,\n" +
                        "    \"taxSum\": 1906,\n" +
                        "    \"taxCurrencySum\": 30.03,\n" +
                        "    \"taxCurrencyId\": 112583,\n" +
                        "    \"incSum\": \"100.10\",\n" +
                        "    \"taxDate\": 1579510800000,\n" +
                        "    \"calcDate\": 1579510800000,\n" +
                        "    \"budgDate\": 1579165200000,\n" +
                        "    \"depoRateId\": 132582,\n" +
                        "    \"issuerId\": null,\n" +
                        "    \"messageNumber\": \"\"\n" +
                        "}")
                .post(URL_endpoint + "operation/");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    //Декларации
    public String createKND56() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"id\":null,\"period\":{\"id\":\"38081\"},\"status\":null,\"type\":{\"id\":1,\"code\":null,\"name\":null},\"changeDate\":null,\"printDate\":1588064400000,\"transitionDate\":1586941200000,\"listsNumber\":null,\"active\":true,\"correctionNumber\":null,\"transportId\":null}")
                .post(URL_endpoint + "declarations/params");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getString("payload.id");
    }

    public String findKND56() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .get(URL_endpoint + "declarations/list?payload.year=2020&payload.periodId=38081&payload.declarationTypeId=1&page=0&size=30&property=type.name&direction=ASC");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getString("payload.id").substring(1, 5);
    }

    public void deleteKND56(String id) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .delete(URL_endpoint + "declarations/params?id=" + id);
        assertEquals(200, response.getStatusCode());
    }

    public String createKND24() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\"id\":null,\"period\":{\"id\":\"38081\"},\"status\":null,\"type\":{\"id\":\"2\",\"code\":null,\"name\":null},\"changeDate\":null,\"printDate\":1588064400000,\"transitionDate\":null,\"listsNumber\":null,\"active\":true,\"correctionNumber\":null,\"transportId\":null}")
                .post(URL_endpoint + "declarations/params");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getString("payload.id");
    }

    public String findKND24() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .get(URL_endpoint + "declarations/list?payload.year=2020&payload.periodId=38081&payload.declarationTypeId=2");
        assertEquals(200, response.getStatusCode());
        String l = response.getBody().jsonPath().getString("payload.id");
        return l.substring(1, l.length() - 1);
    }

    public void deleteKND24(String id) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .delete(URL_endpoint + "declarations/params?id=" + id);
        assertEquals(200, response.getStatusCode());
    }

    public String createRepresentation() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": -1,\n" +
                        "    \"clientName\": \"" + CLIENT_NAMERUS + "\",\n" +
                        "    \"latinName\": null,\n" +
                        "    \"inn\": \"" + CLIENT_INNRUS + "\",\n" +
                        "    \"russianInn\": null,\n" +
                        "    \"swift\": null,\n" +
                        "    \"kio\": null,\n" +
                        "    \"kpp\": null,\n" +
                        "    \"address\": \"\",\n" +
                        "    \"kind\": 1,\n" +
                        "    \"country\": {\n" +
                        "        \"id\": 73,\n" +
                        "        \"cntCode\": \"WF\",\n" +
                        "        \"cntNum3\": \"442\",\n" +
                        "        \"cntName\": \"УОЛЛИС И ФУТУНА\",\n" +
                        "        \"cntFdate\": null,\n" +
                        "        \"cntCdate\": null,\n" +
                        "        \"cntFusrId\": null,\n" +
                        "        \"cntCusrId\": null,\n" +
                        "        \"free\": true,\n" +
                        "        \"active\": true\n" +
                        "    },\n" +
                        "    \"phoneNumber\": \"\",\n" +
                        "    \"addressZip\": \"\",\n" +
                        "    \"region\": \"\",\n" +
                        "    \"city\": \"\",\n" +
                        "    \"district\": \"\",\n" +
                        "    \"street\": \"\",\n" +
                        "    \"house\": \"\",\n" +
                        "    \"building\": \"\",\n" +
                        "    \"apartment\": \"\",\n" +
                        "    \"place\": null,\n" +
                        "    \"almanac\": null,\n" +
                        "    \"status\": null,\n" +
                        "    \"prove\": null,\n" +
                        "    \"foreignDepartment\": true,\n" +
                        "    \"activities\": [\n" +
                        "        {\n" +
                        "            \"id\": 43,\n" +
                        "            \"code\": \"Деятельность\",\n" +
                        "            \"name\": \"1234\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .post(URL_endpoint + "crud/client/");
        assertEquals(200, response.getStatusCode());
        return response.getBody().jsonPath().getString("payload.id");
    }

    public String findRepresentation() {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .get(URL_endpoint + "client/list?page=1&rowsOnPage=30&sortBy=ruName&orderBy=ASC&country=0&inn=447711101742&type=0&place=0&fDept=0&state=0&status=0&prove=0");
        assertEquals(200, response.getStatusCode());
        String l = response.getBody().jsonPath().getString("responseRecordsList.id");
        return l.substring(1, l.length() - 1);
    }

    public void deleteRepresentation(String id) {
        Response response = RestAssured.given()
                .header("Cookie", loginGetCookie())
                .delete(URL_endpoint + "client/" + id);
        assertEquals(200, response.getStatusCode());
    }

}
