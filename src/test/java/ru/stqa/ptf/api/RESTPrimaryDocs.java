package ru.stqa.ptf.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Configs.URLPages.URL_endpoint;
import static org.junit.Assert.assertEquals;

public class RESTPrimaryDocs {
    REST rest = new REST();
//создание ПД депозитария со ставкой 0
    public String createPDDepoZero(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"crtFactRight\": {\n" +
                        "        \"value\": \"\",\n" +
                        "        \"description\": \"\",\n" +
                        "        \"code\": 5\n" +
                        "    },\n" +
                        "    \"showMessage\": false,\n" +
                        "    \"clientId\": " + clientId + ",\n" +
                        "    \"clientKindId\": 1,\n" +
                        "    \"clientCountryId\": 73,\n" +
                        "    \"crtNum\": \"31952\",\n" +
                        "    \"crtIncomeMarkId\": 1,\n" +
                        "    \"statusId\": 1,\n" +
                        "    \"crtSide\": 0,\n" +
                        "    \"rates\": [],\n" +
                        "    \"crtRLetter\": 0,\n" +
                        "    \"docTypeId\": \"5\",\n" +
                        "    \"departId\": \"70\",\n" +
                        "    \"source\": \"DEPO\",\n" +
                        "    \"departName\": \"Депозитарий\",\n" +
                        "    \"statusName\": \"Действующий\",\n" +
                        "    \"freetypes\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"value\": \"Соглашение об освобождении\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"value\": \"Подтверждение местонахождения\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 3,\n" +
                        "            \"value\": \"Подтверждение инф. источников\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"value\": \"Особый налоговый статус\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"value\": \"Нотариально заверен. копия свидетельства\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"value\": \"Уведомл. о доходе пост. пред-ства\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 7,\n" +
                        "            \"value\": \"Внешнеторговый контракт\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 8,\n" +
                        "            \"value\": \"Оказание услуг и выполнение работ за рубежом\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 9,\n" +
                        "            \"value\": \"Оказ. услуг на нерегулярной (разо\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 10,\n" +
                        "            \"value\": \"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 11,\n" +
                        "            \"value\": \"Реализация обращающихся акций\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 12,\n" +
                        "            \"value\": \"Вложение в уставный капитал больше пороговой суммы\",\n" +
                        "            \"boolValue\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 13,\n" +
                        "            \"value\": \"Подтверждение фактического права\",\n" +
                        "            \"boolValue\": false\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"deporates\": [\n" +
                        "        {\n" +
                        "            \"depositoryAccountId\": 4,\n" +
                        "            \"depositoryAccountName\": \"Счет депозитарных программ\",\n" +
                        "            \"ownerTypeId\": 2,\n" +
                        "            \"ownerTypeName\": \"ЮЛ\",\n" +
                        "            \"incomeKindId\": 1,\n" +
                        "            \"incomeKindName\": \"Дивиденды\",\n" +
                        "            \"nsiDeporateId\": 1001064,\n" +
                        "            \"nsiDepofacilityName\": \"\",\n" +
                        "            \"countryId\": 73,\n" +
                        "            \"countryName\": \"УОЛЛИС И ФУТУНА\",\n" +
                        "            \"rtRate\": \"0\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"docTypeName\": \"Договоры Депозитария\",\n" +
                        "    \"crtDate\": 1579165200000\n" +
                        "}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&number=31952&date=1579165200000&pdType=5");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    //созадние ПД клиента со ставкой 0
    public String createPDClientZero(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"crtFactRight\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"value\": \"Неизвестен\",\n" +
                        "        \"description\": \"Налоговому агенту неизвестна информация о фактическом праве иностранной организации или иного третьего лица на доход.\",\n" +
                        "        \"code\": 0,\n" +
                        "        \"boolValue\": false\n" +
                        "    },\n" +
                        "    \"crtFaceCode\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"value\": \"Неопределено\",\n" +
                        "        \"boolValue\": false\n" +
                        "    },\n" +
                        "    \"showMessage\": false,\n" +
                        "    \"clientId\": " + clientId + ",\n" +
                        "    \"clientName\": \"Autotest / Autotest\",\n" +
                        "    \"clientKindId\": 1,\n" +
                        "    \"clientCountryId\": 73,\n" +
                        "    \"crtNum\": \"30752\",\n" +
                        "    \"crtIncomeMarkId\": 1,\n" +
                        "    \"currencyId\": 112575,\n" +
                        "    \"statusId\": 1,\n" +
                        "    \"crtSide\": 0,\n" +
                        "    \"rates\": [\n" +
                        "        {\n" +
                        "            \"freetypes\": [\n" +
                        "                {\n" +
                        "                    \"id\": 1,\n" +
                        "                    \"value\": \"Соглашение об освобождении\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 1\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 2,\n" +
                        "                    \"value\": \"Подтверждение местонахождения\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 2\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 3,\n" +
                        "                    \"value\": \"Подтверждение инф. источников\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 3\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 4,\n" +
                        "                    \"value\": \"Особый налоговый статус\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 4\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 5,\n" +
                        "                    \"value\": \"Нотариально заверен. копия свидетельства\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 5\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 6,\n" +
                        "                    \"value\": \"Уведомл. о доходе пост. пред-ства\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 6\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 7,\n" +
                        "                    \"value\": \"Внешнеторговый контракт\",\n" +
                        "                    \"boolValue\": true,\n" +
                        "                    \"code\": 7\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 8,\n" +
                        "                    \"value\": \"Оказание услуг и выполнение работ за рубежом\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 8\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 9,\n" +
                        "                    \"value\": \"Оказ. услуг на нерегулярной (разо\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 9\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 10,\n" +
                        "                    \"value\": \"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 10\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 11,\n" +
                        "                    \"value\": \"Реализация обращающихся акций\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 11\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 12,\n" +
                        "                    \"value\": \"Вложение в уставный капитал больше пороговой суммы\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 12\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 13,\n" +
                        "                    \"value\": \"Подтверждение фактического права\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 13\n" +
                        "                }\n" +
                        "            ],\n" +
                        "            \"rtStatus\": \"Действующий\",\n" +
                        "            \"incomeId\": 40420,\n" +
                        "            \"rtRate\": \"0\",\n" +
                        "            \"rtDepoRate\": {\n" +
                        "                \"name\": \"Внешнеторговый контракт 99.99%\"\n" +
                        "            },\n" +
                        "            \"rtFacility\": \"п.2 ст.309 НК РФ\",\n" +
                        "            \"autoFilled\": false,\n" +
                        "            \"incFull\": \"Тестовый пид дохода\",\n" +
                        "            \"incCode\": \"01\",\n" +
                        "            \"incSymbol\": \"14102\",\n" +
                        "            \"index\": 0\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"crtRLetter\": 0,\n" +
                        "    \"docTypeId\": 3678,\n" +
                        "    \"departId\": 108672,\n" +
                        "    \"crtDate\": 1579165200000\n" +
                        "}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&currencyId=112575&number=30752&date=1579165200000&pdType=3678");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }

    //созадние ПД депо со ставкой 13
    public String createPDDepoThirteenRate(String clientId) {
        Response response = RestAssured.given()
                .header("Cookie", rest.loginGetCookie())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"crtFactRight\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"value\": \"Неизвестен\",\n" +
                        "        \"description\": \"Налоговому агенту неизвестна информация о фактическом праве иностранной организации или иного третьего лица на доход.\",\n" +
                        "        \"code\": 0,\n" +
                        "        \"boolValue\": false\n" +
                        "    },\n" +
                        "    \"crtFaceCode\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"value\": \"Неопределено\",\n" +
                        "        \"boolValue\": false\n" +
                        "    },\n" +
                        "    \"showMessage\": false,\n" +
                        "    \"clientId\": " + clientId + ",\n" +
                        "    \"clientName\": \"Autotest / Autotest\",\n" +
                        "    \"clientKindId\": 1,\n" +
                        "    \"clientCountryId\": 73,\n" +
                        "    \"crtNum\": \"40952\",\n" +
                        "    \"crtIncomeMarkId\": 1,\n" +
                        "    \"currencyId\": 112575,\n" +
                        "    \"statusId\": 1,\n" +
                        "    \"crtSide\": 0,\n" +
                        "    \"rates\": [\n" +
                        "        {\n" +
                        "            \"freetypes\": [\n" +
                        "                {\n" +
                        "                    \"id\": 1,\n" +
                        "                    \"value\": \"Соглашение об освобождении\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 1\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 2,\n" +
                        "                    \"value\": \"Подтверждение местонахождения\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 2\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 3,\n" +
                        "                    \"value\": \"Подтверждение инф. источников\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 3\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 4,\n" +
                        "                    \"value\": \"Особый налоговый статус\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 4\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 5,\n" +
                        "                    \"value\": \"Нотариально заверен. копия свидетельства\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 5\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 6,\n" +
                        "                    \"value\": \"Уведомл. о доходе пост. пред-ства\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 6\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 7,\n" +
                        "                    \"value\": \"Внешнеторговый контракт\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 7\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 8,\n" +
                        "                    \"value\": \"Оказание услуг и выполнение работ за рубежом\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 8\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 9,\n" +
                        "                    \"value\": \"Оказ. услуг на нерегулярной (разо\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 9\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 10,\n" +
                        "                    \"value\": \"Менее 50% недвижимости в РФ в активах российской компании, акции которой преобретаются иностранной компанией (пп.5 п.1 ст.309 НК РФ)\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 10\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 11,\n" +
                        "                    \"value\": \"Реализация обращающихся акций\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 11\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 12,\n" +
                        "                    \"value\": \"Вложение в уставный капитал больше пороговой суммы\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 12\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"id\": 13,\n" +
                        "                    \"value\": \"Подтверждение фактического права\",\n" +
                        "                    \"boolValue\": false,\n" +
                        "                    \"code\": 13\n" +
                        "                }\n" +
                        "            ],\n" +
                        "            \"rtStatus\": \"Действующий\",\n" +
                        "            \"incomeId\": 40420,\n" +
                        "            \"rtRate\": \"13\",\n" +
                        "            \"rtDepoRate\": {},\n" +
                        "            \"rtFacility\": \"\",\n" +
                        "            \"autoFilled\": false,\n" +
                        "            \"incFull\": \"Тестовый пид дохода\",\n" +
                        "            \"incCode\": \"01\",\n" +
                        "            \"incSymbol\": \"14102\",\n" +
                        "            \"index\": 0\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"crtRLetter\": 0,\n" +
                        "    \"docTypeId\": 1,\n" +
                        "    \"departId\": 70,\n" +
                        "    \"source\": \"DEPO\",\n" +
                        "    \"departName\": \"Депозитарий\",\n" +
                        "    \"docTypeName\": \"Договор\",\n" +
                        "    \"crtDate\": 1579251600000\n" +
                        "}")
                .post(URL_endpoint + "contracts/?clientId=" + clientId + "&currencyId=112575&number=40952&date=1579251600000&pdType=1");
        assertEquals(200, response.getStatusCode());
        return response.asString();
    }
}
